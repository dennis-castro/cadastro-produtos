package br.com.curso.productms.service;

import br.com.curso.productms.dto.request.ProductDtoRequest;
import br.com.curso.productms.dto.response.ProductDtoResponse;
import br.com.curso.productms.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductDtoResponse> create(ProductDtoRequest request);

    Optional<ProductDtoResponse> update(ProductDtoRequest request, Long id);

    List<ProductDtoResponse> getAll();

    Optional<ProductDtoResponse> getById(Long id);

    boolean delete (Long id);
}