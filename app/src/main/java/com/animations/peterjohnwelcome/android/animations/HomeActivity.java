package com.animations.peterjohnwelcome.android.animations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.vectorButton).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),VectorDrawableActivity.class)));
    }
}
