package com.task;

public class Number {

    protected static final int ARABIC = 1;
    protected static final int ROMAN = 2;
    protected static final int ADDITION = 1;
    protected static final int SUBTRACTION = 2;
    protected static final int MULTIPLICATION = 3;
    protected static final int DIVISION = 4;

    int value;
    int type;

    public Number(String str)
    {
        try {
            this.value = Integer.parseInt(str);
            this.type = ARABIC;
        } catch (NumberFormatException e) {
            this.type = ROMAN;
            int value = 0;
            boolean allow_fifth = true;
            boolean allow_tens = true;
            boolean coorect = true;
            for (char symb: str.toCharArray()) {
                if(symb == 'X')
                {
                    if (allow_tens)
                    {
                        this.value += 10;
                    }
                    else
                    {
                        coorect = false;
                    }
                }
                else
                {
                    if (symb == 'V')
                    {
                        if(allow_fifth)
                        {
                            this.value += 5;
                            allow_tens = false;
                        }
                        else
                        {
                            coorect = false;
                        }
                    }
                    else
                    {
                        if(symb == 'I')
                        {
                            this.value++;
                            allow_fifth = false;
                            allow_tens = false;
                        }
                        else
                        {
                            coorect = false;
                        }
                    }
                }
            }
            if(!coorect)
            {
                System.out.println("   __________________"
                        + "\n   |                 |"
                        + "\n   |    BAD VALUE!   |"
                        + "\n   |_________________|");
                throw e;
            }
        }
        if(this.value > 10 || this.value < 0)
        {
            System.out.println("   __________________"
                    + "\n   |                 |"
                    + "\n   |    BAD VALUE!   |"
                    + "\n   |_________________|");
            throw new NumberFormatException();
        }
    }
    public Number(int number, int type)
    {
        this.value = number;
        this.type = type;
    }

    public static Number operation(Number a1, Number a2, int type)
    {
        if(a1.type == a2.type)
        {
            switch (type)
            {
                case (ADDITION):
                {
                    return new Number(a1.value + a2.value, a1.type);
                }
                case (SUBTRACTION):
                {
                    return new Number(a1.value - a2.value, a1.type);
                }
                case (MULTIPLICATION):
                {
                    return new Number(a1.value * a2.value, a1.type);
                }
                case (DIVISION):
                {
                    return new Number(a1.value / a2.value, a1.type);
                }
                default:
                    return null;
            }
        }
        else
        {
            System.out.println("   _________________________"
                    + "\n   |                         |"
                    + "\n   |    UNSUITABLE VALUES!   |"
                    + "\n   |_________________________|");
            throw new NumberFormatException();
        }
    }

    public void showArabic()
    {
        System.out.println(this.value);
    }

    public void showRoman()
    {
        System.out.println("");
        for(int i = 0; i < this.value/100; i++)
        {
            System.out.print("C");
        }
        for(int i = 0; i < (this.value%100)/50; i++)
        {
            System.out.print("L");
        }
        for(int i = 0; i < (this.value%50)/10; i++)
        {
            System.out.print("X");
        }
        for(int i = 0; i < (this.value%10)/5; i++)
        {
            System.out.print("V");
        }
        for(int i = 0; i < (this.value%5); i++)
        {
            System.out.print("I");
        }
    }

    public void show()
    {
        if (this.type == ARABIC)
        {
            showArabic();
        }
        else
        {
            showRoman();
        }
    }

}
