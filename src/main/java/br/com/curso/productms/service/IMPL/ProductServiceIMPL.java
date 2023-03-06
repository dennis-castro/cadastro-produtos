package br.com.curso.productms.service.IMPL;

import br.com.curso.productms.dto.request.ProductDtoRequest;
import br.com.curso.productms.dto.response.ProductDtoResponse;
import br.com.curso.productms.exception.BadRequestException;
import br.com.curso.productms.exception.NotFoundException;
import br.com.curso.productms.mapper.ProductMapper;
import br.com.curso.productms.model.Product;
import br.com.curso.productms.repository.ProductRepository;
import br.com.curso.productms.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional
    public Optional<ProductDtoResponse> create(ProductDtoRequest request) {
        if (repository.existsByName(request.getName())) {
            throw new BadRequestException("O nome " + request.getName() + " ja esta sendo usado");
        }

        Product product = mapper.toProduct(request);
        product.setAvailable(true);
        repository.save(product);
        ProductDtoResponse response = mapper.toProductResponse(product);
        return Optional.of(response);
    }

    @Override
    public List<ProductDtoResponse> getAll() {
        List<Product> products = repository.findAll();
        return mapper.toListProductResponse(products);
    }

    @Override
    public Optional<ProductDtoResponse> getById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return Optional.of(mapper.toProductResponse(product.get()));
        }
        throw new NotFoundException("ID " + id + " não foi encontrado.");
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        Optional<ProductDtoResponse> product = getById(id);
        if (product.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    @Transactional
    public Optional<ProductDtoResponse> update(ProductDtoRequest request, Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            BeanUtils.copyProperties(request, product.get(), "id", "name");
            repository.save(product.get());
            return Optional.of(mapper.toProductResponse(product.get()));
        }
        throw new NotFoundException("ID " + id + " não foi encontrado.");
    }

    public Boolean existsByName(String name) {
        return repository.existsByName(name);
    }


}
