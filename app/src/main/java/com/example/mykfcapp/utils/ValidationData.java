package com.example.mykfcapp.utils;

import com.example.mykfcapp.models.ModelUser;

import java.util.ArrayList;

public class ValidationData
{
    public boolean is_valid = true;
    ArrayList<String> errors = new ArrayList<>();

    public void validateNonNullString(String str, String fieldName, Integer minChars)
    {
        if (str == null || str.isEmpty())
        {
            is_valid = false;
            errors.add("Пожалуйста, заполните поле \"" + fieldName + "\"");
        }
        else if (minChars != null && str.length() < minChars)
        {
            is_valid = false;
            errors.add("Поле  \"" + fieldName + "\" должно содержать минимум " + minChars + " символов");
        }
    }

    public void validateEmail(String email)
    {
        if (email == null || email.isEmpty())
        {
            is_valid = false;
            errors.add("Пожалуйста, заполните поле \"Email\"");
        }
        else if (!ValidationManager.isEmail(email))
        {
            is_valid = false;
            errors.add("Введите корректный email");
        }
    }

    public void validatePassword(String password1, String password2)
    {
        if (password1 == null || password1.isEmpty())
        {
            is_valid = false;
            errors.add("Пожалуйста, заполните поле \"Пароль\"");
        }
        else if (password1 != null && password1.length() < 8)
        {
            is_valid = false;
            errors.add("Поле пароль должно содержать минимум 8 символов");
        }
        else if (password2 == null || password2.isEmpty())
        {
            is_valid = false;
            errors.add("Пожалуйста, заполните поле \"Повторите пароль\"");
        }
        else if (!password1.equals(password2))
        {
            is_valid = false;
            errors.add("Пароли не совпадают. Пожалуйста, повторите пароль");
        }
    }

    public void validateToEnter(String email, String password, ModelUser foundUser)
    {
        if (email == null || email.isEmpty())
        {
            is_valid = false;
            errors.add("Пожалуйста,\nзаполните поле \"Email\"");
        }
        else if (!ValidationManager.isEmail(email))
        {
            is_valid = false;
            errors.add("Введите корректный email");
        }
        else if (password == null || password.isEmpty())
        {
            is_valid = false;
            errors.add("Пожалуйста,\nзаполните поле \"Пароль\"");
        }
        else if (password != null && password.length() < 8)
        {
            is_valid = false;
            errors.add("Поле пароль должно\nсодержать минимум 8 символов");
        }
        else if (foundUser == null)
        {
            is_valid = false;
            errors.add("Неверный email или пароль");
        }
    }

    public String getErrorMessage()
    {
        String message = String.join("\n", errors);
        return message;
    }
}
