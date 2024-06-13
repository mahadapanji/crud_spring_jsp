package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProjectController {


    @Autowired
    ProjectService projectService;

    @GetMapping({"/", "/viewProjectList"})
    public String viewAProjectList(Model model){
        model.addAttribute("projectList", projectService.getAllProject());
        return "ViewProjectList";
    }

    @GetMapping("/addProject")
    public String getProject(@ModelAttribute("message") String message, Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("message", message);

        return "AddProject";
    }

    @PostMapping("/saveProject")
    public String saveProject(Project project, RedirectAttributes redirectAttributes){
        if (projectService.saveOrUpdateProject(project)){
            redirectAttributes.addFlashAttribute("message","Save Success");
            return "redirect:/viewProjectList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/addProject";
    }

    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable Long id, Model model){
        model.addAttribute("project", projectService.getProjectById(id));

        return "EditProject";
    }

    @PostMapping("/editSaveProject")
    public String eSaveProject(Project project, RedirectAttributes redirectAttributes){
        if (projectService.saveOrUpdateProject(project)){
            redirectAttributes.addFlashAttribute("message","Save Success");
            return "redirect:/viewProjectList";
        }
        redirectAttributes.addFlashAttribute("message","Save Failure");
        return "redirect:/editProject/" + project.getId();
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if (projectService.deleteAnime(id)){
            redirectAttributes.addFlashAttribute("message","Delete Success");
            return "redirect:/viewProjectList";
        }
        redirectAttributes.addFlashAttribute("message","Delete Failure");
        return "redirect:/viewProjectList";
    }

}
