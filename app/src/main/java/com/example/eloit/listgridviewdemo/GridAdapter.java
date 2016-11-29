package com.example.eloit.listgridviewdemo;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Eloit on 2016/11/25.
 */
public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> images;
    private LayoutInflater layoutInflater;

    public GridAdapter(Context context, List<Map<String, Object>> images) {
        this.context = context;
        this.images = images;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public final class GalleryItem {
        private ImageView imgs;
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
            //获取item地址
            convertView = layoutInflater.inflate(R.layout.list_gridview_item, null);
            gallery.imgs = (ImageView) convertView.findViewById(R.id.image_gallery_title);

            convertView.setTag(gallery);

        } else {
            gallery = (GalleryItem) convertView.getTag();
        }
        //获取图片信息,list<Bitmap>


        int img_url = (int) images.get(position).get("img");
        Log.i("Grid_Img::::::::", img_url + "//r");

        gallery.imgs.setImageResource((int) images.get(position).get("img"));

        return convertView;
    }
}
