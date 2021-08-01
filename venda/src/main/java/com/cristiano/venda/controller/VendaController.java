package com.cristiano.venda.controller;

import java.util.Map;

import com.cristiano.venda.client.VendaGrpcClient;
import com.cristiano.venda.model.Venda;
import com.google.protobuf.Descriptors.FieldDescriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.interfaces.grpc.VendaRequest;

@RestController
@RequestMapping("/api/v1")
public class VendaController {
    @Autowired
    private VendaGrpcClient cliente;

    @PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<FieldDescriptor, Object> cadastrarVenda(@RequestBody Venda venda) {
        VendaRequest vendaRequest = VendaRequest.newBuilder().setNomeCliente(venda.getNomeCliente())
                .setNomeProduto(venda.getNomeProduto()).setPrecoProduto(venda.getPrecoProduto())
                .setQuantidadeProduto(venda.getQuantidadeProduto()).build();

        return this.cliente.verificarVenda(vendaRequest);
    }
}
