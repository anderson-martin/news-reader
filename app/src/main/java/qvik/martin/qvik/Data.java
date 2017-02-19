package qvik.martin.qvik;

import java.util.ArrayList;


/**
 * Created by Martin Anderson
 */
public class Data {
    private ArrayList<Thumbnail> thumbnails;
    private ArrayList<Headline> science;
    private ArrayList<Headline> fashion;
    private ArrayList<Headline> auto;
    private ArrayList<Headline> technology;
    private ArrayList<Headline> entertainment;
    private ArrayList<Headline> environment;
    private ArrayList<Headline> finances;
    private ArrayList<Headline> travel;


    private static Data ourInstance = new Data();


    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        this.thumbnails = new ArrayList<>();
        this.science = new ArrayList<>();
        this.fashion = new ArrayList<>();
        this.auto = new ArrayList<>();
        this.technology = new ArrayList<>();
        this.entertainment = new ArrayList<>();
        this.environment = new ArrayList<>();
        this.finances = new ArrayList<>();
        this.travel = new ArrayList<>();
        populateArrays();
    }

    public ArrayList<Thumbnail> getThumbnails() {
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_fashion, "Fashion"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_science, "Science"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_auto, "Auto"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_technology, "Technology"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_entertainment, "Entertainment"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_environment, "Environment"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_finances, "Finances"));
        thumbnails.add(new Thumbnail(R.drawable.thumbnail_travel, "Travel"));
        return this.thumbnails;
    }

    public ArrayList<Headline> getData(String categorie) {
        ArrayList<Headline> result = new ArrayList<>();
        switch (categorie.toLowerCase()) {
            case "fashion":
                result = this.fashion;
                break;
            case "science":
                result = this.science;
                break;
            case "auto":
                result = this.auto;
                break;
            case "technology":
                result = this.technology;
                break;
            case "entertainment":
                result = this.entertainment;
                break;
            case "environment":
                result = this.environment;
                break;
            case "finances":
                result = this.finances;
                break;
            case "travel":
                result = this.travel;
                break;

        }
        return result;
    }


    public void populateArrays() {
        String body = "<p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p> <p> <b> Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </b> </p> <p> Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p> ";


        this.science.add(new Headline("CNN", "Apr 3, 2015", "Arctic sea ice extent hits record low for winter maximum", "Science", body));
        this.science.add(new Headline("The New York Times", "Apr 3, 2015", "Archaelogists discovered lost city in Honduran jungle", "Science", body));
        this.science.add(new Headline("CNN", "Apr 1, 2015", "The ballons that could fly tourists to the edge of space", "Science", body));
        this.science.add(new Headline("The New Your Times", "Apr 1, 2015", "In the Prawn Nebula, a Nursery for Newborn Stars", "Science", body));
        this.science.add(new Headline("Popular Science", "Apr 1, 2015", "What will the battleship of the Future look like?", "Science", body));

        this.fashion.add(new Headline("Agency 1", "Date 1", "Title 1 of Fashion", "Fashion", body));
        this.fashion.add(new Headline("Agency 2", "Date 2", "Title 2 of Fashion", "Fashion", body));
        this.fashion.add(new Headline("Agency 3", "Date 3", "Title 3 of Fashion", "Fashion", body));
        this.fashion.add(new Headline("Agency 4", "Date 4", "Title 4 of Fashion", "Fashion", body));
        this.fashion.add(new Headline("Agency 5", "Date 5", "Title 5 of Auto", "Auto", body));

        this.auto.add(new Headline("Agency 1", "Date 1", "Title 1 of Auto", "Auto", body));
        this.auto.add(new Headline("Agency 2", "Date 2", "Title 2 of Auto", "Auto", body));
        this.auto.add(new Headline("Agency 3", "Date 3", "Title 3 of Auto", "Auto", body));
        this.auto.add(new Headline("Agency 4", "Date 4", "Title 4 of Auto", "Auto", body));
        this.auto.add(new Headline("Agency 5", "Date 5", "Title 5 of Auto", "Auto", body));

        this.technology.add(new Headline("Agency 1", "Date 1", "Title 1 of Technology", "Technology", body));
        this.technology.add(new Headline("Agency 2", "Date 2", "Title 2 of Technology", "Technology", body));
        this.technology.add(new Headline("Agency 3", "Date 3", "Title 3 of Technology", "Technology", body));
        this.technology.add(new Headline("Agency 4", "Date 4", "Title 4 of Technology", "Technology", body));
        this.technology.add(new Headline("Agency 5", "Date 5", "Title 5 of Technology", "Technology", body));

        this.entertainment.add(new Headline("Agency 1", "Date 1", "Title 1 of Entertainment", "Entertainment", body));
        this.entertainment.add(new Headline("Agency 2", "Date 2", "Title 2 of Entertainment", "Entertainment", body));
        this.entertainment.add(new Headline("Agency 3", "Date 3", "Title 3 of Entertainment", "Entertainment", body));
        this.entertainment.add(new Headline("Agency 4", "Date 4", "Title 4 of Entertainment", "Entertainment", body));
        this.entertainment.add(new Headline("Agency 5", "Date 5", "Title 5 of Entertainment", "Entertainment", body));


        this.environment.add(new Headline("Agency 1", "Date 1", "Title 1 of Environment", "Environment", body));
        this.environment.add(new Headline("Agency 2", "Date 2", "Title 2 of Environment", "Environment", body));
        this.environment.add(new Headline("Agency 3", "Date 3", "Title 3 of Environment", "Environment", body));
        this.environment.add(new Headline("Agency 4", "Date 4", "Title 4 of Environment", "Environment", body));
        this.environment.add(new Headline("Agency 5", "Date 5", "Title 5 of Environment", "Environment", body));

        this.finances.add(new Headline("Agency 1", "Date 1", "Title 1 of Finances", "Finances", body));
        this.finances.add(new Headline("Agency 2", "Date 2", "Title 2 of Finances", "Finances", body));
        this.finances.add(new Headline("Agency 3", "Date 3", "Title 3 of Finances", "Finances", body));
        this.finances.add(new Headline("Agency 4", "Date 4", "Title 4 of Finances", "Finances", body));
        this.finances.add(new Headline("Agency 5", "Date 5", "Title 5 of Finances", "Finances", body));

        this.travel.add(new Headline("Agency 1", "Date 1", "Title 1 of Travel", "Travel", body));
        this.travel.add(new Headline("Agency 2", "Date 2", "Title 2 of Travel", "Travel", body));
        this.travel.add(new Headline("Agency 3", "Date 3", "Title 3 of Travel", "Travel", body));
        this.travel.add(new Headline("Agency 4", "Date 4", "Title 4 of Travel", "Travel", body));
        this.travel.add(new Headline("Agency 5", "Date 5", "Title 5 of Travel", "Travel", body));

    }


    public int getCategorieImageId(String categorie) {
        int id = 0;
        switch (categorie.toLowerCase()) {
            case "fashion":
                id = R.drawable.thumbnail_3x_fashion;
                break;
            case "science":
                id = R.drawable.thumbnail_3x_science;
                break;
            case "auto":
                id = R.drawable.thumbnail_3x_auto;
                break;
            case "technology":
                id = R.drawable.thumbnail_3x_technology;
                break;
            case "entertainment":
                id = R.drawable.thumbnail_3x_entertainment;
                break;
            case "environment":
                id = R.drawable.thumbnail_3x_environment;
                break;
            case "finances":
                id = R.drawable.thumbnail_3x_finances;
                break;
            case "travel":
                id = R.drawable.thumbnail_3x_travel;
                break;
        }

        return id;


    }
}
