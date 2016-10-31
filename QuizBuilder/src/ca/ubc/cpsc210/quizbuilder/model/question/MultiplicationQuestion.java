package ca.ubc.cpsc210.quizbuilder.model.question;

/**
 * Created by Yoram on 2014-11-30.
 */
public class MultiplicationQuestion extends Question {
    private int correctAnswer;

    public MultiplicationQuestion(double maxMark, int factor1, int factor2) {
        super(maxMark, Integer.toString(factor1) + " * " + Integer.toString(factor2) + " = ???");
        this.correctAnswer = factor1 * factor2;
    }

    @Override
    public boolean isCorrect(String answer) {
        try {
            return Integer.parseInt(answer) == correctAnswer;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
