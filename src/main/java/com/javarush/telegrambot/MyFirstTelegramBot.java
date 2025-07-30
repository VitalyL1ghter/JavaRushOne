package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "L1_Ghter_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "8254723749:AAGZ2NsBDxCFxk5DfCwcenQZfKR3QDq15xs"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        //* Игра кот*//

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Взломать холодильник ! + 20 славы", "button_one"));
        }
        if (getCallbackQueryButtonKey().equals("button_one")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять колбаску ! + 20 славы", "button_two",
                            "Взять рыбу ! + 20 славы", "button_two",
                            "Опрокинуть молоко ! + 20 славы", "button_two"));
        }
        if (getCallbackQueryButtonKey().equals("button_two")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Взломать робота-пылесос ! + 30 славы", "button_three"));
        }
        if (getCallbackQueryButtonKey().equals("button_three")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("отправить робота на зарядку ! + 30 славы ", "button_four",
                            "Покататься на роботе ! + 30 славы", "button_four",
                            "Убежать от робота ! + 30 славы", "button_four"));
        }
        if (getCallbackQueryButtonKey().equals("button_four")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Взять камеру Go-Pro ! + 40 славы", "button_five"));

        }
        if (getCallbackQueryButtonKey().equals("button_five")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Надеть и включить камеру! + 40 славы", "button_six",
                            "Сбросить камеру! + 40 славы", "button_six",
                            "Разбить камеру! + 40 славы", "button_six"));

        }
        if (getCallbackQueryButtonKey().equals("button_six")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взломать пароль компьютера! + 50 славы", "button_seven"));

        }
        if (getCallbackQueryButtonKey().equals("button_seven")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Подобрать пароль!", "button_eight",
                            "Выключить компьютер!", "button_eight",
                            "Выдернуть провод из розетки!", "button_eight"));
        }

        if (getCallbackQueryButtonKey().equals("button_eight")) {
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
    }


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

// if (getMessageText().equals("/start")) sendTextMessageAsync("Привет, Виталий !");
//
//        if (getMessageText().equals("/buy")) sendTextMessageAsync("Asta la vista, baby!");
//
//        if (getMessageText().contains("Hello")) sendTextMessageAsync("Hello, Виталий !");
//
//        if (getMessageText().contains("Картинка")) {
//            sendPhotoMessageAsync("step_6_pic");
//        }
//        if (getMessageText().contains("picture")) {
//            sendTextMessageAsync("Ваше любимое животное ? ",
//                    Map.of("кот", "cat", "собака", "dog"));
//        }
//        if (getCallbackQueryButtonKey().equals("cat")) {
//            sendPhotoMessageAsync("step_4_pic");
//
//        }
//        if (getCallbackQueryButtonKey().equals("dog")) {
//            sendPhotoMessageAsync("step_6_pic");
//        }
//        if (getMessageText().contains(")")) {
//            var message = getLastSentMessage();
//            editTextMessageAsync(message.getMessageId(), message.getText() + " :))) ");
//        }