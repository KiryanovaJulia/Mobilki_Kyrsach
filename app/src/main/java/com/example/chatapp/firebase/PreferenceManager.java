package com.example.chatapp.firebase;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.chatapp.utilities.Constants;

public class PreferenceManager {

    private final SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        // Получение экземпляра SharedPreferences для работы с настройками приложения
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Сохраняет значение типа boolean в настройках приложения.
     *
     * @param key   Ключ, с помощью которого значение будет сохранено
     * @param value Значение типа boolean, которое будет сохранено
     */
    public void putBoolean(String key, Boolean value) {
        // Сохранение значения типа boolean в настройках приложения
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Возвращает значение типа boolean из настроек приложения.
     *
     * @param key Ключ, с помощью которого будет получено значение
     * @return Значение типа boolean из настроек приложения
     */
    public Boolean getBoolean(String key) {
        // Получение значения типа boolean из настроек приложения
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * Сохраняет значение типа String в настройках приложения.
     *
     * @param key   Ключ, с помощью которого значение будет сохранено
     * @param value Значение типа String, которое будет сохранено
     */
    public void putString(String key, String value) {
        // Сохранение значения типа String в настройках приложения
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Возвращает значение типа String из настроек приложения.
     *
     * @param key Ключ, с помощью которого будет получено значение
     * @return Значение типа String из настроек приложения
     */
    public String getString(String key) {
        // Получение значения типа String из настроек приложения
        return sharedPreferences.getString(key, null);
    }

    /**
     * Очищает все настройки приложения.
     */
    public void clear() {
        // Очистка всех настроек приложения
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
