package fnrc.JogoDaVelha.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String playerId;
    private String name;
    private char symbol; // 'X' ou 'O'
    private boolean isTurn;
}