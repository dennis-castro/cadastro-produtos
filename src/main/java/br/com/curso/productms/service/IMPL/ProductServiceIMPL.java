package br.com.curso.productms.service.IMPL;

import br.com.curso.productms.dto.request.ProductDto;
import br.com.curso.productms.dto.response.ProductDTOResponse;
import br.com.curso.productms.exception.NotFoundException;
import br.com.curso.productms.mapper.ProductMapper;
import br.com.curso.productms.model.Product;
import br.com.curso.productms.repository.ProductRepository;
import br.com.curso.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductDTOResponse create(ProductDto request) {
        Product product = mapper.toProduct(request);
        product.setAvailable(true);
        repository.save(product);
        return mapper.toProductResponse(product);
    }


    @Override
    public ProductDTOResponse update(ProductDto request, Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            optionalProduct.get().setDescription(request.getDescription());
            optionalProduct.get().setPrice(request.getPrice());
            repository.save(optionalProduct.get());
            return mapper.toProductResponse(optionalProduct.get());
        }
        throw new NotFoundException("Product is not found");
    }

    @Override
    public List<ProductDTOResponse> getAll() {
        List<Product> products = repository.findAll();
        return mapper.toListProductResponse(products);
    }

    @Override
    public ProductDTOResponse getById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("Product is not found");
        }
        if (optionalProduct.get().isAvailable() == false) {
            throw new NotFoundException("Product is not found");
        }
        return mapper.toProductResponse(optionalProduct.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            throw new NotFoundException("Product is not found");
        }
        product.get().setAvailable(false);
        repository.saveAndFlush(product.get());
    }


}
