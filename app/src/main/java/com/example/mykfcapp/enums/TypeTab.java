package com.example.mykfcapp.enums;

public enum TypeTab
{
    Categories, Favourites, Search, Profile;

    public static TypeTab initFromPos(int position)
    {
        switch (position)
        {
            case 0:
            {
                return Categories;
            }
            case 1:
            {
                return Favourites;
            }
            case 2:
            {
                return Search;
            }
            case 3:
            {
                return Profile;
            }
        }
        throw new RuntimeException("Error invalid position");
    }

    public int getTabPos()
    {
        switch (this)
        {
            case Categories:
                return 0;
            case Favourites:
                return 1;
            case Search:
                return 2;
            case Profile:
                return 3;
        }
        throw new RuntimeException("Error invalid TypeTab");
    }
}
