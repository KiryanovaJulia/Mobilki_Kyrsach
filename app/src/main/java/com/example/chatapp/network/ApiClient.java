package com.example.chatapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    /**
     * Возвращает экземпляр класса Retrofit для выполнения сетевых запросов.
     * Если экземпляр еще не создан, создает его с указанием базового URL и конвертера скаляров.
     *
     * @return экземпляр класса Retrofit
     */
    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fcm.googleapis.com/fcm/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
