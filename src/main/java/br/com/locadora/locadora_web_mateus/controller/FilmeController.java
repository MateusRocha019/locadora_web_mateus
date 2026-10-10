package br.com.locadora.locadora_web_mateus.controller;
import br.com.locadora.locadora_web_mateus.model.Filme;
import br.com.locadora.locadora_web_mateus.service.LocadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filmes") //Vai definir /filmes como ínicio de todas as rotas dessa classe

public class FilmeController {

    private final LocadoraService service; //guarda a refêrencia do service usado pelo controller

    public FilmeController(LocadoraService service){
        this.service = service; //guarda o objeto recebido no atributo
    }

    @GetMapping("/novo")
    public String abrirFormulario(Model model){ //objeto usado para enviar dados do JAVA para o HTML
        model.addAttribute("filme", new Filme()); //Enviar o objeto vazio chamado filme para o formulário
        return "filmes/formulario";
    }
    @PostMapping("/salvar") //cria a rota post que recebe o nome do formulário (no caso "salvar")
    public String salvarFilmes( @ModelAttribute Filme filme, Model model){ //Pede ao sting para preencher o objeto Filme para os dados enviados

        try{ //Inicia um bloco que pode gerar erro de regra
            service.cadastrarFilme(filme); //entrega o objeto ao service e depois retorna
            return "redirect:/filmes?sucesso=true"; //manda o navegador abrir a listagem dos filmes e acrescenta um parâmetro de sucesso
        }catch (IllegalArgumentException erro) { //captura uma regra invalida lançada pelo service ou pelo model
            model.addAttribute("mensagemErro", erro.getMessage()); //obter a mensagem de erro
            return "filmes/formulario";
        }
    }
    @GetMapping
    public String listarFilmes(Model model){
        model.addAttribute("filmes", service.listarFilmes());
        return "filmes/listar";
    }
}
