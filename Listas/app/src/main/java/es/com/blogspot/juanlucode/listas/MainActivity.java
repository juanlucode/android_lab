package es.com.blogspot.juanlucode.listas;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaListView;
    private List<String> nombres;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaListView = (ListView) findViewById(R.id.listaListView);

        nombres = new ArrayList<String>();
        nombres.add("Darío");
        nombres.add("Irene");
        nombres.add("María Antonia");
        nombres.add("Juan Luis");
        nombres.add("Fermín");
        nombres.add("Juan");
        nombres.add("María Jesús");
        nombres.add("José Antonio");
        nombres.add("Pedro");
        nombres.add("Manuela");
        nombres.add("Luis");
        nombres.add("Pilar");

        arrayAdapter = new ArrayAdapter<String>
                                        (this,android.R.layout.simple_list_item_1 ,nombres );

        listaListView.setAdapter(arrayAdapter);

        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, nombres.get(position) ,Toast.LENGTH_LONG).show();
            }
        });
    }
}
