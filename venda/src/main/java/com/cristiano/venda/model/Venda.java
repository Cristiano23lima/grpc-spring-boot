package com.cristiano.venda.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Venda implements Serializable {
    private String nomeCliente;
    private String nomeProduto;
    private Integer quantidadeProduto;
    private Double precoProduto;
}
