package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText bookId;
    private EditText chapterId;
    private EditText verseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookId = (EditText) findViewById(R.id.userBookTitle);
        chapterId = (EditText) findViewById(R.id.userChapterNumber);
        verseId = (EditText) findViewById(R.id.userVerseNumber);
    }

    /** Called when the user taps the Display button */
    public void displayScripture(View view) {
        Intent intent = new Intent(this, DisplayScripture.class);
        String book = bookId.getText().toString();
        String chapter = chapterId.getText().toString();
        String verse = verseId.getText().toString();
        intent.putExtra("BOOK", book);
        intent.putExtra("CHAPTER", chapter);
        intent.putExtra("VERSE", verse);
        String scripture = book + " " + chapter + ": " + verse;
        Log.d(this.getLocalClassName(),"About to create intent with " + scripture +".");
        startActivity(intent);
    }

    public void loadScripture(View view){
        SharedPreferences sharedPref = getSharedPreferences("Scripture.txt", Context.MODE_PRIVATE);

        String bookLoaded = sharedPref.getString("BOOK","");
        String chapterLoaded = sharedPref.getString("CHAPTER","");
        String verseLoaded = sharedPref.getString("VERSE","");

        bookId.setText(bookLoaded);
        chapterId.setText(chapterLoaded);
        verseId.setText(verseLoaded);
    }
}