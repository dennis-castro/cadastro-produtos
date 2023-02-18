package br.com.curso.productms.controller;


import br.com.curso.productms.dto.request.ProductDto;
import br.com.curso.productms.dto.response.ProductDTOResponse;
import br.com.curso.productms.service.IMPL.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceIMPL service;


    @PostMapping
    ResponseEntity<ProductDTOResponse> salvar(@Valid @RequestBody ProductDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductDTOResponse> update(@PathVariable Long id,@Valid @RequestBody ProductDto request){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(request, id));
    }

    @GetMapping
    ResponseEntity<List<ProductDTOResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDTOResponse> getById(@PathVariable Long id){
        ProductDTOResponse productDTOResponse = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDTOResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
