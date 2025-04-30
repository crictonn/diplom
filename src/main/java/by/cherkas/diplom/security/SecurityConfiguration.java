package by.cherkas.diplom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity security) throws Exception{
        return security.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().permitAll();
//                    authorize.requestMatchers("/login").permitAll();
//                    authorize.requestMatchers("/user").permitAll();
//                    authorize.anyRequest().authenticated();
                })
//                .addFilterBefore(
//                        new BasicAuthenticationFilter(authenticationManager(httpSecurity)),
//                        UsernamePasswordAuthenticationFilter.class
//                )
//                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter(){
//        return new JwtAuthenticationFilter();
//    }
}
