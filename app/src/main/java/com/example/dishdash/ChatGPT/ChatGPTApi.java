package com.example.dishdash.ChatGPT;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ChatGPTApi {
    @POST("v1/chat/completions")
    Call<ChatResponse> getChatResponse(
            @Header("Authorization") String authorization,
            @Body ChatRequest request
    );
}

