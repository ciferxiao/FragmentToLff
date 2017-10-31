package com.cifer.fragmenttolff.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cifer.fragmenttolff.R;

/**
 * Created by xiaojinggong on 10/30/17.
 */

public class CourseHot extends Fragment {
    private View mview;
    ListView listView_new;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mview == null){
            mview = inflater.inflate(R.layout.course_new,container,false);
        }
        listView_new = (ListView)mview.findViewById(R.id.list_hot);
       // listView_new.setAdapter(new SimpleAdapter(getContext(),));
        return mview;
    }
}
