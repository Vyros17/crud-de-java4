package com.crud.consse.controllers;
import com.crud.consse.domain.dto.CarDto;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.mappers.impl.CarMapper;
import com.crud.consse.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;
    @Autowired
    public CarController(CarService carService, CarMapper carMapper){
        this.carService = carService;
        this.carMapper = carMapper;
    }
    @GetMapping
    public Iterable<CarEntity> getAllCars(){
        return carService.getCars();
    }
    @PostMapping
    public String createCar(@RequestBody final CarDto carDto){
        CarEntity carEntity = carMapper.mapFrom(carDto);
        return carService.createCar(carEntity);
    }



}
