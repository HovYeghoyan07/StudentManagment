package am.itspace.studentmanagment.repository;

import am.itspace.studentmanagment.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
