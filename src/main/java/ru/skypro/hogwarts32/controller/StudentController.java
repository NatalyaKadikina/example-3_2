package ru.skypro.hogwarts32.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hogwarts32.entities.Student;
import ru.skypro.hogwarts32.service.StudentService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student read(@PathVariable long id) {
        return studentService.read(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable long id,
                          @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable long id) {
        return studentService.delete(id);
    }

    @GetMapping
    public Collection<Student> findByAge(@RequestParam int age) {
        return studentService.findByAge(age);
    }
}
