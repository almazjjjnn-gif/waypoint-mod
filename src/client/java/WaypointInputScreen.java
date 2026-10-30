package com.example.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

public class WaypointInputScreen extends Screen {
    private TextFieldWidget coordField;

    public WaypointInputScreen() {
        super(Text.literal("Ввод координат"));
    }

    @Override
    protected void init() {
        // Поле ввода координат
        this.coordField = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, this.height / 2 - 20, 200, 20, Text.literal("Координаты"));
        this.coordField.setPlaceholder(Text.literal("Например: 100 64 -200"));
        this.addDrawableChild(this.coordField);

        // Кнопка "Поставить"
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Поставить"), button -> {
            String input = this.coordField.getText();

            // Выводим в чат то, что ввели
            if (this.client != null && this.client.player != null) {
                this.client.player.sendMessage(Text.literal("Ты ввел: " + input), false);
            }

            this.close(); // Закрываем меню
        }).dimensions(this.width / 2 - 50, this.height / 2 + 10, 100, 20).build());
    }
}