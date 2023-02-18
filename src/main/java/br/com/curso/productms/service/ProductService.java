package br.com.curso.productms.service;

import br.com.curso.productms.dto.request.ProductDto;
import br.com.curso.productms.dto.response.ProductDTOResponse;

import java.util.List;

public interface ProductService {

    ProductDTOResponse create(ProductDto request);

    ProductDTOResponse update(ProductDto request,Long id);


    List<ProductDTOResponse> getAll();

    ProductDTOResponse getById(Long id);

    void delete (Long id);

}