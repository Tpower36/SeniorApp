package ch.hackathon.asdf.seniorapp.services;

import android.content.Context;

import ch.hackathon.asdf.seniorapp.Business.Contact;
import ch.hackathon.asdf.seniorapp.persistence.dao.ContactsDao;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class ContactsServices {

    public static void addToTop(Context context, Contact contact, int rank){
        ContactsDao dao = new ContactsDao(context);
        dao.open();
        dao.addToTop(contact, rank);
        dao.close();
    }

    public static Contact getContactByRank(Context context, int rank){
        ContactsDao dao = new ContactsDao(context);
        dao.open();
        Contact contact =  dao.getContactById(rank);
        dao.close();
        return contact;
    }

    public static boolean isRankSet(Context context, int rank){
        return new ContactsDao(context).getContactById(rank)!= null;
    }
}
