package mill.core;

import java.util.Arrays;

public class Game {
    private Field[] inner;
    private Field[] middle;
    private Field[] outer;

    int[] firstRow = {0, 1, 2};
    int[] leftColumn = {0, 3, 5};
    int[] rightColumn = {2, 4, 7};
    int[] lastRow = {5, 6, 7};
    int[] connection = {1, 3, 4, 6};

    private Player turn;
    private int PlaceCounter;

    public Game() {
        this.inner = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        this.middle = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};
        this.outer = new Field[]{Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY};

        this.turn = Player.OOO;
        this.PlaceCounter = 0;
    }

    public void setGame(Field[] inner, Field[] middle, Field[] outer) {
        this.inner = inner;
        this.outer = outer;
        this.middle = middle;
    }

    public boolean getPlayer() {
        return turn == Player.OOO;
        //returns true if Player == 000 == white
        // returns false if Player == XXX == black
    }

    public boolean placeToken(String placeToBe) {
        if (PlaceCounter >= 18) {
            return false;
            // To Do:
            // Fehlercodes einbauen, um am UserInterface anzeigen zu können was los ist.
            // derzeit nur eine Fehlerbehandlung => für zu viele Tokens derzeit ungeeignet.
        }

        Field token;
        // welcher Spieler
        if (getPlayer()) {
            token = Field.WHITE;
        } else {
            token = Field.BLACK;
        }

        // Wohin?
        // = placeToBe
        char[] location = placeToBe.toCharArray();

        Field[] chooseField = getChosenCircle(location[0]);

        int index = location[1] - '1';
        // ASCII magic

        if (chooseField[index] != Field.EMPTY) {
            return false;
        }

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
                if (checkMillConnections(index, color)) return true;
            }
        }
        return false;
    }

    private boolean checkMillRing(Field[] field, Field fieldColor) {
        if (checkMill(field, firstRow, fieldColor)) return true;
        if (checkMill(field, leftColumn, fieldColor)) return true;
        if (checkMill(field, rightColumn, fieldColor)) return true;
        if (checkMill(field, lastRow, fieldColor)) return true;
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

        // wo soll entfernt werden?
        char[] location = PlacetoRemove.toCharArray();
        Field[] chooseField = getChosenCircle(location[0]);

        int index = location[1] - '1';
        // to do: also refactor this, because is is also used in placeToken()

        // kann hier entfernt werden?

        // entfernen
        if (chooseField[index] == tokenToRemove) {
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

    private Field[] getChosenCircle(char thelocation) {
        Field[] theChosenField = null;

        switch (thelocation) {
            case 'i': {
                theChosenField = inner;
                break;
            }
            case 'm': {
                theChosenField = middle;
                break;
            }
            case 'a': {
                theChosenField = outer;
                break;
            }
        }

        return theChosenField;
    }

    public int moveToken(String start, String goal) {
        // wurde ein richtiger Token ausgewählt?

        // wie kann man eine Klassenbeschreibung hinzufügen, die man beim Hovern beim Aufruf sehen kann?

        // mag ich hier so art Returncodes verwenden?
        // 0 = successfull
        // 1 = cannot be moved, empty Field
        // 2 = cannot be moved, opponents Field
        // 3 = cannot be moved, no empty fields nearby
        // 9 = error unknown

        // start ist valid
        int wohinSollIchMichWenden = 0;

        // Welcher Kreis?
        char[] startLocation = start.toCharArray();
        char[] goalLocation = goal.toCharArray();
        Field currentPlayersToken;

        Field[] startCircle = getChosenCircle(startLocation[0]);
        Field[] goalCircle = getChosenCircle(goalLocation[0]);
        int startIndex = startLocation[1] - '1';
        int goalIndex = goalLocation[1] - '1';


        currentPlayersToken = getPlayersToken(getPlayer());



        // move right
        if(startIndex == goalIndex - 1){
            if(startCircle == outer){
                outer[startIndex] = Field.EMPTY;
                outer[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == middle){
                middle[startIndex] = Field.EMPTY;
                middle[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == inner){
                inner[startIndex] = Field.EMPTY;
                inner[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
            /*
            * Zeilenhüpfen ist möglich!
            * fix later
            * */
        }

        // move left
        if(startIndex - 1 == goalIndex){
            if(startCircle == outer){
                outer[startIndex] = Field.EMPTY;
                outer[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == middle){
                middle[startIndex] = Field.EMPTY;
                middle[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == inner){
                inner[startIndex] = Field.EMPTY;
                inner[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
            /*
             * Zeilenhüpfen ist möglich!
             * fix later
             * */
        }

        // move down (first to second row)
        if(startIndex == goalIndex - 3){
            if(startCircle == outer){
                outer[startIndex] = Field.EMPTY;
                outer[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == middle){
                middle[startIndex] = Field.EMPTY;
                middle[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == inner){
                inner[startIndex] = Field.EMPTY;
                inner[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
        }

        // move down (second to third row)
        if(startIndex == goalIndex - 2){
            if(startCircle == outer){
                outer[startIndex] = Field.EMPTY;
                outer[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == middle){
                middle[startIndex] = Field.EMPTY;
                middle[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }else if (startCircle == inner){
                inner[startIndex] = Field.EMPTY;
                inner[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
        }

        // von außen nach mitte
        if (startIndex == goalIndex){
            if(startCircle == outer && goalCircle == middle){
                outer[startIndex] = Field.EMPTY;
                middle[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
            else if(startCircle == middle && goalCircle == inner){
                middle[startIndex] = Field.EMPTY;
                inner[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
            else if (startCircle == inner && goalCircle == middle){
                inner[startIndex] = Field.EMPTY;
                middle[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
            else if(startCircle == middle && goalCircle == outer){
                middle[startIndex] = Field.EMPTY;
                outer[goalIndex] = currentPlayersToken;
                switchPlayer();
                return 0;
            }
        }


        return 9;
    }

    public boolean checkIfValidTokenToMove(String start) {
        // wenn start Feld Token = aktueller Spieler ist => true
        // sonst false

        if (start == null){
            return false;
        }

        char[] location = start.toCharArray();
        Field currentPlayersToken;

        Field[] chosenCircle = getChosenCircle(location[0]);
        int index = location[1] - '1';
        // getPlayer        ...    boolean (true = white; false = black)
        // chosenField[index] ...

        currentPlayersToken = getPlayersToken(getPlayer());

        if (chosenCircle == outer && outer[index] == currentPlayersToken) {
            return true;
        } else if (chosenCircle == middle && middle[index] == currentPlayersToken) {
            return true;
        } else if (chosenCircle == inner && inner[index] == currentPlayersToken) {
            return true;
        }else {
            return false;
        }
    }

    private Field getPlayersToken(boolean player){
        if(player){
            return Field.WHITE;
        }else {
            return Field.BLACK;
        }
    }


    /*

    private Field checkField(char circle, int index) throws Exception {
        if (circle == null) throw new Exception("unclear");


    }

     */
}
