package com.crud.consse.services;
import com.crud.consse.domain.entities.CarEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


public interface CarService {
    public String createCar(CarEntity carEntity);
    public Iterable<CarEntity> getCars();
}
