package juanlucode.github.com.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView sitesRecyclerView;
    ArrayList<Site> sites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sites = new ArrayList<Site>(){{
            add(new Site("Google", "www.google.es"));
            add(new Site("El Mundo", "www.elmundo.es"));
            add(new Site("Facebook", "www.facebook.com"));
            add(new Site("Twitter", "www.twitter.com"));
            add(new Site("Junta Extremadura", "www.juntaex.es"));
            add(new Site("Diario HOY", "www.hoy.es"));
            add(new Site("Acer", "www.acer.com"));
            add(new Site("Carrefour", "www.carrefour.es"));
            add(new Site("Amazon", "www.amazon.es"));
            add(new Site("La web del programador", "www.lwp.com"));
            add(new Site("Merida Digital", "www.meridadigital.es"));
            add(new Site("Udemy", "www.udemy.com"));
            add(new Site("Coursera", "www.coursera.com"));
            add(new Site("Oracle", "www.oracle.com"));
            add(new Site("Videotutoriales", "www.illasaron.com"));
            add(new Site("YouTube", "www.youtube.com"));
            add(new Site("Java Hispano", "www.javahispano.org"));
            add(new Site("SoloLearn", "www.sololearn.com"));
            add(new Site("Linked In", "www.linkedin.com"));


        }};

        sitesRecyclerView = (RecyclerView) findViewById(R.id.sitesRecyclerView);

        sitesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sitesRecyclerView.setAdapter(new SitesAdapter(sites,R.layout.site_item));
    }
}
