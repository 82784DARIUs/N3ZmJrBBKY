// 代码生成时间: 2025-10-16 19:12:49
package com.yourcompany.b2bpurchase;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@ManagedBean(name = "purchaseBean")
@ViewScoped
public class B2BPurchaseSystem implements Serializable {

    // 产品列表
    private List<Product> products;

    // 采购详情
    private Product purchaseDetails;

    public B2BPurchaseSystem() {
        this.products = new ArrayList<>();
    }

    // 获取产品列表
    public List<Product> getProducts() {
        return products;
    }

    // 设置产品列表
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // 获取采购详情
    public Product getPurchaseDetails() {
        return purchaseDetails;
    }

    // 设置采购详情
    public void setPurchaseDetails(Product purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    // 添加产品到采购系统
    public void addProduct() {
        try {
            // 假设有一个方法来添加产品到数据库
            products.add(purchaseDetails);
            // 清空采购详情
            purchaseDetails = new Product();
        } catch (Exception e) {
            // 处理异常
            System.out.println("Error adding product to purchase system: " + e.getMessage());
        }
    }

    // 一个产品类
    public static class Product {
        private String id;
        private String name;
        private double price;
        private int quantity;

        public Product() {
        }

        public Product(String id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        // Getter 和 Setter
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
