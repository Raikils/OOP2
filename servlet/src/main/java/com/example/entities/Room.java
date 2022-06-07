package com.example.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"ID", "place", "clas", "booked","price"})
public class Room {
    private int ID;
    private int place;
    private int clas;
    private boolean booked;
    private float price;
}
