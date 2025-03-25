package microservicio.api_rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                  .anyRequest().authenticated() // Requiere autenticación para las demás rutas
            )
            .httpBasic(httpBasic -> {
            }) // Habilita Basic Auth
            .build();
   }

   @Bean
   public InMemoryUserDetailsManager userDetailsService() {

      PasswordEncoder encoder = this.passwordEncoder();

      UserDetails user = User.builder()
            .username("rguevarav")
            .password(encoder.encode("123"))
            .roles("ROOT")
            .build();

      return new InMemoryUserDetailsManager(user);

   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

}
