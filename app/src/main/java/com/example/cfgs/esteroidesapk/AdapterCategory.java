package com.example.cfgs.esteroidesapk;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategory extends BaseAdapter{

    static class ViewHolder
    {
        TextView tvUsuari;
        TextView tvScore;
    }
    private static final String TAG = "CustomAdapter";
    private static int convertViewCounter = 0;

    private ArrayList<Category> data;
    private LayoutInflater inflater = null;

    public AdapterCategory(Context c, ArrayList<Category> d)
    {
        Log.v(TAG, "Constructing CustomAdapter");

        this.data = d;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount()
    {
        Log.v(TAG, "in getCount()");
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        Log.v(TAG, "in getItem() for position " + position);
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        Log.v(TAG, "in getItemId() for position " + position);
        return position;
    }
    @Override
    public int getViewTypeCount()
    {
        Log.v(TAG, "in getViewTypeCount()");
        return 1;
    }

    @Override
    public int getItemViewType(int position)
    {
        Log.v(TAG, "in getItemViewType() for position " + position);
        return 0;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder holder;

        Log.v(TAG, "in getView for position " + position + ", convertView is "
                + ((convertView == null) ? "null" : "being recycled"));

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_score, null);

            convertViewCounter++;
            Log.v(TAG, convertViewCounter + " convertViews have been created");

            holder = new ViewHolder();

            holder.tvScore = (TextView) convertView
                    .findViewById(R.id.textoPuntos);
            holder.tvUsuari = (TextView) convertView
                    .findViewById(R.id.textoUsuari);

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        Category d = (Category) getItem(position);
        // Setting all values in listview
        holder.tvScore.setText(data.get(position).getPoints());
        holder.tvUsuari.setText(data.get(position).getUser());

        return convertView;
    }

}

