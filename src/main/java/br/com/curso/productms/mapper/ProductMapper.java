package br.com.curso.productms.mapper;

import br.com.curso.productms.dto.request.ProductDtoRequest;
import br.com.curso.productms.dto.response.ProductDtoResponse;
import br.com.curso.productms.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper mapper;

    public Product toProduct(ProductDtoRequest request) {
        return mapper.map(request, Product.class);
    }

    public ProductDtoResponse toProductResponse(Product product){
        return mapper.map(product, ProductDtoResponse.class);
    }

    public List<ProductDtoResponse> toListProductResponse(List<Product> products){
        return products.stream()
                .map(this::toProductResponse)
                .collect(Collectors.toList());
    }

}
