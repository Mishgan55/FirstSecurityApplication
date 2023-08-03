package khorsun.library.FirstSecurityApplication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//здесь будет проводить вся конфигурация нашего секьюрити(аунтефикация и авторизация)
//Ставим обязательно аннотацию над классом @EnableWebSecurity
// и наследуемся от класса WebSecurityConfiguration
@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    /*In the old version you inject AuthenticationManagerBuilder, set userDetailsService,
     passwordEncoder and build it. But authenticationManager is already created in this step.
     It is created the way we wanted (with userDetailsService and the passwordEncoder).*/
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
