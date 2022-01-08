package com.isael.restaurantapi.infrastructure.repository;

import com.isael.restaurantapi.domain.repository.RestauranteRepository;
import com.isael.restaurantapi.domain.model.Restaurante;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Restaurante> getRestaurantes() {
        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
//        TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class).getResultList();
//        return restaurantes;
    }

    @Transactional
    public Restaurante createRestaurante(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    public Restaurante getRestauranteById(Long id) {
        return manager.find(Restaurante.class, id);
    }

    public void updateRestaurante(Long id, Restaurante newRestaurante) {
        List<Restaurante> restaurantes = manager.createQuery("from Restaurante", Restaurante.class).getResultList();
        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getId() == id) {
                newRestaurante.setId(restaurante.getId());
                createRestaurante(newRestaurante);
            } else {
                System.out.println("Restaurante Not Found");
            }
        }
    }

    public boolean deleteRestauranteById(Restaurante restaurante) {
        if (restaurante.getId() != null) {
            restaurante = getRestauranteById(restaurante.getId());
            manager.remove(restaurante);
            return true;
        }
        return false;
    }

}
