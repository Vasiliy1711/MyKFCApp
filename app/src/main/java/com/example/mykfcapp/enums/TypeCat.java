package com.example.mykfcapp.enums;

public enum TypeCat
{
    Twisters, Drinks, Baskets;

    public static TypeCat initFromPos(int position)
    {
        switch (position)
        {
            case 0:
                return Twisters;
            case 1:
                return Drinks;
            case 2:
                return Baskets;
        }
        throw new RuntimeException("Error invalid position");
    }

    public int getCatPos()
    {
        switch (this)
        {
            case Twisters:
                return 0;
            case Drinks:
                return 1;
            case Baskets:
                return 2;
        }
        throw new RuntimeException("Error invalid TypeCat");
    }
}
