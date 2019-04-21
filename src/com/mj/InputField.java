package com.mj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputField {

    private static final String alfabet = "abcdefg";
    private int lengthOfBoard = 7;
    private int sizeOfBoard = 49;
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
        String help = null;
        int [] coordinate = new int[sizeOfBattleship];
        int prob = 0;
        boolean success = false;
        int position = 0;
        numberOfBattleships++;
        int inkr = 1;
        if ((numberOfBattleships % 2) == 1) { // if odd -> set vertical
            inkr = lengthOfBoard; // vertical increase
        }
        while (!success & prob++ < 200 ) {
            position = (int) (Math.random() * sizeOfBoard); // random start point
            int x = 0; //
            success = true;

            while (success && x < sizeOfBattleship) {
                if (board[position] == 0) {
                    coordinate[x++] = position;
                    position += inkr;
                    if (position >= sizeOfBoard) {
                        success = false;
                    }
                    if (x > 0 & (position % lengthOfBoard == 0)) {
                        success = false;
                    }
                } else { // field is occupied
                    success = false;
                }
            }
        }
        int x = 0;
        int wiersz = 0;
        int kolumna = 0;

        while (x < sizeOfBattleship) {
            board[coordinate[x]] = 1; // mark occupied field
            wiersz = (int) (coordinate[x] / lengthOfBoard); // which line
            kolumna = coordinate[x] % lengthOfBoard; // get number of column
            help = String.valueOf(alfabet.charAt(kolumna)); // convert to alphanumeric
            occupiedFields.add(help.concat(Integer.toString(wiersz)));
            x++;
            //System.out.print(" współrzędne " + x + " = " + occupiedFields.get(x-1));
        }

        return occupiedFields;
    }
}
