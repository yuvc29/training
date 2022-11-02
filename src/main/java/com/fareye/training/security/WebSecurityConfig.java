//package com.fareye.training.security;
//
//import com.fareye.training.repository.UserRepository;
//// import com.fareye.training.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                UserDetails user = User.withUsername("user")
//                        .password(passwordEncoder.encode("password"))
//                        .roles("USER")
//                        .build();
//
//                UserDetails admin = User.withUsername("admin")
//                        .password(passwordEncoder.encode("admin"))
//                        .roles("USER", "ADMIN")
//                        .build();
//
//                return username.equals("admin") ? admin : user;
//            }
//        };
//    }
////    @Bean
////    public DaoAuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
////        auth.setUserDetailsService(userService);
////        auth.setPasswordEncoder(passwordEncoder());
////        return auth;
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider());
////    }
//
//
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
////        UserDetails user = User.withUsername("user")
////                .password(passwordEncoder.encode("password"))
////                .roles("USER")
////                .build();
////
////        UserDetails admin = User.withUsername("admin")
////                .password(passwordEncoder.encode("admin"))
////                .roles("USER", "ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(user, admin);
////    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin();
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//        return http.build();
//    }
//
//
//
//
//}
//
////package net.javaguides.springboot.config;
////
////        import org.springframework.beans.factory.annotation.Autowired;
////        import org.springframework.context.annotation.Bean;
////        import org.springframework.context.annotation.Configuration;
////        import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////        import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////        import net.javaguides.springboot.service.UserService;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
////
////    @Autowired
////    private UserService userService;
////
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public DaoAuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
////        auth.setUserDetailsService(userService);
////        auth.setPasswordEncoder(passwordEncoder());
////        return auth;
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider());
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers(
////                        "/registration**",
////                        "/js/**",
////                        "/css/**",
////                        "/img/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout")
////                .permitAll();
////    }
////
////}
