package com.example.restaurantedevapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurantedevapi.model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário.
}