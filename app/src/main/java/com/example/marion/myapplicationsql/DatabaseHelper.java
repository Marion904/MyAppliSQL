package com.example.marion.myapplicationsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marion on 12/07/17.
 */

public class DatabaseHelper {

    /**
     * To prevent any accidental instantiation of the class, the constructor is private
     */

    private DatabaseHelper(){}


    public static class TweetsDbHelper extends SQLiteOpenHelper {

        public static long userCreation(Context context, SQLiteDatabase dbUser, String name, String email){
            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesUser = new ContentValues();
            valuesUser.put(DatabaseContract.UserEntry.COLUMN_NAME_NAME, name);
            valuesUser.put(DatabaseContract.UserEntry.COLUMN_NAME_EMAIL, email);
            return dbUser.insert(DatabaseContract.UserEntry.TABLE_NAME, null, valuesUser);
        }

        public static long organizationCreation(Context context, SQLiteDatabase db, String name, String webSite){

            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesOrga = new ContentValues();
            valuesOrga.put(DatabaseContract.OrganizationEntry.COLUMN_NAME_NAME, name);
            valuesOrga.put(DatabaseContract.OrganizationEntry.COLUMN_NAME_WEBSITE, webSite);
            return db.insert(DatabaseContract.OrganizationEntry.TABLE_NAME, null, valuesOrga);
        }

        public static long belongingCreation(Context context, SQLiteDatabase dbBelongs, long userId, long orgaId){
            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesBelongs = new ContentValues();
            valuesBelongs.put(DatabaseContract.BelongsEntry.COLUMN_NAME_USER_ID, userId);
            valuesBelongs.put(DatabaseContract.BelongsEntry.COLUMN_NAME_ORGA_ID, orgaId);
            return dbBelongs.insert(DatabaseContract.BelongsEntry.TABLE_NAME, null, valuesBelongs);
        }

        public static long tweetCreation(Context context, SQLiteDatabase dbTweet, long userId, String content){
            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesTweet = new ContentValues();
            valuesTweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID, userId);
            valuesTweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT, content);
            return dbTweet.insert(DatabaseContract.TweetEntry.TABLE_NAME, null, valuesTweet);
        }

        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 3;
        public static final String DATABASE_NAME = "myDataBase.db";

        public TweetsDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DatabaseContract.SQL_CREATE_USERS_ENTRIES);
            db.execSQL(DatabaseContract.SQL_CREATE_ORGANIZATION_ENTRIES);
            db.execSQL(DatabaseContract.SQL_CREATE_BELONGS_ENTRIES);
            db.execSQL(DatabaseContract.SQL_CREATE_TWEET_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DatabaseContract.SQL_DELETE_USER_ENTRIES);
            db.execSQL(DatabaseContract.SQL_DELETE_ORGANIZATION_ENTRIES);
            db.execSQL(DatabaseContract.SQL_DELETE_BELONGS_ENTRIES);
            db.execSQL(DatabaseContract.SQL_DELETE_TWEET_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }

}
