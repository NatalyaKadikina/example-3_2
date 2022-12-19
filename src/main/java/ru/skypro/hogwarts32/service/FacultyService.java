package ru.skypro.hogwarts32.service;

import ru.skypro.hogwarts32.entities.Faculty;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Faculty editFaculty(long id, Faculty faculty);

    void deleteFaculty(long id);
}
