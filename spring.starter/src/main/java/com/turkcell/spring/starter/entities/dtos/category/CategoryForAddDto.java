package com.turkcell.spring.starter.entities.dtos.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
//Validationlar kullanıcı girdilerinin olduğu bölgelerde yapılır
// Hatalı ve istenmeyen durumları önlemek adına yapılır
// Örneğin ; categoryName alanı 3 haneden küçük olamaz

@Data
public class CategoryForAddDto {

    @NotBlank(message = "Kategori Adı Girmek Zorunludur") //categoryName boş olamaz (Validation) https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary
    @Size(min = 3, message = "{categoryNameShouldBeMinimum}")
    // Controller da çağırdığımız yerde @Valid demeliyiz.
    private String categoryName;

    @NotBlank
    private String description;
}
