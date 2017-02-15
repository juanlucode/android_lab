package juanlucode.github.com.fruitworld2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import juanlucode.github.com.fruitworld2.R;
import juanlucode.github.com.fruitworld2.models.Fruta;

/**
 * Created by juanluis on 15/02/17.
 */

public final class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder> {

    // DECLARACIONES

    private Context context;
    private List<Fruta> frutas;
    private int layout;


    public class FrutaViewHolder extends RecyclerView.ViewHolder{
        public ImageView frutaImageView;
        public TextView nombreTextView;
        public TextView descripcionTextView;
        public TextView cantidadTextView;

        public FrutaViewHolder(View itemView) {
            super(itemView);
            this.frutaImageView = (ImageView) itemView.findViewById(R.id.frutaImageView);
            this.nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            this.descripcionTextView = (TextView) itemView.findViewById(R.id.descripcionTextView);
            this.cantidadTextView = (TextView) itemView.findViewById(R.id.cantidadTextView);
        }
    }


    // CONSTRUCTOR

    public FrutaAdapter(Context context, List<Fruta> frutas, int layout) {
        this.context = context;
        this.frutas = frutas;
        this.layout = layout;
    }

    // SOBREESCRITURAS

    @Override
    public FrutaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(this.layout, null);
        return new FrutaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FrutaAdapter.FrutaViewHolder holder, int position) {
        Picasso.with(this.context)
                .load(frutas.get(position).getImagen()).fit()
                .into(holder.frutaImageView);
        holder.nombreTextView.setText(frutas.get(position).getNombre());
        holder.descripcionTextView.setText(frutas.get(position).getDescripcion());
        holder.cantidadTextView.setText(String.valueOf(frutas.get(position).getCantidad()));
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }
}
