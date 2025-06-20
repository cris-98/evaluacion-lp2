package com.lozano.alquiler.controller;

import com.lozano.alquiler.entity.Pelicula;
import com.lozano.alquiler.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "peliculas";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "form_pelicula";
    }

    @GetMapping("/guardar")
    public String guardarPelicula(@Valid @ModelAttribute Pelicula pelicula, BindingResult result) {
        if (result.hasErrors()) {
            return "form_pelicula";
        }
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";

    }
}
