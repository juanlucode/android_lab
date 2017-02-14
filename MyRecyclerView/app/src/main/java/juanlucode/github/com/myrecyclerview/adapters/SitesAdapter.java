package juanlucode.github.com.myrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import juanlucode.github.com.myrecyclerview.R;
import juanlucode.github.com.myrecyclerview.models.Site;

/**
 * Created by juanluis on 8/02/17.
 */

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Site> sites;
    private int layout;
    private OnItemClickListener itemClickListener;


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView addressTextView;
        public ImageView logoImageView;

        public ViewHolder(View site_item){
            super(site_item);
            nameTextView = (TextView) site_item.findViewById(R.id.nameTextView);
            addressTextView = (TextView) site_item.findViewById(R.id.addressTextView);
            logoImageView = (ImageView) site_item.findViewById(R.id.logoImageView);
        }

        public void bind(final Site site, final OnItemClickListener listener){
            this.nameTextView.setText(site.getName());
            this.addressTextView.setText(site.getAddress());
            Picasso.with(SitesAdapter.this.context).load(site.getLogo()).fit().into(this.logoImageView);
            //this.logoImageView.setImageResource(site.getLogo());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(site, getAdapterPosition());
                }
            });
        }
    }

    public SitesAdapter(    Context context,
                            List<Site> sites,
                            int layout,
                            OnItemClickListener itemClickListener){
        this.context = context;
        this.sites = (ArrayList<Site>) sites;
        this.layout = layout;
        this.itemClickListener = itemClickListener;

    }


    @Override
    public SitesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(this.layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SitesAdapter.ViewHolder holder, int position) {
        holder.bind(sites.get(position), this.itemClickListener);
    }

    @Override
    public int getItemCount() {

        return sites.size();
    }

    public interface OnItemClickListener{
        void onItemClick(Site site, int position);
    }

}
