package com.github.ralmnsk.telbot.bot;

import com.github.ralmnsk.telbot.model.City;
import com.github.ralmnsk.telbot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.logging.Level;

@Slf4j
@Component
@PropertySource("application.properties")
public class Bot extends TelegramLongPollingBot {
    @Value("user.name")
    private String name;
    @Autowired
    private CityService cityService;
//    @Value("user.token")
//    private String token;



    public void initBot() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotToken() {
        return "1052752588:AAGBsI-dE6pcKe5sP3jVD2-kgzkl-ihHy1A";
    }

    @Override
    public void onUpdateReceived(Update update) {
        City city=cityService.findByName(update.getMessage().getText());
        String response=new String();
        if(city!=null){
            response=city.getName()+": "+city.getInfo();
        }
        else{
            response="Такого города нет в базе. Введите другое название города";
        }
        SendMessage message=new SendMessage();
        message.setText(response);
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

}
