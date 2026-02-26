package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Pedido;
import com.elSurco.ElSurco_in5bv.Repository.PedidoRepository;
import com.elSurco.ElSurco_in5bv.Util.EstadoPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido con ID Erróneo"));
    }

    @Override
    public Pedido agregar(Pedido pedido) {
        pedido.setIdPedido(null);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizar(Integer id, Pedido pedido) {
        Pedido pedidoExistente = pedidoRepository.findById(id).orElse(null);

        if (pedidoExistente != null) {
            pedidoExistente.setTotalPedido(pedido.getTotalPedido());
            pedidoExistente.setCantidadPedido(pedido.getCantidadPedido());
            pedidoExistente.setEstadoPedido(pedido.getEstadoPedido());

            pedidoExistente.setComprador(pedido.getComprador());
            pedidoExistente.setProducto(pedido.getProducto());

            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> listarPorComprador(Integer idComprador) {
        return pedidoRepository.findByComprador_IdComprador(idComprador);
    }

    @Override
    public List<Pedido> listarPorEstado(EstadoPedido estado) {
        return pedidoRepository.findByEstadoPedido(estado);
    }
}