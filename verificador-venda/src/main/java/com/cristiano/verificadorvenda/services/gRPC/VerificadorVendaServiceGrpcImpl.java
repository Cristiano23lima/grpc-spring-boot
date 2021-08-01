package com.cristiano.verificadorvenda.services.gRPC;

import com.cristiano.verificadorvenda.model.Venda;
import com.cristiano.verificadorvenda.repository.VendaRepository;

import demo.interfaces.grpc.VendaRequest;
import demo.interfaces.grpc.VendaResponse;
import demo.interfaces.grpc.VendaServiceGrpc.VendaServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class VerificadorVendaServiceGrpcImpl extends VendaServiceImplBase {
    private final VendaRepository repository;

    @Override
    public void myHello(VendaRequest request, StreamObserver<VendaResponse> responseObserver) {

        Venda vendaParaSalvar = Venda.builder().setNomeCliente(request.getNomeCliente())
                .setNomeProduto(request.getNomeProduto()).setPrecoProduto(request.getPrecoProduto())
                .setQuantidadeProduto(request.getQuantidadeProduto()).build();

        Venda vendaSalva = this.repository.save(vendaParaSalvar);

        VendaResponse response = VendaResponse.newBuilder().setNomeCliente(vendaSalva.getNomeCliente())
                .setNomeProduto(vendaSalva.getNomeProduto()).setPrecoProduto(vendaSalva.getPrecoProduto())
                .setQuantidadeProduto(vendaSalva.getQuantidadeProduto()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
