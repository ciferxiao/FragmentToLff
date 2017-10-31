package com.cifer.fragmenttolff;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cifer.fragmenttolff.Fragment.CourseFragment;
import com.cifer.fragmenttolff.Fragment.MainFragment;
import com.cifer.fragmenttolff.Fragment.MyFragment;
import com.cifer.fragmenttolff.Fragment.NoteFragment;

import java.util.ArrayList;

import static com.cifer.fragmenttolff.R.drawable.my;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager viewPager;
    private RadioGroup tabGroup;
    private int mCurrentTab;
    public static final int MAIN_TAB_INDEX = 0;
    public static final int COURSE_TAB_INDEX = 1;
    public static final int NOTE_TAB_INDEX = 2;
    public static final int MY_TAB_INDEX = 3;

    private ArrayList<Fragment> mPagers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewpage);
        tabGroup = (RadioGroup) findViewById(R.id.division_bottom) ;
        tabGroup.setOnCheckedChangeListener(this);

        initPager();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTabCheckedByPosition(position) ;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager())) ;
        viewPager.setOffscreenPageLimit(3);//jiazai
    }

    private void initPager(){
        MainFragment mainFragment =new MainFragment();
        CourseFragment courseFragment = new CourseFragment();
        MyFragment myFragment = new MyFragment();
        NoteFragment noteFragment = new NoteFragment();
        mPagers = new ArrayList<Fragment>();
        mPagers.add(mainFragment);
        mPagers.add(courseFragment);
        mPagers.add(myFragment);
        mPagers.add(noteFragment);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        setTabCheckedById(i);
    }

    public void setTabCheckedById(int checkedId) {
        switch(checkedId){
            case R.id.main_content :
                mCurrentTab = MAIN_TAB_INDEX;
                viewPager.setCurrentItem(MAIN_TAB_INDEX);
                handlerDrawableTop(MAIN_TAB_INDEX) ;
                break ;
            case R.id.course_content :
                mCurrentTab = COURSE_TAB_INDEX;
                viewPager.setCurrentItem(COURSE_TAB_INDEX);
                handlerDrawableTop(COURSE_TAB_INDEX) ;
                break ;
            case R.id.note_content :
                mCurrentTab = NOTE_TAB_INDEX;
                viewPager.setCurrentItem(NOTE_TAB_INDEX);
                handlerDrawableTop(NOTE_TAB_INDEX) ;
                break ;
            case R.id.my_content:
                mCurrentTab =MY_TAB_INDEX;
                viewPager.setCurrentItem(MY_TAB_INDEX);
                handlerDrawableTop(MY_TAB_INDEX) ;
                break ;
        }
    }

    private void handlerDrawableTop(int position){
        mCurrentTab = position ;
        Drawable drawable = getResources().getDrawable(selectedDrawableIds[position]);
        drawable.setBounds(0,0,50,50);
        resetDrawableTop() ;
        ((RadioButton) tabGroup.getChildAt(position)).setCompoundDrawablesWithIntrinsicBounds(null,
                drawable, null, null) ;
    }

    // xiao add
    public void setTabCheckedByPosition(int position) {
        mCurrentTab = position;
        switch(position){
            case MAIN_TAB_INDEX :
                // mCurrentTab = CLOCK_TAB_INDEX;
                tabGroup.check(R.id.main_content);

                break ;
            case COURSE_TAB_INDEX :
                // mCurrentTab = ALARM_TAB_INDEX;
                tabGroup.check(R.id.course_content);
                break ;
            case NOTE_TAB_INDEX :
                // mCurrentTab = STOPWATCH_TAB_INDEX;
                tabGroup.check(R.id.note_content);

                break ;
            case MY_TAB_INDEX :
                // mCurrentTab = TIMER_TAB_INDEX;
                tabGroup.check(R.id.my_content);
                break ;
        }
        viewPager.setCurrentItem(position);
        handlerDrawableTop(position) ;
    }

    private void resetDrawableTop(){
        for (int i = 0; i < 4; i++) {
            Drawable drawable = getResources().getDrawable(normalDrawableIds[i]);
            //drawable.setBounds(0,0,50,50);
            ((RadioButton) tabGroup.getChildAt(i)).setCompoundDrawablesWithIntrinsicBounds(null,
                    getResources().getDrawable(normalDrawableIds[i]), null, null);
        }
    }
    private static final int[] selectedDrawableIds = {R.drawable.main_click,R.drawable.course_click ,
            R.drawable.note_click  ,R.drawable.my_click} ;

    private static final int[] normalDrawableIds = {R.drawable.main ,R.drawable.course,
            R.drawable.note , my} ;


    private class ViewPagerAdapter extends FragmentPagerAdapter{
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mPagers.get(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
