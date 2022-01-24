package com.isael.restaurantapi.api.controller;

import com.isael.restaurantapi.infrastructure.repository.RestauranteRepositoryImpl;
import com.isael.restaurantapi.domain.model.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteRepositoryImpl restauranteRepository;

//    public RestauranteController() {
//        RestauranteRepositoryImpl restauranteRepository = new RestauranteRepositoryImpl();
//        restauranteRepository = restauranteRepository;
//    }

    @GetMapping
    public List<Restaurante> listRestaurantes() {

        return restauranteRepository.getRestaurantes();
    }

    public Restaurante createRestaurante(Restaurante restaurante) {

        return restauranteRepository.createRestaurante(restaurante);
    }
}
