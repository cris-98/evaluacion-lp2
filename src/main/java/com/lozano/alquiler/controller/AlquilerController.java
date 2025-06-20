package com.lozano.alquiler.controller;

import com.lozano.alquiler.entity.*;
import com.lozano.alquiler.service.AlquilerService;
import com.lozano.alquiler.service.ClienteService;
import com.lozano.alquiler.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/alquileres")
public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alquileres", alquilerService.listarTodos());
        return "alquileres";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("alquiler", new Alquiler());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("peliculas", peliculaService.listarTodas());
        model.addAttribute("estados", EstadoAlquiler.values());
        return "form_alquiler";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Alquiler alquiler,
                          BindingResult result,
                          @RequestParam("idPelicula") Long idPelicula,
                          @RequestParam("cantidad") int cantidad,
                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("peliculas", peliculaService.listarTodas());
            model.addAttribute("estados", EstadoAlquiler.values());
            return "form_alquiler";
        }

        Pelicula peli = peliculaService.listarTodas()
                .stream()
                .filter(p -> p.getIdPelicula().equals(idPelicula))
                .findFirst()
                .orElse(null);

        if (peli == null || cantidad <= 0) {
            model.addAttribute("error", "Película inválida o cantidad incorrecta.");
            return "form_alquiler";
        }

        DetalleAlquiler detalle = new DetalleAlquiler();
        detalle.setPelicula(peli);
        detalle.setCantidad(cantidad);
        alquiler.setDetalles(Collections.singletonList(detalle));
        alquiler.setTotal(5.0 * cantidad); // Supuesto: S/. 5 por película

        alquilerService.registrarAlquiler(alquiler);
        return "redirect:/alquileres";
    }
}
