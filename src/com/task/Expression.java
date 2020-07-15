package com.task;

public class Expression {

    protected static final int ADDITION = 1;
    protected static final int SUBTRACTION = 2;
    protected static final int MULTIPLICATION = 3;
    protected static final int DIVISION = 4;

    Number n1;
    Number n2;
    int operation_type;

    public Expression(String str)
    {
        String num1 = "";
        String num2 = "";

        str = str.replaceAll(" ", "");
        if(str.contains("+"))
        {
            operation_type = ADDITION;
            str = str.replace("+", "$");
        }
        else
        {
            if(str.contains("-"))
            {
                operation_type = SUBTRACTION;
                str = str.replace("-", "$");
            }
            else
            {
                if(str.contains("*"))
                {
                    operation_type = MULTIPLICATION;
                    str = str.replace("*", "$");
                }
                else
                {
                    if(str.contains("/"))
                    {
                        operation_type = DIVISION;
                        str = str.replace("/", "$");
                    }
                    else
                    {
                        System.out.println("   _____________________________"
                                + "\n   |                             |"
                                + "\n   |    No suitable operation!   |"
                                + "\n   |_____________________________|");
                        throw new NumberFormatException();
                    }
                }
            }
        }

        char[] sequence = str.toCharArray();
        int i = 0;
        while (sequence[i]!='$')
        {
            num1 += sequence[i];
            i++;
        }
        i++;
        while (i < sequence.length)
        {
            num2 += sequence[i];
            i++;
        }
        n1 = new Number(num1);
        n2 = new Number(num2);
    }
    public void calculate()
    {
        (Number.operation(n1, n2, operation_type)).show();
    }

}
