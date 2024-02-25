package classes;

public class Player {
    String _playerName;

    public String getPlayerName() {
        return _playerName;
    }

    public void setPlayerName(String _playerName) {
        this._playerName = _playerName;
    }

    Integer _playerPoints;

    public Integer getPlayerPoints() {
        return _playerPoints;
    }

    Board _playerBoard;

    public Board getPlayerBoard() {
        return _playerBoard;
    }

    public Player(String playerName, Board playerBoard) {
        _playerName = playerName;
        _playerBoard = playerBoard;
        _playerPoints = 0;
    }

    public Integer addPoint() {
        _playerPoints++;
        return _playerPoints;
    }

    public boolean allShipsHasBeenHit() {
        for (Ship ship : _playerBoard.getShips()) {
            if (!ship.getWasHit()) return false;
        }
        return true;
    }

}
