package juanlucode.github.com.realmapp.app;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import juanlucode.github.com.realmapp.models.Board;
import juanlucode.github.com.realmapp.models.Note;

/**
 * Created by juanluis on 17/02/17.
 */

public final class MyApplication extends Application {

    public static AtomicInteger BoardID;
    public static AtomicInteger NoteID;


    @Override
    public void onCreate() {
        super.onCreate();

        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        BoardID = getIdByTable(realm, Board.class);
        NoteID = getIdByTable(realm, Note.class);

        realm.close();

    }

    private void setUpRealmConfig(){
        RealmConfiguration config = new RealmConfiguration
                .Builder(getApplicationContext())
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        AtomicInteger atomicInteger;

        RealmResults realmResults = realm.where(anyClass).findAll();
        if (realmResults.size() > 0){
            atomicInteger = new AtomicInteger(realmResults.max("id").intValue());
        } else {
            atomicInteger = new AtomicInteger();
        }
        return atomicInteger;
    }


}
