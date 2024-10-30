package ru.hogwarts.artefact.school.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.artefact.school.model.Faculty;
import ru.hogwarts.artefact.school.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

  private final FacultyService facultyService = new FacultyService();

  @PostMapping
  public Faculty createFaculty(@RequestParam String name, @RequestParam String color) {
    return facultyService.addFaculty(name, color);
  }

  @GetMapping("/get/{id}")
  public Faculty getFaculty(@PathVariable Long id) {
    return facultyService.getFaculty(id);
  }

  @GetMapping
  public List<Faculty> getAllFaculty() {
    return new ArrayList<>(facultyService.getAllFaculties().values());
  }

  @PutMapping("/update/{id}")
  public Faculty updateFaculty(@PathVariable Long id, @RequestParam String name,
      @RequestParam String color) {
    return facultyService.updateFaculty(id, name, color);
  }

  @DeleteMapping("/delete/{id}")
  public Faculty deleteFaculty(@PathVariable Long id) {
    return facultyService.deleteFaculty(id);
  }

  @GetMapping("/color/{color}")
  public List<Faculty> getFacultiesByColor(@PathVariable String color) {
    List<Faculty> list = new ArrayList<>();
    for (Faculty faculty : facultyService.getAllFaculties().values()) {
      if (faculty.getColor().equals(color)) {
        list.add(faculty);
      }
    }
    return list;
  }
}
