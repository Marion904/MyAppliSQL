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


    public static class OrganizationDbHelper extends SQLiteOpenHelper {

        public static long organizationCreation(Context context, SQLiteDatabase dbOrganization, String name, String email){

            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesOrga = new ContentValues();
            valuesOrga.put(DatabaseContract.OrganizationEntry.COLUMN_NAME_NAME, name);
            valuesOrga.put(DatabaseContract.OrganizationEntry.COLUMN_NAME_WEBSITE, email);
            return dbOrganization.insert(DatabaseContract.OrganizationEntry.TABLE_NAME, null, valuesOrga);
        }


        private static final String SQL_CREATE_ORGANIZATION =
                "CREATE TABLE " + DatabaseContract.OrganizationEntry.TABLE_NAME + " (" +
                        DatabaseContract.OrganizationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DatabaseContract.OrganizationEntry.COLUMN_NAME_NAME + " VARCHAR(50) NOT NULL, " +
                        DatabaseContract.OrganizationEntry.COLUMN_NAME_WEBSITE + " VARCHAR(50) NOT NULL);";

        private static final String SQL_DELETE_ORGANIZATION =
                "DROP TABLE IF EXISTS " + DatabaseContract.OrganizationEntry.TABLE_NAME;

        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Organization.db";

        public OrganizationDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ORGANIZATION);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ORGANIZATION);
            onCreate(db);

        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }


    public static class UserDbHelper extends SQLiteOpenHelper {

        public static long userCreation(Context context, SQLiteDatabase dbUser, String name, String email){
            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesUser = new ContentValues();
            valuesUser.put(DatabaseContract.UserEntry.COLUMN_NAME_NAME, name);
            valuesUser.put(DatabaseContract.UserEntry.COLUMN_NAME_EMAIL, email);
            return dbUser.insert(DatabaseContract.UserEntry.TABLE_NAME, null, valuesUser);
        }

        private static final String SQL_CREATE_USER =
                "CREATE TABLE " + DatabaseContract.UserEntry.TABLE_NAME + " (" +
                        DatabaseContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DatabaseContract.UserEntry.COLUMN_NAME_NAME + " VARCHAR(50) NOT NULL, " +
                        DatabaseContract.UserEntry.COLUMN_NAME_EMAIL + " VARCHAR(50) NOT NULL);";

        private static final String SQL_DELETE_USER =
                "DROP TABLE IF EXISTS " + DatabaseContract.UserEntry.TABLE_NAME;

        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "User.db";

        public UserDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_USER);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_USER);
            onCreate(db);

        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }


    public static class BelongsDbHelper extends SQLiteOpenHelper {

        public static long belongingCreation(Context context, SQLiteDatabase dbBelongs, long userId, long orgaId){
            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesBelongs = new ContentValues();
            valuesBelongs.put(DatabaseContract.BelongsEntry.COLUMN_NAME_ORGA_ID, "orga");
            valuesBelongs.put(DatabaseContract.BelongsEntry.COLUMN_NAME_ORGA_ID, "www.myOrga.com");
            return dbBelongs.insert(DatabaseContract.BelongsEntry.TABLE_NAME, null, valuesBelongs);
        }

        private static final String SQL_CREATE_BELONGS =
                "CREATE TABLE " + DatabaseContract.BelongsEntry.TABLE_NAME + " (" +
                        DatabaseContract.BelongsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DatabaseContract.BelongsEntry.COLUMN_NAME_USER_ID + " INTEGER, " +
                        DatabaseContract.BelongsEntry.COLUMN_NAME_ORGA_ID + " INTEGER)";

        private static final String SQL_DELETE_BELONGS =
                "DROP TABLE IF EXISTS " + DatabaseContract.OrganizationEntry.TABLE_NAME;

        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Belongs.db";

        public BelongsDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_BELONGS);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_BELONGS);
            onCreate(db);

        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }

    public static class TweetDbHelper extends SQLiteOpenHelper{

        public static long tweetCreation(Context context, SQLiteDatabase dbTweet, long userId, String content){
            // Create a new map of values, where column names are the keysvalues
            ContentValues valuesTweet = new ContentValues();
            valuesTweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID, userId);
            valuesTweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT, content);
            return dbTweet.insert(DatabaseContract.TweetEntry.TABLE_NAME, null, valuesTweet);
        }

        private static final String SQL_CREATE_TWEET =
                "CREATE TABLE " + DatabaseContract.TweetEntry.TABLE_NAME + " (" +
                        DatabaseContract.TweetEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID + " INTEGER, " +
                        DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT + " VARCHAR(140) NOT NULL);";

        private static final String SQL_DELETE_TWEET =
                "DROP TABLE IF EXISTS " + DatabaseContract.TweetEntry.TABLE_NAME;


        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Tweet.db";

        public TweetDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_TWEET);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_TWEET);
            onCreate(db);

        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }


}
