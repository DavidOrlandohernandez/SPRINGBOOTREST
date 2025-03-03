package org.prototype;

import org.prototype.prototype.PriceList;
import org.prototype.prototype.Product;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PriceList priceList = new PriceList("Lista Normal");
        List<Product> productList = List.of(
                new Product("Computadora", 10000.00),
                new Product("Mouse", 12000.00),
                new Product("Teclado", 13000.00),
                new Product("Pantalla", 14000.00),
                new Product("Auriculares", 15000.00));
        priceList.setProductList(productList);
        System.out.println(priceList);

        //Segunda lista de precios con descuento
        PriceList priceList2 = (PriceList) priceList.deepClone();
        priceList2.setName("Lista Preferencial");


        for(Product product : priceList2.getProductList()) {
                product.setPrice(product.getPrice() * 0.9);
        }

        System.out.println(priceList2);
    }
}