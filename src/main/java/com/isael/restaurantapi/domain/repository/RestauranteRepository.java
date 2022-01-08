package com.isael.restaurantapi.domain.repository;

import com.isael.restaurantapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    public List<Restaurante> getRestaurantes();

    public Restaurante createRestaurante(Restaurante restaurante);

    public void updateRestaurante(Long id, Restaurante newRestaurante);

    public boolean deleteRestauranteById(Restaurante restaurante);
}
