package br.com.curso.productms.dto.request;

import lombok.Data;

import javax.validation.constraints.*;


@Data
public class ProductDto {


    @NotBlank(message = "This field is required")
    @Size(min= 3,max =30,message = "field with at maximum 10 characters")
    private String name;

    @Size(min = 10,message = "field with at least 10 characters")
    @NotBlank(message = "This field is required")
    private String description;

    @Positive(message = "this field cannot be null ")
    private double price;


}
