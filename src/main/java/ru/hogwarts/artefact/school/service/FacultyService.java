package ru.hogwarts.artefact.school.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.artefact.school.model.Faculty;

@Service

public class FacultyService {
  private final Map<Long, Faculty> faculties = new HashMap<>();
  private Long idCounter = 1L;


  public Faculty addFaculty(String name, String color) {
    Faculty faculty = new Faculty(idCounter++, name, color);
    faculties.put(faculty.getId(), faculty);
    return faculty;
  }

  public Faculty getFaculty(Long id) {
    return faculties.get(id);
  }

  public Faculty updateFaculty(Long id, String name, String color) {
    Faculty faculty = faculties.get(id);
    if (faculty != null) {
      faculty.setName(name);
      faculty.setColor(color);
    }
    return faculty;
  }
  public Faculty deleteFaculty(Long id) {
    return faculties.remove(id);
  }

  public Map<Long, Faculty> getAllFaculties() {
    return faculties;
  }

}
