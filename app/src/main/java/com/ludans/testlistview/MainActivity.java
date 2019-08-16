package com.ludans.testlistview;

import android.app.ActionBar;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import adapter.NewsAdapter;
import domain.JavaBean;
import domain.NewsTitle;

public class MainActivity extends AppCompatActivity {

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
//        initData();

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
                "    },\n" +
                "    {\n" +
                "        \"title\": \"夏季生猪驱虫正当时\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"羊瘤胃臌胀咋治疗？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"夏季仔猪易腹泻 找准成因巧防治\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"8月高温高湿 大棚管理要严\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"桃树管理需排灌结合\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"苹果园管理注意五大要点\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"猕猴桃抓紧防治灰霉病\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"果树持续高温光照强时要防日烧\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"控旺、促根又降温，夏季得这样浇水\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"雨季棚室后墙咋防护\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"夏季鸡球虫病反复发作怎么办\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"蛋鸡夏季常产软壳蛋怎么办\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"夏季雨水多，养羊注意防“羊瘟”\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"高温热害可致玉米减产30%,如何预防？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"草莓定植注意事项\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"高温多雨季 防治苹果病虫害要趁早\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"提高猕猴桃品质四法\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"八月份樱桃、猕猴桃、枣树、果桑如何管理？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"马铃薯生长期内如何科学浇水？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"推广种植紫薯 加强田间管理\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"蔬菜如何促深根增产？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"掌握九法防治葡萄成熟期裂果\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"鹰嘴豆的高产种植技术详解\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"西红柿如何授粉？露天和大棚种植有何区别？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"露地番茄要加强田间管理\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"小番茄管理技术\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"番茄定植前后咋管理\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"钾肥市场新“李鬼”教你三招认清它\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"猕猴桃黄化病如何防治？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"蘑菇菌棒生长缓慢是什么原因？\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"番茄筋腐果多发 教你三招轻松搞定\"\n" +
                "    }\n" +
                "]";
        Gson gson = new Gson();
        newsTitleArrayList = gson.fromJson(json, new TypeToken<ArrayList<NewsTitle>>() {
        }.getType());

        Log.e(TAG, "newsTitleArrayList: " + newsTitleArrayList.toString());
    }

    private void initView() {
        newsAdapter = new NewsAdapter(newsTitleArrayList, mContext);
        listView.setAdapter(newsAdapter);
    }
}
