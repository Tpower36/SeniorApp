package ch.hackathon.asdf.seniorapp.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class SkypeContacts{

    public static List<String> getSkypeContacts(Context context){
        List contacts = null;
            Cursor c = context.getContentResolver().query(
                    ContactsContract.Data.CONTENT_URI,
                    new String[]{ContactsContract.Data.CONTACT_ID, ContactsContract.Data.DATA1},
                    ContactsContract.Data.MIMETYPE + "= ?",
                    new String[]{"vnd.android.cursor.item/com.skype.android.skypecall.action"},
                    null);

            while (c != null && c.moveToNext()) {
                contacts.add(c.getString(1));
            }
        return contacts;

        }
    }

