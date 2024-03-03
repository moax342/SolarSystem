package com.moax.solarsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ScrollView;
import android.widget.StackView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    CardAdapter adapter;
    List<ModelItemCardView> modelItemCardViews;
    Integer[] colors =null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    final int paddingX =150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding items to the list of modelItemCardViews to view them on the viewPager
        modelItemCardViews = new ArrayList<>();
        modelItemCardViews.add(new ModelItemCardView(R.drawable.sun,getString(R.string.The_Sun),getString(R.string.sun_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.mercury,getString(R.string.Mercury),getString(R.string.mercury_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.venus,getString(R.string.Venus),getString(R.string.venus_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.worldwide,getString(R.string.Earth),getString(R.string.Earth_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.mars,getString(R.string.Mars),getString(R.string.mars_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.jupiter,getString(R.string.jupiter),getString(R.string.Jupter_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.saturn,getString(R.string.Saturn),getString(R.string.sutran_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.uranus,getString(R.string.Uranos),getString(R.string.uranos_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.neptune,getString(R.string.Neptune),getString(R.string.neptone_Desc)));
        modelItemCardViews.add(new ModelItemCardView(R.drawable.pluto,getString(R.string.Pluto),getString(R.string.pluto_Desc)));


        //setting the adapter to the cardAdapter
        adapter = new CardAdapter(modelItemCardViews,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(paddingX,0,paddingX,0);
        viewPager.setPageTransformer(false,transformer);

        //adding colors to the background by assinging them the array list
        Integer[] color_temp ={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color10),
        };

        //passing the colors to the colors array list
        colors =color_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount()-1) && position<(colors.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
          }

         // adding the transformer to the viewPager by the below function
          ViewPager.PageTransformer transformer = new ViewPager.PageTransformer() {
              @Override
              public void transformPage(@NonNull View page, float position) {
                  float pagerWidthPx = ((ViewPager) page.getParent()).getWidth();
                  float pageWidthPx = pagerWidthPx-2*paddingX;

                  float maxVisiblePage = pagerWidthPx/pageWidthPx;
                  float center = maxVisiblePage/2f;

                  float scale;
                  if (position+0.5f<center-0.5f||position>center){
                      scale =0.8f;
                  }else{
                      float ceof;
                      if(position+0.5f<center){
                        ceof = (position+1-center)/0.5f;
                      }else{
                          ceof = (center-position)/0.5f;
                      }
                      scale =ceof*(1f-0.8f)+0.8f;
                  }
                  page.setScaleX(scale);
                  page.setScaleY(scale);
              }
          };
    }

