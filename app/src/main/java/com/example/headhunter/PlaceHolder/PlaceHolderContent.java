package com.example.headhunter.PlaceHolder;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Это вспомогательный класс для предоставления примера для пользовательского интерфейса.
 * Он используется как заполнитель и должен быть заменен реальными данными в финальном приложении.
 */
public class PlaceHolderContent {

    // Список элементов
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    // Карта элементов с уникальными идентификаторами
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    // Количество элементов
    private static final int COUNT = 25;

    // Статический блок инициализации для заполнения списка и карты
    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    // Метод для добавления элемента в список и карту
    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    // Метод для создания элемента-заполнителя с заданной позицией
    private static PlaceholderItem createPlaceholderItem(int position) {
        return new PlaceholderItem(String.valueOf(position), "Элемент " + position, makeDetails(position));
    }

    // Метод для генерации деталей для элемента заполнителя на основе его позиции
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Детали об элементе: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nЗдесь находится больше информации о деталях.");
        }
        return builder.toString();
    }

    // Внутренний класс, представляющий элемент заполнитель
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
