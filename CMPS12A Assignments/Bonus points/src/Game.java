class Game {
    private int position;
    private Board board;
    private Player[] players;
    private Player currentPlayer;
    private Cell cell;
    private Ladder ladder;
    private Snake snake;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    public Game(Player[] players) {
        this.board = new Board(10);
        this.players = players;
    }

    public Player currentPlayer() {
        for (int i = 0; i < players.length; i++) {
            players[i] = currentPlayer;
        }
        return currentPlayer;
    }

    public void addPlayer(Player player) {
        Player[] temp = new Player[players.length + 1];
        for (int i = 0; i < temp.length; i++) {
            if (i < temp.length - 1) {
                temp[i] = players[i];
            }
            temp[players.length] = player;
        }
        this.players = temp;
    }

    public boolean winner() {
        if (currentPlayer.getPosition() >= 100) {
            return true;
        }
        return false;
    }

    public void movePlayer(int n) {
        position = n + currentPlayer.getPosition();
        cell = board.getCells()[position];
        if (cell.getLadder() != null) {
            position += ladder.getTop();
        }
        if (cell.getSnake() != null) {
            position -= snake.getTail();
        }
        if (cell.isOccupied()) {
            position = 1;
        }
    }

    public boolean play(int moveCount) {
        moveCount = moveCount + currentPlayer.getPosition();
        currentPlayer.setPosition(moveCount);
        movePlayer(moveCount);
        return winner();
    }

    public Board getBoard() { return board; }

}

class Player {
    private int position;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void setPosition(int toSet) {
        position = this.getPosition() + position;
    }

    public int getPosition() { return position; }
    public String getName() { return name; }

    public String toString() {
        return name + "@" + position;
    }
}

class Cell {
    private Cell cell = null;
    private Ladder ladder;
    private int number;
    private Snake snake;

    public Cell(int number) {
        this.number = number;
    }

    public void setOccupied(boolean occupied) {
        occupied = cell.isOccupied();
    }

    public boolean isOccupied() {
        return cell != null;
    }

    public void setLadder(Ladder toSet) {
        ladder.getTop();
    }

    public void setSnake(Snake snake) {
        snake.getTail();
    }
    public Ladder getLadder() { return ladder; }
    public Snake getSnake() { return snake; }
    public int getNumber() { return number;}

}

class Board {
    private Ladder ladder;
    private Snake snake;
    private Cell[] cell;
    private Cell[] board;

    public Board(int n) {
        for (int i = 0; i < n; i++) {
            cell = new Cell[i];
        }
        board = new Cell[n * n];
    }

    public void setCellToLadder(int startPosition, int endPosition) {
        cell[startPosition].setLadder(ladder);
    }

    public void setCellToSnake(int headPosition, int tailPosition) {
        cell[headPosition].setSnake(snake);
    }

    public Cell[] getCells() {
        return cell;
    }
}

class Snake {
    private int headPosition;
    private int tailPosition;

    public Snake(int headPosition, int tailPosition) {
        this.headPosition = headPosition;
        this.tailPosition = tailPosition;
    }

    public int getTail() { return tailPosition; }

    public String toString() {
        return headPosition + " - " + tailPosition;
    }
}

class Ladder {
    private int startPosition;
    private int endPosition;

    public Ladder(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getTop (){
        return endPosition;
    }

    public String toString() {
        return startPosition + " - " + endPosition;
    }
}