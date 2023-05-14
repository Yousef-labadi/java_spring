package com.example.ProjectManager.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjectManager.Models.Project;
import com.example.ProjectManager.Models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project,Long> {
	
	List<Project> findAll();
	List<Project>findByUsersNotContains(User user);
	List<Project> findAllByUsers(User user);
}
