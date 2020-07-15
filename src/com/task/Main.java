package com.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        boolean contin = true;
        Scanner in = new Scanner(System.in);
        while(contin)
        {
            System.out.println("\nEnter your expression: ");
            Expression expr = new Expression(in.nextLine());
            expr.calculate();
            System.out.println("\nWant to count one more expression?\n" +
                    "0 = No, else = Yes");
            if(in.nextLine().equals('0'))
            {
                contin = false;
            }
        }

    }
}
