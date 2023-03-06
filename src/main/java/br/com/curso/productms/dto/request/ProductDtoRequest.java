package br.com.curso.productms.dto.request;

import lombok.Data;

import javax.validation.constraints.*;


@Data
public class ProductDtoRequest {


    @NotBlank(message = "Este campo não pode estar em branco")
    @Size(min= 3,max =30,message = "O nome deve conter entre 3 a 30 caracteres")
    private String name;

    @Size(min = 10,message = "A descrição deve conter no minimo 10 caracteres")
    @NotBlank(message = "Este campo não pode estar em branco")
    private String description;

    @Positive(message = "O preço deve ser positivo")
    private double price;


}
