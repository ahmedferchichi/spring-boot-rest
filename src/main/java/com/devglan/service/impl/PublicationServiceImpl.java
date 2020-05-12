package com.devglan.service.impl;

import com.devglan.dao.PublicationRepository;
import com.devglan.model.publication.Publication;
import com.devglan.model.publication.PublicationDto;
import com.devglan.service.PublicationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service(value = "publicationService")
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public Publication save(PublicationDto publication) {
        Publication newPublication = new Publication();
        newPublication.setTitle(publication.getTitle());
        newPublication.setContent(publication.getContent());
        newPublication.setEditor(publication.getEditor());
        newPublication.setDate(publication.getDate());
        newPublication.setThematics(publication.getThematics());
        return publicationRepository.save(newPublication);
    }

    @Override
    public List<Publication> findAll() {
        List<Publication> list = new ArrayList<>();
        publicationRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Publication findOneByTitle(String title) {
        return publicationRepository.findPublicationByTitle(title);
    }

    @Override
    public Publication findById(int id) {
        Optional<Publication> optionalPublication = publicationRepository.findById(id);
        return optionalPublication.isPresent() ? optionalPublication.get() : null;
    }

    @Override
    public PublicationDto update(PublicationDto publicationDto) {
        Publication publication = findById(publicationDto.getId());
        if (publication != null) {
            BeanUtils.copyProperties(publicationDto, publication, "editor", "date");
            publicationRepository.save(publication);
        }
        return publicationDto;
    }

    @Override
    public void delete(int id) {
        publicationRepository.deleteById(id);
    }
}
