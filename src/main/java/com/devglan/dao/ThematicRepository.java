package com.devglan.dao;

import com.devglan.model.thematic.Thematic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThematicRepository extends CrudRepository<Thematic, Integer> {

    Thematic findByTitle(String title);
}
