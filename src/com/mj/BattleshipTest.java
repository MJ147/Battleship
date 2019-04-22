package com.mj;

import java.util.ArrayList;

public class BattleshipTest {

    public static void main(String[] args) {

        Battleship battleship = new Battleship("Name");
        ArrayList<String> position = new ArrayList<>();

        position.add("A1");
        position.add("A2");
        position.add("A3");

        battleship.setPosition(position);

        String move = "A1";

        String result = battleship.check(move);

        String resultOfTest = "megative";

        if (result.equals("trafiony")) {
            resultOfTest = "positive";
        }

        System.out.println(resultOfTest);




    }
}
