package ch.hackathon.asdf.seniorapp.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Contact;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class SkypeContacts{

    public static List<String> getSkypeContacts(Context context){
        List contacts = new ArrayList<String>();
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

    public static Contact getContactByUsername(Context context, String username){
        List contacts = new ArrayList<String>();
        Cursor c = context.getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                new String[]{ContactsContract.Data.CONTACT_ID, ContactsContract.Data.DATA1, ContactsContract.Data.DATA2},
                ContactsContract.Data.MIMETYPE + "= ?",
                new String[]{"vnd.android.cursor.item/com.skype.android.skypecall.action"},
                null);

        while (c != null && c.moveToNext()) {
            Log.i("SKYPE FIRSTNAME=" ,c.getString(2));


        }
        return new Contact();
    }
    }

