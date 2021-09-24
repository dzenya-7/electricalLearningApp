package net.vrgsoft.rollinglayoutmanager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView lblQuestion;
    RadioButton optionA;
    RadioButton optionB;
    RadioButton optionC;
    RadioButton optionD;
    Button confirm;
    String rightAnswer;
    String Answer;
    List<Question> questions;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();
        confirm = findViewById(R.id.confirm);
        lblQuestion = findViewById(R.id.text2);
        optionA = findViewById(R.id.A);
        optionB = findViewById(R.id.B);
        optionC = findViewById(R.id.C);
        optionD = findViewById(R.id.D);
        score = 0;
        radioGroup = findViewById(R.id.radioGroup);

        questions = new ArrayList<Question>(){
            {
                add(new Question("Что такое электрический ток?", "B", "Графическое изображение элементов",
                        "Упорядоченное движение заряженных частиц в проводнике","Это устройство для измерения ЭДС", "Совокупность устройств предназначенных для использования электрического сопротивления"));
                add(new Question("Устройство, состоящее из двух проводников любой формы, разделенных диэлектриком?", "A",
                        "конденсатор", "резисторы","источник", "реостаты"));
                add(new Question("Определите сопротивление нити электрической лампы мощностью 100 Вт, если лампа рассчитана на напряжение 220 В.",
                        "D", "570 Ом", "488 Ом","523 Ом", "446 Ом"));
                add(new Question("Физическая величина, характеризующую быстроту совершения работы.",
                        "B", "работа", "напряжения", "мощность",
                        "нет правильного ответа."));
                add(new Question("Сила тока в электрической цепи 2 А при напряжении на его концах 5 В. Найдите сопротивление проводника.",
                        "C", "10 Ом", "0,4 Ом", "2,5 Ом", "4 Ом"));
                add(new Question("Вещества, почти не проводящие электрический ток.",
                        "D", "сегнетоэлектрики", "пьезоэлектрический эффект", "диод", "диэлектрики"));
            }
        };

        loadQuestion();
    }




    private void loadQuestion(){
        if(questions.size() > 0) {
            Question q = questions.remove(0);
            lblQuestion.setText(q.getQuestion());
            List<String> answers = q.getAnswers();

            optionA.setText(answers.get(0));
            optionB.setText(answers.get(1));
            optionC.setText(answers.get(2));
            optionD.setText(answers.get(3));

            rightAnswer = q.getRightAnswer();
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Ваш счет:"+ score).setTitle("Вы прошли тест").setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).create().show();

        }
    }

    public void loadAnswer(View view) {
        int op = radioGroup.getCheckedRadioButtonId();

        switch (op){
            case R.id.A:
                Answer="A";
                break;

            case R.id.B:
                Answer="B";
                break;

            case R.id.C:
                Answer="C";
                break;

            case R.id.D:
                Answer="D";
                break;

            default:
                return;

        }

        radioGroup.clearCheck();

        isRightOrWrong(Answer);

    }

    private void isRightOrWrong(String Answer){
        if(Answer.equals(rightAnswer)) {
            this.score += 1;
            Toast.makeText(this, "Правильно", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Не правильно", Toast.LENGTH_SHORT).show();
        }
        loadQuestion();
    }

}