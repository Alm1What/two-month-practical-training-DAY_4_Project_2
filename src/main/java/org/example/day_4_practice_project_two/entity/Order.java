package org.example.day_4_practice_project_two.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    private String customerName;

    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Order() {
    }

    public Order(Long id, LocalDate orderDate, String customerName, int quantity, Product product) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
