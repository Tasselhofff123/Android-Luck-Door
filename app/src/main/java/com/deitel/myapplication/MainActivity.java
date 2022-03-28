package com.deitel.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*private final int BUTTON_ONE = 1;
    private final int BUTTON_TWO = 2;
    private final int BUTTON_THREE = 3;
    private final int BUTTON_FOUR = 4;*/
    private int rand;

    private int level = 1;
    private Button levelButton;
    private List<ButtonWithParameter> buttonsList = new ArrayList<>();
    // private Button b2;
   // private Button b3;
    //private Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelButton = findViewById(R.id.next_level);

        buttonsList.add(new ButtonWithParameter(
                (Button) findViewById(R.id.button1), 1));
        buttonsList.add(new ButtonWithParameter(
                (Button) findViewById(R.id.button2), 2));
        buttonsList.add(new ButtonWithParameter(
                (Button) findViewById(R.id.button3), 3));
        buttonsList.add(new ButtonWithParameter(
                (Button) findViewById(R.id.button4), 4));

        for (ButtonWithParameter b : buttonsList){
            b.getButton().setOnClickListener(this);
        }
        levelButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == levelButton)
        {
            nextLevel();
        }
        else {
            startRand(view);
        }


    }

    private void nextLevel() {
        if(level <= 3){
            ((TextView)findViewById(R.id.textView)).setText("Уровень: " + level);
            for(ButtonWithParameter b : buttonsList){
                b.getButton().setBackgroundColor(Color.GRAY);
            }
            setAllButtonsEnabled(true);
        }
        else {

            Bundle arguments = getIntent().getExtras();
            String name = arguments.get("name").toString();

            Intent intent = new Intent(this, End.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

    private void startRand(View view) {
        rand = (int) ((Math.random()*4)+1);

        for (ButtonWithParameter b : buttonsList){
            if (view == b.getButton()){
                if(rand == b.getParameter())
                    win(b.getButton());
                else
                    fall(b.getButton());
            }
        }

    }

    private void win(Button b){
        level++;
        b.setBackgroundColor(Color.GREEN);
        levelButton.setText("Следующий уровень");
        setAllButtonsEnabled(false);
        System.out.println("Выиграл");
    }

    private void fall(Button b){
        level = 1;
        b.setBackgroundColor(Color.RED);
        levelButton.setText("Начать сначала");
        setAllButtonsEnabled(false);
        System.out.println("Проиграл");
    }

    private void setAllButtonsEnabled(boolean enabled){
        if(enabled == false) {
            for (ButtonWithParameter b : buttonsList)
                b.getButton().setEnabled(enabled);
            levelButton.setVisibility(View.VISIBLE);
        }
        else {
            for (ButtonWithParameter b : buttonsList)
                b.getButton().setEnabled(enabled);
            levelButton.setVisibility(View.INVISIBLE);
        }
    }
}

