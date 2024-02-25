import classes.Board;
import classes.Player;
import classes.Ship;

public class App {
    public static void main(String[] args) throws Exception {
        Board firstBoard = new Board(7, 10);
        Player firstPlayer = new Player("Player1", firstBoard);

        System.out.println("Adicionando navios: ");
        firstBoard.addShip("Ship1", 4, 8);
        firstBoard.addShip("Ship2", 8, 3);
        firstBoard.addShip("Ship3", 1, 2);
        firstBoard.addShip("Ship4", 6, 12);

        System.out.println("\nListagem de navios no tabuleiro: ");
        for (Ship ship : firstBoard.getShips()) {
            System.out.println(ship.getShipName());
        }

        System.out.println("\nAtirando no tabuleiro: ");
        System.out.println(firstBoard.shootBoard(2, 4));
        System.out.println(firstBoard.shootBoard(8, 1));
        System.out.println(firstBoard.shootBoard(4, 8));
        System.out.println(firstBoard.shootBoard(5, 11));


        System.out.println("\nTabuleiro 1:");
        System.out.println(firstPlayer.getPlayerBoard().printBoard());
    }
}