package com.personal.shivam.springBootJsp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = createUserDetails("Shivam", "dummy");
        UserDetails userDetails2 = createUserDetails("shivam123", "dummy");
        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }

    private UserDetails createUserDetails(String userName, String password) {
        return User.builder().passwordEncoder(s -> passwordEncoder().encode(s))
                .username(userName)
                .password(password)
                .roles("USER", "ADMIN").build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filter(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return httpSecurity.build();
    }
}
