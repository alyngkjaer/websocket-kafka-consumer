package dk.spillers.websocketkafkaconsumer;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;


@Configuration
public class FunctionalSample {
    

	@Autowired 
	SimpMessagingTemplate messagingTemplate;

	@Bean
	public Consumer<String> input() {
		return value -> {
			messagingTemplate.convertAndSend("/topic/message",value);
		};
	}

}
