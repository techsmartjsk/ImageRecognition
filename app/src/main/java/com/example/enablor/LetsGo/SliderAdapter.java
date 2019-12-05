package com.example.enablor.LetsGo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.enablor.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context = context;
    }
    public int[] slideimages={
            R.drawable.man,
            R.drawable.meninblack,
            R.drawable.ola
    };
    public String[] slideheadings={
          "Slide 1","Slide 2","Slide 3"
    } ;

    @Override
    public int getCount() {
        return slideheadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.slideview);
        TextView textView= (TextView) view.findViewById(R.id.slideheading);


        imageView.setImageResource(slideimages[position]);
        textView.setText(slideheadings[position]);

        container.addView(view);
        return view;

    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((RelativeLayout)object);
    }
}
