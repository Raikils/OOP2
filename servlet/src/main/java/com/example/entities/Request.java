package com.example.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"ID", "place", "clas", "approved","price", "IDROOM"})
public class Request {
    private int ID;
    private int place;
    private int clas;
    private boolean approved;
    private float price;
    private int IDROOM;
}
