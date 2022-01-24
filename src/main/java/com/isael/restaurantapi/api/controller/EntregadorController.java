package com.isael.restaurantapi.api.controller;

import com.isael.restaurantapi.domain.model.Entregador;
import com.isael.restaurantapi.domain.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping
    public List<Entregador> getEntregadores() {
        return entregadorRepository.getEntregadores();
    }
}
