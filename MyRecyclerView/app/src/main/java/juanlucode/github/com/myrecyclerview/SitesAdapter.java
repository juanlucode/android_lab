package juanlucode.github.com.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanluis on 8/02/17.
 */

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.ViewHolder> {

    private ArrayList<Site> sites;
    private int layout;
    private OnItemClickListener itemClickListener;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView addressTextView;

        public ViewHolder(View site_item){
            super(site_item);
            nameTextView = (TextView) site_item.findViewById(R.id.nameTextView);
            addressTextView = (TextView) site_item.findViewById(R.id.addressTextView);
        }

        public void bind(final Site site, final OnItemClickListener listener){
            this.nameTextView.setText(site.getName());
            this.addressTextView.setText(site.getAddress());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(site, getAdapterPosition());
                }
            });
        }
    }

    public SitesAdapter(List<Site> sites, int layout, OnItemClickListener itemClickListener){
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
