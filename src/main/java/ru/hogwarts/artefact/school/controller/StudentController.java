package ru.hogwarts.artefact.school.controller;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.artefact.school.model.Student;
import ru.hogwarts.artefact.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
  private final StudentService studentService = new StudentService();

  @PostMapping
  public Student createStudent(@RequestParam String name, @RequestParam int age) {
    return studentService.addStudent(name, age);
  }

  @GetMapping("/get/{id}")
  public Student getStudent(@PathVariable Long id) {
    return studentService.getStudent(id);
  }

  @PutMapping("/update/{id}")
  public Student updateStudent(@PathVariable Long id, @RequestParam String name, @RequestParam int age) {
    return studentService.updateStudent(id, name, age);
  }

  @DeleteMapping("delete/{id}")
  public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
  }

  @GetMapping("/age/{age}")
  public List<Student> getStudentsByAge(@PathVariable int age) {
    return studentService.getAllStudents().values().stream()
        .filter(student -> student.getAge() == age)
        .collect(Collectors.toList());
  }
}
