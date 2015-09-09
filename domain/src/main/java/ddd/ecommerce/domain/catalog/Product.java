package ddd.ecommerce.domain.catalog;

public class Product {
    private ProductId productId;
    private String description;
    private String brand;
    private String ASIN;
    private String weight;
    private String dimension;
    private Category category;

    public Product(ProductId productId, String description, String brand, String ASIN, String weight, String dimension, Category category) {
        this.productId = productId;
        this.description = description;
        this.brand = brand;
        this.ASIN = ASIN;
        this.weight = weight;
        this.dimension = dimension;
        this.category = category;
    }

    public ProductId getId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getASIN() {
        return ASIN;
    }

    public String getWeight() {
        return weight;
    }

    public String getDimension() {
        return dimension;
    }

    public Category getCategory() {
        return category;
    }
}
