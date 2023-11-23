package nl.novi.les11.les11model.controller;

import nl.novi.les11.les11model.model.Teacher;
import nl.novi.les11.les11model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherRepository.findAll());
    }

    @GetMapping("/after")
    public ResponseEntity<List<Teacher>> getTeachersAfter(@RequestParam LocalDate date) {
        return ResponseEntity.ok(teacherRepository.findByDobAfter(date));
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + teacher.getId()).toUriString());
        return ResponseEntity.created(uri).body(teacher);
    }
}
