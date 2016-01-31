package ch.hackathon.asdf.seniorapp.persistence.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import ch.hackathon.asdf.seniorapp.Business.Contact;
import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.persistence.dbhelper.DBHelper;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class ContactsDao {

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = { DBHelper.CONTACTS_ID,DBHelper.CONTACTS_USERNAME, DBHelper.CONTACTS_FIRSTNAME,
            DBHelper.CONTACTS_LASTNAME};

    public ContactsDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void addToTop(Contact contact, int rank){
        if(getContactById(rank)==null){
            addContact(contact, rank);
        }
        else{
            editContact(contact, rank);
        }
    }

    private void addContact(Contact contact, int rank){
        ContentValues values = new ContentValues();
        values.put(DBHelper.CONTACTS_ID, rank);
        values.put(DBHelper.CONTACTS_USERNAME, contact.getUsername());
        values.put(DBHelper.CONTACTS_FIRSTNAME, contact.getFirstname());
        values.put(DBHelper.CONTACTS_LASTNAME, contact.getLastname());

        database.insert(DBHelper.TABLE_CONTACTS, null,
                values);
    }

    private void editContact(Contact contact, int rank){
        deleteContact(rank);
        addContact(contact, rank);
    }

    private void deleteContact(int rank){
        database.delete(DBHelper.TABLE_CONTACTS, DBHelper.CONTACTS_ID
                + " = " + rank, null);
    }

    public Contact getContactById(int id){
        Contact contact = null;
        Cursor cursor = null;
        try {
            cursor = database.query(DBHelper.TABLE_CONTACTS,
                    allColumns, "id="+id, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                contact = cursorToContact(cursor);
                cursor.moveToNext();
            }
        }
        catch(NullPointerException ex){
            return null;
        }
        cursor.close();
        return contact;
    }

    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(cursor.getInt(0));
        contact.setUsername(cursor.getString(1));
        contact.setFirstname(cursor.getString(2));
        contact.setLastname(cursor.getString(3));

        return contact;
    }
}
