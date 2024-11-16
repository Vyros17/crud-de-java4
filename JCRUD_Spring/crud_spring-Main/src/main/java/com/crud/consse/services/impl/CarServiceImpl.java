package com.crud.consse.services.impl;
import com.crud.consse.repositories.CarRepositories;

import org.springframework.stereotype.Service;
import com.crud.consse.domain.entities.CarEntity;
import com.crud.consse.services.CarService;
import org.springframework.dao.DataIntegrityViolationException;



@Service
public class CarServiceImpl implements CarService {
    private CarRepositories carRepositories;

    public CarServiceImpl(CarRepositories carRepositories){
        this.carRepositories = carRepositories;
    }

    @Override
    public String createCar(CarEntity carEntity) {
        try {
            carRepositories.save(carEntity);
            return "Auto creado";
        }catch(DataIntegrityViolationException e){
            return "Color inexistente";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public Iterable<CarEntity> getCars() {
        return carRepositories.findAll();
    }



}
