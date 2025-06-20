package com.lozano.alquiler.service;

import com.lozano.alquiler.entity.Alquiler;
import com.lozano.alquiler.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlquilerService {
    @Autowired
    private AlquilerRepository alquilerRepository;

    public List<Alquiler>listarTodos(){
        return alquilerRepository.findAll();
    }
    public void registrarAlquiler(Alquiler alquiler){
        alquiler.setFecha(LocalDate.now());
        alquilerRepository.save(alquiler);
    }
}
