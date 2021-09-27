package br.edu.infnet.venturaWEB.controller;

import br.edu.infnet.venturaWEB.model.domain.Usuario;
import br.edu.infnet.venturaWEB.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

import static java.util.Objects.isNull;


@SessionAttributes("user")
@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping(value = "/")
	public String telaLogin(Model model) {
		return "login";
	}

	@GetMapping(value = "/usuario/pagina/cadastro")
	public String telaRegistrarUsuario() {
		return "/usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String listarUsuarios() {
		return "usuario/lista";
	}

	@GetMapping(value = "/home")
	public String telaHome(@SessionAttribute(name="user", required=false) Usuario user, Model model) {
		System.out.println("/HOME DEBUG");
		if (isNull(user)) {
			return "/login";
		}
		return "home";
	}

	@PostMapping(value = "/usuario/cadastra")
	public String registrar(Model model, Usuario usuario) {
		usuario.setTipo(Usuario.EMPRESA);
		try {
			usuario = usuarioService.criarConta(usuario);
			model.addAttribute("user", usuario);
		} catch (Exception e){
			model.addAttribute("message", "Erro ao criar usuário!");
		}

		return telaHome(usuario, model);
	}
    
    @PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		System.out.println("LOGAR DEBUG");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		Usuario usuarioValidado = usuarioService.validar(usuario);

		if (usuarioValidado != null && usuarioValidado.getEmail() != null && usuarioValidado.getSenha() != null) {
			model.addAttribute("user", usuarioValidado);
			String pagina = null;

			return telaHome(usuario, model);
		} else {
			model.addAttribute("message", "Autenticação inválida para o usuário " + email + "!!!");

			return telaLogin(model);
		}
	}


		@GetMapping(value = "/logout")
		public String logout(HttpSession session, SessionStatus status) {
			status.setComplete();
			
			session.removeAttribute("user");
			
			return "redirect:/";
		}


}
