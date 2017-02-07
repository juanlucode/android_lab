package es.com.blogspot.juanlucode.fruitworld.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.com.blogspot.juanlucode.fruitworld.R;
import es.com.blogspot.juanlucode.fruitworld.adapters.FrutaAdapter;
import es.com.blogspot.juanlucode.fruitworld.models.Fruta;

public class MainActivity extends AppCompatActivity {

    private enum VISTA{
        LISTA,
        REJILLA
    }

    private ListView frutasListView;
    private GridView frutasGridView;

    private List<Fruta> frutas;

    private VISTA vista;

    private MenuItem itemLista;
    private MenuItem itemRejilla;

    private int contador;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contexto, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(frutas.get(info.position).getNombre());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean ok = true;
        try {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_opciones, menu);
            itemLista = menu.findItem(R.id.listViewItem);
            itemRejilla = menu.findItem(R.id.gridViewItem);
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
            case R.id.add_fruit:
                this.addFruit(frutas);
                ((BaseAdapter) frutasListView.getAdapter()).notifyDataSetChanged();
                ((BaseAdapter) frutasGridView.getAdapter()).notifyDataSetChanged();
                break;

            case R.id.gridViewItem:
            case R.id.listViewItem:
                this.changeView();
                break;

            default:
                ok = super.onOptionsItemSelected(item);
        }

        return  ok;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frutasListView = (ListView) findViewById(R.id.frutasListView);
        frutasGridView = (GridView) findViewById(R.id.frutasGridView);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        frutas = new ArrayList<Fruta>();
        loadFruits(frutas);

        this.vista = VISTA.LISTA;

        frutasListView.setAdapter(new FrutaAdapter(this,R.layout.item_fruta, frutas));
        frutasGridView.setAdapter(new FrutaAdapter(this, R.layout.item_fruta, frutas));

        frutasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.this.infoFruit(position);
            }
        });
        frutasGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.this.infoFruit(position);
            }
        });




        ((BaseAdapter) frutasListView.getAdapter()).notifyDataSetChanged();
        ((BaseAdapter) frutasGridView.getAdapter()).notifyDataSetChanged();

        contador = 0;
    }

    private void infoFruit(int position){
        if (frutas.get(position).getOrigen().equals("NEW")){
            Toast.makeText(this, "Nueva", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Precargada", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadFruits(List<Fruta> struct){
        struct.add(new Fruta("Pera","ESP",R.mipmap.ic_fruits_1));
        struct.add(new Fruta("Manzana","FRA",R.mipmap.ic_fruits_2));
        struct.add(new Fruta("Naranja","POR",R.mipmap.ic_fruits_3));
        struct.add(new Fruta("Uva","ITA",R.mipmap.ic_fruits_3));
        struct.add(new Fruta("Piña","SUD",R.mipmap.ic_fruits_2));
        struct.add(new Fruta("Melocotón","GRE",R.mipmap.ic_fruits_1));
        struct.add(new Fruta("Ciruela","MAR",R.mipmap.ic_fruits_2));
        struct.add(new Fruta("Fresa","TUR",R.mipmap.ic_fruits_2));
        struct.add(new Fruta("Melón","ESP",R.mipmap.ic_fruits_2));
        struct.add(new Fruta("Sandía","ESP",R.mipmap.ic_fruits_1));
        struct.add(new Fruta("Kaki","ISR",R.mipmap.ic_fruits_1));
        struct.add(new Fruta("Mandarina","ESP",R.mipmap.ic_fruits_1));
        struct.add(new Fruta("Lichis","COL",R.mipmap.ic_fruits_3));
        struct.add(new Fruta("Albaricoque","POR",R.mipmap.ic_fruits_3));
        struct.add(new Fruta("Nectarina","POR",R.mipmap.ic_fruits_3));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean ok = true;
        try {
            AdapterView.AdapterContextMenuInfo info;
            info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            switch (item.getItemId()) {
                case R.id.del_fruit:
                    ok = this.delFruit(frutas, info.position);
                    ((BaseAdapter) frutasListView.getAdapter()).notifyDataSetChanged();
                    ((BaseAdapter) frutasGridView.getAdapter()).notifyDataSetChanged();
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    private void changeView(){

        switch (this.vista){
            case LISTA:
                this.frutasListView.setVisibility(View.INVISIBLE);
                this.frutasGridView.setVisibility(View.VISIBLE);
                this.itemLista.setVisible(true);
                this.itemRejilla.setVisible(false);
                this.vista = VISTA.REJILLA;
                this.registerForContextMenu(this.frutasGridView);
                break;

            case REJILLA:
                this.frutasGridView.setVisibility(View.INVISIBLE);
                this.frutasListView.setVisibility(View.VISIBLE);
                this.itemRejilla.setVisible(true);
                this.itemLista.setVisible(false);
                this.vista = VISTA.LISTA;
                this.registerForContextMenu(this.frutasListView);
                break;
        }
    }

    private boolean addFruit(List<Fruta> struct){
        boolean ok = true;
        try{
            Random random = new Random();
            int icono;

            icono = (int) (random.nextDouble() * 3 + 1);
            switch (icono){
                case 1:
                    icono = R.mipmap.ic_fruits_1;
                    break;
                case 2:
                    icono = R.mipmap.ic_fruits_2;
                    break;
                case 3:
                    icono = R.mipmap.ic_fruits_3;
                    break;
            }
            StringBuilder newFruit = new StringBuilder("Nueva Fruta #");
            newFruit.append(++contador);
            struct.add(new Fruta(newFruit.toString(), "NEW", icono));
        }catch(Exception ex){
            ex.printStackTrace();
            ok = false;
        }

        return ok;
    }

    private boolean delFruit(List<Fruta> struct, int position){
        boolean ok = true;
        try{
            struct.remove(position);
        }catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }

        return ok;
    }
}
