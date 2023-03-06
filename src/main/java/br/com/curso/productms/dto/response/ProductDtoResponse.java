package br.com.curso.productms.dto.response;

import lombok.Data;


@Data
public class ProductDtoResponse {

    private Long id;

    private String name;

    private String description;

    private double price;

    private boolean available;
}
