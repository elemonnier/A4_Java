public class Cell {
    private int row;
    private int col;
    private boolean mine;
    private boolean visible;
    private int nbTouchingMines;
    private char marking;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.mine = false;
        this.visible = false;
        this.nbTouchingMines = 0;
        this.marking = '#';
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isMine() {
        return mine;
    }

    public boolean isVisible() {
        return visible;
    }

    public int getNbTouchingMines() {
        return nbTouchingMines;
    }

    public char getMarking() {
        return marking;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setNbTouchingMines(int nbTouchingMines) {
        this.nbTouchingMines = nbTouchingMines;
    }

    public void setMarking(char marking) {
        this.marking = marking;
    }
}
