package com.example.semana14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText username;
    Button enterBtn;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usernameText);
        enterBtn = findViewById(R.id.enterButton);

        db = FirebaseDatabase.getInstance();

        enterBtn.setOnClickListener((view) ->
        {
            registerUser();
            switchTo();
        });
    }

    public void switchTo()
    {
        Intent toList = new Intent(this, NotesActivity.class);
        startActivity(toList);
    }

    public void registerUser()
    {
        DatabaseReference dbRef = db.getReference("users/");
        DatabaseReference newUser = dbRef.push();

        User user = new User(
                username.getText().toString(),
                newUser.getKey()
                );

        newUser.setValue(user);
    }

    public void createNewUser()
    {

    }
}