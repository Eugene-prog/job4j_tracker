package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.getActual() <= product.getStandard()
                        && product.getStandard() - product.getActual() <= 3)
                .map(product -> new Label(product.getName(), product.getPrice() * 0.5f).toString())
                .collect(Collectors.toList());
    }
}