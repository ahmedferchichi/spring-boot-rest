package com.devglan.service;

import com.devglan.model.publication.Publication;
import com.devglan.model.publication.PublicationDto;

import java.util.List;

public interface PublicationService {

    Publication save(PublicationDto publication);

    List<Publication> findAll();

    Publication findOneByTitle(String title);

    Publication findById(int id);

    PublicationDto update(PublicationDto publicationDto);

    void delete(int id);
}
