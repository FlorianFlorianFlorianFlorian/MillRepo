package mill.core;

import java.util.Arrays;

public class Game {
    private Field[] inner;
    private Field[] middle;
    private Field[] outer;

    int[] firstRow    = {0,1,2};
    int[] leftColumn  = {0,3,5};
    int[] rightColumn = {2,4,7};
    int[] lastRow     = {5,6,7};
    int[] connection  = {1,3,4,6};

    private Player turn;
    private int PlaceCounter;

    public Game() {
        this.inner = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        this.middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        this.outer = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};

        this.turn = Player.OOO;
        this.PlaceCounter = 0;
    }

    public void setGame(Field[] inner, Field[] middle, Field[] outer){
        this.inner = inner;
        this.outer = outer;
        this.middle = middle;
    }

    public String getPlayer() {
        if (turn == Player.OOO) {
            return "weiß ('O')";
        } else {
            return "schwarz ('X')";
        }
    }

    public boolean placeToken(String placeToBe) {
        if (PlaceCounter >= 18){
            return false;
            // To Do:
            // Fehlercodes einbauen, um am UserInterface anzeigen zu können was los ist.
            // derzeit nur eine Fehlerbehandlung => für zu viele Tokens derzeit ungeeignet.
        }

        Field token;
        // welcher Spieler
        if (turn == Player.OOO) {
            token = Field.WHITE;
        } else {
            token = Field.BLACK;
        }

        // Wohin?
        // = placeToBe
        char[] location = placeToBe.toCharArray();

        Field[] chooseField = null;
        switch (location[0]) {
            case 'i': {
                chooseField = inner;
                break;
            }
            case 'm': {
                chooseField = middle;
                break;
            }
            case 'a': {
                chooseField = outer;
                break;
            }
        }

        int index = location[1] - '1';
        // ASCII magic

        if (chooseField[index] != Field.EMPTY) {
            return false;
        }

        /*
        Bug Report:
        when wanting to place a token at a6 it is placed to a5 put it is shown at a6 and m6.
        check out why!
         */

        chooseField[index] = token;
        PlaceCounter++;
        switchPlayer();
        return true;
        // java obj sind immer parse by referenz => also übergeben wir einfach die Speicheradresse und somit ist es direkt in inner/middle/outer gespeichert

    }

    public void drawBoard() {
        Board.drawField(inner, middle, outer);
    }

    private void switchPlayer() {
        // assume ideal conditions
        if (turn == Player.XXX) {
            turn = Player.OOO;
        } else {
            turn = Player.XXX;
        }
    }

    public boolean checkForMills() {

        Field[] fieldColor = {Field.WHITE, Field.BLACK};
        for (Field color : fieldColor) {
            if (checkMillRing(outer, color)) return true;
            if (checkMillRing(middle, color)) return true;
            if (checkMillRing(inner, color)) return true;
            for (int index : connection) {
                if(checkMillConnections(index,color)) return true;
            }
        }
        return false;
    }

    private boolean checkMillRing(Field[] field, Field fieldColor){
        if (checkMill(field,firstRow,fieldColor)) return true;
        if (checkMill(field,leftColumn,fieldColor)) return true;
        if (checkMill(field,rightColumn,fieldColor)) return true;
        if (checkMill(field,lastRow,fieldColor)) return true;
        return false;
    }

    private boolean checkMill(Field[] field, int[] index, Field fieldColor) {
        return field[index[0]].equals(fieldColor) && field[index[1]].equals(fieldColor) && field[index[2]].equals(fieldColor);
    }

    private boolean checkMillConnections(int index, Field fieldColor) {
        return outer[index].equals(fieldColor) && middle[index].equals(fieldColor) && inner[index].equals(fieldColor);
    }

    public boolean removeToken(String PlacetoRemove) {
        // Welcher Token gehört entfernt?
        // SwitchPlacer wird nach placetoken aufgerufen, somit ist zu diesem Zeitpunkt der aktuelle Spieler bereits der, der als nächstes legt == das Token, das es zu entfernen liegt
        Field tokenToRemove;
        if (turn == Player.OOO) {
            tokenToRemove = Field.WHITE;
        } else {
            tokenToRemove = Field.BLACK;
        }
        // to do: refactor this code above, because it is also used in placeToken()

        // wo soll entfernt werden?
        char[] location = PlacetoRemove.toCharArray();
        Field[] chooseField = null;

        switch (location[0]) {
            case 'i': {
                chooseField = inner;
                break;
            }
            case 'm': {
                chooseField = middle;
                break;
            }
            case 'a': {
                chooseField = outer;
                break;
            }
        }
        int index = location[1] - '1';
        // to do: also refactor this, because is is also used in placeToken()

        // kann hier entfernt werden?

        // entfernen
        if(chooseField[index] == tokenToRemove) {
            if (chooseField == outer) {
                outer[index] = Field.EMPTY;
            } else if (chooseField == middle) {
                middle[index] = Field.EMPTY;
            } else if (chooseField == inner) {
                inner[index] = Field.EMPTY;
            }
            return true;
        }

        // Kontrolle?

        return false;
    }

    public boolean moveToken(String Start, String Goal){
        return false;
    }
}
