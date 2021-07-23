package hihi;
import java.util.Scanner;

public class funGame {
    int positionA = 0;
    int positionB = 29;
    String[] list = new String[30];
    Scanner scanner = new Scanner(System.in);

    private void refreshMap(){
        for (int i = 0 ; i<30; i++)
            list[i] = "_";
    }
    private void displayMap(){
        for (String x : list)
            System.out.print(x);
        System.out.println();
    }
    public void running(){
        boolean AWin = false;
        boolean BWin = false;
        int round = 1 ;
        refreshMap();
        list[positionA] = "A";
        list[positionB] = "B";
        int stepA;
        int stepB;
        displayMap();

        while (!AWin && !BWin) {
            System.out.println("It's A turn:");
            System.out.println("Do you want to move (1)?Or attack(2)?");

            int choiceA = scanner.nextInt();
            if (choiceA == 1)
                System.out.println("move: (1 or 2 spaces forward)");
            else
                System.out.println("Where do you want to attack? (1- 3)");
            stepA = scanner.nextInt();

            // B's turn

            System.out.println("It's B turn:");
            System.out.println("Do you want to move (1)?Or attack(2)?");
            int choiceB = scanner.nextInt();
            if (choiceB == 1)
                System.out.println("move: (1 or 2 spaces forward)");
            else
                System.out.println("Where do you want to attack? (1- 3)");
            stepB = scanner.nextInt();

            // display result
            displayMap();
            if (choiceA == 1)
                move('A', stepA);
            else
                attack('A', stepA);
            if (choiceB == 1)
                move('B', stepB);
            else
                attack('B', stepA);

            System.out.println("Round "+ round + " finish");
            System.out.println("--------------------");
            System.out.println();

            if (choiceA == 2 && positionA + stepA == positionB)
                AWin = true;
            if (choiceB == 2 && positionB - stepB == positionA)
                BWin = true;
        }
        if (AWin)
            System.out.println("A is win");
        else
            System.out.println("B is win");
    }

    private void attack(char l, int step) {
        System.out.println(l + " attacked the location "+ step +" spaces forward");
        if (l == 'A')
            list[positionA + step] = "X";
        else
            list[positionB - step] = "X";
        displayMap();
    }

    private void move(char l, int step) {
        refreshMap();
        System.out.println(l + " moved "+ step +" spaces forward");
        if (l == 'A')
            positionA += step;
        else
            positionB -= step;
        list[positionA] = "A";
        list[positionB] = "B";
        displayMap();
    }
}

