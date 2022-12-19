package ru.skypro.hogwarts32.service;

import org.springframework.stereotype.Service;
import ru.skypro.hogwarts32.entities.Faculty;
import ru.skypro.hogwarts32.entities.Student;
import ru.skypro.hogwarts32.exeption.StudentNotFoundException;
import ru.skypro.hogwarts32.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        student.setId(0);
        return studentRepository.save(student);
    }

    public Student read(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student update(long id,
                          Student student) {
        Student oldStudent = read(id);
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        return studentRepository.save(oldStudent);
    }

    public Student delete(long id) {
        Student student = read(id);
        studentRepository.delete(student);
        return student;
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findAllByAge(age);
    }
}