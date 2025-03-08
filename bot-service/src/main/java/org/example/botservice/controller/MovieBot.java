package org.example.botservice.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class MovieBot extends TelegramLongPollingBot {

    private static final String BOT_NAME = "movviewtg_bot";
    private static final String BOT_TOKEN = "7746537029:AAEStDE86nMTrYC_Lx-Zbo-Dl8H9zWX1snk";


    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

}
