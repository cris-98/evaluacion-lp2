package com.lozano.alquiler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lozano.alquiler.entity.Pelicula;
import com.lozano.alquiler.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula>listarTodas(){
        return peliculaRepository.findAll();

    }
    public void guardar(Pelicula pelicula){
        peliculaRepository.save(pelicula);
    }
}
