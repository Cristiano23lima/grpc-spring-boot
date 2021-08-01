package com.cristiano.verificadorvenda.repository;

import java.util.UUID;

import com.cristiano.verificadorvenda.model.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {
}
