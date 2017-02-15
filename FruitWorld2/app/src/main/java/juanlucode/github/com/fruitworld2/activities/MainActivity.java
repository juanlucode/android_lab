package juanlucode.github.com.fruitworld2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import juanlucode.github.com.fruitworld2.R;
import juanlucode.github.com.fruitworld2.adapters.FrutaAdapter;
import juanlucode.github.com.fruitworld2.models.Fruta;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Fruta> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obtenerFrutas();
        recyclerView = (RecyclerView) findViewById(R.id.reciclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FrutaAdapter(this, this.frutas, R.layout.fruit_card_view));

    }

    private void obtenerFrutas() {
        this.frutas = new ArrayList<Fruta>(){{
            add(new Fruta(  "Apple",
                            "manzana",
                            R.drawable.apple_bg,
                            R.drawable.apple_ic,
                            0
            ));
            add(new Fruta(  "Banana",
                            "plátano",
                            R.drawable.banana_bg,
                            R.drawable.banana_ic,
                            0
            ));
            add(new Fruta(  "Cherry",
                            "cereza",
                            R.drawable.cherry_bg,
                            R.drawable.cherry_ic,
                            0
            ));
            add(new Fruta(  "Orange",
                            "naranja",
                            R.drawable.orange_bg,
                            R.drawable.orange_ic,
                            0
            ));
            add(new Fruta(  "Pear",
                            "pera",
                            R.drawable.pear_bg,
                            R.drawable.pear_ic,
                            0
            ));
            add(new Fruta(  "Plum",
                            "ciruela",
                            R.drawable.plum_bg,
                            R.drawable.plum_ic,
                            0
            ));
            add(new Fruta(  "Raspberry",
                            "frambuesa",
                            R.drawable.raspberry_bg,
                            R.drawable.raspberry_ic,
                            0
            ));
            add(new Fruta(  "Strawberry",
                            "fresa",
                            R.drawable.strawberry_bg,
                            R.drawable.strawberry_ic,
                            0
            ));

        }};

    }
}
