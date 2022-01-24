package com.isael.restaurantapi.domain.repository;

import com.isael.restaurantapi.domain.model.Entregador;

import java.util.List;

public interface EntregadorRepository {

    public List<Entregador> getEntregadores();

    public Entregador createEntregador(Entregador entregador);

    public Entregador updateEntregador(Long id, Entregador entregador);

    public Entregador findEntregadorById(Long id);


    public boolean removerEntregador(Entregador entregador, Long id);


}
