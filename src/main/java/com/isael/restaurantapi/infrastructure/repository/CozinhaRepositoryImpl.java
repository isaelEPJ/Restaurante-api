package com.isael.restaurantapi.infrastructure.repository;

import com.isael.restaurantapi.domain.repository.CozinhaRepository;
import com.isael.restaurantapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> getCozinhas() {
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Override
    @Transactional
    public Cozinha createCozinha(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    public Cozinha updateCozinha(Long id, Cozinha cozinha) {

        return null;
    }

    @Override
    public Cozinha getCozinhaById(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    public boolean removeCozinha(Cozinha cozinha) {
        cozinha = getCozinhaById(cozinha.getId());
        manager.remove(cozinha);
        return true;
    }
}
