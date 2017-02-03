package es.com.blogspot.juanlucode.gridview_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                break;
            default:
                ok = super.onOptionsItemSelected(item);
        }

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rejillaGridView = (GridView) findViewById(R.id.rejillaGridView);
        this.techs = new ArrayList<Tech>();
        this.loadTechs(techs);

        rejillaGridView.setAdapter( new MyAdapter(this, R.layout.grid_layout, techs));


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
}
