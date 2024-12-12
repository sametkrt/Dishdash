package com.example.dishdash;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton recipeBookButton;
    ImageButton aiRecipesButton;
    ImageButton ingredientsButton;
    ImageButton shoppingListButton;
    Button sideMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // BUTTONS
        recipeBookButton = (ImageButton) findViewById(R.id.recipeBookButtonId);
        aiRecipesButton = (ImageButton) findViewById(R.id.aiRecipesButtonId);
        ingredientsButton = (ImageButton) findViewById(R.id.ingredientsButtonId);
        shoppingListButton = (ImageButton) findViewById(R.id.shoppingListButtonId);
        sideMenuButton = (Button) findViewById(R.id.sideMenuButtonId);

        recipeBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Recipe Book", Toast.LENGTH_SHORT).show();
            }
        });

        aiRecipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "AI Recipes", Toast.LENGTH_SHORT).show();
            }
        });

        ingredientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ingredients", Toast.LENGTH_SHORT).show();
            }
        });

        shoppingListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Shopping List", Toast.LENGTH_SHORT).show();
            }
        });

        sideMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "SkMin KeYfInE gOrE bUtOnU", Toast.LENGTH_SHORT).show();
            }
        });

    }
}