package br.com.locadora.locadora_web_mateus.controller;

import org.springframework.stereotype.Controller; // Coloca a classe pacote no controller
import org.springframework.web.bind.annotation.GetMapping; //Importa a anotação que identifica o Controller and Importa a anotação usada para





@Controller //informa ao Spring que a classe recebe acesso do navegador.

public class HomeController { //Declara o controller da página inicial
    @GetMapping("/") // Liga o endereço principal ao metódo abaixo
    public String abrirPaginaInicial(){
        return "index";
    };

}
