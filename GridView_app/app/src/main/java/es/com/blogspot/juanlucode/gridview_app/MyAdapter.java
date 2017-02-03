package es.com.blogspot.juanlucode.gridview_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by juanluis on 3/02/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Tech> datos;


    public MyAdapter(Context context, int layout, List<Tech> datos){
        this.context = context;
        this.layout = layout;
        this.datos = (ArrayList<Tech>) datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int id) {

        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        class TechGridHolderView {

            public TextView name;
            public TextView field;
        }

        TechGridHolderView techHolderView;

        // comprobamos si el elemento está renderizado
        if (convertView == null){
            // sin renderizar
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout,null);
            techHolderView = new TechGridHolderView();
            techHolderView.name = (TextView) convertView.findViewById(R.id.nameTextView);
            techHolderView.field = (TextView) convertView.findViewById(R.id.fieldTextView);
            convertView.setTag(techHolderView);
        } else {
            // ya está renderizado
            techHolderView = (TechGridHolderView) convertView.getTag();
        }


        techHolderView.name.setText(this.datos.get(position).getName());
        techHolderView.field.setText(this.datos.get(position).getField());

        return convertView;
    }
}
