package config.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//TODO: не проверяла ещё, jsp не вставляла пока потому что
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/pages/**").access("hasAnyRole('ROLE_USER')"). //и это лишее что ли
                and().formLogin().  //login configuration
                loginPage("/"). //need to add
                loginProcessingUrl("/appLogin").
                usernameParameter("app_username").
                passwordParameter("app_password").
                defaultSuccessUrl("/"). //need to add
                and().logout().    //logout configuration
                logoutUrl("/appLogout"). //need to add
                logoutSuccessUrl("/");
        http.csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select nick, password from user where nick=?")
                .authoritiesByUsernameQuery("select login, role from user_role where login=?") //это лишнее походу
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }
}