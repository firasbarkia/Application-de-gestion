package com.example.myapplication;

public class Constants {

    // database or db name
    public static final String DATABASE_NAME = "GESTION_DB2";
    //database version
    public static final int DATABASE_VERSION = 2;

    // table name 1
    public static final String TABLE_USER = "USER_TABLE";

    // table column or field name
    public static final String U_ID = "ID";
    public static final String U_NAME = "NAME";
    public static final String U_EMAIL = "EMAIL";
    public static final String U_PASSWORD = "PASSWORD";

    // query for create table
    public static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "( "
            + U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + U_NAME + " TEXT, "
            + U_EMAIL + " TEXT, "
            + U_PASSWORD + " TEXT"
            + " );";
    // table name 2
    public static final String TABLE_PRODUIT = "PRODUCT_TABLE";

    // table column or filed name

    public static final String P_ID = "ID";
    public static final String P_name = "NAME";
    public static final String P_DESC = "DESC";
    public static final String P_PRICE = "PRICE";

    //query for create table

    public static final String CREATE_TABLE_PRODUCT = "CREATE TABLE " + TABLE_PRODUIT + "("
            + P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + P_name + " TEXT, "
            + P_DESC + " TEXT, "
            + P_PRICE + " TEXT "
            + ");";
    //table 3
    public static final String TABLE_CREDIT = "CREDIT_TABLE";
    // table column or filed name
    public static final String PR_ID = "P_ID";
    public static final String UE_ID = "U_ID";
    public static final String QTE = "QTE";
    public static final String RESTE_PAYER = "RESTE";
    public static final String NB_TRANCHE = "NB";

    public static final String CREATE_TABLE_CREDIT = "CREATE TABLE " + TABLE_PRODUIT + "("
            + PR_ID + " INTEGER PRIMARY KEY , "
            + UE_ID + " INTEGER PRIMARY KEY , "
            + QTE + " TEXT, "
            + RESTE_PAYER + " INTEGER, "
            + NB_TRANCHE + " INTEGER ,"
            + "FOREIGN KEY "
            + "("+PR_ID+")"+
            "REFERENCES"+
            TABLE_PRODUIT +"("+P_ID+"),"
            +"FOREIGN KEY "
            +"("+UE_ID+")"
            +"REFERENCES"
            +TABLE_USER
            +"("+U_ID+")"
            +");";

}

