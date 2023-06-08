package com.example.chatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.chatapp.R;

/**
 * Класс, представляющий активность "О приложении".
 */
public class AboutActivity extends AppCompatActivity {
    private boolean isSecondFragmentDisplayed = false;

    /**
     * Метод, вызываемый при создании активности.
     *
     * @param savedInstanceState Сохраненное состояние активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        showFirstFragment();
    }

    /**
     * Отображает первый фрагмент в контейнере фрагментов.
     */
    private void showFirstFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment firstFragment = new FirstAboutFragment();
        fragmentTransaction.replace(R.id.fragment_container, firstFragment);
        fragmentTransaction.commit();

        isSecondFragmentDisplayed = false;
    }

    /**
     * Отображает второй фрагмент в контейнере фрагментов.
     */
    public void showSecondFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment secondFragment = new SecondAboutFragment();
        fragmentTransaction.replace(R.id.fragment_container, secondFragment);
        fragmentTransaction.commit();

        isSecondFragmentDisplayed = true;
    }
}
