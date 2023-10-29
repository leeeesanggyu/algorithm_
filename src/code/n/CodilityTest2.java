package code.n;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodilityTest2 {

    public static void main(String[] args) throws IOException {
        List<SoldProduct> productList = List.of(
                new SoldProduct("a", new BigDecimal("1164.4300"), "KR"),
                new SoldProduct("b", new BigDecimal("0000.0003"), "AS"),
                new SoldProduct("c", new BigDecimal("1164.4300"), "AS")
        );
        Stream<SoldProduct> products = productList.stream();

        if (products == null) {
            new SoldProductsAggregate(Collections.emptyList(), BigDecimal.ZERO);
        }

        List<SimpleSoldProduct> simpleSoldProducts = products
                .filter(product ->
                        rate(product.getCurrency()).isPresent() &&
                        rate(product.getCurrency()).get().compareTo(BigDecimal.ZERO) >= 0
                )
                .map(soldProduct -> new SimpleSoldProduct(
                        soldProduct.getName(),
                        soldProduct.getPrice().multiply(rate(soldProduct.getCurrency()).get())
                ))
                .collect(Collectors.toList());

        BigDecimal total = simpleSoldProducts.stream()
                .map(SimpleSoldProduct::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        SoldProductsAggregate soldProductsAggregate = new SoldProductsAggregate(simpleSoldProducts, total);
        System.out.println(soldProductsAggregate);
    }

    static Optional<BigDecimal> rate(String currency) {
        if (currency.equals("AS")) {
            return Optional.empty();
        } else {
            return Optional.of(new BigDecimal("10"));
        }
    }

    public static class SoldProduct {
        public String getName() {
            return name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public String getCurrency() {
            return currency;
        }

        String name;
        BigDecimal price;
        String currency;

        public SoldProduct(String name, BigDecimal price, String currency) {
            this.name = name;
            this.price = price;
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "SoldProduct{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", currency='" + currency + '\'' +
                    '}';
        }
    }

    public static class SoldProductsAggregate {
        List<SimpleSoldProduct> products;
        BigDecimal total;

        public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
            this.products = products;
            this.total = total;
        }

        @Override
        public String toString() {
            return "SoldProductsAggregate{" +
                    "products=" + products +
                    ", total=" + total +
                    '}';
        }
    }

    public static class SimpleSoldProduct {
        String name;
        BigDecimal price;

        @Override
        public String toString() {
            return "SimpleSoldProduct{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public String getName() {
            return name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public SimpleSoldProduct(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }
    }
}

