package com.project.pizzatime.controllers;

public class PizzaPrice {
    private double basePrice;
    private double sizePriceSmall;
    private double sizePriceMedium;
    private double sizePriceLarge;
    private double crustPriceThin;
    private double crustPriceThick;
    private double toppingPrice;

    public PizzaPrice() {
        // Default constructor
    }

    // Constructor with all attributes
    public PizzaPrice(double basePrice, double sizePriceSmall, double sizePriceMedium, double sizePriceLarge,
                      double crustPriceThin, double crustPriceThick, double toppingPrice) {
        this.basePrice = basePrice;
        this.sizePriceSmall = sizePriceSmall;
        this.sizePriceMedium = sizePriceMedium;
        this.sizePriceLarge = sizePriceLarge;
        this.crustPriceThin = crustPriceThin;
        this.crustPriceThick = crustPriceThick;
        this.toppingPrice = toppingPrice;
    }

    // Getters and setters
    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getSizePriceSmall() {
        return sizePriceSmall;
    }

    public void setSizePriceSmall(double sizePriceSmall) {
        this.sizePriceSmall = sizePriceSmall;
    }

    public double getSizePriceMedium() {
        return sizePriceMedium;
    }

    public void setSizePriceMedium(double sizePriceMedium) {
        this.sizePriceMedium = sizePriceMedium;
    }

    public double getSizePriceLarge() {
        return sizePriceLarge;
    }

    public void setSizePriceLarge(double sizePriceLarge) {
        this.sizePriceLarge = sizePriceLarge;
    }

    public double getCrustPriceThin() {
        return crustPriceThin;
    }

    public void setCrustPriceThin(double crustPriceThin) {
        this.crustPriceThin = crustPriceThin;
    }

    public double getCrustPriceThick() {
        return crustPriceThick;
    }

    public void setCrustPriceThick(double crustPriceThick) {
        this.crustPriceThick = crustPriceThick;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    // Example of defining default prices
    public static PizzaPrice getDefaultPrices() {
        return new PizzaPrice(8.99, 2.30, 2.00, 4.00, 3.00, 1.50, 1.00);
    }
}

