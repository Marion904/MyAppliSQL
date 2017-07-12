package com.example.marion.myapplicationsql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper.UserDbHelper userDbHelper = new DatabaseHelper.UserDbHelper(this);
        DatabaseHelper.OrganizationDbHelper organizationDbHelper = new DatabaseHelper.OrganizationDbHelper(this);
        DatabaseHelper.BelongsDbHelper belongsDbHelper = new DatabaseHelper.BelongsDbHelper(this);
        DatabaseHelper.TweetDbHelper tweetDbHelper = new DatabaseHelper.TweetDbHelper(this);

        // Get the data repository in write mode
        SQLiteDatabase dbUser = userDbHelper.getWritableDatabase();
        SQLiteDatabase dbOrga = organizationDbHelper.getWritableDatabase();
        SQLiteDatabase dbBelongs = belongsDbHelper.getWritableDatabase();
        SQLiteDatabase dbTweets = tweetDbHelper.getWritableDatabase();

        //Get the data in read mode
        SQLiteDatabase Tweets = tweetDbHelper.getReadableDatabase();


        // Insert the new row, returning the primary key value of the new row
//        long newRowUserId = DatabaseHelper.UserDbHelper.userCreation(this, dbUser, "myName","myEmail");
//        long newRowOrgaId = DatabaseHelper.OrganizationDbHelper.organizationCreation(this, dbOrga);
//        long newRowBelongsId = DatabaseHelper.BelongsDbHelper.belongingCreation(this, dbBelongs, newRowUserId, newRowOrgaId);
//        long newTweet = DatabaseHelper.TweetDbHelper.tweetCreation(this,dbTweets, newRowUserId,"bla bla bla ");

//        for(int i = 0;i<10;i++){
//            long newTweets = DatabaseHelper.TweetDbHelper.tweetCreation(this,dbTweets, newRowUserId,"bla bla bla "+i);
//        }

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DatabaseContract.TweetEntry._ID,
                DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID,
                DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID+ " = ?";
        String[] selectionArgs = {"30"};


        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                DatabaseContract.TweetEntry._ID+ " DESC";
        String query = "SELECT * from "+DatabaseContract.TweetEntry.TABLE_NAME+" WHERE "+selection;
        Cursor cursor = Tweets.rawQuery(
                query,   // The table to query
                selectionArgs                            // The values for the WHERE clause
        );
        /*
        (
                DatabaseContract.TweetEntry.TABLE_NAME,   // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
*/
        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            String itemId = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT));
            itemIds.add(itemId);
        }
        cursor.close();

        for(int i = 0; i<itemIds.size();i++){
            Toast.makeText(this, itemIds.get(i).toString(),Toast.LENGTH_SHORT).show();
        }





    }








}
