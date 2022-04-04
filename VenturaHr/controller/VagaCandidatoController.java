package br.edu.infnet.VenturaHr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.VenturaHr.model.Usuario;
import br.edu.infnet.VenturaHr.model.Vaga;
import br.edu.infnet.VenturaHr.model.VagaCandidato;
import br.edu.infnet.VenturaHr.service.CandidatoService;
import br.edu.infnet.VenturaHr.service.VagaCandidatoService;
import br.edu.infnet.VenturaHr.service.VagaService;



@Controller
public class VagaCandidatoController {
	@Autowired
	private VagaCandidatoService vagaCandidatoService; // restaurante
	@Autowired
	private CandidatoService candidatoService; // solicitante
	@Autowired
	private VagaService vagaService; // local

	@GetMapping(value = "/vagaCandidato")
	public String telaRegistro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("candidatoLista", candidatoService.obterLista(usuario));

		model.addAttribute("vagaLista", vagaService.obterLista(usuario));

		return "vagaCandidato/registro";
	}

	@GetMapping(value = "/vagaCandidatos")
	public String telaLista(Model model, @SessionAttribute("user")Usuario usuario) {

		model.addAttribute("vagaCandidatoLista", vagaCandidatoService.obterLista(usuario));

		return "vagaCandidato/lista";
	}

	@PostMapping(value = "/vagaCandidato/incluir")
	public String incluir(@RequestParam String[] idsVagas, VagaCandidato vagaCandidato, Model model,
			@SessionAttribute("user") Usuario usuario) {

		List<Vaga> vagas = new ArrayList<Vaga>();

		for (String idVaga : idsVagas) {
			

			Vaga vaga = vagaService.obterPorId(Integer.valueOf(idVaga));

			vagas.add(vaga);
		}

		vagaCandidato.setUsuario(usuario);

		vagaCandidato.setVagas(vagas);

		vagaCandidatoService.incluir(vagaCandidato);

		model.addAttribute("mensagem", "Parabens por se candidatar para a vaga!!!");

		return telaLista(model, usuario);
	}

	
}