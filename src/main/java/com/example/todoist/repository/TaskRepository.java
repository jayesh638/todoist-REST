package com.example.todoist.repository;

import com.example.todoist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    //List<Task> getTaskByProjectId(Integer id);
//    List<Task> getTasklistByUsername(String username);

    List<Task> getTaskBySectionIdAndProjectId(Integer sectionId, Integer projectId);
}
