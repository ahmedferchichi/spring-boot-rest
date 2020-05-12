package com.devglan.dao;

import com.devglan.model.publication.Publication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer> {

    Publication findPublicationByTitle(String title);

}
