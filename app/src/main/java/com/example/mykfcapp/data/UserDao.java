package com.example.mykfcapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mykfcapp.models.ModelUser;

import java.util.List;

@Dao
public interface UserDao
{
    @Query("SELECT * FROM users")
    List<ModelUser> getAllUsers();

    @Query("SELECT * FROM users WHERE id == :userId")
    ModelUser geUserById(int userId);


    @Query("DELETE FROM users")
    void deleteAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(ModelUser user);

    @Delete
    void deleteUser(ModelUser user);

    @Query("SELECT * FROM users WHERE userEmail == :userEmail AND password == :password")
    ModelUser getUserByEmail(String userEmail, String password);
}
