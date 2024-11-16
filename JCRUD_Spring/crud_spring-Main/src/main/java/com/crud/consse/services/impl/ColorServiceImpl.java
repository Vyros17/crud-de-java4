package com.crud.consse.services.impl;

import com.crud.consse.domain.entities.ColorEntity;
import com.crud.consse.repositories.ColorRepositories;
import com.crud.consse.services.ColorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    private ColorRepositories colorRepositories;
    public ColorServiceImpl(ColorRepositories colorRepositories){
        this.colorRepositories = colorRepositories;
    }
    @Override
    public Iterable<ColorEntity> getColors() {
        return colorRepositories.findAll();
    }

    @Override
    public ColorEntity createColor(ColorEntity colorEntity) {
        return colorRepositories.save(colorEntity);
    }

    @Override
    public Optional<ColorEntity> updateColor(long id, ColorEntity colorEntity) {
        Optional<ColorEntity> foundColor = colorRepositories.findById(id);
        if(foundColor.isPresent()){
            colorRepositories.deleteById(id);
            colorRepositories.save(colorEntity);
            return foundColor;
        }
        return Optional.empty();
    }

    @Override
    public String deleteColor(long id) {
        colorRepositories.deleteById(id);
        return "Color Eliminado";
    }
}
