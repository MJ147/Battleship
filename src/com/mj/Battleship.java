package com.mj;

import java.util.ArrayList;

public class Battleship {

    private ArrayList<String> position;
    private String name;

    public Battleship(String name) {
        this.name = name;
    }

    public void setPosition(ArrayList<String> position) {
        this.position = position;
    }

    public String check(String move) {
        String result = "pudło";
        int index = position.indexOf(move);

        if (index >= 0) {
            position.remove(index);

            if (position.isEmpty()) {
                result = "zatopiony";
                System.out.println("Kapitanie! Okret " + name + " zatopiony!");
            } else {
                result = "trafiony";
            }
        }
        return result;

    }

}
