package ca.ubc.cpsc210.quizbuilder.model.quiz;

import ca.ubc.cpsc210.quizbuilder.model.exceptions.OutOfTriesException;
import ca.ubc.cpsc210.quizbuilder.model.exceptions.RetryAnswerException;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;

/**
 * Created by Yoram on 2014-11-30.
 */
public class DecrementMarksQuiz extends EachAnswerMustBeRightQuiz {
    public DecrementMarksQuiz(QuestionsList questions) {
        super(questions);
    }

    @Override
    public String submitAnswer(String answer) throws RetryAnswerException, OutOfTriesException{
        boolean correct = super.checkAnswer(answer);
        if (!correct){
            curQuestion.setMaxMark(curQuestion.getMaxMark()-1);
            if (curQuestion.getMaxMark() > 0){
                throw new RetryAnswerException("Try Again");
            }
            if (curQuestion.getMaxMark() == 0){
                throw new OutOfTriesException("You have run out of tries");
            }
        }
        return "";
    }
}
