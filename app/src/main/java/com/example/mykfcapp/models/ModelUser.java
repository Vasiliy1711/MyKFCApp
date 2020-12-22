package com.example.mykfcapp.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "users")
public class ModelUser implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String userEmail;
    private String password;


    public ModelUser(int id, String userName, String userEmail, String password)
    {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    @Ignore
    public ModelUser(String userName, String userEmail, String password)
    {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

//    public static ModelUser getData()
//    {
//        ModelUser user = new ModelUser(R.drawable.user,
//                "Ляшенко", "Василий", "vas2011@ya.ru", "asdfghytf");
//        return user;
//    }

}
