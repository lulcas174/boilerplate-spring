package com.example.API_vendas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Produto implements Serializable {
    @Id
    private int id;

    private String nome;

    private String descricao;

    private double preco;

    private int quantidade;

    @Column(name="forma-pagamento")
    private String formaPagamento;


}
