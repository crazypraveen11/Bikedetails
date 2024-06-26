package Projectbike.Bikedetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Authentication {
    @Autowired
    bikeservice service;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer customurl() {
        return web -> web.ignoring().requestMatchers("/indianbank/addbikes");
    }

    @Bean
    public InMemoryUserDetailsManager myuserdetails() {
        UserDetails user1 = User.withUsername("Praveen").password(encoder().encode("Praveen11")).build();
        UserDetails user2 = User.withUsername("Ajith").password(encoder().encode("Ajith11")).build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
    
    @Bean
    public SecurityFilterChain httpfilter(HttpSecurity hp) throws Exception {
        // hp.authorizeHttpRequests().anyRequest().authenticated(); // Forall requests
        // hp.authorizeHttpRequests().anyRequest().permitAll(); // permitall requests

        // hp.authorizeHttpRequests().requestMatchers("/indianbank/**").authenticated();
        // hp.csrf().disable();
        // hp.cors();
        // hp.httpBasic();
        // hp.formLogin();

        hp.authorizeRequests().requestMatchers("/indianbank/**").authenticated().and().csrf().disable().cors().and()
                .httpBasic();
        hp.formLogin();

        AuthenticationManagerBuilder builder = hp.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(service).passwordEncoder(encoder());

        hp.authenticationManager(builder.build());

        return hp.build();
    }
}
