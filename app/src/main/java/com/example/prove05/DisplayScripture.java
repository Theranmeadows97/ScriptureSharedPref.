package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScripture extends AppCompatActivity {

    private String book;
    private String chapter;
    private String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        book = intent.getStringExtra("BOOK");
        chapter = intent.getStringExtra("CHAPTER");
        verse = intent.getStringExtra("VERSE");
        // Capture the layout's TextView and set the string as its text
        String scripture = book + " " + chapter + ": " + verse;
        Log.d(this.getLocalClassName(), "Received intent with " + scripture);
        TextView textView = findViewById(R.id.textView);
        textView.setText(scripture);
    }

    public void saveToPreferences(View view){
        SharedPreferences sharedPref = getSharedPreferences("Scripture.txt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("BOOK", book);
        editor.putString("CHAPTER", chapter);
        editor.putString("VERSE", verse);
        editor.apply();

        Toast.makeText(this, "Scripture saved", Toast.LENGTH_SHORT).show();
    }
}