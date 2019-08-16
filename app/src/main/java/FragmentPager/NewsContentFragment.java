package FragmentPager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ludans.testlistview.R;

import java.util.ArrayList;

import domain.NewsTitle;

public class NewsContentFragment extends Fragment {

    private TextView textView;
    private ArrayList<NewsTitle> tempList;
    private static final String TAG = "NewsContentFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_news_content, container, false);
        textView = view.findViewById(R.id.fg_news_text);

        Bundle bundle = getArguments();
//        String title = bundle.getString("title");
        Log.e(TAG, "Fragment 中的值");

        NewsTitle temp = (NewsTitle) bundle.getSerializable("title");
        textView.setText(temp.getTitle());



//        传递 list集合过来，就需要这样操作
//        tempList = new ArrayList<>();
//        tempList = (ArrayList<NewsTitle>) bundle.getSerializable("title");
//        Log.e(TAG, "传过来的集合的数据:"+tempList.get(1).getTitle() );

//        textView.setText(tempList.get(0).getTitle());


//        textView.setText(bundle.getString("title"));
//        Log.e(TAG, "NewsContent传过来的值：" + bundle.getString("title"));
        return view;

    }
}
