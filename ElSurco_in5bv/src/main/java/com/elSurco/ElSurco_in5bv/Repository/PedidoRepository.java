package com.elSurco.ElSurco_in5bv.Repository;

import com.elSurco.ElSurco_in5bv.Entity.Pedido;
import com.elSurco.ElSurco_in5bv.Util.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByComprador_IdComprador(Integer idComprador);

    List<Pedido> findByEstadoPedido(EstadoPedido estadoPedido);
}