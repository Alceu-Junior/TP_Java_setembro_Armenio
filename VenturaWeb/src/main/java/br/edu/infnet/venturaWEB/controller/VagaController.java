package br.edu.infnet.venturaWEB.controller;

import br.edu.infnet.venturaWEB.model.domain.Usuario;
import br.edu.infnet.venturaWEB.model.domain.Vaga;
import br.edu.infnet.venturaWEB.model.service.UsuarioService;
import br.edu.infnet.venturaWEB.model.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes("user")
@Controller
public class VagaController {

	@Autowired
	private VagaService vagaService;

	@GetMapping(value = "/vaga/quantidadecriterios")
	public String quantidadeDeCriterios() {
		return "/quantidadeDeCriterios";
	}

	@GetMapping(value = "/vaga/cadastro")
	public String quantidadeDeCriterios(@RequestParam int quantidadeDeCriterios, Model model) {
		model.addAttribute("quantidadeDeCriterios", quantidadeDeCriterios);
		return "/cadastroVaga";
	}

	@PostMapping(value = "/vaga/cadastro/envio")
	public String registrarVaga(Vaga vaga, Model model, @SessionAttribute("user") Usuario user) {
		System.out.println("ENVIO VAGA DEBUG");
		vaga.setIdUsuario(user.getId());
		try {
			vagaService.criarVaga(vaga);
			model.addAttribute("message", "Vaga cadastrada com sucesso!");
		} catch (Exception e) {
			model.addAttribute("message", "Erro ao cadastrar a vaga!");
		}
		return "redirect:/vaga/lista";

	}

	@GetMapping(value = "/vaga/lista")
	public String listarVagas(Model model, @SessionAttribute("user") Usuario usuario) {
		System.out.println("LISTAR VAGAS DEBUG");
		List<Vaga> vagas;
		String pagina = null;

		if (usuario.getTipo() == Usuario.ADMINISTRADOR) {
			vagas = vagaService.listarTodasVagas();
			model.addAttribute("vagas", vagas);
			pagina = "/administradores/index";
		} else {
			vagas = vagaService.listarPorUsuario(usuario.getId());
			model.addAttribute("vagas", vagas);
			pagina = "/empresas/index";
		}
		return pagina;
	}

	@GetMapping(value = "/vaga/{id}/excluir")
	public String excluirVaga(@PathVariable int id, Model model, @SessionAttribute("user") Usuario usuario) {
		try {
			vagaService.excluirVaga(id);
			model.addAttribute("message", "Vaga deletada com sucesso!");
		} catch (Exception e) {
			model.addAttribute("message", "Erro ao excluir vaga!");
		}
			return "redirect:/vaga/lista";
	}

}
