package br.com.curso.productms.dto.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Data
public class   ProductDTOResponse {

    private Long id;

    private String name;

    private String description;

    private double price;

    private boolean available;
}
