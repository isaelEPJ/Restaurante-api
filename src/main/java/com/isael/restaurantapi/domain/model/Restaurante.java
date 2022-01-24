package com.isael.restaurantapi.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "taxa_frete", nullable = false)
    private String taxaFrete;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(String taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    public void setCozinha(Cozinha cozinha) {
        this.cozinha = cozinha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurante)) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getTaxaFrete(), that.getTaxaFrete()) && Objects.equals(getCozinha(), that.getCozinha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTaxaFrete(), getCozinha());
    }
}
