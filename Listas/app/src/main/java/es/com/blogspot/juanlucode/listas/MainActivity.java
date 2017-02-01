package es.com.blogspot.juanlucode.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaListView;
    private List<Familiar> familia;
    private ArrayAdapter<Familiar> arrayAdapter;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Datos a mostrar
        familia = new ArrayList<Familiar>();
        familia.add(new Familiar("Darío", "Hijo"));
        familia.add(new Familiar("Irene", "Hija"));
        familia.add(new Familiar("María Antonia", "Conyuge"));
        familia.add(new Familiar("Juan Luis", "Referido"));
        familia.add(new Familiar("Fermín", "Cuñado"));
        familia.add(new Familiar("Juan", "Padre"));
        familia.add(new Familiar("María Jesús", "Madre"));
        familia.add(new Familiar("José Antonio", "Cuñado"));
        familia.add(new Familiar("Pedro", "Cuñado"));
        familia.add(new Familiar("Manuela", "Suegra"));
        familia.add(new Familiar("Fermín", "Suegro"));
        familia.add(new Familiar("Luis", "Abuelo"));
        familia.add(new Familiar("Pilar", "Abuela"));

        // Recuperar control del layout
        listaListView = (ListView) findViewById(R.id.listaListView);

        // Asociamos un adaptador de datos a la vist
        // El adaptador asocia un layout de elemento de lista
        // con los datos a mostrar
        myAdapter = new MyAdapter(this,R.layout.lista_mejorada_layout, familia);
        listaListView.setAdapter(myAdapter);

        // evento de pulsación sobre elemento de lista
        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, familia.get(position).getParentesco() ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

