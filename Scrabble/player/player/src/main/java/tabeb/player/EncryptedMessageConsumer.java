package tabeb.player;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tabeb.utils.Message;


@Component
public class EncryptedMessageConsumer {

    private final WebClient client;


    public EncryptedMessageConsumer(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getHello() {
        return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMsg);
    }


    public Mono<String> getInscription(int id) {
        return this.client.get().uri("/player/" + id ).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMsg);
    }
}
