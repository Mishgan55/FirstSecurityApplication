package khorsun.library.FirstSecurityApplication.config;

import khorsun.library.FirstSecurityApplication.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//здесь будет проводить вся конфигурация нашего секьюрити(аунтефикация и авторизация)
//Ставим обязательно аннотацию над классом @EnableWebSecurity
// и наследуемся от класса WebSecurityConfiguration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final AuthProviderImpl authProvider;
    @Autowired
    public SecurityConfiguration(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authProvider);
    }
}
