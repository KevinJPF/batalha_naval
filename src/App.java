import java.util.HashMap;
import java.util.Map;

import classes.Board;
import classes.Player;
import classes.Ship;
import classes.Util;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(
                "Bem vindo ao Batalha Naval!\n");

        System.out.println(
                "Começamos com as configurações dos tabuleiros dos jogadores.\n");
        Map<String, Integer> boardOptions = boardOptions();

        System.out.println(
                "Vamos criar o primeiro jogador!\n");
        Player firstPlayer = createNewPlayer(boardOptions.get("numberOfRows"), boardOptions.get("numberOfColumns"),
                boardOptions.get("numberOfShips"));

        System.out.println(
                "Vamos criar o segundo jogador!\n");
        Player secondPlayer = createNewPlayer(boardOptions.get("numberOfRows"), boardOptions.get("numberOfColumns"),
                boardOptions.get("numberOfShips"));

        System.out.println("\nAtirando no tabuleiro:");
        System.out.println(firstPlayer.getPlayerBoard().shootBoard(2, 4));
        System.out.println(firstPlayer.getPlayerBoard().shootBoard(8, 1));
        System.out.println(firstPlayer.getPlayerBoard().shootBoard(4, 8));
        System.out.println(firstPlayer.getPlayerBoard().shootBoard(5, 11));

        System.out.println("\nTabuleiro (" + firstPlayer.getPlayerName() + "):");
        System.out.println(firstPlayer.getPlayerBoard().printBoard());
    }

    private static Map<String, Integer> boardOptions() {
        Map<String, Integer> boardOptionsMap = new HashMap<>();

        // Choosing board size
        System.out.println(
                "Primeiro me diga o número de linhas dos tabuleiros(Min. 3 e Máx. 10):");
        Integer numberOfRows = Util.persistIntegerInterval(3, 10,
                "Valor da linha inserido está fora dos limites, por favor insira um número válido:");

        System.out.println("Agora me diga o número de colunas dos tabuleiros(Min. 3 e Máx. 10):");
        Integer numberOfColumns = Util.persistIntegerInterval(3, 10,
                "Valor da coluna inserido está fora dos limites, por favor insira um número válido:");

        // Choosing ships quantity
        System.out.println("Agora me diga o número de navios que terão os tabuleiros(Min. 1 e Máx. 5):");
        Integer numberOfShips = Util.persistIntegerInterval(1, 5,
                "Valor de navios inserido está fora dos limites, por favor insira um número válido:");

        boardOptionsMap.put("numberOfRows", numberOfRows);
        boardOptionsMap.put("numberOfColumns", numberOfColumns);
        boardOptionsMap.put("numberOfShips", numberOfShips);

        return boardOptionsMap;
    }

    private static Player createNewPlayer(Integer numberOfRows, Integer numberOfColumns, Integer numberOfShips) {
        // Choosing player name
        System.out.println("Digite o nome do usuário:");
        String name = Util.scanner.nextLine();

        // Creating board and player objects
        Board newPlayerBoard = new Board(numberOfRows, numberOfColumns);
        Player newPlayer = new Player(name, newPlayerBoard);

        // Adding ships to the player board

        System.out.println("\nAgora iremos adicionar os navios:");
        newPlayer.getPlayerBoard().addShips(numberOfShips);

        System.out.println("\nListagem de navios no tabuleiro(" + newPlayer.getPlayerName() + "):");
        for (Ship ship : newPlayerBoard.getShips()) {
            System.out.println(ship.getShipName());
        }

        return newPlayer;
    }
}