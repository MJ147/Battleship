package com.mj;

import java.util.ArrayList;

public class Game {

    InputField input = new InputField();
    ArrayList<Battleship> battleshipList = new ArrayList<>();
    private int numberOfMoves = 0;

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public void prepareGame() {
        //create, set name, set position of objects battleship
        //display information for player
    }

    public void startGame() {
        //ask player for move
        //initial checkMove
    }

    public void checkMove() {
        //initial check()
    }

    public void endGame() {
        //print number of moves
    }

}
