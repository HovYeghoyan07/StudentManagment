package am.itspace.studentmanagment.service.impl;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.repository.LessonRepository;
import am.itspace.studentmanagment.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteById(int id) {
    lessonRepository.deleteById(id);
    }
}
