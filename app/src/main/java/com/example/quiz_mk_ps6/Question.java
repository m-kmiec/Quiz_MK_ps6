package com.example.quiz_mk_ps6;

public class Question {

    private int questionId;
    private boolean correctAnswer;

    public Question(int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.correctAnswer = trueAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }
}
