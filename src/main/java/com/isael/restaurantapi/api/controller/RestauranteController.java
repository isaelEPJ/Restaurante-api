package com.isael.restaurantapi.api.controller;

import com.isael.restaurantapi.infrastructure.repository.RestauranteRepositoryImpl;
import com.isael.restaurantapi.domain.model.Restaurante;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/restaurants")
public class RestauranteController {
    RestauranteRepositoryImpl restauranteRepository;

    public RestauranteController() {
        RestauranteRepositoryImpl restauranteRepository = new RestauranteRepositoryImpl();
        restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> listRestaurantes() {

        return restauranteRepository.getRestaurantes();
    }

    public Restaurante createRestaurante(Restaurante restaurante) {

        return restauranteRepository.createRestaurante(restaurante);
    }
}
