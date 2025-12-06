package com.budgetify.Models;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "income")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;      // FIXED: was "Id"

    private String name;
    private double amount;
    private String category;
    private Date date;
}