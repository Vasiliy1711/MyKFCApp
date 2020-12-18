package com.example.mykfcapp.models;

import com.example.mykfcapp.R;

public class ModelUser
{
    private int userImg;
    private String userName;
    private String userEmail;


    public ModelUser(int userImg, String userName, String userEmail)
    {
        this.userImg = userImg;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public int getUserImg()
    {
        return userImg;
    }

    public void setUserImg(int userImg)
    {
        this.userImg = userImg;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public static ModelUser getData()
    {
        ModelUser user = new ModelUser(R.drawable.user,
                "Ляшенко Василий", "vas2011@ya.ru");
        return user;
    }

}
