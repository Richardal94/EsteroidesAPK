package com.example.cfgs.esteroidesapk;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Category> items;

    public CategoryAdapter(Activity activity, ArrayList<Category> items) {
        this.activity = activity;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View vi=contentView;

        if(contentView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.item_category, null);
        }

        Category item = items.get(position);

         /*ImageView image = (ImageView) vi.findViewById(R.id.imgIcon);
       int imageResource = activity.getResources()
                .getIdentifier(String.valueOf(Uri.parse("android.resource://" + activity.getPackageName() +"/"+R.drawable.icon)), null,
                        activity.getPackageName());
        image.setImageDrawable(activity.getResources().getDrawable(
                imageResource));*/

        TextView nombre = (TextView) vi.findViewById(R.id.textoUsuario);
        nombre.setText(item.getUser());

        TextView tipo = (TextView) vi.findViewById(R.id.textoPuntos);
        tipo.setText(String.valueOf(item.getPoints()));

        return vi;
    }
}
