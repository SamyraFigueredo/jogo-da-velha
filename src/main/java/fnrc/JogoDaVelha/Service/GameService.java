package fnrc.JogoDaVelha.Service;

import fnrc.JogoDaVelha.Model.Game;
import fnrc.JogoDaVelha.Model.Player;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game currentGame;

    public GameService() {
        iniciarJogo();
    }

    public void iniciarJogo() {
        Player player1 = new Player("1", "Jogador 1", 'X', true);
        Player player2 = new Player("2", "Jogador 2", 'O', false);
        this.currentGame = new Game("1", player1, player2, player1, new char[9], "em andamento");

        for (int i = 0; i < currentGame.getBoard().length; i++) {
            currentGame.getBoard()[i] = '-';
        }
    }

    public String processarJogo(String mensagem) {
        String resposta = "";

        if ("iniciar".equals(mensagem)) {
            iniciarJogo();
            resposta = "O jogo começou!";
        } else {
            try {
                int position = Integer.parseInt(mensagem);
                if (position < 0 || position >= 9 || currentGame.getBoard()[position] != '-') {
                    resposta = "Posição inválida ou já ocupada!";
                    return resposta;
                }
                char symbol = currentGame.getCurrentPlayer().getSymbol();
                currentGame.getBoard()[position] = symbol;

                if (verificarVitoria(symbol)) {
                    currentGame.setStatus(symbol == 'X' ? "Vitória Jogador 1" : "Vitória Jogador 2");
                    resposta = "Jogador " + currentGame.getCurrentPlayer().getName() + " venceu!";
                } else if (verificarEmpate()) {
                    currentGame.setStatus("Empate");
                    resposta = "O jogo terminou em empate!";
                } else {
                    currentGame.setCurrentPlayer(
                            currentGame.getCurrentPlayer() == currentGame.getPlayer1() ? currentGame.getPlayer2() : currentGame.getPlayer1()
                    );
                    resposta = "Jogada processada: " + symbol + " na posição " + position;
                }
            } catch (NumberFormatException e) {
                resposta = "Entrada inválida. Informe um número para a posição.";
            }
        }
        return resposta;
    }

    private boolean verificarVitoria(char symbol) {
        int[][] vitoria = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] posicoes : vitoria) {
            if (currentGame.getBoard()[posicoes[0]] == symbol &&
                    currentGame.getBoard()[posicoes[1]] == symbol &&
                    currentGame.getBoard()[posicoes[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarEmpate() {
        for (char c : currentGame.getBoard()) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
}
