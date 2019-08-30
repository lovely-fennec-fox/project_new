package com.project.success.configure;
//
//import com.project.success.application.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**"); // resources는 해당 안되게
//    }
//
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/**")
//                    .permitAll()
//                    .and()
//                .formLogin()
//                    .usernameParameter("userId")
//                    .passwordParameter("userPassword")
//                    .loginProcessingUrl("/customLogin")
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutUrl("/customLogout")
//                    .logoutSuccessUrl("/")
//                    .invalidateHttpSession(true)
//                    .permitAll()
//                    .and()
//                .csrf()
//                    .disable();
//    }
//
//
//}
