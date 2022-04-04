package br.edu.infnet.VenturaHr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.model.Vaga;
import br.edu.infnet.VenturaHr.service.VagaService;

@Controller
public class VagaController {

	@Autowired
	private VagaService vagaService;

	// private static List<Usuario> usuarios = new ArrayList<>(); /// pode tirar

	@GetMapping(value = "/vagas")
	public String telaLista(Model model) {

		model.addAttribute("vagaLista", vagaService.obterLista());

		return "/vaga/lista";
	}

	@GetMapping(value = "/vaga")
	public String telaRegistro() {
		return "/vaga/registro";
	}

	@PostMapping(value = "/vaga/incluir")
	public String incluir(Vaga vaga, @SessionAttribute("user") Usuario usuario) {
		
		vaga.setUsuario(usuario);
		vagaService.incluir(vaga);

		return "redirect:/vagas";
	}

	@PostMapping(value = "/atualizar/vaga")
	public String atualizar(Vaga vaga) {

		vagaService.incluir(vaga);

		return "redirect:/";
	}

	@GetMapping(value = "/vaga/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		vagaService.excluir(id);

		return "redirect:/vagas";
	}
}
