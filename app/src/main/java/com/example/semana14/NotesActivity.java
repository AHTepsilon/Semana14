package com.example.semana14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotesActivity extends AppCompatActivity {

    EditText taskName;
    EditText description;

    TextView listTextV;

    Button addBtn;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        taskName = findViewById(R.id.tasknameText);
        description = findViewById(R.id.descriptionText);
        addBtn = findViewById(R.id.addButton);

        listTextV = findViewById(R.id.listTextView);

        db = FirebaseDatabase.getInstance();

        addBtn.setOnClickListener((view) ->
        {
            createTask();
        });

        getUsers();
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

    public void getUsers()
    {
        DatabaseReference noteRef = db.getReference("notes");
        noteRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot notes)
            {
                listTextV.setText("");

                for(DataSnapshot noteSnapshot: notes.getChildren())
                {
                    Note note = noteSnapshot.getValue(Note.class);
                    listTextV.append(note.getNoteName() + ": " + note.getDescription() + "\n");

                    /*Note note = noteSnapshot.getValue(Note.class);
                    listTextV.append(note.getNoteName() + ": " + note.getDescription() + "\n");*/
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }


}