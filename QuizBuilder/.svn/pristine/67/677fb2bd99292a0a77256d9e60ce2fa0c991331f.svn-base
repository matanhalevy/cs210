package ca.ubc.cpsc210.quizbuilder.model.quiz;

import ca.ubc.cpsc210.quizbuilder.model.exceptions.OutOfTriesException;
import ca.ubc.cpsc210.quizbuilder.model.exceptions.RetryAnswerException;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;

/**
 * Represents a Quiz that requires the right answer to a question before the
 * user can move on.
 */
public class EachAnswerMustBeRightQuiz extends Quiz {

    public EachAnswerMustBeRightQuiz(QuestionsList questions) {
        super(questions);
    }

    /**
     * Enforce the right answer requirement by throwing a RetryAnswerException
     * exception when the user submits a wrong answer.
     * Also must throw OutOfTriesException because its overriding method will do so.
     * Note: Nothing to do in this method for the assignment.
     */
    @Override
    public String submitAnswer(String answer) throws RetryAnswerException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);
        if (!correct) {
            throw new RetryAnswerException("Wrong answer, please retry.");
        }
        return "";
    }

}
