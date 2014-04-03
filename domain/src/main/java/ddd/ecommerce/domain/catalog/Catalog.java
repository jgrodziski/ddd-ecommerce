package ddd.ecommerce.domain.catalog;

import ddd.ecommerce.domain.Product;
import ddd.ecommerce.domain.ProductId;

import java.util.HashMap;
import java.util.Map;


public class Catalog {
    private String name;
    Map<String, Universe> universes;
    private Map<ProductId, Product> products;


    public Catalog(String name) {
        this.name = name;
        universes = new HashMap<String, Universe>();
        products = new HashMap<ProductId, Product>();
    }

    public String getName() {
        return name;
    }

    public Universe getUniverse(String id){
        return universes.get(id);
    }

    public void add(Universe universe){
        universes.put(universe.getId(), universe);
    }

    public void add(Product product) {
        products.put(product.getId(),product);
    }

    public Product get(ProductId productId){
        return products.get(productId);
    }
}
