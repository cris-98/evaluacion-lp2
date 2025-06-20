package com.lozano.alquiler.service;

import java.util.List;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lozano.alquiler.entity.Cliente;
import com.lozano.alquiler.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente>listarTodos(){
        return clienteRepository.findAll();
    }
    public void guardar(Cliente cliente){
        clienteRepository.save(cliente);
    }


}
