package juanlucode.github.com.realmapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import juanlucode.github.com.realmapp.R;
import juanlucode.github.com.realmapp.adapters.NoteAdapter;
import juanlucode.github.com.realmapp.models.Board;
import juanlucode.github.com.realmapp.models.Note;

public class NoteActivity
                            extends     AppCompatActivity
                            implements RealmChangeListener<Board> {


    private ListView notesListView;
    private RealmList<Note> noteRealmList;

    private FloatingActionButton addNoteFAB;

    private int boardID;
    private Board board;

    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        realm = Realm.getDefaultInstance();

        if ( getIntent().getExtras().get("boardID") != null) {
            this.boardID = getIntent().getExtras().getInt("boardID");
        }

        board = realm.where(Board.class).equalTo("id", boardID).findFirst();
        noteRealmList = board.getNotes();

        this.setTitle(board.getTitle());

        notesListView = (ListView) findViewById(R.id.notesListView);
        notesListView.setAdapter( new NoteAdapter(noteRealmList, R.layout.note_listview_item, this));

        addNoteFAB = (FloatingActionButton) findViewById(R.id.AddNoteFAB);
        addNoteFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertForCreatingNote("New note", "Insert note:");
            }
        });
    }

//** Dialogs **/

    private void showAlertForCreatingNote(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (title != null) builder.setTitle(title);
        if (message != null) builder.setMessage(message);

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.add_note_dialog, null);
        builder.setView(viewInflated);

        final EditText input = (EditText) viewInflated.findViewById(R.id.noteDescriptionEditText);


        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String note = input.getText().toString().trim();
                if (note.length() > 0)
                    createNewNote(note);
                else
                    Toast.makeText(getApplicationContext(), "The note can't be empty", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void createNewNote(String note) {
        this.realm.beginTransaction();
        Note newNote = new Note(note);
        this.realm.copyToRealm(newNote);
        this.board.getNotes().add(newNote);
        this.realm.commitTransaction();
    }

    @Override
    public void onChange(Board element) {
        ((BaseAdapter) notesListView.getAdapter()).notifyDataSetChanged();
    }
}
