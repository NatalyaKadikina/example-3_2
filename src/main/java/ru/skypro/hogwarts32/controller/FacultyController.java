package ru.skypro.hogwarts32.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hogwarts32.entities.Faculty;
import ru.skypro.hogwarts32.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty read(@PathVariable long id) {
        return facultyService.read(id);
    }

    @PostMapping
    public Faculty createSt(@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }

    @PutMapping("{id}")
    public Faculty update(@PathVariable long id, @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("{id}")
    public Faculty delete(@PathVariable long id) {
        return facultyService.delete(id);
    }

    @GetMapping
    public Collection<Faculty> findByCollor(@RequestParam String color) {
        return facultyService.findByColor(color);
    }
}
