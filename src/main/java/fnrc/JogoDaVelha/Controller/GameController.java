package com.fnrc.JogoDaVelha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    // Método que será chamado quando o cliente enviar uma mensagem para iniciar ou interagir no jogo
    @MessageMapping("/jogo") // O prefixo "/mensage-client/jogo" no cliente irá ativar este método
    @SendTo("/mensage-serve/jogo") // O prefixo "/mensage-serve/jogo" será onde a mensagem será enviada para os clientes
    public String jogar(String mensagem) {
        // Aqui você pode processar a mensagem recebida e interagir com o serviço
        return gameService.processarJogo(mensagem); // Exemplo de chamada do service
    }
}
