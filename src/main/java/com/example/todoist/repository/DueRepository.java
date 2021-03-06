package com.example.todoist.repository;

import com.example.todoist.model.Due;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DueRepository extends JpaRepository<Due, String> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Due c WHERE c.string = :string")
    boolean existsByString(@Param("string") String string);

    Due findDueByString(String string);
}
