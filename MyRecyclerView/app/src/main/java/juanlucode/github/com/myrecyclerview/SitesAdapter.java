package juanlucode.github.com.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanluis on 8/02/17.
 */

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.ViewHolder> {

    private ArrayList<Site> sites;
    private int layout;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView addressTextView;

        public ViewHolder(View site_item){
            super(site_item);
            nameTextView = (TextView) site_item.findViewById(R.id.nameTextView);
            addressTextView = (TextView) site_item.findViewById(R.id.addressTextView);
        }
    }

    public SitesAdapter(List<Site> sites, int layout){
        this.sites = (ArrayList<Site>) sites;
        this.layout = layout;

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
        holder.nameTextView.setText(sites.get(position).getName());
        holder.addressTextView.setText(sites.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }



}
