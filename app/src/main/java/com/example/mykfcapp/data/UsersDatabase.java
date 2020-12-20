package com.example.mykfcapp.data;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mykfcapp.models.ModelUser;


@Database(entities = {ModelUser.class}, version = 1, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase
{
    private static final String DB_NAME = "users.db";
    private static UsersDatabase database;
    private static final Object LOCK = new Object();

    public static UsersDatabase getInstance(Context context)
    {
        synchronized (LOCK)
        {
            if (database == null)
            {
                database = Room.databaseBuilder(context, UsersDatabase.class, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration().build();
            }
        }
        return database;
    }

    public abstract UserDao userDao();
//    public boolean isUserInDatabase(String email, String password)
//    {
//        boolean isUserInDatabase = false;
//        ModelUser foundUserByEmail = database.userDao().getByUserEmail(email);
//        Log.e("foundUserByEmail", "" + foundUserByEmail);
//        ModelUser foundUserByPassword = database.userDao().getByPassWord(password);
//        Log.e("foundUserByPassword", "" + foundUserByPassword);
//        if (foundUserByEmail != null)
//        {
//            isUserInDatabase = foundUserByEmail.equals(foundUserByPassword);
//
//        }
//
//        Log.e("XXXXXX", "" + isUserInDatabase);
//        return false;
//    }
}
