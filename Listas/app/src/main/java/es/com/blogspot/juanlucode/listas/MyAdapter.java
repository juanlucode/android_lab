package es.com.blogspot.juanlucode.listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/*
Clase MyAdapter:
Es una clase que extiende a BaseAdapter
siendo una personalización del tipo de
elementos que contendrá el ListView al que
se le relacionará.
 */
public class MyAdapter extends BaseAdapter {


    // Variables a tratar:

    // datos
    private List<Familiar> miembros;
    // contexto donde aparecerá el ListView
    private Context context;
    // referencia al layout descriptor de cada elemento
    private int layout;

    // CONSTRUCTOR
    public MyAdapter(Context context, int layout, List<Familiar> miembros){
        this.context = context;
        this.layout = layout;
        this.miembros = miembros;
    }

    @Override
    public int getCount() {
        return this.miembros.size();
    }

    @Override
    public Object getItem(int position) {
        return miembros.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        // Este método es el encargado de devolver el elemento a renderizar
        // en pantalla. Hay que tener en cuenta que aunque el elemento salga
        // de pantalla, por ejemplo, al ser desplazado por un scrollBar, seguirá
        // estando renderizado. Para que el método de devolución de elemento sea
        // óptimo, es necesario diferenciar entre elementos renderizados y no
        // renderizados.

        /*
        Para manejo de elemento se utiliza el patron ViewHolder, que la encapsulación
        del elemento dentro de una clase.
         */
        class HolderView{
            TextView nombreTextView;
            TextView parentescoTextView;
        }

        HolderView holderView;

        if ( convertView == null ){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);
            holderView = new HolderView();
            holderView.nombreTextView = (TextView) convertView.findViewById(R.id.nombreTextView);
            holderView.nombreTextView.setText(miembros.get(position).getNombre());
            holderView.parentescoTextView = (TextView) convertView.findViewById(R.id.parentescoTextView);
            holderView.parentescoTextView.setText(miembros.get(position).getParentesco());
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }
        holderView.nombreTextView.setText(this.miembros.get(position).getNombre());
        holderView.parentescoTextView.setText(this.miembros.get(position).getParentesco());
        return convertView;
    }


}
