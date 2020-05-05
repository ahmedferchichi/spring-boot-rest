package com.devglan.service.impl;

import com.devglan.dao.ThematicRepository;
import com.devglan.model.thematic.ThamaticDto;
import com.devglan.model.thematic.Thematic;
import com.devglan.service.ThematicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service(value = "ThematicService")
public class ThematicServiceImpl implements ThematicService {

    @Autowired
    private ThematicRepository thematicRepository;

    public List<Thematic> findAll() {
        List<Thematic> list = new ArrayList<>();
        thematicRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Thematic findOne(String title) {
        return thematicRepository.findByTitle(title);
    }

    @Override
    public Thematic findById(int id) {
        Optional<Thematic> optionalThematic = thematicRepository.findById(id);
        return optionalThematic.isPresent() ? optionalThematic.get() : null;
    }

    @Override
    public ThamaticDto update(ThamaticDto thematicDto) {
        Thematic thematic = findById(thematicDto.getId());
        if(thematic != null) {
            BeanUtils.copyProperties(thematicDto, thematic);
            thematicRepository.save(thematic);
        }
        return thematicDto;
    }

    @Override
    public void delete(int id) {
        thematicRepository.deleteById(id);
    }

    @Override
    public Thematic save(ThamaticDto thematic) {
        Thematic newThematic = new Thematic();
        newThematic.setTitle(thematic.getTitle());
        return thematicRepository.save(newThematic);
    }
}
