package com.example.mykfcapp.models;

import com.example.mykfcapp.R;

import java.util.ArrayList;
import java.util.List;

public class ModelDocument
{
    private int docImg;
    private int docName;
    private int docDescription;
    private int docDate;

    public ModelDocument(int docImg, int docName, int docDescription, int docDate)
    {
        this.docImg = docImg;
        this.docName = docName;
        this.docDescription = docDescription;
        this.docDate = docDate;
    }

    public int getDocImg()
    {
        return docImg;
    }

    public void setDocImg(int docImg)
    {
        this.docImg = docImg;
    }

    public int getDocName()
    {
        return docName;
    }

    public void setDocName(int docName)
    {
        this.docName = docName;
    }

    public int getDocDescription()
    {
        return docDescription;
    }

    public void setDocDescription(int docDescription)
    {
        this.docDescription = docDescription;
    }

    public int getDocDate()
    {
        return docDate;
    }

    public void setDocDate(int docDate)
    {
        this.docDate = docDate;
    }

    public static ArrayList<ModelDocument> getData()
    {
        ArrayList<ModelDocument> documents = new ArrayList<>();
        ModelDocument document1 = new ModelDocument(R.drawable.kfc6, R.string.strips, R.string.doc_description, R.string.date2);
        ModelDocument document2 = new ModelDocument(R.drawable.basket24, R.string.basket24, R.string.doc_description, R.string.date1);
        ModelDocument document3 = new ModelDocument(R.drawable.basket_duet, R.string.basket_duet, R.string.doc_description, R.string.date2);
        ModelDocument document4 = new ModelDocument(R.drawable.party_basket, R.string.party_basket, R.string.doc_description, R.string.date1);
        ModelDocument document5 = new ModelDocument(R.drawable.sanders_basket, R.string.sanders_basket, R.string.doc_description, R.string.date3);
        documents.add(document1);
        documents.add(document2);
        documents.add(document3);
        documents.add(document4);
        documents.add(document5);
        return documents;
    }
}
