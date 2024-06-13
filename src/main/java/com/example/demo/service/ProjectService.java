package com.example.demo.service;

import com.example.demo.model.Project;
import com.example.demo.repo.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    IProjectRepository projectRepo;

    public List<Project> getAllProject(){
        List<Project> projectList = new ArrayList<>();
        projectRepo.findAll().forEach(project -> projectList.add(project));

        return projectList;
    }

    public Project getProjectById(Long id){
        return projectRepo.findById(id).get();
    }

    public boolean saveOrUpdateProject(Project project){
        Project updatedProject = projectRepo.save(project);

        if (projectRepo.findById(updatedProject.getId()) != null){
            return true;
        }

        return false;

    }


    public boolean deleteAnime(Long id){
         projectRepo.deleteById(id);

        if (projectRepo.findById(id) != null){
            return true;
        }

        return false;

    }


}
