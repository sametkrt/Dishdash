package com.example.dishdash;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class AiRecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ai_recipes);

        TextView textViewResponse = findViewById(R.id.chatGPTResponseTextView);

        String response = getIntent().getStringExtra("response");

        textViewResponse.setText(Objects.requireNonNullElse(response, "No response received."));
    }
}
