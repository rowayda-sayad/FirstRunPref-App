package com.example.firstrunprefudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("myprefs", 0);
        textView = findViewById(R.id.helloTxt);

        if (firstRun()) {
            setRunned();
        } else {
            textView.setText("Hello Again");
            textView.setTextColor(getResources().getColor(R.color.teal_700));
        }
    }

    public void setRunned() {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean("FirstRun", false);
        edit.commit();
    }

    public boolean firstRun() {
        return prefs.getBoolean("FirstRun", true);
    }
}