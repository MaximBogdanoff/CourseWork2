package ru.skypro.Course_work_2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.Course_work_2.model.Question;
import ru.skypro.Course_work_2.service.QuestionService;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("Какая сегодня погода?", "Неважно, важней всего погода в доме");
        add("Столица Израиля?", "Иерусалим");
        add("Кто поет песню Кольщик?", "Михаил Круг");
        add("Какой лучший файлообменник?", "Конечно же Skype!");
        add("Где лучшие тусовки?", "У нас в приюте");
    }
    @Override
    public Question add(String question, String answer) {
        Question questionAdd = new Question(question, answer);
        questions.add(questionAdd);
        return questionAdd;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> findAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question findAllRandomQuestion() {
        int randomQuestion = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomQuestion);
    }
}