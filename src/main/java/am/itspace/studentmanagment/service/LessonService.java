package am.itspace.studentmanagment.service;

import am.itspace.studentmanagment.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();
    Lesson save(Lesson lesson);
    void deleteById(int id);
}
