package com.moax.solarsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class CardAdapter extends PagerAdapter {

    private List<ModelItemCardView> modelItemCardViews;
    private LayoutInflater layoutInflater;
    private Context context;

    public CardAdapter(List<ModelItemCardView> modelItemCardViews, Context context) {
        this.modelItemCardViews = modelItemCardViews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelItemCardViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater =LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.planets_viewcards,container,false);

        ImageView imageView;
        TextView title,Desc;

        imageView = view.findViewById(R.id.planetImage);
        title = view.findViewById(R.id.planteNameText);
        Desc = view.findViewById(R.id.planetDesc);

        imageView.setImageResource(modelItemCardViews.get(position).getImage());
        title.setText(modelItemCardViews.get(position).getTitle());
        Desc.setText(modelItemCardViews.get(position).getDesc());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
