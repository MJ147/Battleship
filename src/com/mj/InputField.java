package com.mj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputField {

    private final String abc = "abcdefg";
    private int lengthOfBoard = 7;
    private int sizeOfBoard = 49;

    public String getABC() {
        return abc;
    }

    public int getLengthOfBoard() {
        return lengthOfBoard;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    private int[] board = new int[sizeOfBoard];
    private int numberOfBattleships = 0;

    public String inputField(){

        String input = null;
        System.out.println("Podaj współrzędne pola: ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            input = is.readLine();
            if (input.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return input.toLowerCase();
    }

    public ArrayList setupBattleship (int sizeOfBattleship) {
        ArrayList<String> occupiedFields = new ArrayList<>();
        String convertToABC = null;
        int [] coordinate = new int[sizeOfBattleship];
        int numberOfTries = 0;
        boolean success = false;
        int position = 0;
        numberOfBattleships++;
        int increase = 1;

        if ((numberOfBattleships % 2) == 1) { // if odd -> set vertical
            increase = lengthOfBoard; // vertical increase
        }
        while (!success & numberOfTries++ < 200 ) {
            position = (int) (Math.random() * sizeOfBoard); // random start point
            int x = 0; //
            success = true;

            while (success && x < sizeOfBattleship) {
                if (board[position] == 0) {
                    coordinate[x++] = position;
                    position += increase;
                    if (position >= sizeOfBoard) { // out of bottom edge
                        success = false;
                    }
                    if (x > 0 && (position % lengthOfBoard == 0)) { // out of right edge
                        success = false;
                    }
                } else { // field is occupied
                    success = false;
                }
            }
        }

        int x = 0;
        int line = 0;
        int column = 0;

        while (x < sizeOfBattleship) {
            board[coordinate[x]] = 1; // mark occupied field
            line = (int) (coordinate[x] / lengthOfBoard); // which line
            column = coordinate[x] % lengthOfBoard; // get number of column
            convertToABC = String.valueOf(abc.charAt(column)); // convert to alphanumeric
            occupiedFields.add(convertToABC.concat(Integer.toString(line)));
            x++;
            //System.out.print(" współrzędne " + x + " = " + occupiedFields.get(x-1)); // print coordinates of Battleships
        }

        return occupiedFields;
    }
}
