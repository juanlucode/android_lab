package juanlucode.github.com.realmapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import juanlucode.github.com.realmapp.R;
import juanlucode.github.com.realmapp.models.Note;

/**
 * Created by juanluis on 22/02/17.
 */

public class NoteAdapter extends BaseAdapter {

    private List<Note> notesList;
    int layout;
    Context context;

    private class ViewHolder{
        TextView noteDescriptionTextView;
        TextView noteCreatedAtTextView;
    }

    /*
    CONSTRUCTOR
     */
    public NoteAdapter(List<Note> notesList, int layout, Context context){
        this.notesList = notesList;
        this.layout = layout;
        this.context = context;

    }

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Note getItem(int position) {

        return notesList.get(position);
    }

    @Override
    public long getItemId(int id) {

        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if ( convertView == null ){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(this.context).inflate(layout, null);
            viewHolder.noteDescriptionTextView =
                    (TextView) convertView.findViewById(R.id.noteDescriptionTextView);
            viewHolder.noteCreatedAtTextView =
                    (TextView) convertView.findViewById(R.id.noteCreatedAtTextView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.noteDescriptionTextView.setText(notesList.get(position).getDescription());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        viewHolder.noteCreatedAtTextView.setText(
                dateFormat.format(notesList.get(position).getCreateAt())
        );
        return convertView;
    }
}
