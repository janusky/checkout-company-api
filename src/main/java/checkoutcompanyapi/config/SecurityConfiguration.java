package checkoutcompanyapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Value("${app.route.actuator-uri:/actuator/**}")
	private String actuatorfUri;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
					.anyRequest().authenticated()
			)
			.x509(withDefaults());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("client")
				.password("password")
				.roles("USER")
				.build();
		UserDetails dianne = User.withDefaultPasswordEncoder()
				.username("dianne")
				.password("password")
				.roles("USER")
				.build();
		UserDetails rod = User.withDefaultPasswordEncoder()
				.username("rod")
				.password("password")
				.roles("USER", "ADMIN")
				.build();
		UserDetails scott = User.withDefaultPasswordEncoder()
				.username("localhost")
				.password("none")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user, dianne, rod, scott);
	}
}
