package com.devglan.controller;

import com.devglan.model.ApiResponse;
import com.devglan.model.thematic.ThamaticDto;
import com.devglan.model.thematic.Thematic;
import com.devglan.service.ThematicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/thematic")
public class ThematicController {

    @Autowired
    private ThematicService thematicService;

    @PostMapping
    public ApiResponse<Thematic> saveThematic(@RequestBody ThamaticDto thematic){
        return new ApiResponse<>(HttpStatus.OK.value(), "Thematic saved successfully.", thematicService.save(thematic));
    }

    @GetMapping
    public ApiResponse<List<Thematic>> listThematic(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Thematic list fetched successfully.", thematicService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Thematic> getThematic(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(),"Thematic fetched successfully.", thematicService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<ThamaticDto> updateThematic(@RequestBody ThamaticDto thematic){
        return new ApiResponse<>(HttpStatus.OK.value(), "Thematic updated successfully.", thematicService.update(thematic));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteThematic(@PathVariable int id){
        thematicService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Thematic deleted successfully.", null);
    }
}
