import classes.Board;
import classes.Ship;

public class App {
    public static void main(String[] args) throws Exception {
        Board firstBoard = new Board(7, 10);

        firstBoard.addShip("Ship1", 4, 8);
        firstBoard.addShip("Ship2", 8, 3);
        firstBoard.addShip("Ship3", 1, 2);
        firstBoard.addShip("Ship4", 6, 12);

        System.out.println("O tabuleiro 1 tem os navios: ");
        for (Ship ship : firstBoard.getShips()) {
            System.out.println(ship.getShipName());
        }

        boolean[][] firstBoardCoordinates = firstBoard.getBoardCoordinates();
        String rowToPrint = "|";
        char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        System.out.println("Tabuleiro 1:");
        for (int i = -1; i < firstBoardCoordinates.length; i++) {
            System.out.println("______________________");
            for (int j = -1; j < firstBoardCoordinates[0].length; j++) {
                if (i < 0) {
                    if (j < 0) {
                        rowToPrint += "*|";
                    } else {
                        rowToPrint += alfabeto[j] + "|";
                    }
                } else {
                    if (j < 0) {
                        rowToPrint += (i + 1) + "|";
                    } else {
                        rowToPrint += (firstBoardCoordinates[i][j] ? "X" : "O") + "|";
                    }
                }
            }
            System.out.println(rowToPrint);
            rowToPrint = "|";
        }

        System.out.println("Batalha Naval!");
    }
}