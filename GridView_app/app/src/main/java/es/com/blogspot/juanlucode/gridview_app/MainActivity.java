package es.com.blogspot.juanlucode.gridview_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView rejillaGridView;
    List<Tech> techs;
    int cont = 0;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ok = true;
        switch (item.getItemId()){
            case R.id.add_item:
                ok = this.addItem(techs);
                ((MyAdapter) rejillaGridView.getAdapter()).notifyDataSetChanged();
                break;
            default:
                ok = super.onOptionsItemSelected(item);
        }
        return ok;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean ok = true;
        try {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.option_menu, menu);
        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info;
        info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(techs.get(info.position).getName());

        inflater.inflate(R.menu.context_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean ok = true;
        AdapterView.AdapterContextMenuInfo info;
        info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.del_item:
                //item.setTitle(techs.get(info.position).getName());
                ok = delItem(techs, info.position);
                ((MyAdapter) rejillaGridView.getAdapter()).notifyDataSetChanged();
            default:
                ok = super.onContextItemSelected(item);
        }
        return ok;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rejillaGridView = (GridView) findViewById(R.id.rejillaGridView);
        this.techs = new ArrayList<Tech>();
        this.loadTechs(techs);

        rejillaGridView.setAdapter( new MyAdapter(this, R.layout.grid_layout, techs));
        registerForContextMenu(rejillaGridView);


    }

    private void loadTechs( List<Tech> struct){
        struct.add(new Tech("Android", "SO"));
        struct.add(new Tech("Java", "LANG"));
        struct.add(new Tech("C++", "LANG"));
        struct.add(new Tech("HTTP", "PROT"));
        struct.add(new Tech("TCP/IF", "PROT"));
        struct.add(new Tech("iOS", "OS"));
        struct.add(new Tech("Swift", "LANG"));
        struct.add(new Tech("Firefox", "BROW"));
        struct.add(new Tech("Linux", "OS"));
        struct.add(new Tech("Udemy", "APP"));
        struct.add(new Tech("Android Studio", "IDE"));
        struct.add(new Tech("Cordova", "FRMW"));
        struct.add(new Tech("YouTube", "APP"));
        struct.add(new Tech("C", "LANG"));
        struct.add(new Tech("Opera", "BROW"));
        struct.add(new Tech("C#", "LANG"));
        struct.add(new Tech("Eclipse", "IDE"));
        struct.add(new Tech("FTP", "PROT"));

    }

    private boolean addItem(List<Tech> struct){
        boolean ok = true;
        try {
            StringBuilder cadena = new StringBuilder("Tech #");
            cadena.append(++this.cont);
            struct.add(new Tech(cadena.toString(), "NEW"));

        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    private boolean delItem(List<Tech> struct, int item){
        boolean ok = true;
        try{
            struct.remove(item);
        } catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }
}
