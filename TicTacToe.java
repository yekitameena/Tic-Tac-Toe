package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static int score;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] ticTacToeBox = new char[3][3];
        String[] inputs = scanner.nextLine().split(" ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j <3; j++)
                ticTacToeBox[i][j] = ' ';

        printTicTacToeBox(ticTacToeBox);
        boolean isContinue = true;
        boolean isTurnX = true;
        if (inputs.length < 2) {
            System.out.println("Bad parameters!");
        } else if (inputs[0].equals("start")) {
            do {
                if (inputs[1].equals("easy") && inputs[2].equals("easy")) {
                    if (isTurnX) {
                        isTurnX = false;
                        turnComputerPlayer(ticTacToeBox);
                        System.out.println("Making move level \"easy\"");
                    } else if (!isTurnX) {
                        isTurnX = true;
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nMaking move level \"easy\"");
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("easy") && inputs[2].equals("user")) {
                    if (isTurnX) {
                        isTurnX = false;
                        printTicTacToeBox(ticTacToeBox);
                        System.out.println("Making move level \"easy\"");
                    } else if (!isTurnX) {
                        isTurnX = true;
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nEnter the coordinates:");
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("user") && inputs[2].equals("user")) {
                    if (isTurnX) {
                        isTurnX = false;
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        printTicTacToeBox(ticTacToeBox);
                        System.out.print("\nEnter the coordinates:");
                    } else if (!isTurnX) {
                        isTurnX = true;
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        printTicTacToeBox(ticTacToeBox);
                        System.out.print("\nEnter the coordinates:");
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("user") && inputs[2].equals("easy")) {
                    if (!isTurnX) {
                        isTurnX = true;
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nEnter the coordinates:");
                    } else if (isTurnX) {
                        isTurnX = false;
                        printTicTacToeBox(ticTacToeBox);
                        System.out.println("Making move level \"easy\"");
                    }
                    isContinue = checkWins(ticTacToeBox);
                }

                //medium stage
                else if (inputs[1].equals("user") && inputs[2].equals("medium")) {
                    if (isTurnX) {
                        isTurnX = false;
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            printTicTacToeBox(ticTacToeBox);
                            System.out.println("Making move level \"medium\"");
                        }
                    } else if (!isTurnX) {
                        isTurnX = true;
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nEnter the coordinates:");
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("medium") && inputs[2].equals("user")) {
                    if (isTurnX) {
                        isTurnX = true;
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nEnter the coordinates:");
                    } else if (!isTurnX) {
                        isTurnX = false;
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            printTicTacToeBox(ticTacToeBox);
                            System.out.println("Making move level \"medium\"");
                        }
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("medium") && inputs[2].equals("medium")) {
                    if (isTurnX) {
                        isTurnX = true;
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            printTicTacToeBox(ticTacToeBox);
                            System.out.println("Making move level \"medium\"");
                        }
                    } else if (!isTurnX) {
                        isTurnX = false;
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            printTicTacToeBox(ticTacToeBox);
                            System.out.println("Making move level \"medium\"");
                        }
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("medium") && inputs[2].equals("easy")) {
                    if (isTurnX) {
                        isTurnX = true;
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            printTicTacToeBox(ticTacToeBox);
                            System.out.println("Making move level \"medium\"");
                        }
                    } else if (!isTurnX) {
                        isTurnX = false;
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nMaking move level \"easy\"");
                    }
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("easy") && inputs[2].equals("medium")) {
                    if (isTurnX) {
                        isTurnX = true;
                        turnComputerPlayer(ticTacToeBox);
                        System.out.print("\nMaking move level \"easy\"");
                    } else if (!isTurnX) {
                        isTurnX = false;
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            printTicTacToeBox(ticTacToeBox);
                            System.out.println("Making move level \"medium\"");
                        }
                    }
                    isContinue = checkWins(ticTacToeBox);
                }

                //hard stage
                else if (inputs[1].equals("hard") && inputs[2].equals("user")) {
                    if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    } else if (!isTurnX) {
                        System.out.print("\nEnter the coordinates:");
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        isTurnX = true;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("user") && inputs[2].equals("hard")) {
                    if (!isTurnX) {
                        System.out.print("\nEnter the coordinates:");
                        String input = scanner.nextLine();
                        boolean isManual = checkTicTacToeBox(ticTacToeBox, input, isTurnX);
                        isTurnX = true;
                    } else if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("hard") && inputs[2].equals("medium")) {
                    if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    } else if (!isTurnX) {
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            System.out.println("Making move level \"medium\"");
                        }
                        isTurnX = true;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("medium") && inputs[2].equals("hard")) {
                    if (!isTurnX) {
                        if (!playComputerMediumLevel(ticTacToeBox, isTurnX)) {
                            System.out.println("Making move level \"medium\"");
                        }
                        isTurnX = true;
                    } else if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("hard") && inputs[2].equals("easy")) {
                    if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    } else if (!isTurnX) {
                        turnComputerPlayer(ticTacToeBox);
                        System.out.println("Making move level \"easy\"");
                        isTurnX = true;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("easy") && inputs[2].equals("hard")) {
                    if (!isTurnX) {
                        turnComputerPlayer(ticTacToeBox);
                        System.out.println("Making move level \"easy\"");
                        isTurnX = true;
                    } else if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                } else if (inputs[1].equals("hard") && inputs[2].equals("hard")) {
                    if (!isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = true;
                    } else if (isTurnX) {
                        playComputerHardLevel(ticTacToeBox, isTurnX);
                        System.out.println("Making move level \"hard\"");
                        isTurnX = false;
                    }
                    printTicTacToeBox(ticTacToeBox);
                    isContinue = checkWins(ticTacToeBox);
                }

            } while (isContinue);
        }
    }

    public static void printTicTacToeBox(char[][] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append("---------\n");
        for (int i = 0; i < 3; i++){
            builder.append("| ");
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == '_') {
                    builder.append("  ");
                } else {
                    builder.append(arr[i][j] + " ");
                }
            }
            builder.append("|\n");
        }
        builder.append("---------");
        System.out.println(builder.toString());
    }

    public static boolean playComputerMediumLevel(char[][] arr, boolean isTurnX) {
        int len = arr.length - 1;
        boolean isMediumPlayed = true;
        if (isTurnX) {
            if (arr[len / 2][len / 2] == 'X' && arr[len / 2][len / 2 - 1] == 'X') { //left
                arr[len / 2][len / 2 + 1] = 'X';
            } else if (arr[len / 2][len / 2] == 'X' && arr[len / 2][len / 2 + 1] == 'X') { //right
                arr[len / 2][len / 2 - 1] = 'X';
            } else if (arr[len / 2][len / 2] == 'X' && arr[len / 2 - 1][len / 2] == 'X') { //up
                arr[len / 2 + 1][len / 2] = 'X';
            } else if (arr[len / 2][len / 2] == 'X' && arr[len / 2 + 1][len / 2] == 'X') { //down
                arr[len / 2 - 1][len / 2] = 'X';
            } else if (arr[len / 2][len / 2] == 'X' && arr[len / 2 - 1][len / 2 - 1] == 'X') { //left-up
                arr[len / 2 + 1][len / 2 + 1] = 'X';
            } else if (arr[len / 2][len / 2] == 'X' && arr[len / 2 + 1][len / 2 + 1] == 'X') { //left-down
                arr[len / 2 - 1][len / 2 - 1] = 'X';
            } else if (arr[len / 2][len / 2] == 'X' && arr[len / 2 - 1][len / 2 + 1] == 'X') { //right-up
                arr[len / 2 + 1][len / 2 - 1] = 'X';
            } else if (arr[len/ 2][len / 2] == 'X' && arr[len / 2 + 1][len / 2 - 1] == 'X') { //right-down
                arr[len / 2 - 1][len / 2 + 1] = 'X';
            } else {
                isMediumPlayed = false;
                return isMediumPlayed;
            }
        } else {
            if (arr[len / 2][len / 2] == 'O' && arr[len / 2][len / 2 - 1] == 'O') { //left
                arr[len / 2][len / 2 + 1] = 'O';
            } else if (arr[len / 2][len / 2] == 'O' && arr[len / 2][len / 2 + 1] == 'O') { //right
                arr[len / 2][len / 2 - 1] = 'O';
            } else if (arr[len / 2][len / 2] == 'O' && arr[len / 2 - 1][len / 2] == 'O') { //up
                arr[len / 2 + 1][len / 2] = 'O';
            } else if (arr[len / 2][len / 2] == 'O' && arr[len / 2 + 1][len / 2] == 'O') { //down
                arr[len / 2 - 1][len / 2] = 'O';
            } else if (arr[len / 2][len / 2] == 'O' && arr[len / 2 - 1][len / 2 - 1] == 'O') { //left-up
                arr[len / 2 + 1][len / 2 + 1] = 'O';
            } else if (arr[len / 2][len / 2] == 'O' && arr[len / 2 + 1][len / 2 + 1] == 'O') { //left-down
                arr[len / 2 - 1][len / 2 - 1] = 'O';
            } else if (arr[len / 2][len / 2] == 'O' && arr[len / 2 - 1][len / 2 + 1] == 'O') { //right-up
                arr[len / 2 + 1][len / 2 - 1] = 'O';
            } else if (arr[len/ 2][len / 2] == 'O' && arr[len / 2 + 1][len / 2 - 1] == 'O') { //right-down
                arr[len / 2 - 1][len / 2 + 1] = 'O';
            } else {
                isMediumPlayed = false;
                return isMediumPlayed;
            }
        }
        return isMediumPlayed;
    }

    public static void turnComputerPlayer(char[][] arr) {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);

        while (true) {
            if (arr[x][y] != ' ') {
                x = random.nextInt(3);
                y = random.nextInt(3);
            } else {
                break;
            }
        }
        arr[x][y] = 'O';
    }

    public static void playComputerHardLevel(char[][] arr, boolean isTurnX) {
        int bestScore = (int) Double.NEGATIVE_INFINITY;
        int posX = 0;
        int posY = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == ' ') {
                    if (isTurnX) {
                        arr[i][j] = 'X';
                    } else {
                        arr[i][j] = 'O';
                    }
                    int score = minimax(arr, 0, false, isTurnX);
                    if (score > bestScore) {
                        bestScore = Math.max(score, bestScore);
                        posX = i;
                        posY = j;
                    }
                    arr[i][j] = ' ';
                }
            }
        }
        if (isTurnX) {
            arr[posX][posY] = 'X';
        } else {
            arr[posX][posY] = 'O';
        }
    }

    public static int minimax(char[][] arr, int depth, boolean isMaximizing, boolean isTurnX) {
        if (checkWins(arr)) {
            return score;
        }

        if (isMaximizing) {
            int bestScore = (int) Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == ' ') {
                        if (isTurnX) {
                            arr[i][j] = 'X';
                        } else {
                            arr[i][j] = 'O';
                        }
                        int score = minimax(arr, depth + 1, false, !isTurnX);
                        bestScore = Math.max(score, bestScore);
                        arr[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = (int) Double.POSITIVE_INFINITY;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == ' ') {
                        if (isTurnX) {
                            arr[i][j] = 'X';
                        } else {
                            arr[i][j] = 'O';
                        }
                        int score = minimax(arr, depth + 1, true, !isTurnX);
                        bestScore = Math.min(score, bestScore);
                        arr[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        }
    }

    public static boolean checkTurn(String input) {
        int count = 0;
        boolean isTurnX = true;
        int[] chances = new int[2];
        while (count < 9) {
            if (input.charAt(count) == 'X') {
                chances[0]++; //X turn
            } else if (input.charAt(count) == 'O') {
                chances[1]++; //O turn
            }
            count++;
        }

        if (chances[0] > chances[1]) {
            isTurnX = false;
        }
        return isTurnX;
    }

    public static boolean checkTicTacToeBox(char[][] arr, String input, boolean isTurnX) {
        String[] arrOfStr = input.split(" ");
        int firstCoordinate;
        int secondCoordinate;
        try {
            firstCoordinate = Integer.parseInt(arrOfStr[0]);
            secondCoordinate = Integer.parseInt(arrOfStr[1]);
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        if (firstCoordinate > 0
                && firstCoordinate < 4
                && secondCoordinate > 0
                && secondCoordinate < 4){
            if (arr[3 - secondCoordinate][firstCoordinate - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }
            if (isTurnX) {
                arr[3 - secondCoordinate][firstCoordinate - 1] = 'X';
            } else if (!isTurnX) {
                arr[3 - secondCoordinate][firstCoordinate - 1] = 'O';
            }
            return true;
        } else if (firstCoordinate > 3 || secondCoordinate > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else {
            System.out.println("You should enter numbers!");
        }
        return false;
    }

    public static boolean checkWins(char[][] arr) {
        boolean isContinue = true;
        if ((arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X')
                || (arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X')
                || (arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X')

                || (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X')
                || (arr[0][1] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X')
                || (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X')

                || (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X')
                || (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X')) {
            System.out.println("X wins");
            score = 1;
            isContinue = false;
        } else if ((arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X')
                || (arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O')
                || (arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O')

                || (arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O')
                || (arr[0][1] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O')
                || (arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O')

                || (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O')
                || (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O')) {
            System.out.println("O wins");
            score = -1;
            isContinue = false;
        } else {
            boolean isGameOn = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == '_') {
                        isGameOn = false;
                        break;
                    }
                }
            }
            if (!isGameOn) {
                //do nothing
            } else {
                System.out.println("Draw");
                score = 0;
                isContinue = false;
            }
        }
        return isContinue;
    }
}
