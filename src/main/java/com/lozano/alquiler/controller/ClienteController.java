package com.lozano.alquiler.controller;
import com.lozano.alquiler.entity.Cliente;
import com.lozano.alquiler.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model){
        model.addAttribute("clientes",clienteService.listarTodos());
        return "clientes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("cliente",new Cliente());
        return "form_cliente";
    }

    @PostMapping("/guardar")
        public String guardarCliente(@Valid @ModelAttribute Cliente cliente,BindingResult result,Model model){
        if (result.hasErrors()){
            return "form_cliente";

        }
        clienteService.guardar(cliente);
        return "redirect:/cliente";

}
}
