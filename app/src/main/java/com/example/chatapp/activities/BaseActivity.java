package com.example.chatapp.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chatapp.firebase.PreferenceManager;
import com.example.chatapp.utilities.Constants;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Базовый класс для всех активностей.
 */
public class BaseActivity extends AppCompatActivity {

    private DocumentReference documentReference;

    /**
     * Метод, вызываемый при создании активности.
     *
     * @param savedInstanceState Сохраненное состояние активности.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        documentReference = database.collection(Constants.KEY_COLLECTION_USERS)
                .document(preferenceManager.getString(Constants.KEY_USER_ID));
    }

    /**
     * Метод, вызываемый при приостановке активности.
     * Обновляет статус доступности пользователя в базе данных.
     */
    @Override
    protected void onPause() {
        super.onPause();
        documentReference.update(Constants.KEY_AVAILABILITY, 0);
    }

    /**
     * Метод, вызываемый при возобновлении активности.
     * Обновляет статус доступности пользователя в базе данных.
     */
    @Override
    protected void onResume() {
        super.onResume();
        documentReference.update(Constants.KEY_AVAILABILITY, 1);
    }
}
