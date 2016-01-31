package ch.hackathon.asdf.seniorapp.Business;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class News {
    private long id;
    private String resume;
    private String content;

    public News(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
