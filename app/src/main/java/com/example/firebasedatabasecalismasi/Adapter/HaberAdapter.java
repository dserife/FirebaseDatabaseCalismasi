package com.example.firebasedatabasecalismasi.Adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firebasedatabasecalismasi.Model.Haber;
import com.example.firebasedatabasecalismasi.R;
import com.google.android.gms.dynamite.DynamiteModule;

import java.util.ArrayList;

public class HaberAdapter extends BaseAdapter {

    private ArrayList<Haber> haberler;
    private Context context;
    private LayoutInflater layoutInflater;

    TextView tvBaslik, tvAciklama;
    ImageView imageView;

    public HaberAdapter() {
    }

    public HaberAdapter(ArrayList<Haber> haberler, Context context) {
        this.haberler = haberler;
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return haberler.size();
    }

    @Override
    public Object getItem(int position) {

        return haberler.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=layoutInflater.inflate(R.layout.haber_satirgoruntusu,null);

        tvBaslik=v.findViewById(R.id.tvBaslik);
        tvAciklama=v.findViewById(R.id.tvAciklama);
        imageView=v.findViewById(R.id.imageView);

        tvBaslik.setText(""+haberler.get(position).getHaberBaslik());
        tvAciklama.setText(""+haberler.get(position).getHaberIcerik());
        imageView.setImageResource(R.drawable.ic_launcher_background);

        return v;
    }
}
