package es.com.blogspot.juanlucode.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    private int contadorFamiliar = 0;


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
        registerForContextMenu(listaListView);

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

    private boolean addItem(){
        boolean ok = true;

        String cont = String.valueOf(++contadorFamiliar);
        try {
            familia.add(new Familiar("nuevo familiar ".concat(cont), "indefinido"));
            myAdapter.notifyDataSetChanged();
            Toast.makeText(this,"nuevo elemento añadido", Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    private boolean deleteItem(long id){
        boolean ok = true;
        try {
            String familiar = familia.get((int) id).getNombre();
            familia.remove((int) id);
            this.myAdapter.notifyDataSetChanged();
            Toast.makeText(this,familiar.concat(" eliminado"),Toast.LENGTH_SHORT).show();
        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }

        return ok;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context_lista, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean ok = true;
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo;
        adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.delete_item:
                this.deleteItem(adapterContextMenuInfo.id);
                break;
            default:
                ok = super.onContextItemSelected(item);
        }

        return ok;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean ok = true;
        try {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_lista, menu);
        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }

        return ok;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ok = true;
        switch (item.getItemId()){
            case R.id.add_item:
                ok = this.addItem();
                break;
            default:
                ok = super.onOptionsItemSelected(item);
        }
        return ok;
    }
}

