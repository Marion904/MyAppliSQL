package com.example.marion.myapplicationsql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.marion.myapplicationsql", appContext.getPackageName());
    }

    @Test
    public void newUser() throws Exception{

        Context appContext = InstrumentationRegistry.getTargetContext();


        DatabaseHelper.TweetsDbHelper dbHelper = new DatabaseHelper.TweetsDbHelper(appContext);

        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteDatabase tweets = dbHelper.getReadableDatabase();

        long newUserId = DatabaseHelper.TweetsDbHelper.userCreation(appContext,db,"myName","MyId");
        long newOrgaId = DatabaseHelper.TweetsDbHelper.organizationCreation(appContext,db,"myOrga","www.myOrga.com");

        assertNotEquals(-1,newUserId);
        assertNotEquals(-1,newOrgaId);

        for(int i = 0;i<10;i++){
            long newTweet = DatabaseHelper.TweetsDbHelper.tweetCreation(appContext,db, newUserId,"bla bla bla "+i);
            assertNotEquals(-1,newTweet);
        }

        // Filter results WHERE "user id " = '30'
        String selection = DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID+ " = ?";
        String[] selectionArgs = {Long.valueOf(newUserId).toString()};


        // How you want the results sorted in the resulting Cursor
        String query = "SELECT * from "+DatabaseContract.TweetEntry.TABLE_NAME+" WHERE "+selection;
        Cursor cursor = tweets.rawQuery(
                query,                                      // query
                selectionArgs                            // The values for the WHERE clause
        );

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            String itemId = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT));
            itemIds.add(itemId);
        }
        cursor.close();

        for(int i = 0; i<itemIds.size();i++){
            assertNotEquals("",itemIds.get(i));
        }

    }


}
