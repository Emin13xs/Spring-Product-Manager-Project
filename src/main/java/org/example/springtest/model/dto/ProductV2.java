package org.example.springtest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class ProductV2 {
    private String name;
    private BigDecimal price;
    private String category;
    private Integer stock;

}
