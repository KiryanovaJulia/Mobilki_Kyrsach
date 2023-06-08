package com.example.chatapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatapp.R;

public class SecondAboutFragment extends Fragment {

    /**
     * Создает визуальное представление фрагмента.
     *
     * @param inflater           Объект LayoutInflater, который может использоваться для раздувания (инфлейта) любых представлений во фрагменте.
     * @param container          Корневой элемент фрагмента, в который будет добавлен визуальный интерфейс фрагмента.
     * @param savedInstanceState Объект Bundle, содержащий предыдущее состояние фрагмента (если оно есть).
     * @return Возвращает созданное представление фрагмента.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_about, container, false);
        return view;
    }
}
