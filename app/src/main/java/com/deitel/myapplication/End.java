package com.deitel.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class End extends AppCompatActivity implements View.OnClickListener{

    private String name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Bundle arguments = getIntent().getExtras();
        name = arguments.get("name").toString();

        ((TextView)findViewById(R.id.textView2)).setText(name + ", поздравляем Вас! Вы потратили уйму своего времени на нашу игру, и в качестве приза вы получите ровным счётом ничего! Продолжайте в том же духе!");
        findViewById(R.id.button5).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
