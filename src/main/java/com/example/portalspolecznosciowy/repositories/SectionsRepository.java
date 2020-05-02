package com.example.portalspolecznosciowy.repositories;

import com.example.portalspolecznosciowy.models.Sections;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionsRepository extends CrudRepository<Sections,Long> {

    @Query(value = "select * from sections", nativeQuery = true)
    List<Sections> getAllSections();

    @Query(value = "select * from sections where name =?1", nativeQuery = true)
    Sections findIdByName(String email);

    @Query(value = "select name from sections where section_id=?1", nativeQuery = true)
    String findSectionName(long id);
}
