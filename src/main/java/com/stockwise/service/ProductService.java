package com.stockwise.service;

import com.stockwise.model.Product;
import com.stockwise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Listar todos os produtos
    public List<Product> findAll() {
        return repository.findAll();
    }

    // Buscar produto por ID
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    // Salvar ou atualizar produto
    public Product save(Product product) {
        return repository.save(product);
    }

    // Deletar produto por ID
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
