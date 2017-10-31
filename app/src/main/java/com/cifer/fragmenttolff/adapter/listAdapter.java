package com.cifer.fragmenttolff.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by xiaojinggong on 10/31/17.
 * 自定义adapter
 *
 */

public class listAdapter extends ArrayAdapter {

    public listAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
