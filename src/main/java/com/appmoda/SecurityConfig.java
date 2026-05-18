package com.appmoda;

import com.appmoda.service.CustomOAuth2UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                /* páginas públicas: qualquer um pode acessar */
                .antMatchers(
                        "/",
                        "/css/**",
                        "/js/**",
                        "/img/**"
                ).permitAll()

                /* páginas protegidas: só quem está logado */
                .antMatchers(
                        "/temperatura",
                        "/guarda-roupa",
                        "/guarda-roupa/adicionar",
                        "/sugestao"
                ).authenticated()

                .anyRequest().authenticated()

                .and()

                .oauth2Login()

                /* página de login: a tela inicial */
                .loginPage("/")

                .userInfoEndpoint()
                .userService(customOAuth2UserService)

                .and()

                /* após login com Google, vai para a tela de temperatura */
                .defaultSuccessUrl("/temperatura", true)

                .and()

                .logout()
                /* após logout, volta para a tela inicial */
                .logoutSuccessUrl("/");

        http.csrf().disable();
    }
}