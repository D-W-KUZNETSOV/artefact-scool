package ru.hogwarts.artefact.school.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import ru.hogwarts.artefact.school.model.Student;

@Service

public class StudentService {

  private final Map<Long, Student> students = new HashMap<>();
  private Long idCounter = 1L;

  public Student addStudent(String name, int age) {
    Student student = new Student(idCounter++, name, age);
    students.put(student.getId(), student);
    return student;
  }

  public Student getStudent(Long Id) {
    return students.get(Id);
  }

  public Map<Long, Student> getAllStudents() {
    return students;
  }

  public Student updateStudent(Long id, String name, int age) {
    Student student = students.get(id);
    if (student != null) {
      student.setName(name);
      student.setAge(age);
    }
    return student;
  }

  public Student deleteStudent(Long id) {

    return students.remove(id);
  }

}
