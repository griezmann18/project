package MyBotEver.cometo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



@Component
public class TelegramBot extends TelegramLongPollingBot {

public TelegramBot( @Value("${bot.token}")String botToken) {
	super(botToken);
}
@Override
public String getBotUsername() {
	
	return "The1stmybot";
}

	@Override
	public void onUpdateReceived(Update update) {
		if(update.hasMessage()&&update.getMessage().hasText()) {
			String messageText=update.getMessage().getText();
			long chatId=update.getMessage().getChatId();
			
			switch (messageText) {
			case "/start": 
				startCommandRecieved(chatId, update.getMessage().getChat().getFirstName());
				break;
				default: sendMessage(chatId, "Sorry, but it does not support");
			}
		}
		
	}

	
	private void startCommandRecieved(long chatId, String name) {
		String answer="Hi, "+ name+", nice to meet you";
		
		sendMessage(chatId, answer);
	}
	private void sendMessage(long chatId, String textToSend) {
		SendMessage message=new SendMessage();
		message.setChatId(String.valueOf(chatId));
		message.setText(textToSend);
		
		try {
			execute(message);
		} catch(TelegramApiException e){
			throw new RuntimeException(e);
		}
	}
	
}
