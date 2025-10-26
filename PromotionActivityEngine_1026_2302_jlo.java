// 代码生成时间: 2025-10-26 23:02:39
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * ManagedBean for Promotion Activity Engine.
 * Provides methods to apply promotions to products.
 */
@ManagedBean(name = "promotionActivityEngine")
@ViewScoped
public class PromotionActivityEngine {

    // List of products that can be promoted
    private List<Product> products;

    // Constructor
    public PromotionActivityEngine() {
        products = new ArrayList<>();
        // Initialize with some dummy products for demonstration
        products.add(new Product("Product 1", 100.0, true));
        products.add(new Product("Product 2", 200.0, false));
        // ... Add more products as needed
    }

    /**
     * Applies a discount to a product based on the promotion conditions.
     * @param product The product to apply the promotion to.
     * @return The updated product with the promotion applied.
     */
    public Product applyPromotion(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        // Check if the product is eligible for promotion
        if (product.isPromotable()) {
            // Apply a fixed discount
            product.setPrice(product.getPrice() * 0.9);
        } else {
            System.out.println("Product is not eligible for promotion");
        }

        return product;
    }

    /**
     * Gets the list of products.
     * @return The list of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the list of products.
     * @param products The list of products to set.
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Product class representing a product with price and promotion eligibility
    public static class Product {
        private String name;
        private double price;
        private boolean promotable;

        public Product(String name, double price, boolean promotable) {
            this.name = name;
            this.price = price;
            this.promotable = promotable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isPromotable() {
            return promotable;
        }

        public void setPromotable(boolean promotable) {
            this.promotable = promotable;
        }
    }
}
