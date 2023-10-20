package mill;
public class MCP {
    static void printBoard(){
        System.out.println("X----------X----------X");
        System.out.println("|          |          |");
        System.out.println("|   X------X------X   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   |   X--X--X   |   |");
        System.out.println("|   |   |     |   |   |");
        System.out.println("X---X---X     X---X---X");
        System.out.println("|   |   |     |   |   |");
        System.out.println("|   |   X--X--X   |   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   X------X------X   |");
        System.out.println("|          |          |");
        System.out.println("X----------X----------X");

    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Mill Game");
        System.out.println("Start the Tutorial --> press t");
        System.out.println("Start a new Game   --> press g");

        //printBoard();
    }
}