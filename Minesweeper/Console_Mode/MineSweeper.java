import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class MineSweeper {

    // debug flags
    private boolean showMines = false;
    private boolean showNbTouchingMines = false;

    // grid properties
    private int nbRows;
    private int nbCols;
    private Cell[][] grid;

    // useful for play() method
    private int nbMines;
    private int nbVisibleCells;

    public MineSweeper(int nbRows, int nbCols, int nbMines) {
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        this.nbMines = nbMines;
        this.nbVisibleCells = 0;
        this.grid = new Cell[nbRows][nbCols];
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                this.grid[i][j] = new Cell(i, j);
            }
        }
    }

    public MineSweeper(int nbRows, int nbCols) {
        this(nbRows, nbCols, 0);
    }

    public void putMines(int nbMines, LinkedList<Cell> forbiddenSquares) {
        Random random = new Random();
        for (int i = 0; i < nbMines; i++) {
            int row = random.nextInt(this.nbRows);
            int col = random.nextInt(this.nbCols);
            if (this.nbRows * this.nbCols < nbMines) {
                System.out.println("Error: Too much mines given in argument!");
                break;
            }
            if (!this.grid[row][col].isMine() && !forbiddenSquares.contains(this.grid[row][col])) {
                this.grid[row][col].setMine(true);
                LinkedList<Cell> neighbors = new LinkedList<>(getNeighbors(this.grid[row][col]));
                for (Cell neighbour : neighbors) {
                    this.grid[neighbour.getRow()][neighbour.getCol()].setNbTouchingMines(this.grid[neighbour.getRow()][neighbour.getCol()].getNbTouchingMines() + 1);
                }
            } else i--;
        }
    }

    public void unveil(int row, int col) {
        if (grid[row][col].getNbTouchingMines() == 0) {
            LinkedList<Cell> visiting = new LinkedList<>();
            visiting.add(grid[row][col]);
            do {
                Cell actual = visiting.poll();
                actual.setVisible(true);
                nbVisibleCells++;
                LinkedList<Cell> neighbors = new LinkedList<>(getNeighbors(actual));
                for (Cell neighbor : neighbors) {
                    if (!neighbor.isVisible() && !visiting.contains(neighbor)) {
                        if (neighbor.getNbTouchingMines() == 0) {
                            visiting.add(neighbor);
                        } else {
                            neighbor.setVisible(true);
                            nbVisibleCells++;
                        }
                    }
                }
            } while (!visiting.isEmpty());
        } else {
            this.grid[row][col].setVisible(true);
            nbVisibleCells++;
        }
    }

    public void play() {
        int i;
        int j;
        char symbol;
        boolean areMinesPut = false;
        Scanner s = new Scanner(System.in);
        print();
        while (nbVisibleCells < nbRows * nbCols - nbMines) {
            System.out.print("Unveil a cell [d i j], mark a cell [m i j !/?/#] or quit game [q] > ");
            char letter = s.next().charAt(0);
            if (letter == 'd') {
                try {
                    i = s.nextInt();
                    j = s.nextInt();
                    s.nextLine();
                    if (i >= 0 && i < nbRows && j >= 0 && j < nbCols) {
                        if (!grid[i][j].isVisible()) {
                            if (!areMinesPut) {
                                areMinesPut = true;
                                LinkedList<Cell> forbiddenSquares = new LinkedList<>(getNeighbors(grid[i][j]));
                                forbiddenSquares.add(grid[i][j]);
                                putMines(nbMines, forbiddenSquares);
                            }
                            if (grid[i][j].isMine()) {
                                showMines = true;
                                System.out.println("----------------------------------\n------------YOU LOST !!-----------\n----------------------------------");
                                print();
                                s.close();
                                System.exit(0);
                            }
                            unveil(i, j);
                            if (nbVisibleCells < nbRows * nbCols - nbMines) {
                                print();
                            }
                        } else {
                            System.out.println("This cell has already been unveiled!");
                        }
                    } else {
                        System.out.println("Wrong bounds: i ∈ [0, " + (nbRows - 1) + "] and j ∈ [0, " + (nbCols - 1) + "]");
                    }
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("Wrong input!");
                }
            } else if (letter == 'm') {
                try {
                    i = s.nextInt();
                    j = s.nextInt();
                    symbol = s.next().charAt(0);
                    s.nextLine();
                    if ((symbol == '!' || symbol == '?' || symbol == '#') && (i >= 0 && i < nbRows && j >= 0 && j < nbCols)) {
                        if (symbol == '!') {
                            grid[i][j].setMarking('!');
                        }
                        if (symbol == '?') {
                            grid[i][j].setMarking('?');
                        }
                        if (symbol == '#') {
                            grid[i][j].setMarking('#');
                        }
                        print();
                    } else if (!(i >= 0 && i < nbRows && j >= 0 && j < nbCols)) {
                        System.out.println("Wrong bounds: i ∈ [0, " + (nbRows - 1) + "] and j ∈ [0, " + (nbCols - 1) + "]");
                    } else {
                        System.out.println("Wrong input!");
                    }
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("Wrong input!");
                }
            } else if (letter == 'q') {
                System.out.println("Game aborted");
                s.close();
                System.exit(0);
            } else {
                s.nextLine();
                System.out.println("Wrong input!");
            }
        }
        showMines = true;
        System.out.println("-----------------------------------\n☺  ☺  ☺ YOU HAVE WON !! ☺  ☺  ☺ \n-----------------------------------");
        print();
        s.close();
    }


    /// already implemented classes

    // returns the String representation of a Cell, depending on its attributes and the debug flags
    public String getCellSymbol(Cell cell) {

        String symbol = "#";        // default symbol = hidden cell

        // shows the mine in the cell if the cell is visible or if the showMines flag is on
        if ((cell.isVisible() || this.showMines) && cell.isMine()) {
            symbol = "*";
        }
        // shows the number of touching mines if the cell is visible or if the showNbTouchingMines flag is on
        else if (cell.isVisible() || this.showNbTouchingMines) {

            // special case of a visible cell : " " is displayed instead of "0"
            if (cell.isVisible() && cell.getNbTouchingMines() == 0) {
                symbol = " ";
            } else {
                symbol = Integer.toString(cell.getNbTouchingMines());
            }

        }

        // marking cells
        else if (cell.getMarking() == '!') {
            symbol = "!";
        }

        else if (cell.getMarking() == '?') {
            symbol = "?";
        }


        return symbol;
    }

    // prints the game grid
    public void print() {

        int firstColumnWidth = (int) Math.ceil(Math.log10(this.nbRows));     // first column width = number of digits in nbRows
        int otherColumnsWidth = (int) Math.ceil(Math.log10(this.nbCols));    // other columns width = number of digits in nbCols

        // first line = column numbers
        System.out.printf("%" + firstColumnWidth + "s ", "");
        for (int j = 0; j < this.nbCols; j++) {
            System.out.printf("%" + otherColumnsWidth + "s ", j);
        }
        System.out.println();

        for (int i = 0; i < this.nbRows; i++) {

            // first column = row numbers
            System.out.printf("%" + firstColumnWidth + "s ", i);
            for (int j = 0; j < this.nbCols; j++) {

                Cell cell = this.grid[i][j];
                String cellSymbol = getCellSymbol(cell);
                System.out.printf("%" + otherColumnsWidth + "s ", cellSymbol);
            }
            System.out.println();
        }
    }

    // returns the neighbors of a Cell at the specified row and col in the grid
    public LinkedList<Cell> getNeighbors(Cell cell) {

        LinkedList<Cell> neighbors = new LinkedList<>();
        int row = cell.getRow();
        int col = cell.getCol();

        if (row - 1 >= 0) {
            neighbors.add(this.grid[row - 1][col]);

            if (col + 1 < this.nbCols) {
                neighbors.add(this.grid[row - 1][col + 1]);
            }

            if (col - 1 >= 0) {
                neighbors.add(this.grid[row - 1][col - 1]);
            }
        }

        if (col + 1 < this.nbCols) {
            neighbors.add(this.grid[row][col + 1]);
        }

        if (col - 1 >= 0) {
            neighbors.add(this.grid[row][col - 1]);
        }

        if (row + 1 < this.nbRows) {
            neighbors.add(this.grid[row + 1][col]);

            if (col + 1 < this.nbCols) {
                neighbors.add(this.grid[row + 1][col + 1]);
            }

            if (col - 1 >= 0) {
                neighbors.add(this.grid[row + 1][col - 1]);
            }
        }

        return neighbors;
    }

}
