package com.example.eloit.listgridviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Eloit on 2016/11/15.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> images;
    private LayoutInflater layoutInflater;

    private GridAdapter gridAdapter;


    public MyAdapter(Context context, List<Map<String, Object>> images) {
        this.context = context;
        this.images = images;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public final class GalleryItem {
        TextView name;
        GridView gridview;
        RelativeLayout head_item;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        GalleryItem gallery = null;
        if (convertView == null) {
            gallery = new GalleryItem();
            //初始化并定义各个控件
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            gallery.name = (TextView) convertView.findViewById(R.id.list_text1);
            gallery.gridview = (GridView) convertView.findViewById(R.id.list_grid);

            convertView.setTag(gallery);

        } else {
            gallery = (GalleryItem) convertView.getTag();
        }

        gallery.name.setText((String) images.get(position).get("name"));

        //从main activity中获取到的list，其中再包含了对应list所对应的map数据源
        List<Map<String, Object>> grid_img = (List<Map<String, Object>>) images.get(position).get("info");


        for (Map<String, Object> m : grid_img) {
            for (String k : m.keySet()) {
//                System.out.println(k + " : " + m.get(k));
                Log.i("=======", k + ":" + m.get(k) + "||" + grid_img.size());
            }

        }
        gridAdapter = new GridAdapter(context, grid_img);
        gallery.gridview.setAdapter(gridAdapter);


        return convertView;
    }


}
