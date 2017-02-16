package juanlucode.github.com.realmapp.models;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by juanluis on 16/02/17.
 */

public final class Board extends RealmObject {

    @PrimaryKey
    private int             id;
    @Required
    private String          title;
    @Required
    private Date            createAt;
    private RealmList<Note> notes;

    public Board(){

    }

    public Board(String title){
        this.id = 0;
        this.title = title;
        this.createAt = new Date();
        notes = new RealmList<Note>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public RealmList<Note> getNotes() {
        return notes;
    }
}
