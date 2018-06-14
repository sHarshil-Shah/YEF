package com.example.sum.yef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        (Objects.requireNonNull(getSupportActionBar())).setDisplayHomeAsUpEnabled(true);

    }
}
