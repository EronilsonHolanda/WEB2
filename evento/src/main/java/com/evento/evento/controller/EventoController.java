package com.evento.evento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.evento.evento.model.Evento;
import com.evento.evento.model.EventoRepository;
import com.evento.evento.model.EventoUpdateDados;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/eventos")
public class EventoController {
    private final EventoRepository eventoRepository;

    @Autowired
    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @GetMapping
    public String listarEventos(Model model) {
        List<Evento> eventos = eventoRepository.findAll();
        model.addAttribute("eventos", eventos);
        return "eventos/listar";
    }

    @GetMapping("/criar")
    public String mostrarFormularioCriar(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario";
    }

    @PostMapping("/criar")
    public String criarEvento(@ModelAttribute Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/eventos";
    }

    @DeleteMapping
    @Transactional
    public String deletarAtleta(Long id){
        eventoRepository.deleteById(id);
        return "redirect:/atletas";
    }

    @PutMapping
    @Transactional
    public String atualizaCompra(EventoUpdateDados dados){
        Evento a1 = eventoRepository.getReferenceById(dados.id());
        a1.atualizaEvento(dados);
        return "redirect:/eventos";
    }

}
