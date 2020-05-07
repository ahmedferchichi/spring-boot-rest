package com.devglan.service;

import com.devglan.model.thematic.ThamaticDto;
import com.devglan.model.thematic.Thematic;

import java.util.List;

public interface ThematicService {

    Thematic save( ThamaticDto thematic);
    List<Thematic> findAll();

    Thematic findOne(String title);

    Thematic findById(int id);

    ThamaticDto update(ThamaticDto thematicDto);

    void delete(int id);

}
