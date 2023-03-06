package br.com.curso.productms.controller;


import br.com.curso.productms.dto.request.ProductDtoRequest;
import br.com.curso.productms.dto.response.ProductDtoResponse;
import br.com.curso.productms.service.IMPL.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceIMPL service;

    @PostMapping
    ResponseEntity<ProductDtoResponse> create(@Valid @RequestBody ProductDtoRequest request) {
        Optional<ProductDtoResponse> product = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(product.get());
    }

    @GetMapping
    ResponseEntity<List<ProductDtoResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDtoResponse> getById(@PathVariable Long id) {
        Optional<ProductDtoResponse> product = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductDtoResponse> update(@PathVariable Long id, @Valid @RequestBody ProductDtoRequest request) {
        Optional<ProductDtoResponse> product = service.update(request, id);
        return ResponseEntity.status(HttpStatus.OK).body(product.get());

    }


    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean delete = service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }
}
