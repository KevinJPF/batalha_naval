package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private String[][] _boardCoordinates;

    public String[][] getBoardCoordinates() {
        return _boardCoordinates;
    }

    public Integer getBoardRows() {
        return _boardCoordinates.length;
    }

    public Integer getBoardColumns() {
        return _boardCoordinates[0].length;
    }

    private List<Ship> _ships;

    public List<Ship> getShips() {
        return _ships;
    }

    public Ship getSpecificShip(Integer index) {
        return _ships.get(index);
    }

    public Board(Integer numberOfRows, Integer numberOfColumns) {
        _boardCoordinates = new String[Math.max(3, Math.min(10, numberOfRows))][Math.max(3,
                Math.min(10, numberOfColumns))];
        _ships = new ArrayList<>();
    }

    public void addShips(Integer numberOfShips) {
        for (int i = 1; i <= numberOfShips; i++) {
            System.out.println("Me diga o nome do " + i + "º navio");
            String shipName = Util.scanner.nextLine();

            boolean succesfullyInserted = false;
            do {
                System.out.println("Em qual a linha ficará o navio " + shipName + ":");
                Integer selectedRow = Util.persistIntegerInterval(1, getBoardRows(),
                        "Valor da linha inserido está fora dos limites do tabuleiro, por favor insira uma linha válida:");

                System.out.println("Em qual a coluna ficará o navio " + shipName + ":");
                Integer selectedColumn = Util.persistIntegerInterval(1, getBoardColumns(),
                        "Valor da linha inserido está fora dos limites do tabuleiro, por favor insira uma coluna válida:");

                succesfullyInserted = addShip(shipName, selectedRow, selectedColumn);
            } while (!succesfullyInserted);
        }
    }

    private boolean addShip(String shipName, Integer rowPosition, Integer columnPosition) {
        if (rowPosition > _boardCoordinates.length || columnPosition > _boardCoordinates[0].length) {
            System.out.println(
                    "O navio " + shipName
                            + " não foi adicionado pois sua posição escolhida não e válida para o tabuleiro atual.");
            return false;
        } else {
            if (hasAnyShipOnCoordinate(rowPosition, columnPosition) != null) {
                System.out.println(
                        "O navio " + shipName
                                + " não foi adicionado pois sua posição escolhida já tem um navio para o tabuleiro atual.");
                return false;
            }
            _ships.add(new Ship(shipName, rowPosition.toString(), columnPosition.toString()));
            System.out.println("Navio " + shipName + " adicionado com sucesso!");
            return true;
        }
    }

    public String shootBoard() {
        boolean succesfullyShot = false;
        String returnMessage = "";
        do {
            System.out.println("Escolha a linha para atirar:");
            Integer choosenRow = Util.persistIntegerInterval(1, getBoardRows(),
                    "Valor da linha inserido está fora dos limites do tabuleiro, por favor insira uma linha válida:");

            System.out.println("Escolha a coluna para atirar");
            Integer choosenColumn = Util.persistIntegerInterval(1, getBoardColumns(),
                    "Valor da linha inserido está fora dos limites do tabuleiro, por favor insira uma coluna válida:");

            if (choosenRow > _boardCoordinates.length || choosenColumn > _boardCoordinates[0].length) {
                System.err.println("Valor fora dos limites do tabuleiro.");
            } else {
                if (identifyValueOnBoard(choosenRow, choosenColumn) != null) {
                    System.err.println(
                            "Estas coordenadas ja foram atingidas, por favor escolha outra coordenada para prosseguir.");
                } else {
                    succesfullyShot = true;
                    Ship hittenShip = hasAnyShipOnCoordinate(choosenRow, choosenColumn);
                    if (hittenShip != null) {
                        _boardCoordinates[choosenRow - 1][choosenColumn - 1] = "O";
                        getSpecificShip(_ships.indexOf(hittenShip)).hasBeenHit();
                        returnMessage = "O tiro acertou o navio " + hittenShip.getShipName() + " adversario!";
                    } else {
                        _boardCoordinates[choosenRow - 1][choosenColumn - 1] = "X";
                        returnMessage = "O tiro acertou a agua.";
                    }
                }
            }
        } while (!succesfullyShot);

        return returnMessage;
    }

    private String identifyValueOnBoard(Integer choosenRow, Integer choosenColumn) {
        return _boardCoordinates[choosenRow - 1][choosenColumn - 1];
    }

    private Ship hasAnyShipOnCoordinate(Integer choosenRow, Integer choosenColumn) {
        Ship hasShip = null;
        for (Ship ship : _ships) {
            if (ship.getColumnPosition().equals(choosenColumn.toString())
                    && ship.getRowPosition().equals(choosenRow.toString())) {
                hasShip = ship;
                break;
            }
        }

        return hasShip;
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
