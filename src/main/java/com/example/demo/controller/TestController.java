package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> handleDynamicRequest(@RequestBody Map<String, Object> payload) {

        Map<String, Object> response = new HashMap<>();
        int status = 200;

        try{

            Project prjct = new Project();

            if (payload.containsKey("id")) prjct.setId(Long.parseLong(payload.get("id").toString()));

            prjct.setName(payload.get("name").toString());
            prjct.setYear(Integer.parseInt(payload.get("year").toString()));
            projectService.saveOrUpdateProject(prjct);

            response.put("message", "success");

        }catch (Exception e){

            status = 400;
            response = new HashMap<>();
            response.put("message", e.getMessage());
        }


        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/get_data")
    public ResponseEntity<Map<String, Object>> getData() {

        Map<String, Object> response = new HashMap<>();
        int status = 200;

        try{
            response.put("message","success");
            List<Project> all_data = projectService.getAllProject();

            response.put("data", all_data);


        }catch (Exception e){
            status = 400;
            response = new HashMap<>();
            response.put("message", e.getMessage());
        }

        return ResponseEntity.status(status).body(response);
    }

}
