package com.isael.restaurantapi.domain.repository;

import com.isael.restaurantapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    public List<Cozinha> getCozinhas();

    public Cozinha createCozinha(Cozinha cozinha);

    public Cozinha updateCozinha(Long id, Cozinha cozinha);

    public Cozinha getCozinhaById(Long id);

    public boolean removeCozinha(Cozinha cozinha);
}
