package com.devglan.controller;

import com.devglan.model.ApiResponse;
import com.devglan.model.publication.Publication;
import com.devglan.model.publication.PublicationDto;
import com.devglan.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @PostMapping
    public ApiResponse<Publication> savePublication(@RequestBody PublicationDto publicationDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Publication saved successfully", publicationService.save(publicationDto));
    }

    @GetMapping
    public ApiResponse<List<Publication>> publicationsList() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Publications list fetched successfully", publicationService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Publication> getOne(@PathVariable int id) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Publication fetched successfully", publicationService.findById(id));
    }

    @GetMapping("/title")
    public ApiResponse<Publication> getPublicationByTitle(@RequestParam String title) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Publication fetched successfully", publicationService.findOneByTitle(title));
    }

    @PutMapping("/{id}")
    public ApiResponse<PublicationDto> updatePublication(@RequestBody PublicationDto publicationDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Publication updated successfully", publicationService.update(publicationDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deletePublication(@PathVariable int id) {
        publicationService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Publication deleted successfully", null);
    }
}
