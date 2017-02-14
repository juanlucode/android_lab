package juanlucode.github.com.myrecyclerview.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

import juanlucode.github.com.myrecyclerview.R;
import juanlucode.github.com.myrecyclerview.models.Site;
import juanlucode.github.com.myrecyclerview.adapters.SitesAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView sitesRecyclerView;
    ArrayList<Site> sites;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ok = true;
        switch ( item.getItemId() ){
            case R.id.add_site:
                addSite();
                break;

            default:
                ok = super.onOptionsItemSelected(item);
        }

        return ok;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        String header = ((TextView) info.targetView.findViewById(R.id.nameTextView)).getText().toString();
        menu.setHeaderTitle(header);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean ok = true;

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch ( item.getItemId() ){
            case R.id.del_site:
                MainActivity.this.removeSite(info.position);
                break;
            default:
                ok = super.onContextItemSelected(item);
        }



        return ok;
    }

    private void addSite() {
        String index = String.valueOf(sites.size() + 1);
        Site newSite = new Site(    "Nuevo Sitio ".concat(index),
                                    "www.nuevo.".concat(index).concat(".com"),
                                    R.drawable.new_site
                                );

        sites.add(0, newSite);
        sitesRecyclerView.getAdapter().notifyItemInserted(0);
        sitesRecyclerView.getLayoutManager().scrollToPosition(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean ok = true;
        try {
            getMenuInflater().inflate(R.menu.option_menu, menu);
        }catch (Exception ex){
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sites = new ArrayList<Site>(){{
            add(new Site("Google", "www.google.es", R.drawable.google));
            add(new Site("El Mundo", "www.elmundo.es", R.drawable.elmundo));
            add(new Site("Facebook", "www.facebook.com", R.drawable.facebook));
            add(new Site("Twitter", "www.twitter.com", R.drawable.twitter));
            add(new Site("Junta Extremadura", "www.juntaex.es", R.drawable.juntaex));
            add(new Site("Diario HOY", "www.hoy.es", R.drawable.diario_hoy));
            add(new Site("Acer", "www.acer.com", R.drawable.acer));
            add(new Site("Carrefour", "www.carrefour.es", R.drawable.carrefour));
            add(new Site("Amazon", "www.amazon.es", R.drawable.amazon));
            add(new Site("La web del programador", "www.lwp.com", R.drawable.lwp));
            add(new Site("Merida Digital", "www.meridadigital.es", R.drawable.merida_digital));
            add(new Site("Udemy", "www.udemy.com", R.drawable.udemy));
            add(new Site("Coursera", "www.coursera.com", R.drawable.coursera));
            add(new Site("Oracle", "www.oracle.com", R.drawable.oracle));
            add(new Site("Videotutoriales", "www.illasaron.com", R.drawable.videotutoriales));
            add(new Site("YouTube", "www.youtube.com", R.drawable.youtube));
            add(new Site("Java Hispano", "www.javahispano.org", R.drawable.javahispano));
            add(new Site("SoloLearn", "www.sololearn.com", R.drawable.sololearn));
            add(new Site("Linked In", "www.linkedin.com", R.drawable.linkedin));


        }};

        sitesRecyclerView = (RecyclerView) findViewById(R.id.sitesRecyclerView);

        sitesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //sitesRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        /*
        sitesRecyclerView.setAdapter(new SitesAdapter(sites,R.layout.site_item, new SitesAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Site site, int position) {
                removeSite(position);
            }
        }));
        */

        sitesRecyclerView.setAdapter(new SitesAdapter(  MainActivity.this,
                                                        sites,
                                                        R.layout.site_cardview,
                                                        new SitesAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Site site, int position) {
                //removeSite(position);
                MainActivity.this.openSite(site.getAddress());
            }
        }));

        sitesRecyclerView.setHasFixedSize(true);
        sitesRecyclerView.setItemAnimator(new DefaultItemAnimator());

        registerForContextMenu(sitesRecyclerView);


    }

    private void removeSite(int position) {
        sites.remove(position);
        sitesRecyclerView.getAdapter().notifyItemRemoved(position);
    }

    private void openSite(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://".concat(url)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
