package tabeb.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@SpringBootApplication(scanBasePackages = {"org.springframework.web.reactive.function.client", "tabeb.player" })
public class PlayerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PlayerApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    public CommandLineRunner execScript(@Autowired EncryptedMessageConsumer client) {
        return args -> {
            System.out.println("--- DEBUT CMD PLAYER ---");
            Player player = new Player();

            String msg = client.getHello().block();
            System.out.println(msg + " sur le thread : " + Thread.currentThread().getName());

            System.out.println("Envois d'une requete sur localhost/8080/hello");
            requeteMonoGet(client);

            System.out.println("Envois d'une requete sur localhost/8080/player/{id}");
            requeteMonoGetSub(client, player);
        };
    }
    private void requeteMonoGet(EncryptedMessageConsumer client) {
        Mono<String> reqHello = client.getHello();
        reqHello.subscribe(new Consumer<String>() {
            @Override
            public void accept(String msg) {
                System.out.println(" msg :  " + msg +"; thread : "+Thread.currentThread().getName());
            }
        });
    }

    private void requeteMonoGetSub(EncryptedMessageConsumer client, Player player) {
        Mono<String> reqSub = client.getInscription(player.getId());
        reqSub.subscribe(new Consumer<String>() {
            @Override
            public void accept(String msg) {
                System.out.println(" msg :  " + msg +"; thread : "+Thread.currentThread().getName());
            }
        });
    }

}
