package com.smarthome.course.bff.model.vo;

import com.smarthome.course.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBFFVo implements Comparable<Product>{
    private Long id;
    private String name;
    private String description;
    private Double price;

    @Override
    public int compareTo(Product other) {

        return this.getId().compareTo(other.getId());
    }
}
