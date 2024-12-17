
package com.example.dishdash;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;

import com.example.dishdash.ChatGPT.ApiConfig;
import com.example.dishdash.ChatGPT.ChatGPTApi;
import com.example.dishdash.ChatGPT.ChatRequest;
import com.example.dishdash.ChatGPT.ChatResponse;
import com.example.dishdash.ChatGPT.Message;
import com.example.dishdash.ChatGPT.RetrofitInstance;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    ImageButton recipeBookButton;
    ImageButton aiRecipesButton;
    ImageButton ingredientsButton;
    ImageButton shoppingListButton;
    Button sideMenuButton;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ACTIVITY ITEMS
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
                ChatGPTApi chatGPTApi = RetrofitInstance.getInstance().create(ChatGPTApi.class);
                ChatRequest request = new ChatRequest(
                        "gpt-4o-mini",
                        Arrays.asList(new Message("user", "Provide a random meal recipe"))
                );

                // Make the API call
                chatGPTApi.getChatResponse("Bearer " + ApiConfig.API_KEY, request)
                    .enqueue(new Callback<ChatResponse>() {
                        @Override
                        public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                String reply = response.body().getChoices().get(0).getMessage().getContent();
                                Intent intent = new Intent(MainActivity.this, AiRecipes.class);
                                intent.putExtra("response", reply);
                                startActivity(intent);
                            } else {
                                Log.e("ChatGPT Error", "Error: " + response.code() + " - " + response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<ChatResponse> call, Throwable t) {
                            Log.e("ChatGPT Failure", "Request failed", t);
                        }
                    });
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
                Toast.makeText(MainActivity.this, "Side Menu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
