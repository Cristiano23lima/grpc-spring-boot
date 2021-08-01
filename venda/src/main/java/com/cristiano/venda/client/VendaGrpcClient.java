package com.cristiano.venda.client;

import java.util.Map;

import com.google.protobuf.Descriptors.FieldDescriptor;

import org.springframework.stereotype.Service;

import demo.interfaces.grpc.VendaRequest;
import demo.interfaces.grpc.VendaResponse;
import demo.interfaces.grpc.VendaServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class VendaGrpcClient {
    @GrpcClient("verificador-venda")
    private VendaServiceGrpc.VendaServiceBlockingStub vendaServiceBlockingStub;

    public Map<FieldDescriptor, Object> verificarVenda(VendaRequest venda) {
        VendaResponse response = vendaServiceBlockingStub.myHello(venda);

        System.out.println("REQUISIÇÃO FINALIZADA PARA O VERIFICADOR....");

        return response.getAllFields();
    }

}
