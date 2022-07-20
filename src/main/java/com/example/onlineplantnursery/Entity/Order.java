package com.example.onlineplantnursery.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderrecord")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookingOrderId;
    private LocalDate orderDate=LocalDate.now();
    private String transactionMode;
    private int quantity;
    private double totalCost;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "booking_id",
            referencedColumnName = "bookingOrderId"
    )
    @JsonIgnore
    private List<Planter> planters;
}