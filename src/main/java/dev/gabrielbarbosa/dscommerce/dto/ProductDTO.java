package dev.gabrielbarbosa.dscommerce.dto;

import dev.gabrielbarbosa.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDTO {

    private Long id;
    @NotBlank(message = "CAMPO REQUERIDO.")
    @Size(min = 3, max = 80, message = "DIGITE ENTRE 3 E 80 CARACTERES.")
    private String name;
    @Size(min = 10, message = "MINIMO DE CARACTERER 10.")
    private String description;
    @NotNull(message = "CAMPO REQUERIDO.")
    @Positive(message = "O PREÇO PRECISA SER POSITIVO.")
    private Double price;
    private String imgUrl;
    @NotEmpty(message = "DEVE TER AO MENOS UMA CATEGORIA.")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
        this.categories = product.getCategories().stream().map(CategoryDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
