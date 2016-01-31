package ch.hackathon.asdf.seniorapp.Business;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class Transporter {

    private long id;
    private String name;
    private String number;

    public Transporter(){

    }

    public Transporter(String name, String number){
        this.name = name;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
