package com.mj;

public class GameTest extends Game{


    public static void main(String[] args) {

        GameTest game = new GameTest();

        game.prepareGame();

        game.startGame();
    }

    @Override
    public void startGame() {

        InputField input = new InputField();
        while (!battleshipList.isEmpty()) {

        String abc = input.getABC();
        int move = (int) (Math.random() * input.getSizeOfBoard());
        int line = move / input.getLengthOfBoard(); // which line
        int column = move % 7; // get number of column
        String convertToABC = String.valueOf(abc.charAt(column)); // convert to alphanumeric
        String occupiedFields = convertToABC + Integer.toString(line);

        System.out.println(occupiedFields);
        checkMove(occupiedFields);

        }

        endGame();
    }

}
