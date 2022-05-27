package tabeb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tabeb.utils.Message;

@SpringBootApplication
@RestController
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
    
    @GetMapping("/")
    public Message home() {
        return new Message("Server Application : Hello World");
    }

    @GetMapping(value = "/player/{id}")
    public Message getUser(@PathVariable("id") String id) {
        return new Message("Server Application : Connection of the player with id " + id);
    }

    @GetMapping(value = "/game/{id}")
    public Message getGame(@PathVariable("id") String id) {
        return new Message("Server Application : Connection of the game room with id " + id);
    }
}
