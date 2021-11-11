package com.example.semana14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotesActivity extends AppCompatActivity {

    EditText taskName;
    EditText description;
    Button addBtn;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        taskName = findViewById(R.id.tasknameText);
        description = findViewById(R.id.descriptionText);
        addBtn = findViewById(R.id.addButton);

        db = FirebaseDatabase.getInstance();

        addBtn.setOnClickListener((view) ->
        {
            createTask();
        });
    }

    public void createTask()
    {
        DatabaseReference dbRef = db.getReference("notes/");
        DatabaseReference newNote = dbRef.push();

        Note note = new Note(
          taskName.getText().toString(),
                description.getText().toString(),
                newNote.getKey()
        );

        dbRef.setValue(note);
    }


}