package tabeb.player;

import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import tabeb.utils.Message;


@Component
public class EncryptedMessageConsumer {

    private final WebClient client;


    public EncryptedMessageConsumer(WebClient.Builder builder) {
        this.client = builder.
                baseUrl("http://localhost:8080")
                // Permet d'empêcher de fermer le serveur AVANT d'avoir reçu la requête
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build();
    }

    public Mono<String> getHello() {
        return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMsg)
                .onErrorResume(e -> Mono.just("Encountered an exception : " + e));

    }


    public Mono<String> getInscription(int id) {
        return this.client.get().uri("/player/" + id ).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Message.class)
                .map(Message::getMsg)
                // permet de continuer malgré une erreur, on affiche le contenu de l'erreur
                .onErrorResume(e -> Mono.just("Encountered an exception : " + e));
    }
}
