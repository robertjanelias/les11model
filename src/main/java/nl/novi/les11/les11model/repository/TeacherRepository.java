package nl.novi.les11.les11model.repository;

import nl.novi.les11.les11model.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public List<Teacher> findByDobAfter(LocalDate date);
}
