
// -1 will be checking number for cards

class Bingo {
    private Player[] playersList;
    private String winners = "";

    public Bingo(Player[] players) {
        playersList = players;
    }

    public String play(int number) {
        for (int i = 0; i < playersList.length; i++) {
            playersList[i].markNumber(number);
        }
        for (int i = 0; i < playersList.length; i++) {
            if(playersList[i].isWinner()) {
                winners += playersList[i].getName() + " ";
            }
        }
        return winners;
    }
}

class Player {
    private String playerName;
    private Card[] cardMatrix;

    public Player(String name, Card[] cards) {
        this.playerName = name;
        this.cardMatrix = cards;
    }

    public String getName() {
        return playerName;
    }

    public Card[] getCards() {
        return cardMatrix;
    }

    public boolean isWinner() {
        boolean winCondition = false;
        for (int i = 0; i < cardMatrix.length; i++) {
            for (int k = 0; k < 5; k++) {
                for (int j = 0; j < 5; j++) {
                    if (cardMatrix[i].isMarked(j, k)) {
                        winCondition = true;
                        j = 0;
                    }
                }
            }
        }
        for (int i = 0; i < cardMatrix.length; i++) {
            for (int k = 0; k < 5; k++) {
                for (int j = 0; j < 5; j++) {
                    if (cardMatrix[i].isMarked(k, j)) {
                        winCondition = true;
                        j = 0;

                    }
                }
            }
        }
        for (int i = 0; i < cardMatrix.length; i++) {
            for (int k = 0; k < 5; k++) {
                if (cardMatrix[i].isMarked(k, k)) {
                    winCondition = true;
                }
            }
        }
        return winCondition;
    }

    public void markNumber(int number) {
        for(int i = 0; i < cardMatrix.length; i++) {
            cardMatrix[i].markNumber(number);
        }
    }
}

class Card {
    private int[][] numbersMatrix;

    public Card(int[][] numbers)  {
        numbersMatrix = numbers;
    }

    public int getNumber(int row, int col) {
        return numbersMatrix[row][col];
    }

    public boolean isMarked(int row, int col) {
        return numbersMatrix[row][col] == -1;
    }

    public void markNumber(int number) {
        for (int i = 0; i < numbersMatrix.length; i++) {
            for (int k = 0; k < numbersMatrix.length; k++) {
                if (numbersMatrix[i][k] == number)
                    numbersMatrix[i][k] = -1;
            }
        }
    }
}