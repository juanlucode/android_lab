package es.com.blogspot.juanlucode.fruitworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import es.com.blogspot.juanlucode.fruitworld.R;
import es.com.blogspot.juanlucode.fruitworld.models.Fruta;

/**
 * Created by juanluis on 6/02/17.
 */

final public class FrutaAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruta> frutas;

    public FrutaAdapter(Context context, int layout, List<Fruta> frutas){
        this.context = context;
        this.layout = layout;
        this.frutas = frutas;
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = this.frutas.size();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        Object obj = null;
        try {
            obj = frutas.get(position);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }

    @Override
    public long getItemId(int id) {

        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        class HolderView{
            public TextView nombre;
            public TextView origen;
            public ImageView icono;
        }

        HolderView holderView;

        // comprobamos si el convertView está ya renderizado
        if ( convertView == null ){
            // sin renderizar
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);
            holderView = new HolderView();
            holderView.nombre = (TextView) convertView.findViewById(R.id.nombreTextView);
            holderView.origen = (TextView) convertView.findViewById(R.id.origenTextView);
            holderView.icono = (ImageView) convertView.findViewById(R.id.iconoImageView);
            convertView.setTag(holderView);

        } else {
            // renderizado
            holderView = (HolderView) convertView.getTag();
        }

        holderView.nombre.setText(frutas.get(position).getNombre());
        holderView.origen.setText(frutas.get(position).getOrigen());
        holderView.icono.setImageResource(frutas.get(position).getIcono());


        return convertView;
    }
}
