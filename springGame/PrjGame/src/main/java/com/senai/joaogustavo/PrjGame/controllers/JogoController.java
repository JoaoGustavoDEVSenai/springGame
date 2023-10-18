package com.senai.joaogustavo.PrjGame.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.joaogustavo.PrjGame.entities.Jogos;
import com.senai.joaogustavo.PrjGame.services.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {

	public final JogoService jogoService;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogos> getJogo(@PathVariable Long id) {
		Jogos jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Jogos createJogo(@RequestBody Jogos jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping
	public List<Jogos> getAllJogo() {
		return jogoService.getAllJogo();
	}

	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}
}
