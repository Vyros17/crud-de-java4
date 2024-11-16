package com.crud.consse.domain.entities;

import com.crud.consse.domain.dto.ColorDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String plate;
    private String model;
    private String brand;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_color",nullable = false)
    @JsonIgnore
    private ColorEntity color;
    private float speed;

}
