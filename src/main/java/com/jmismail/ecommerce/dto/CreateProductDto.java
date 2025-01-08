package com.jmismail.ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CreateProductDto  {

    @NotNull(message = "Name is required")
    @Length(min = 3, max = 100, message = "Must have 3-100 characters")
    private String name;

    @NotNull(message = "Required")
    @Length(max = 250, message = "Maximum 250 characters are allowed")
    private String description;

    @NotNull(message = "Should have a price")
    @Min(value = 1, message = "Should be greater than zero")
    private int price;
    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CreateProductDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
