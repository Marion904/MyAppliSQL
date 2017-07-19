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

        DatabaseHelper.TweetsDbHelper dbHelper = new DatabaseHelper.TweetsDbHelper(this);

        // Get the data repository in write mode

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Get the data in read mode
        SQLiteDatabase tweets = dbHelper.getReadableDatabase();


        // Insert the new row, returning the primary key value of the new row
       long newRowUserId = DatabaseHelper.TweetsDbHelper.userCreation(this, db, "myName","myEmail");
       long newRowOrgaId = DatabaseHelper.TweetsDbHelper.organizationCreation(this, db,"myOrga","www.myOrga.com");
       long newRowBelongsId = DatabaseHelper.TweetsDbHelper.belongingCreation(this, db, newRowUserId, newRowOrgaId);

        for(int i = 0;i<10;i++){
            long newTweets = DatabaseHelper.TweetsDbHelper.tweetCreation(this,db, newRowUserId,"bla bla bla "+i);
            Toast.makeText(this,newTweets+"",Toast.LENGTH_SHORT).show();
        }


        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DatabaseContract.TweetEntry._ID,
                DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID,
                DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID+ " < ?";
        String[] selectionArgs = {"10"};


        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                DatabaseContract.TweetEntry._ID+ " DESC";
        String query = "SELECT * from "+DatabaseContract.TweetEntry.TABLE_NAME+" WHERE "+selection;
        Cursor cursor = tweets.rawQuery(
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
