package fnrc.JogoDaVelha.Controller;

import fnrc.JogoDaVelha.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @MessageMapping("/jogo")
    @SendTo("/mensage-serve/jogo")
    public String jogar(String mensagem) {
        return gameService.processarJogo(mensagem);
    }
}
