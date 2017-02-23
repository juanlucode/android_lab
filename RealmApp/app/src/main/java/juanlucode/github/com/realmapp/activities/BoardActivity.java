package juanlucode.github.com.realmapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import juanlucode.github.com.realmapp.R;
import juanlucode.github.com.realmapp.adapters.BoardAdapter;
import juanlucode.github.com.realmapp.models.Board;

public class BoardActivity
                            extends     AppCompatActivity
                            implements  RealmChangeListener<RealmResults<Board>>{

    private Realm realm;

    private ListView boardListView;
    private RealmResults<Board> boardsRealmResults;
    private FloatingActionButton addBoardFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_main);

        realm = Realm.getDefaultInstance();


        boardsRealmResults = realm.where(Board.class).findAll();


        boardListView = (ListView) findViewById(R.id.boardListView);
        boardListView.setAdapter(new BoardAdapter(  boardsRealmResults,
                                                    R.layout.board_listview_item,
                                                    this
        ));
        boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent notesIntent = new Intent(BoardActivity.this, NoteActivity.class);
                //notesIntent.putExtra("boardID", boardsRealmResults.get(position).getId());
                notesIntent.putExtra("board");
                startActivity(notesIntent);
            }
        });

        addBoardFAB = (FloatingActionButton) findViewById(R.id.addBoardFAB);
        addBoardFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddBoardDialog();
            }
        });

        boardsRealmResults.addChangeListener(new RealmChangeListener<RealmResults<Board>>() {
            @Override
            public void onChange(RealmResults<Board> element) {
                ((BoardAdapter) boardListView.getAdapter()).notifyDataSetChanged();
            }
        });


    }

    private void showAddBoardDialog(){
        
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View viewDialog = getLayoutInflater().inflate(R.layout.add_board_dialog, null);
        final EditText titleEditText = (EditText) viewDialog.findViewById(R.id.titleEditText);
        builder.setView(viewDialog);
        builder.setTitle("Adding new board...");
        builder.setMessage("Enter the new board's title:");

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String titleBoard = titleEditText.getText().toString().trim();
                if ( titleBoard.isEmpty() ){
                    Toast.makeText( getApplicationContext(), 
                                    "Title is required.", 
                                    Toast.LENGTH_SHORT).show();
                } else {
                    addBoard(titleBoard);
                }
            }
        });

        builder.create().show();;

    }

    private void addBoard(String title) {

        realm.beginTransaction();
        realm.copyToRealm(new Board(title));
        realm.commitTransaction();
    }


    @Override
    public void onChange(RealmResults<Board> element) {
        ((BaseAdapter) boardListView.getAdapter()).notifyDataSetChanged();
    }
}
