package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Manager")
                .password(encoder().encode("ManagerPassword"))
                .roles("MANAGER")
                .and()
                .withUser("Player")
                .password(encoder().encode("PlayerPassword"))
                .roles("PLAYER")
                .and()
                .withUser("Sponsor")
                .password(encoder().encode("SponsorPassword"))
                .roles("SPONSOR");
    }
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .cors()
                .and()
                .authorizeHttpRequests()
                //Manager
                .antMatchers(HttpMethod.POST, "/api/v1/soccer-management/**/save").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/api/v1/soccer-management/**/delete").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/read").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/all").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/findall").hasRole("MANAGER")
                //Player
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/read").hasRole("PLAYER")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/all").hasRole("PLAYER")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/findall").hasRole("PLAYER")
                //Sponsor
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/read").hasRole("SPONSOR")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/all").hasRole("SPONSOR")
                .antMatchers(HttpMethod.GET, "/api/v1/soccer-management/**/findall").hasRole("SPONSOR")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}

