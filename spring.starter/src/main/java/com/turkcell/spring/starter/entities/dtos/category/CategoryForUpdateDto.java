package com.turkcell.spring.starter.entities.dtos.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryForUpdateDto {

    @NotNull() //String Alanlar dışındaki alanların boş olmama durumunun kontrolü
    @Min(1)
    private int id;

    @NotBlank(message = "Kategori Adı Girmek Zorunludur")
    @Size(min = 3)
    // Controller da çağırdığımız yerde @Valid demeliyiz.
    private String categoryName;

    @NotBlank
    private String description;
}
