package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.QuestionEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.QuestionRepository;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Iterable<String> allQuestions(String cuisine) {
        List<String> output=new ArrayList<>();
        for (QuestionEntity questionEntity : questionRepository.findAllByCuisine(cuisine)
                ) {
            output.add(questionEntity.getQuestion());
        }
        return output;
    }

    @Override
    public void deleteQuestion(String question, String cuisine) throws NoSuchEntityException{
        Optional<QuestionEntity> searched=questionRepository.findQuestionEntityByQuestionAndCuisine(question, cuisine);
        if (searched.isEmpty()){
            throw new NoSuchEntityException(question);
        }
    questionRepository.deleteById(searched.get().getId());
    }

    @Override
    public String createQuestion(String question, String cuisine) throws EntityAlreadyExistsException {
        Optional<QuestionEntity> searched=questionRepository.findQuestionEntityByQuestionAndCuisine(question, cuisine);
        if (searched.isEmpty()){
            return questionRepository.save(new QuestionEntity(question,cuisine)).getQuestion();
        }
        throw new EntityAlreadyExistsException(question);

    }

    @Override
    public void saveQuestion(String oldQuestion, String newQuestion, String cuisine)throws NoSuchEntityException {
        Optional<QuestionEntity> searched=questionRepository.findQuestionEntityByQuestionAndCuisine(oldQuestion, cuisine);
        if (searched.isEmpty()){
            throw new NoSuchEntityException(oldQuestion);
        }
        QuestionEntity output=searched.get();
        output.setQuestion(newQuestion);
        questionRepository.save(output);
    }
}
