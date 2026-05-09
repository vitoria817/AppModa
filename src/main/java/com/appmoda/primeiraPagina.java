package com.appmoda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Controller // controla pagina
public class primeiraPagina {

    @GetMapping("/temperatura")
    // quando alguém acessar /temperatura
    public String temperatura() {
        // função que roda quando acessa a rota
        return "temperatura";
        // abre o arquivo: temperatura.html
    }
}

@Configuration
// fala pro Spring que essa classe é uma configuração
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    // sobrescreve o método padrão do Spring Security
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                // começa a definir quem pode acessar o quê

                .antMatchers("/", "/temperatura", "/css/**", "/js/**", "/img/**").permitAll()
                // libera essas rotas pra todo mundo acessar sem login

                .anyRequest().authenticated()
                // qualquer outra rota exige login

                .and()

                .formLogin().disable();
        // remove a tela de login padrão do Spring Security
    }
}