package com.example.gamemath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity3 extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private Button submitButton, restartButton;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String[] questions = {
            "31 + 33 =",
            "19 + 21 =",
            "21 + 21 =",
            "67 + 24 =",
            "59 + 38 ="
    };

    private String[] answers = {"C", "A", "D", "B", "A"};

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        submitButton = findViewById(R.id.submitButton);
        restartButton = findViewById(R.id.restartButton);


        sharedPreferences = getSharedPreferences("GameMath", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    String selectedAnswer = getSelectedAnswer(checkedRadioButtonId);
                    if (selectedAnswer.equals(answers[currentQuestionIndex])) {
                        score += 20;
                    }

                    currentQuestionIndex++;

                    if (currentQuestionIndex < questions.length) {
                        saveScore(score);
                        optionsRadioGroup.clearCheck();
                        loadQuestion(); // Memuat pertanyaan berikutnya setelah memperbarui skor
                    } else {
                        saveScore(score);
                        showResult(); // Memanggil showResult() setelah semua pertanyaan telah dijawab
                    }
                } else {
                    Toast.makeText(MainActivity3.this, "Silakan pilih jawaban terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartQuiz();
            }
        });
    }


    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        option1RadioButton.setText("A. " + getOptionByIndex(currentQuestionIndex, 1));
        option2RadioButton.setText("B. " + getOptionByIndex(currentQuestionIndex, 2));
        option3RadioButton.setText("C. " + getOptionByIndex(currentQuestionIndex, 3));
        option4RadioButton.setText("D. " + getOptionByIndex(currentQuestionIndex, 4));
    }

    private String getOptionByIndex(int questionIndex, int optionIndex) {
        String[][] options = {
                {"62", "63", "64", "66"},
                {"40", "39", "41", "38"},
                {"44", "43", "41", "42"},
                {"89", "91", "90", "92"},
                {"97", "98", "99", "96"}
        };
        return options[questionIndex][optionIndex - 1];
    }

    private String getSelectedAnswer(int checkedRadioButtonId) {
        RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);
        String selectedAnswer = selectedRadioButton.getText().toString();
        return selectedAnswer.substring(0, 1); // Mengambil huruf pertama dari jawaban (A, B, C, D)
    }

    private void saveScore(int score) {
        editor.putInt("score", score);
        editor.apply();
    }

    private void showResult() {
        int totalScore = questions.length * 20;
        int userScore = sharedPreferences.getInt("score", 0);
        String result = "Skor akhir: " + userScore + " / " + totalScore;
        questionTextView.setText(result);
        optionsRadioGroup.setVisibility(View.GONE);
        submitButton.setEnabled(false);
        restartButton.setVisibility(View.VISIBLE);
    }

    private void restartQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        optionsRadioGroup.setVisibility(View.VISIBLE);
        submitButton.setEnabled(true);
        restartButton.setVisibility(View.GONE);
        loadQuestion();
    }
}
