package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private String[][] _boardCoordinates;

    public String[][] getBoardCoordinates() {
        return _boardCoordinates;
    }

    private List<Ship> _ships;

    public List<Ship> getShips() {
        return _ships;
    }

    public Ship getSpecificShip(Integer index) {
        return _ships.get(index);
    }

    public Board(Integer numberOfRows, Integer numberOfColumns) {
        _boardCoordinates = new String[numberOfRows][numberOfColumns];
        _ships = new ArrayList<>();
    }

    public boolean addShip(String shipName, Integer rowPosition, Integer columnPosition) {
        if (rowPosition > _boardCoordinates.length || columnPosition > _boardCoordinates[0].length) {
            System.out.println(
                    "O navio " + shipName
                            + " nao foi adicionado pois sua posicao escolhida nao e valida para o tabuleiro atual.");
            return false;
        } else {
            _ships.add(new Ship(shipName, rowPosition.toString(), columnPosition.toString()));
            System.out.println("Navio " + shipName + " adicionado com sucesso!");
            return true;
        }
    }

    public String shootBoard(Integer choosenRow, Integer choosenColumn) {
        if (choosenRow > _boardCoordinates.length || choosenColumn > _boardCoordinates[0].length) {
            return "Valor fora dos limites do tabuleiro.";
        } else {
            if (_boardCoordinates[choosenRow][choosenColumn] != null) {
                return "Estas coordenadas ja foram atingidas, por favor escolha outra coordenada para prosseguir.";
            } else {
                Ship hittenShip = null;
                for (Ship ship : _ships) {
                    if (ship.getColumnPosition().equals(choosenColumn.toString())
                            && ship.getRowPosition().equals(choosenRow.toString())) {
                        hittenShip = ship;
                        break;
                    }
                }
                if (hittenShip != null) {
                    _boardCoordinates[choosenRow][choosenColumn] = "O";
                    return "O tiro acertou um navio adversario!";
                } else {
                    _boardCoordinates[choosenRow][choosenColumn] = "X";
                    return "O tiro acertou a agua.";
                }
            }
        }
    }

    public String printBoard() {
        String boardToPrint = "_______________________\n";
        char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = -1; i < _boardCoordinates.length; i++) {
            boardToPrint += "|";
            for (int j = -1; j < _boardCoordinates[0].length; j++) {
                if (i < 0) {
                    if (j < 0) {
                        boardToPrint += "*|";
                    } else {
                        boardToPrint += alfabeto[j] + "|";
                    }
                } else {
                    if (j < 0) {
                        boardToPrint += (i + 1) + "|";
                    } else {
                        boardToPrint += (Optional.ofNullable(_boardCoordinates[i][j]).orElse(" ")) + "|";
                    }
                }
            }
            boardToPrint += "\n";
        }
        return boardToPrint;
    }
}
