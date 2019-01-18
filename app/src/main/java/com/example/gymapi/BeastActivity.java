package com.example.gymapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

public class BeastActivity extends AppCompatActivity {

    Switch beast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beast);

        beast = findViewById(R.id.beast_mode1);
    }

    public void welcomeUser(View view){
        Intent beastIN = new Intent(getBaseContext(),MainActivity.class);
        startActivity(beastIN);
    }

}
