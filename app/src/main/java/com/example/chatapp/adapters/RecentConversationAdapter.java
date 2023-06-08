package com.example.chatapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.databinding.ItemContainerRecentConversionBinding;
import com.example.chatapp.listeners.ConversionListener;
import com.example.chatapp.models.ChatMessages;
import com.example.chatapp.models.User;

import java.util.List;

public class RecentConversationAdapter extends RecyclerView.Adapter<RecentConversationAdapter.ConversionViewHolder> {

    private final List<ChatMessages> chatMessages;
    private final ConversionListener conversionListener;

    public RecentConversationAdapter(List<ChatMessages> chatMessages, ConversionListener conversionListener) {
        this.chatMessages = chatMessages;
        this.conversionListener = conversionListener;
    }

    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создание ViewHolder для элемента списка
        return new ConversionViewHolder(
                ItemContainerRecentConversionBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionViewHolder holder, int position) {
        // Установка данных в элемент списка
        holder.setData(chatMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    class ConversionViewHolder extends RecyclerView.ViewHolder {

        ItemContainerRecentConversionBinding binding;

        ConversionViewHolder(ItemContainerRecentConversionBinding itemContainerRecentConversionBinding) {
            super(itemContainerRecentConversionBinding.getRoot());
            binding = itemContainerRecentConversionBinding;
        }

        /**
         * Установка данных беседы в элемент списка.
         *
         * @param chatMessages Данные беседы, которые нужно отобразить
         */
        void setData(ChatMessages chatMessages) {
            // Установка данных в элемент списка
            binding.imageProfile.setImageBitmap(getConversionImage(chatMessages.conversionImage));
            binding.textName.setText(chatMessages.conversionName);
            binding.textRecentMessage.setText(chatMessages.message);

            // Обработчик нажатия на элемент списка
            binding.getRoot().setOnClickListener(v -> {
                // Создание объекта User с данными о беседе
                User user = new User();
                user.id = chatMessages.conversionId;
                user.name = chatMessages.conversionName;
                user.image = chatMessages.conversionImage;

                // Вызов метода колбэка для обработки нажатия на беседу
                conversionListener.onConversionClicked(user);
            });
        }
    }

    /**
     * Получение изображения беседы из строки Base64 и создание объекта Bitmap.
     *
     * @param encodedImage Закодированное изображение в формате Base64
     * @return Объект Bitmap, представляющий изображение беседы
     */
    private Bitmap getConversionImage(String encodedImage) {
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
