package juanlucode.github.com.realmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import juanlucode.github.com.realmapp.R;
import juanlucode.github.com.realmapp.models.Board;

/**
 * Created by juanluis on 20/02/17.
 */

public class BoardAdapter extends BaseAdapter {

    private List<Board> boards;
    private int layout;
    private Context context;

    private class ViewHolder{

        public TextView titleTextView;
        public TextView notesTextView;
        public TextView dateTextView;
    }

    public BoardAdapter(List<Board> boards, int layout, Context context) {

        this.boards = boards;
        this.layout = layout;
        this.context = context;

    }


    @Override
    public int getCount() {

        return this.boards.size();
    }

    @Override
    public Board getItem(int position) {

        return boards.get(position);
    }

    @Override
    public long getItemId(int id) {

        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = (View) LayoutInflater.from(this.context).inflate(this.layout, null);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            viewHolder.notesTextView = (TextView) convertView.findViewById(R.id.notesTextView);
            viewHolder.dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTextView.setText(this.boards.get(position).getTitle());
        int totalNotes = boards.get(position).getNotes().size();
        StringBuilder stringNotes = new StringBuilder();
        if (totalNotes == 1) {
            stringNotes.append(totalNotes).append(" note.");
        } else {
            stringNotes.append(totalNotes).append(" notes.");
        }
        viewHolder.notesTextView.setText(stringNotes.toString());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        viewHolder.dateTextView.setText(dateFormat.format(boards.get(position).getCreateAt()));

        return convertView;
    }
}
