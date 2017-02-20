package qvik.martin.qvik;


/**
 * Created by Martin Anderson
 */

public class Thumbnail {
    private String description;
    private int id;

    public Thumbnail(int id, String desc) {
        this.id = id;
        this.description = desc;

    }

    public String getDesc() {
        return this.description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
