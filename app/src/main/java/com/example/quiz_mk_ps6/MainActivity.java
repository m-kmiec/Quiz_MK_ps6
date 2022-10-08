package com.example.quiz_mk_ps6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(view -> checkAnswerCorrectness(true));

        falseButton.setOnClickListener(view -> checkAnswerCorrectness(false));

        nextButton.setOnClickListener(view -> {
            currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
            setNextQuestion();
        });

        setNextQuestion();
    }

    private Question[] questions = new Question[] {
            new Question(R.string.q_merkury, false),
            new Question(R.string.q_ciaza, false),
            new Question(R.string.q_ziemia, true),
            new Question(R.string.q_mur, false),
            new Question(R.string.q_oczy, true),
            new Question(R.string.q_pory, false),
            new Question(R.string.q_mozg, false),
            new Question(R.string.q_grawitacja, true)
    };

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentQuestionIndex].getCorrectAnswer();

        int resultMessageId = 0;

        if (userAnswer == correctAnswer) {
           resultMessageId = R.string.correct_answer;
        } else {
            resultMessageId = R.string.incorrect_answer;
        }

        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion() {
        questionTextView.setText(questions[currentQuestionIndex].getQuestionId());
    }
}