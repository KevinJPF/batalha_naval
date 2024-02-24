package classes;

public class Ship {
    private String _shipName;

    public String getShipName() {
        return _shipName;
    }

    public void setShipName(String _shipName) {
        this._shipName = _shipName;
    }

    private String _columnPosition;

    public String getColumnPosition() {
        return _columnPosition;
    }

    public void setColumnPosition(String _columnPosition) {
        this._columnPosition = _columnPosition;
    }

    private String _rowPosition;

    public String getRowPosition() {
        return _rowPosition;
    }

    public void setRowPosition(String _rowPosition) {
        this._rowPosition = _rowPosition;
    }

    private boolean _wasHit;

    public boolean getWasHit() {
        return _wasHit;
    }

    public Ship(String shipName, String selectedRow, String selectedColumn) {
        _shipName = shipName;
        _columnPosition = selectedColumn;
        _rowPosition = selectedRow;
        _wasHit = false;
    }

    public void hasBeenHit() {
        _wasHit = true;
    }
}
