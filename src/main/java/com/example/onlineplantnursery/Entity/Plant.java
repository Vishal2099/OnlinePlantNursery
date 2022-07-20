package com.example.onlineplantnursery.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="plantrecord")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long plantId;
    private Integer plantHeight;
    private String plantSpread;
    private String commonName;
    private String bloomTime;
    private String medicinalOrCulinaryUse;
    private String difficultyLevel;
    private String temperature;
    private String typeOfPlant;
    private String plantDescription;
    private Integer plantsStock;
    private double plantCost;
}
