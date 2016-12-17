package com.example.maksim.newsproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maksim.newsproject.Model.ModelNews;
import com.example.maksim.newsproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Maksim on 17.12.2016.
 */

public class NewsAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<ModelNews> p;

    public NewsAdapter(Context context, ArrayList<ModelNews> post) {
        ctx = context;
        p = post;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return p.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return p.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.news_list, parent, false);
        }

        //Заполняем новость
        String url = p.get(position).getUrlsToLogos().getSmall();
        String title = p.get(position).getName();
        String content = p.get(position).getDescription();
        String country = p.get(position).getCountry();
        String category = p.get(position).getCategory();
        ImageView img;


        ((TextView) view.findViewById(R.id.title)).setText(title);
        ((TextView) view.findViewById(R.id.content)).setText(content);
        ((TextView) view.findViewById(R.id.country)).setText("Страна: "+country);
        ((TextView) view.findViewById(R.id.category)).setText("Категория: "+category);
        img = ((ImageView) view.findViewById(R.id.image));

        Picasso.with(ctx)
                .load(url)
                .into(img);
        return view;

    }

}
