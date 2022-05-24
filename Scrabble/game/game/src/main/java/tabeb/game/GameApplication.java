package tabeb.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GameApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
    @Bean
    public CommandLineRunner execScript(@Autowired EncryptedMessageConsumer client) {
        return args -> {
            System.out.println("--- BEGIN CMD GAME ---");
            Game game = new Game();
            System.out.println("Envois d'une requete sur localhost/8080/game/{id}");
            String msg = client.getInscription(game.getId()).block();
            System.out.println(msg + " sur le thread : " + Thread.currentThread().getName());
        };
    }

    /*
    private void requeteMonoGetSub(EncryptedMessageConsumer client, Game game) {
        Mono<String> reqSub = client.getInscription(game.getId());
        reqSub.subscribe(new Consumer<String>() {
            @Override
            public void accept(String msg) {
                System.out.println(" msg :  " + msg +"; thread : "+Thread.currentThread().getName());
            }
        });
    }*/
}
