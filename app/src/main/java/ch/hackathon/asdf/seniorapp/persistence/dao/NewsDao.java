package ch.hackathon.asdf.seniorapp.persistence.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.Business.News;
import ch.hackathon.asdf.seniorapp.persistence.dbhelper.DBHelper;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class NewsDao {

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = {DBHelper.NEWS_ID, DBHelper.NEWS_RESUME, DBHelper.NEWS_CONTENT};


    public NewsDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void createNews(News news) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NEWS_RESUME, news.getResume());

        values.put(DBHelper.NEWS_CONTENT, news.getContent());

        long insertId = database.insert(DBHelper.TABLE_NEWS, null,
                values);
    }

    public List<News> getAllNews(){
        List<News> newsList = new ArrayList<News>();
        Cursor cursor = null;
        try {
            cursor = database.query(DBHelper.TABLE_EVENTS,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                News news = cursorToNews(cursor);
                newsList.add(news);
                cursor.moveToNext();
            }
        }
        catch(NullPointerException ex){
            return null;
        }
        cursor.close();
        return newsList;
    }

    public void cleanNews(Event event) {
        long id = event.getId();
        database.delete(DBHelper.TABLE_NEWS, "1=1", null);
    }

    private News cursorToNews(Cursor cursor) {
        News news= new News();
        news.setId(cursor.getLong(0));
        news.setResume(cursor.getString(1));
        news.setContent(cursor.getString(2));
        return news;
    }

}
