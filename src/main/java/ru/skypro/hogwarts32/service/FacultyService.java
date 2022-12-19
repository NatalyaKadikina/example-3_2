package ru.skypro.hogwarts32.service;

import org.springframework.stereotype.Service;
import ru.skypro.hogwarts32.entities.Faculty;
import ru.skypro.hogwarts32.exeption.FacultyNotFoundException;
import ru.skypro.hogwarts32.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FacultyService{

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        faculty.setId(0);
        return facultyRepository.save(faculty);
    }

    public Faculty read(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public Faculty update(long id,
                          Faculty faculty) {
        Faculty oldFaculty = read(id);
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        return facultyRepository.save(oldFaculty);
    }

    public Faculty delete(long id) {
        Faculty faculty = read(id);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }
}

