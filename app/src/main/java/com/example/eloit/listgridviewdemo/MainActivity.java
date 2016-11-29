package com.example.eloit.listgridviewdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends Activity {


    private ListView listView;
    private MyAdapter myAdapter;
    private Context context;

    List<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();
    List<Map<String, Object>> mmlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        //获取activity的context
        context = this;
        listView = (ListView) findViewById(R.id.list_view1);
        //取得数据源
        mlist = getData();
        //将数据源对应给list
        myAdapter = new MyAdapter(context, mlist);
        //将自定义的listview界面匹配给listview
        listView.setAdapter(myAdapter);

    }


    private List<Map<String, Object>> getData() {

        mmlist = getDetailData();

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "AAA");
        map.put("info", mmlist);
        data.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "BBB");
        map.put("info", mmlist);
        data.add(map);

        return data;
    }

    //对应list view中各item的图片
    public List<Map<String,Object>> getDetailData() {
        List<Map<String,Object>> img_data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("img",R.drawable.firekeeper);
        img_data.add(map);

        map = new HashMap<>();
        map.put("img",R.drawable.natoli);
        img_data.add(map);

        map = new HashMap<>();
        map.put("img",R.drawable.zhizi);
        img_data.add(map);
        return img_data;
    }
}
