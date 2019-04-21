package com.mj;

import java.util.ArrayList;

public class Game {

    private InputField input = new InputField();
    private ArrayList<Battleship> battleshipList = new ArrayList<>();
    private int numberOfMoves = 0;

    public void prepareGame() {

        Battleship bismarck = new Battleship("Bismarck");
        Battleship arizona = new Battleship("Arizon");
        Battleship missouri = new Battleship("Missouri");
        battleshipList.add(bismarck);
        battleshipList.add(arizona);
        battleshipList.add(missouri);

        for ( Battleship battleship : battleshipList ) {

            battleship.setPosition(input.setupBattleship(3));

        }
            System.out.println("Wprowadzaj współrzędne pól (np. A2, E5) w celu zatopienia wszystkich okrętów przeciwnika");
    }

    public void startGame() {

        while (!battleshipList.isEmpty()) {

            String move = input.inputField();
            checkMove(move);
        }

        endGame();
    }

    public void checkMove(String move) {

        numberOfMoves++;
        String resultOfMove = "pudło";

        for ( Battleship battleship : battleshipList ) {

            resultOfMove = battleship.check(move);

            if (resultOfMove.equals("trafiony")){

                break;
            }

            if (resultOfMove.equals("zatopiony")){

                battleshipList.remove(battleship);
                break;
            }

        }

        System.out.println(resultOfMove);

    }

    public void endGame() {

        System.out.println("Wszystkie okręty zostały zatopione.");

        if (numberOfMoves <= 18) {

            System.out.println("Wykonałeś jedynie" + numberOfMoves + " ruchów.");
            System.out.println("Wracasz do domu cały i zdrowy.");
        } else {

            System.out.println("Szybciej się nie dało?. Wykonałeś "+ numberOfMoves + " ruchów.");
            System.out.println("Twója flota tonie, a kapitan schodzi z okrętu ostatni. :(");
        }
    }

}
