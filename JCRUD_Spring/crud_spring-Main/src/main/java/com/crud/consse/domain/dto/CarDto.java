package com.crud.consse.domain.dto;

import com.crud.consse.domain.entities.ColorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private long id;
    private String plate;
    private String model;
    private String brand;
    private ColorEntity color;
    private float speed;
}
