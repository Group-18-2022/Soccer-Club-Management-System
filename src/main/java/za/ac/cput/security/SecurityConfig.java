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
                .withUser("Test User")
                .password("{noop}123456")
                .roles(Role.MANAGER.name())
                .and()
                .withUser("Manager")
                .password(encoder().encode("{noop}123456"))
                .roles(Role.MANAGER.name())
                .and()
                .withUser("Sponsor")
                .password(encoder().encode("{noop}123456"))
                .roles(Role.SPONSOR.name())
                .and()
                .withUser("Player")
                .password(encoder().encode("{noop}123456"))
                .roles(Role.PLAYER.name());
    }
//TODO: Add Employee routes
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                //Role: MANAGER
                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/club/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/club/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/club/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/club/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/contactinformation/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/contactinformation/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/contactinformation/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/contactinformation/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/vehicle/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/vehicle/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/vehicle/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/vehicle/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/managerContract/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/managerContract/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/managerContract/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/managerContract/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/playerContract/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/playerContract/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/playerContract/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/playerContract/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/manager/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/manager/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/manager/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/manager/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/player/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/player/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/player/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/player/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/sponsor/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/sponsor/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/sponsor/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/sponsor/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/kit/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/kit/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/kit/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/kit/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/location/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/location/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/location/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/location/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/match/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/match/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/match/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/match/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/matchLocation/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/matchLocation/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/matchLocation/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/matchLocation/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/matchScore/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/matchScore/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/matchScore/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/matchScore/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/team/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/team/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/team/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/team/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/team-statistics/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/team-statistics/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/team-statistics/").hasRole(Role.MANAGER.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/team-statistics/").hasRole(Role.MANAGER.name())

                //Role: Sponsor
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/club/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/manager/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/player/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/sponsor/").hasRole(Role.SPONSOR.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/sponsor/").hasRole(Role.SPONSOR.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/soccer-management/sponsor/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/kit/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/match/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/matchLocation/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/matchScore/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/team/").hasRole(Role.SPONSOR.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/team-statistics/").hasRole(Role.SPONSOR.name())

                //Role: PLAYER
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/club/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.POST, "api/v1/soccer-management/contactinformation/").hasRole(Role.PLAYER.name())
                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/contactinformation/").hasRole(Role.PLAYER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/contactinformation/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/vehicle/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/playerContract/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/manager/").hasRole(Role.MANAGER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/player/").hasRole(Role.PLAYER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/soccer-management/player/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/kit/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/location/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/match/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/matchLocation/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/matchScore/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/team/").hasRole(Role.PLAYER.name())

                .antMatchers(HttpMethod.GET, "api/v1/soccer-management/team-statistics/").hasRole(Role.PLAYER.name())

                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}

