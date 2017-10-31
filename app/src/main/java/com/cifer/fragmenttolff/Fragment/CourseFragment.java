package com.cifer.fragmenttolff.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cifer.fragmenttolff.R;

/**
 * Created by xiaojinggong on 10/30/17.
 */

public class CourseFragment extends Fragment {
    private View mview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mview == null){
            mview = inflater.inflate(R.layout.course_content,container,false);
        }
        return mview;
    }
}
