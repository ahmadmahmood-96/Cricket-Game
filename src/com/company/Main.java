package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                ------------------------------------------
                \tWelcome to our cricket game\t
                ------------------------------------------""");
        Instructions();
        toss();
        while (true) {
            System.out.print("\nDo you want to play again? If yes then enter 'y' otherwise the program will exit: ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                Instructions();
                toss();
            } else
                System.exit(0);
        }
    }
    private static void Instructions(){
        System.out.println();
        System.out.println("""
                This is a cricket game.
                 1) First the toss will occur then you will be given option to first ball or bat.
                 2) If you choose wrong option during the toss you will loss the toss.
                 3) If you choose batting first, you will be able to score by pressing
                    0, 1, 2, 3, 4, 5 and 6. and computer will also generate numbers except 0
                    to make you out.
                 4) And if you choose bowling first then you will have to enter numbers 1, 2, 3, 4,
                    5 and 6 to out the computer.
                """);
    }
    private static void toss() {
        Scanner input = new Scanner(System.in);
        char data = 'y';
        try {
            while (data == 'y'){
                data = 'a';
                System.out.print("\nChoose 1 for heads and 2 for tails: ");
                int user_choice = input.nextInt();
                int toss = (int) (1 + (Math.random() * 2));
                if (user_choice == toss && toss == 1) {
                    System.out.print("""
                            It is heads!
                            Congratulations you won the toss!
                            What do you want to do first?
                            Press 1 for batting and 2 for bowling:\s""");
                    int choice = input.nextInt();
                    if (choice == 1) {
                        User_Batting();
                    } else if (choice == 2) {
                        User_Bowling();
                    } else
                        System.out.println("Please enter from the given choices");
                } else if (user_choice == toss && toss == 2) {
                    System.out.print("""
                            It is tails!
                            Congratulations you won the toss!
                            What do you want to do first?
                            Press 1 for batting and 2 for bowling:\s""");
                    int choice = input.nextInt();
                    if (choice == 1) {
                        User_Batting();
                    } else if (choice == 2) {
                        User_Bowling();
                    } else
                        System.out.println("Please enter from the given choices");
                } else if (user_choice != toss && toss == 1) {
                    System.out.println("""
                            It is heads!
                            Oh! You lost the toss
                            Computer is batting first!\s""");
                        User_Bowling();
                } else if (user_choice != toss && toss == 2) {
                    System.out.println("""
                            It is tails!
                            Oh! You lost the toss
                            Computer is bowling first!\s""");
                        User_Batting();
                }
            }
        } catch (Exception ex) {
            System.out.println("Please enter an integer");
            input.nextLine();
        }
    }

    private static void User_Batting() {
        Scanner input = new Scanner(System.in);
        int user_run;
        int comp_run;
        int user_balls = 0;
        int user_total = 0;
        int comp_balls = 0;
        int comp_total = 0;
        while (true) {
            comp_run = (int) (1 + (Math.random() * 6));
            System.out.print("Your score on this ball: ");
            user_run = input.nextInt();
            if ((user_run != comp_run) && (user_run == 0 || user_run == 2 || user_run == 3 || user_run == 4 || user_run == 5 || user_run == 6)) {
                user_total += user_run;
                user_balls++;
                System.out.println("You scored " + user_run + " runs. Your total score up till now is: " + user_total + " runs");
            } else if ((user_run == 1) && (user_run != comp_run)) {
                user_total += user_run;
                user_balls++;
                System.out.println("You scored " + user_run + " runs. Your total score up till now is: " + user_total + " runs");
            } else if (user_run == comp_run) {
                System.out.println("You got out!");
                user_balls++;
                System.out.println("Your total score is: " + user_total + " runs");
                break;
            } else
                System.out.println("Please enter score in integers!");
        }

        System.out.println("The target for computer to beat is " + (user_total + 1));

        try {
            while (comp_total < user_total) {
                comp_run = (int) (Math.random() * 7);
                System.out.print("Your score on this ball: ");
                user_run = input.nextInt();
                if ((comp_run != user_run) && (comp_run == 0 || comp_run == 2 || comp_run == 3 || comp_run == 4 || comp_run == 5 || comp_run == 6)
                    && (user_run == 0 || user_run == 1|| user_run == 2 || user_run == 3 || user_run == 4 || user_run == 5 || user_run == 6)) {
                    comp_balls++;
                    System.out.println("Computer scored " + comp_run + " runs");
                    comp_total += comp_run;
                } else if ((comp_run == 1) && (comp_run != user_run)) {
                    comp_balls++;
                    System.out.println("Computer scored " + comp_run + " run");
                    comp_total += comp_run;
                } else if ((comp_run == user_run) && (comp_balls > 0)) {
                    comp_balls++;
                    System.out.println("Computer got out!");
                    System.out.println("Computer total score is: " + comp_total + " runs");
                    break;
                } else if (comp_run > user_run) {
                    System.out.println("\nThe computer won. Computer scored " + comp_total + " in "
                            + (comp_balls / 6) + "." + (comp_balls % 6) + " overs and you scored "
                            + user_total + "in " + (user_balls / 6) + "." + (user_balls % 6) + " overs");
                    break;
                } else
                    System.out.println("Please enter score in integers and from given choices!");
            }
            if (comp_total < user_total) {
                System.out.println("\nCongratulations!! You won. You scored " + user_total + " in "
                        + (user_balls / 6) + "." + (user_balls % 6) + " overs and computer scored "
                        + comp_total + " in " + (comp_balls / 6) + "." + (comp_balls % 6) + " overs");
            }
            else if (comp_total == user_total) {
                System.out.println("\nOh! The match is tied. Computer scored " + comp_total + " in "
                        + (comp_balls / 6) + "." + (comp_balls % 6) + " overs and you scored "
                        + user_total + " in " + (user_balls / 6) + "." + (user_balls % 6) + " overs");
            }
            else if (comp_total > user_total) {
                System.out.println("\nThe computer won. Computer scored " + comp_total + " in "
                        + (comp_balls / 6) + "." + (comp_balls % 6) + " overs and you scored "
                        + user_total + " in " + (user_balls / 6) + "." + (user_balls % 6) + " overs");
            }
        } catch (Exception ex) {
            System.out.println("Please enter an integer");
            input.nextLine();
        }
    }

    private static void User_Bowling() {
        Scanner input = new Scanner(System.in);
        int user_run;
        int comp_run;
        int user_balls = 0;
        int user_total = 0;
        int comp_balls = 0;
        int comp_total = 0;
        try {
            while (true) {
                comp_run = (int) (Math.random() * 7);
                System.out.print("Your score on this ball: ");
                user_run = input.nextInt();
                if ((comp_run != user_run) && (comp_run == 0 || comp_run == 2 || comp_run == 3 || comp_run == 4 || comp_run == 5 || comp_run == 6)
                        && (user_run == 0 || user_run == 1|| user_run == 2 || user_run == 3 || user_run == 4 || user_run == 5 || user_run == 6)) {
                    comp_balls++;
                    System.out.println("Computer scored " + comp_run + " runs");
                    comp_total += comp_run;
                } else if ((comp_run == 1) && (comp_run != user_run)) {
                    comp_balls++;
                    System.out.println("Computer scored " + comp_run + " run");
                    comp_total += comp_run;
                } else if (comp_run == user_run) {
                    comp_balls++;
                    System.out.println("Computer got out!");
                    System.out.println("Computer total score is: " + comp_total + " runs");
                    break;
                } else
                    System.out.println("Please enter score in integers and from given choices!");
            }
        } catch (Exception ex) {
            System.out.println("Please enter an integer");
            input.nextLine();
        }

        System.out.println("\nThe target for you to beat is " + (comp_total + 1) + " runs");

        try {
            while (user_total < comp_total) {
                comp_run = (int) (1 + (Math.random() * 6));
                System.out.print("Your score on this ball: ");
                user_run = input.nextInt();
                if ((user_run != comp_run) && (user_run == 0 || user_run == 2 || user_run == 3 || user_run == 4 || user_run == 5 || user_run == 6)) {
                    user_balls++;
                    user_total += user_run;
                    System.out.println("You scored " + user_run + " runs. Your total score up till now is: " + user_total + " runs");
                } else if ((user_run == 1) && (user_run != comp_run)) {
                    user_balls++;
                    user_total += user_run;
                    System.out.println("You scored " + user_run + " runs. Your total score up till now is: " + user_total + " runs");
                } else if ((user_run == comp_run) && (user_balls > 0)) {
                    user_balls++;
                    System.out.println("You got out!");
                    System.out.println("Your total score is: " + user_total + " runs");
                    break;
                } else if (user_total > comp_total) {
                    System.out.println("\nCongratulations!! You won. You scored " + user_total + " in "
                            + (user_balls / 6) + "." + (user_balls % 6) + " overs and computer scored "
                            + comp_total + " in " + (comp_balls / 6) + "." + (comp_balls % 6) + " overs");
                    break;
                } else
                    System.out.println("Please enter score in integers!");
            }
            if (comp_total > user_total) {
                System.out.println("\nThe computer won. Computer scored " + comp_total + " in "
                        + (comp_balls / 6) + "." + (comp_balls % 6) + " overs and you scored "
                        + user_total + " in " + (user_balls / 6) + "." + (user_balls % 6) + " overs");
            }
            else if (user_total > comp_total) {
                System.out.println("\nCongratulations!! You won. You scored " + user_total + " in "
                        + (user_balls / 6) + "." + (user_balls % 6) + " overs and computer scored "
                        + comp_total + " in " + (comp_balls / 6) + "." + (comp_balls % 6) + " overs");
            }
            else if (user_total == comp_total) {
                System.out.println("\nOh! The match is tied. You scored " + user_total + " in "
                        + (user_balls / 6) + "." + (user_balls % 6) + " overs and computer scored "
                        + comp_total + " in " + (comp_balls / 6) + "." + (comp_balls % 6) + " overs");
            }
        }
        catch (Exception ex) {
            System.out.println("Please enter an integer");
            input.nextLine();
        }
    }
}

