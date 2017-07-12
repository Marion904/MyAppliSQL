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
        public static final String TABLE_NAME ="Belongs";
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
}
