package MyBotEver.cometo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import MyBotEver.cometo.service.TelegramBot;




@Configuration
public class BotInitializer {

	@Bean
	public TelegramBotsApi telegramBotsApi(TelegramBot bot) throws TelegramApiException {
		var api=new TelegramBotsApi(DefaultBotSession.class);
		try {
			api.registerBot(bot);
				
		} catch(TelegramApiException e) {
			
			
		}
		return api;
		
	
	
	
	}
}
