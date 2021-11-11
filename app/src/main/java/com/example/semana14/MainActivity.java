package com.example.semana14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username;
    Button enterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usernameText);
        enterBtn = findViewById(R.id.enterButton);

        enterBtn.setOnClickListener((view) ->
        {
            switchTo();
        });
    }

    public void switchTo()
    {
        Intent toList = new Intent(this, NotesActivity.class);
        startActivity(toList);
    }
}