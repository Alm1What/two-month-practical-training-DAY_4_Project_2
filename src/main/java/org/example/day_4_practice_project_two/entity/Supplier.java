package org.example.day_4_practice_project_two.entity;

import jakarta.persistence.*;
import org.example.day_4_practice_project_two.enumEntity.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInfo;

    private String address;

    private int rating;

    private Status status;

    private LocalDate deliveryDate;

    private BigDecimal totalPrice; // загальна сума замовлення (ціна * кількість)

    public Supplier() {
    }

    public Supplier(Long id, String name, String contactInfo, String address, int rating, Status status, LocalDate deliveryDate, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.address = address;
        this.rating = rating;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
