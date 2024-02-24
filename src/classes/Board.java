package classes;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private boolean[][] _boardCoordinates;

    public boolean[][] getBoardCoordinates() {
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
        _boardCoordinates = new boolean[numberOfRows][numberOfColumns];
        _ships = new ArrayList<>();
    }

    public boolean addShip(String shipName, Integer rowPosition, Integer columnPosition) {
        if (rowPosition > _boardCoordinates.length || columnPosition > _boardCoordinates[0].length) {
            System.out.println(
                    "O navio " + shipName
                            + " não foi adicionado pois sua posição escolhida não é válida para o tabuleiro atual.");
            return false;
        } else {
            _ships.add(new Ship(shipName, rowPosition.toString(), columnPosition.toString()));
            System.out.println("Navio " + shipName + " adicionado com sucesso!");
            return true;
        }
    }
}
