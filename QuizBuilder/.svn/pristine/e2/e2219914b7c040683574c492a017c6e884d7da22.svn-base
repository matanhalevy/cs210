package ca.ubc.cpsc210.quizbuilder.model.questionslist;

import java.util.Collections;
import java.util.Random;

import ca.ubc.cpsc210.quizbuilder.model.question.Question;

/**
 * Represents a random list of quiz questions.
 */
public class RandomizedQuestionsList extends QuestionsList {

    @Override
    public void addQuestion(Question q) {
        super.addQuestion(q);

        // Randomize the order of the questions list. Ideally, we wouldn't do
        // this on every invocation of addQuestion, but that's our API..
        long seed = System.nanoTime();
        Collections.shuffle(questions, new Random(seed));
    }
}
