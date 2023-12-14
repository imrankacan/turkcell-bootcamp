package com.turkcell.spring.starter.entities.dtos.order;

import com.turkcell.spring.starter.entities.dtos.orderdetail.OrderDetailForAddDto;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderForAddDto {
    private String customerId; //Normalde giriş yapan kullanıcının id si otomotik alınır.
    private int employeeId;
    private LocalDate requiredDate;
    private short shipVia;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;


    private List<OrderDetailForAddDto>items;


}
