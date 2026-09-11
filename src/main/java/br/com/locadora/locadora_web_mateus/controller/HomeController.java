package br.com.locadora.locadora_web_mateus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;





@Controller //informa ao Spring que a classe recebe acesso do navegador.

public class HomeController { //Declara o controller da página inicial
    @GetMapping("/") // Liga o endereço principal ao metódo abaixo
    public String abrirPaginaInicial(){
        return "index";
    };

}


/*
3 -Coloca a classe pacote no controller
4 - Importa a anotação que identifica o Controller
4 - Importa a anotação usada para
*/