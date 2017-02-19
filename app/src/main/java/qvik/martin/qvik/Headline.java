package qvik.martin.qvik;


/**
 * Created by Martin Anderson
 */

public class Headline {


    private String agency;


    private String date;


    private String title;
    private String body;
    private String categorie;


    public Headline(String agency, String date, String title, String categorie, String body)
    {
        this.agency = agency;
        this.date = date;
        this.title = title;
        this.body = body;
        this.categorie = categorie;
    }

    public Headline(String aDefault, String aDefault1, String aDefault2, String aDefault3) {
    }

    public String getAgency() {
        return agency;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
    public String getBody(){return this.body;}
    public String getCategorie(){return this.categorie;}
}
