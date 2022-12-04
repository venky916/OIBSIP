package com.example.offline_quiz;

import static com.example.offline_quiz.QuestionAnswer.correctAnswers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestions;
    TextView question;
    RadioGroup rag;
    RadioButton ansA, ansB, ansC, ansD;
    Button submit;

    int score = 0;
    int total_question = QuestionAnswer.questions.length;
    int currentQuestionIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestions = findViewById(R.id.total_questions);
        question = findViewById(R.id.question);
        rag=findViewById(R.id.RG);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(this);

        totalQuestions.setText("total questions: " + total_question);
        loadNewQuestion();

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.submit_btn) {
            onPressButton();
        }

    }

    private void onPressButton() {
        if(ansA.isChecked()) {
            checkAndMove(ansA);
        }else if(ansB.isChecked()) {
            checkAndMove(ansB);

        }else if(ansC.isChecked()) {
            checkAndMove(ansC);
        }else if (ansD.isChecked()) {
            checkAndMove(ansD);
        }else {
            Toast.makeText(this, "Please select a answer", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkAndMove(RadioButton answer) {

        if(answer.getText().equals(correctAnswers[currentQuestionIndex])) {
            score ++;
            answer.setChecked(false);
        }
        currentQuestionIndex++;
        loadNewQuestion();
    }

    void loadNewQuestion() {

        if (currentQuestionIndex == total_question) {
            finishQuiz();
            return;
        }
        question.setText(QuestionAnswer.questions[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        currentQuestionIndex = 0;
        
        String passStatus = "";
        if (score > total_question * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is"+score+"out of "+total_question)
                .setPositiveButton("Restart",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();

    }
}