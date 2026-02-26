package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Pedido;
import com.elSurco.ElSurco_in5bv.Util.EstadoPedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> listar();
    Pedido obtenerPorId(Integer id);
    Pedido agregar(Pedido pedido);
    Pedido actualizar(Integer id, Pedido pedido);
    void eliminar(Integer id);

    List<Pedido> listarPorComprador(Integer idComprador);
    List<Pedido> listarPorEstado(EstadoPedido estado);
}