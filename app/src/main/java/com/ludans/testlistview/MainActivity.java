package com.ludans.testlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import FragmentPager.NewsContentFragment;
import adapter.NewsAdapter;
import domain.NewsTitle;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private NewsAdapter newsAdapter;
    private ArrayList<NewsTitle> newsTitleArrayList = null;
    private Context mContext = null;
    private static final String TAG = "MainActivity";
    private Object getHandler = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        listView = findViewById(R.id.list_item);

        jsonTest();

        initView();


    }

    private void jsonTest() {
        newsTitleArrayList = new ArrayList<>();
        String json = "[\n" +
                "    {\n" +
                "        \"title\": \"“利奇马”台风过后加强蔬菜生产管理技术指导意见\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"养鸡备点儿保健料\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"种鸡淘汰有时间\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"猪身上起红斑点怎么办？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"兔螨病该咋防治\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"养猪，饲料选用学问多\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"八月，苹果园补钾正当时\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"猕猴桃秋季修剪做好四点\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"柑橘秋季咋防裂果\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"果园秋季管理要点\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"封闭式除草剂 什么时间喷最合适\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"四类缓控释肥，你了解吗？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"苹果膨大期 施肥要科学\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"暴雨天气 养殖场如何做好防范工作\"\n" +
                "    }]";
        Gson gson = new Gson();
        newsTitleArrayList = gson.fromJson(json, new TypeToken<ArrayList<NewsTitle>>() {
        }.getType());

        Log.e(TAG, "newsTitleArrayList: " + newsTitleArrayList);
    }

    private void initView() {

        newsAdapter = new NewsAdapter(newsTitleArrayList, mContext);
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "点击了第" + position + "标签", Toast.LENGTH_LONG).show();

        NewsContentFragment newsContent = new NewsContentFragment();
        //      Fragment管理器
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fg = fm.beginTransaction();
//        传递数据
        Bundle bundle = new Bundle();
//        bundle.putString("title", "标题1");
//        传递List集合中的相应的对象过去
        bundle.putSerializable("title", newsTitleArrayList.get(position));
//        传递List集合
// bundle.putSerializable("title",newsTitleArrayList);
        newsContent.setArguments(bundle);

        fg.replace(R.id.fl_content, newsContent);
        fg.commit();
    }
}
