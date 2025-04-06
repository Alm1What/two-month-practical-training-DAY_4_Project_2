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



}
