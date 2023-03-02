package com.example.jira.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TSHIRTSIZE")
public class TShirtSize {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;
    @Enumerated(EnumType.STRING)
    private TShirtSizeName sizeName;
    private double sizeValue;
}
