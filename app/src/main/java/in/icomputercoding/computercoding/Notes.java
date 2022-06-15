package in.icomputercoding.computercoding;

public class Notes {

    public int id;
    public String title;
    public String link;

    public Notes(int id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
