package com.crud.consse.controllers;


import com.crud.consse.domain.dto.ColorDto;
import com.crud.consse.domain.entities.ColorEntity;
import com.crud.consse.mappers.impl.ColorMapper;
import com.crud.consse.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/colors")
public class ColorController {
    private final ColorService colorService;
    private final ColorMapper colorMapper;
    @Autowired
    public ColorController(ColorService colorService,ColorMapper colorMapper){
        this.colorService = colorService;
        this.colorMapper = colorMapper;
    }
    @GetMapping
    public Iterable<ColorEntity> getAllCars(){
        return colorService.getColors();
    }
    @PostMapping
    public String createColor(@RequestBody final ColorDto colorDto){
        ColorEntity colorEntity = colorMapper.mapFrom(colorDto);
        colorService.createColor(colorEntity);
        return "Color Agregado";
    }
    @PutMapping("/{id}")
    public String updateCar(@PathVariable long id,@RequestBody ColorDto colorDto){
        ColorEntity colorEntity = colorMapper.mapFrom(colorDto);
        colorService.updateColor(id,colorEntity);
        return "Color Actualizado.";
    }
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable long id){
        return colorService.deleteColor(id);
    }
}
