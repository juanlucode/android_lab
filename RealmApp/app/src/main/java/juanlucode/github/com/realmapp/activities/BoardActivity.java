package juanlucode.github.com.realmapp.activities;

import android.content.DialogInterface;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import juanlucode.github.com.realmapp.R;

public class BoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_main);
        showAddBoardDialog();


    }

    private void showAddBoardDialog(){
        
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View viewDialog = (View) getLayoutInflater().inflate(R.layout.add_board_dialog, null);
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
                    addBoard();
                }
            }
        });

        builder.create().show();;

    }

    private void addBoard() {
    }
}
