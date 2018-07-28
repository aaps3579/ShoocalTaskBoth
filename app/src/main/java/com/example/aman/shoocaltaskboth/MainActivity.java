package com.example.aman.shoocaltaskboth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTask1(View view) {
        startActivity(new Intent(this, TaskOne.class));
    }

    public void onClickTask2(View view) {

        startActivity(new Intent(this, TaskOne.class));
    }
}
