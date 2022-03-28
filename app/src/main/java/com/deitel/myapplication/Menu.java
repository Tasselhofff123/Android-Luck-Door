package com.deitel.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        String name = ((EditText)findViewById(R.id.editText)).getText().toString();
        System.out.println(name);
        if(!name.isEmpty())
            intent.putExtra("name", name);

        else
            intent.putExtra("name", getString(R.string.player_name));

        startActivity(intent);
    }
}
