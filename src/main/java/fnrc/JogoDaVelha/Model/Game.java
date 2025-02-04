package fnrc.JogoDaVelha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String gameId;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private char[] board = new char[9];
    private String status; // "em andamento", "vitória", "empate"
}