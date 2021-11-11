package com.example.semana14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NotesActivity extends AppCompatActivity {

    EditText taskName;
    EditText description;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        taskName = findViewById(R.id.tasknameText);
        description = findViewById(R.id.descriptionText);
        addBtn = findViewById(R.id.addButton);

        addBtn.setOnClickListener((view) ->
        {

        });
    }


}