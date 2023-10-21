package com.evento.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.evento.evento.model.Evento;
import com.evento.evento.model.EventoDados;
import com.evento.evento.model.EventoRepository;
import com.evento.evento.model.EventoUpdateDados;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @GetMapping("/formulario")
    public String mostrarFormularioCriar(Long id, Model model) {
        if (id != null) {
            Evento a1 = repository.getReferenceById(id);
            model.addAttribute("evento", a1);
        }
        return "eventos/formulario";
    }

    @GetMapping
    public String loadEventoList(Model model) {
        model.addAttribute("eventos", repository.findAll());
        return "eventos/listar";
    }

    @PostMapping("/formulario")
    @Transactional
    public String registrarEvento(EventoDados dados) {
        Evento a1 = new Evento(dados);
        repository.save(a1);
        return "redirect:/eventos";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarEvento(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/eventos";
    }

    @PutMapping("/{id}")
    @Transactional
    public String atualizaEvento(EventoUpdateDados dados){
        Evento a1 = repository.getReferenceById(dados.id());
        a1.atualizaEvento(dados);
        return "redirect:/eventos";
    }
}