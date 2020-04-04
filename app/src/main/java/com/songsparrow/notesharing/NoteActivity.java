package com.songsparrow.notesharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String layout = intent.getStringExtra("layout");
        if (layout == null) {
            onDestroy();
            return;
        }
        switch (layout){
            case "upload":
                setContentView(R.layout.activity_upload);
                break;
            case "favorite":
                setContentView(R.layout.activity_favorite);
                break;
            case "like":
                setContentView(R.layout.activity_like);
                break;
            case "appeal":
                setContentView(R.layout.activity_appeal);
                break;
            case "report":
                setContentView(R.layout.activity_report);
                break;
            case "comment":
                setContentView(R.layout.activity_comment);
                break;
            default:
                break;
        }
    }
}
