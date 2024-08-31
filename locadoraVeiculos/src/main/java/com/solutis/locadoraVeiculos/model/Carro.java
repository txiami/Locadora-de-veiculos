package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String chassi;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private BigDecimal valorDiaria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "Carro_Acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id")
    private ModeloCarro modeloCarro;

    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis;

    @Column(nullable = false)
    private String imagem;
}
