package com.example.portalspolecznosciowy.services;

import com.example.portalspolecznosciowy.models.Sections;
import com.example.portalspolecznosciowy.repositories.SectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionsServices {

    @Autowired
    SectionsRepository sectionsRepository;

    public Sections findSectionByName(String name) {
        Sections sections = sectionsRepository.findIdByName(name);
        return sections;
    }

    public List<Sections> allSections() {
        List<Sections> sections= new ArrayList<Sections>();
        sectionsRepository.getAllSections().forEach(sections::add);
        return sections;
    }
    public String findSectionName(long id) {
        return sectionsRepository.findSectionName(id);
    }
}
