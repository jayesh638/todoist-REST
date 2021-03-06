package com.example.todoist.repository;

import com.example.todoist.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Section c WHERE c.id = :id")
    boolean existsById(@Param("id") int id);

    @Override
    List<Section> findAll();

    @Override
    Optional<Section> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    Section getOne(Integer integer);

    List<Section> getSectionByProjectId(Integer id);
}
