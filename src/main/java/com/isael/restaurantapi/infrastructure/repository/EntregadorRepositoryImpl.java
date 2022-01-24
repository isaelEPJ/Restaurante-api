package com.isael.restaurantapi.infrastructure.repository;

import com.isael.restaurantapi.domain.model.Entregador;
import com.isael.restaurantapi.domain.repository.EntregadorRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EntregadorRepositoryImpl implements EntregadorRepository {

    @PersistenceContext
    private EntityManager entity;

    public EntregadorRepositoryImpl() {
    }

    @Override
    public List<Entregador> getEntregadores() {
        return entity.createQuery("from entregador", Entregador.class).getResultList();
    }

    @Override
    public Entregador createEntregador(Entregador entregador) {
        return entity.merge(entregador);
    }

    @Override
    public Entregador updateEntregador(Long id, Entregador newEntregador) {
        List<Entregador> entregadores = entity.createQuery("from entregador", Entregador.class).getResultList();
        for (Entregador entregador1 : entregadores) {
            if (entregador1.getId() == id) {
                newEntregador.setId(id);
                createEntregador(newEntregador);
                return newEntregador;

            }
        }
        return null;
    }

    @Override
    public Entregador findEntregadorById(Long id) {
        Entregador entregador = entity.find(Entregador.class, id);
        return entregador;
    }

    @Override
    public boolean removerEntregador(Entregador entregador, Long id) {
        Entregador entregadorExists = findEntregadorById(id);
        if (entregadorExists != null) {
            entity.remove(entregadorExists);
            return true;
        }
        return false;
    }
}
