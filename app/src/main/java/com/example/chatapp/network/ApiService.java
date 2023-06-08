package com.example.chatapp.network;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ApiService {

    /**
     * Отправляет сообщение на сервер.
     *
     * @param headers     заголовки запроса
     * @param messageBody тело сообщения в виде строки
     * @return объект Call, представляющий асинхронный запрос на отправку сообщения
     */
    @POST("send")
    Call<String> sendMessage(
            @HeaderMap HashMap<String, String> headers,
            @Body String messageBody
    );


}
