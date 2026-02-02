package com.example.ec.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductForm {

    @NotBlank(message = "商品名は必須です")
    private String name;

    @NotNull(message = "価格は必須です")
    @Min(value = 0, message = "価格は0以上で入力してください")
    private Integer price;

    private String description;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
