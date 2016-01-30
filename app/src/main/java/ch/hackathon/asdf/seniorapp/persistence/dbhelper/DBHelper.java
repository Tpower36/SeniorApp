package ch.hackathon.asdf.seniorapp.persistence.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thierry.hubmann on 30.01.2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final String TABLE_EVENTS = "events";
    public static final String EVENTS_ID = "id";
    public static final String EVENTS_TITLE = "title";
    public static final String EVENTS_DESCRIPTION = "description";
    public static final String EVENTS_DATE = "event_date";
    public static final String EVENTS_LOCATION = "location";

    public static final String TABLE_CONTACTS = "contacts";
    public static final String CONTACTS_ID = "id";
    public static final String CONTACTS_USERNAME ="username";
    public static final String CONTACTS_LASTNAME="lastname";
    public static final String CONTACTS_FIRSTNAME="firstname";

    private static final String DATABASE_NAME = "SeniorApp.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createQueryBuilder(TABLE_EVENTS));
        db.execSQL(createQueryBuilder(TABLE_CONTACTS));
    }

    /**
     * Cette méthode retourne la requête de création de la table donnée en paramètre.
     * @param tableName la table qu'on veut créer
     * @return la requête de création pour la table
     */
    private String createQueryBuilder(String tableName){
        StringBuilder query = new StringBuilder();
        switch(tableName){
            case TABLE_EVENTS:
                query.append("create table ");
                query.append(TABLE_EVENTS);
                query.append("(");
                query.append(EVENTS_ID);
                query.append(" integer primary key autoincrement, ");
                query.append(EVENTS_TITLE);
                query.append(" varchar(100) not null, ");
                query.append(EVENTS_DESCRIPTION);
                query.append(" varchar(255), ");
                query.append(EVENTS_DATE);
                query.append(" text not null, ");
                query.append(EVENTS_LOCATION);
                query.append(" varchar(100));");
                break;

            case TABLE_CONTACTS:
                query.append("create table ");
                query.append(TABLE_CONTACTS);
                query.append("(");
                query.append(CONTACTS_ID);
                query.append(" integer primary key autoincrement, ");
                query.append(CONTACTS_USERNAME);
                query.append(" varchar(255) not null, ");
                query.append(CONTACTS_FIRSTNAME);
                query.append(" varchar(255) not null, ");
                query.append(CONTACTS_LASTNAME);
                query.append(" varchar(255) not null);");
                break;
        }
        return query.toString();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Version 1
    }
}
