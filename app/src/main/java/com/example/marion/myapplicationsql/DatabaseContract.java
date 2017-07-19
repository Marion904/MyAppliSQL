package com.example.marion.myapplicationsql;

import android.provider.BaseColumns;

/**
 * Created by marion on 10/07/17.
 */

public final class DatabaseContract {
    /**
     * Created by marion on 10/07/17.
     */

    /**
     * To prevent any accidental instantiation of the class, the constructor is private
     */


    private DatabaseContract(){}


    public static class BelongsEntry implements BaseColumns {
        public static final String _ID = "id";
        public static final String TABLE_NAME ="belongs";
        public static final String COLUMN_NAME_USER_ID ="userId";
        public static final String COLUMN_NAME_ORGA_ID ="organizationId";
    }



    /**
     * Created by marion on 10/07/17.
     */

    public static class OrganizationEntry implements BaseColumns {
        public static final String _ID = "id";
        public static final String TABLE_NAME = "organization";
        public static final String COLUMN_NAME_NAME="name";
        public static final String COLUMN_NAME_WEBSITE="website";
    }

    /**
     * Created by marion on 10/07/17.
     */

    public static class TweetEntry implements BaseColumns {
        public static final String _ID = "id";
        public static final String TABLE_NAME = "tweet";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_USER_ID = "userId";

    }

    /**
     * Created by marion on 10/07/17.
     */

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String _ID = "id";
    }

    /**
     * the base writting
     *
     */

    public static final String SQL_CREATE_ORGANIZATION_ENTRIES =
            "CREATE TABLE " + DatabaseContract.OrganizationEntry.TABLE_NAME + " (" +
                    DatabaseContract.OrganizationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DatabaseContract.OrganizationEntry.COLUMN_NAME_NAME + " VARCHAR(50) NOT NULL, " +
                    DatabaseContract.OrganizationEntry.COLUMN_NAME_WEBSITE + " VARCHAR(50) NOT NULL);";

    public static final String SQL_CREATE_USERS_ENTRIES =
            "CREATE TABLE " + DatabaseContract.UserEntry.TABLE_NAME + " (" +
                    DatabaseContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DatabaseContract.UserEntry.COLUMN_NAME_NAME + " VARCHAR(50) NOT NULL, " +
                    DatabaseContract.UserEntry.COLUMN_NAME_EMAIL + " VARCHAR(50) NOT NULL);";

    public static final String SQL_CREATE_BELONGS_ENTRIES =
            "CREATE TABLE " + DatabaseContract.BelongsEntry.TABLE_NAME + " (" +
                    DatabaseContract.BelongsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DatabaseContract.BelongsEntry.COLUMN_NAME_USER_ID + " INTEGER, " +
                    DatabaseContract.BelongsEntry.COLUMN_NAME_ORGA_ID + " INTEGER);";

    public static final String SQL_CREATE_TWEET_ENTRIES =
            "CREATE TABLE " + DatabaseContract.TweetEntry.TABLE_NAME + " (" +
                    DatabaseContract.TweetEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID + " INTEGER, " +
                    DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT + " VARCHAR(140) NOT NULL)";

    public static final String SQL_DELETE_USER_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.UserEntry.TABLE_NAME;

    public static final String SQL_DELETE_ORGANIZATION_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.OrganizationEntry.TABLE_NAME;

    public static final String SQL_DELETE_BELONGS_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.BelongsEntry.TABLE_NAME;

    public static final String SQL_DELETE_TWEET_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.TweetEntry.TABLE_NAME;




}
