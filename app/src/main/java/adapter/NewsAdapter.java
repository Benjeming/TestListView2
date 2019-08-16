package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ludans.testlistview.R;

import java.util.ArrayList;

import domain.NewsTitle;

public class NewsAdapter extends BaseAdapter {
    private ArrayList<NewsTitle> mData;
    private Context mContext;
    private static final String TAG = "NewsAdapter";

    public class ViewHodler {
        TextView textView;
    }

    public NewsAdapter(ArrayList<NewsTitle> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler = null;
        if (convertView == null) {
            viewHodler = new ViewHodler();

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);

            viewHodler.textView = (TextView) convertView.findViewById(R.id.item_hello);
            viewHodler.textView.setTextSize(16);
            viewHodler.textView.setGravity(1);
            convertView.setTag(viewHodler);
        } else {
            //如果不将值传给 viewHodler,将会报空指针异常
            viewHodler = (ViewHodler) convertView.getTag();
        }

        viewHodler.textView.setText(mData.get(position).getTitle());

        return convertView;
    }
}
