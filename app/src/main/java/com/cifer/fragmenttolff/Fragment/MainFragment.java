package com.cifer.fragmenttolff.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.cifer.fragmenttolff.R;
import com.cifer.fragmenttolff.adapter.HorizontalPagerAdapter;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;

/**
 * Created by xiaojinggong on 10/30/17.
 */

public class MainFragment extends Fragment implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private View mview;
    private ViewPager mviewpager;
    private HorizontalInfiniteCycleViewPager hviewpager;
    private RadioGroup radioGroup;

    private ArrayList<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mview == null){
            mview = inflater.inflate(R.layout.main_content,container,false);
            hviewpager = (HorizontalInfiniteCycleViewPager)mview.findViewById(R.id.horizonalviewpager);
            mviewpager = (ViewPager)mview.findViewById(R.id.coursepager);
            radioGroup = (RadioGroup)mview.findViewById(R.id.radio);
            initPager();
            hviewpager.setAdapter(new HorizontalPagerAdapter(getContext(),false));

            // 轮盘的设置方法
            //https://github.com/Devlight/InfiniteCycleViewPager
            //github 上有开源项目 根据需要的大小设置
            hviewpager.setMaxPageScale(1.2F);//第一个view 的大小

            hviewpager.setMinPageScale(0.5F);//除第一个view的大小
            hviewpager.setCenterPageScaleOffset(10.0F);
            hviewpager.setMinPageScaleOffset(5.0F);
            //hviewpager.setCenterPageScaleOffset(30.0F);
            //hviewpager.setMinPageScaleOffset(5.0F);
           // hviewpager.setOnInfiniteCyclePageTransformListener(...);




            mviewpager.setAdapter(new Viewpageradapetofcourse(getFragmentManager()));
            mviewpager.setOffscreenPageLimit(1);


        }


        return mview;
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.lastest:
                mviewpager.setCurrentItem(0);
                break;
            case R.id.hotest:
                mviewpager.setCurrentItem(1);
                break;
        }
    }

    private void initPager(){
        CourseNew courseNew = new CourseNew();
        CourseHot courseHot = new CourseHot();
        list = new ArrayList<>();
        list.add(courseNew);
        list.add(courseHot);
        mviewpager.setCurrentItem(0);
    }

    private class Viewpageradapetofcourse extends FragmentPagerAdapter {
        public Viewpageradapetofcourse(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
