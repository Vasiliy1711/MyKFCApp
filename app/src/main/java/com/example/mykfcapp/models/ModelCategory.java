package com.example.mykfcapp.models;

import com.example.mykfcapp.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModelCategory implements Serializable
{
    private int imgId;
    private int catName;
    private int catDescription;
    private int catDate;
    private int fileQuantity;

    public ModelCategory(int imgId, int catName, int catDescription, int catDate, int fileQuantity)
    {
        this.imgId = imgId;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catDate = catDate;
        this.fileQuantity = fileQuantity;
    }

    public int getImgId()
    {
        return imgId;
    }

    public void setImgId(int imgId)
    {
        this.imgId = imgId;
    }

    public int getCatName()
    {
        return catName;
    }

    public void setCatName(int catName)
    {
        this.catName = catName;
    }

    public int getCatDescription()
    {
        return catDescription;
    }

    public void setCatDescription(int catDescription)
    {
        this.catDescription = catDescription;
    }

    public int getCatDate()
    {
        return catDate;
    }

    public void setCatDate(int catDate)
    {
        this.catDate = catDate;
    }

    public int getFileQuantity()
    {
        return fileQuantity;
    }

    public void setFileQuantity(int fileQuantity)
    {
        this.fileQuantity = fileQuantity;
    }

    public static ArrayList<ModelCategory> getData()
    {
        ArrayList<ModelCategory> categories = new ArrayList<>();
        ModelCategory category1 = new ModelCategory(R.drawable.kfc3, R.string.item_name, R.string.description, R.string.date1, R.string.quantity1);
        ModelCategory category2 = new ModelCategory(R.drawable.kfc7, R.string.item_name2, R.string.description, R.string.date2, R.string.quantity2);
        ModelCategory category3 = new ModelCategory(R.drawable.kfc8, R.string.item_name3, R.string.description, R.string.date3, R.string.quantity3);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        return categories;
    }
}
