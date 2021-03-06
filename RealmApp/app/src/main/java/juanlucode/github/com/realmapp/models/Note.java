package juanlucode.github.com.realmapp.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import juanlucode.github.com.realmapp.app.MyApplication;

/**
 * Created by juanluis on 16/02/17.
 */

public class Note extends RealmObject {

    @PrimaryKey
    private int     id;
    @Required
    private String  description;
    @Required
    private Date    createAt;

    public Note(){

    }

    public Note(String description){
        this.id = MyApplication.NoteID.incrementAndGet();
        this.description = description;
        this.createAt = new Date();
    }

    public int getId() {

        return id;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Date getCreateAt() {

        return createAt;
    }
}
