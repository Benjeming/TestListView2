

# 2019/8/16总结

## Activity页面切换

### ListView——> Fragment
1. 怎么进行页面切换？

   - 使用  **帧布局** ，新建一个Fragment 类 ，再为其绑定一个FrameLayout 布局.

     fg_news_content.xml
     
     ```xml
     <?xml version="1.0" encoding="utf-8"?><LinearLayout 	xmlns:android="http://schemas.android.com/apk/res/android"    	    android:layout_width="match_paren"                                            android:layout_height="match_parent"  
      android:layout_marginTop="400dp"  
      android:orientation="vertical">  
         <TextView        
                   android:id="@+id/fg_news_text"        
                   android:layout_width="match_parent"    
                   android:layout_height="wrap_content"        
                   android:gravity="center_horizontal"  
                   android:text="Content页面"    
                   android:textSize="16dp" />
</LinearLayout>
     ```
     
   - 新建一个NewsContent类，继承于Fragment 类，那么就要重写 Fragment 的方法。**onCreateView（）**方法。
   
     其中 inflater.inflater()方法是绑定**xml布局** , 如果后面两个参数设置成**null** 将会出现 在视图中文字重叠。
   
     Bundle 部分 ，是进行数据 传输的。
   
     
   
     ```java
      public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fg_news_content, container, false);
             textView = view.findViewById(R.id.fg_news_text);
             Bundle bundle = getArguments();
          
             NewsTitle temp = (NewsTitle) bundle.getSerializable("title");
             textView.setText(temp.getTitle());
             return view;
      }
     ```
   
     





## Activity数据传递

### Bundle传值

1. 传数据部分，使用了Bundle传值，其中Bundle传值不仅能传**对象**，而且能传 **List集合**.

   - 其中有个方法 ：

     ```java
     bundle.putSerializable("title", newsTitleArrayList.get(position));
     ```

     这个方法 就是将 传输**对象** ，传输对象还需要进行一个设置，就是在JavaBean 这个类中继承**Serializable 接口**

     ```java
     public class NewsTitle implements Serializable
     ```

   - 如果是 **List集合**的话就不需要继承这个接口了.

     传值部分

     ```java
     	  Bundle bundle = new Bundle();
           bundle.putSerializable("title", newsTitleArrayList.get(position));
           newsContent.setArguments(bundle);
     ```

     接受部分：

     ```java
             Bundle bundle = getArguments();
             NewsTitle temp = (NewsTitle) bundle.getSerializable("title");
     ```

     

## 运行效果图

![TestListView](TestListView.gif)
