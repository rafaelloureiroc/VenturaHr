package br.edu.infnet.VenturaHr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.VenturaHr.model.Candidato;
import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.service.CandidatoService;


@Controller
public class CandidatoController {
	
	@Autowired
	private CandidatoService candidatoService;

	@GetMapping(value = "/candidato")
	public String telaRegistro() {
		return "candidato/registro";
	}
	
	@GetMapping(value = "/candidatos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("candidatoLista", candidatoService.obterLista(usuario));

		return "candidato/lista";
	}

	@PostMapping(value = "/candidato/incluir")
	public String incluir(Candidato candidato, Model model, @SessionAttribute("user")  Usuario usuario){
		
		candidato.setUsuario(usuario);

		candidatoService.incluir(candidato);

		model.addAttribute("mensagem", "O candidato " + candidato.getNome() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/candidato/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Candidato candidato = candidatoService.obterPorId(id);
				
		if(candidato != null) {			
			candidatoService.excluir(id);			
			model.addAttribute("mensagem", "O candidato "+candidato.getNome()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "candidato inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}