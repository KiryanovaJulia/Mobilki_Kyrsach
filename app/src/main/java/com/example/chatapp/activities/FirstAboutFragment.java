package com.example.chatapp.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatapp.R;
import com.google.android.material.snackbar.Snackbar;

public class FirstAboutFragment extends Fragment {

    private ImageView appIcon;
    private int clickCount = 0;
    private Handler handler;

    // Задача для сброса счетчика нажатий через определенное время
    private Runnable clickResetRunnable = new Runnable() {
        @Override
        public void run() {
            clickCount = 0;
        }
    };

    /**
     * Метод для создания визуального представления фрагмента и инициализации его компонентов.
     *
     * @param inflater           Объект LayoutInflater, который может использоваться для раздувания (инфлейта) любых представлений во фрагменте.
     * @param container          Корневой элемент фрагмента, в который будет добавлен визуальный интерфейс фрагмента.
     * @param savedInstanceState Объект Bundle, содержащий предыдущее состояние фрагмента (если оно есть).
     * @return                   Возвращает созданное представление фрагмента.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_about, container, false);

        appIcon = view.findViewById(R.id.app_icon);
        appIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount >= 5) {
                    ((AboutActivity) requireActivity()).showSecondFragment();
                    clickCount = 0;
                } else {
                    showBottomSnackbar("Нажмите еще " + (5 - clickCount) + " раз");
                    if (handler != null) {
                        handler.removeCallbacks(clickResetRunnable);
                    }
                    handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(clickResetRunnable, 1000);
                }
            }
        });

        return view;
    }

    /**
     * Метод для отображения снэкбара в нижней части экрана с заданным сообщением.
     *
     * @param message Сообщение, которое будет отображено в снэкбаре.
     */
    private void showBottomSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        snackbar.show();
    }
}
