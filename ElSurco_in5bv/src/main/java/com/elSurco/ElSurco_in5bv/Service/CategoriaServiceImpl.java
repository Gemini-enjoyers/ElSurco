package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Categoria;
import com.elSurco.ElSurco_in5bv.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría con ID Erróneo"));
    }

    @Override
    public Categoria agregar(Categoria categoria) {
        categoria.setIdCategoria(null);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizar(Integer id, Categoria categoria) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);

        if (categoriaExistente != null) {
            categoriaExistente.setNombreCategoria(categoria.getNombreCategoria());
            categoriaExistente.setDescripcionCategoria(categoria.getDescripcionCategoria());

            return categoriaRepository.save(categoriaExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}