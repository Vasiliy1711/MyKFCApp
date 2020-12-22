package com.example.mykfcapp.utils;

import android.util.Patterns;

import com.example.mykfcapp.models.ModelUser;

import java.util.regex.Matcher;

public class ValidationManager
{
    public static boolean isEmail(String email)
    {
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(email);
        return matcher.matches();
    }

    public static ValidationData validateRegister(String userName, String userSurname, String email, String password1, String password2)
    {
        ValidationData data = new ValidationData();
        data.validateNonNullString(userName, "Имя", 2);
        data.validateNonNullString(userSurname, "Фамилия", 2);
        data.validateEmail(email);
        data.validatePassword(password1, password2);
        return data;
    }

    public static ValidationData validateRegister(String email, String password, ModelUser foundUser)
    {
        ValidationData data = new ValidationData();
        data.validateToEnter(email, password, foundUser);
        return data;
    }
}
