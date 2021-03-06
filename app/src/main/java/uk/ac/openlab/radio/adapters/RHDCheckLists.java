/*
 * Copyright (c) 2016. Kyle Montague
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package uk.ac.openlab.radio.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ArrayRes;

import java.util.ArrayList;

import uk.ac.openlab.radio.R;
import uk.ac.openlab.radio.datatypes.CheckListItem;

/**
 * Created by Kyle Montague on 25/02/16.
 */

public class RHDCheckLists {

    public static CheckListAdapter mainMenu(Context context, IRecyclerViewItemClickedListener listener){
        return listFromXML(context, listener,R.array.main_menu_titles, R.array.main_menu_icons);
    }

    public static CheckListAdapter prepareShow(Context context, IRecyclerViewItemClickedListener listener){
        return listFromXML(context, listener,R.array.prepare_show_titles, R.array.prepare_show_icons);
    }

    public static CheckListAdapter listFromXML(Context context, IRecyclerViewItemClickedListener listener, @ArrayRes int titlesResource, @ArrayRes int iconsResource){
        String[] titles = context.getResources().getStringArray(titlesResource);
        TypedArray icons = context.getResources().obtainTypedArray(iconsResource);

        if(titles.length != icons.length())
            return null;
        ArrayList<CheckListItem> items = new ArrayList<>();
        for(int x=0;x<titles.length;x++) {
            items.add(new CheckListItem(titles[x], icons.getResourceId(x,0)));
        }
        return new CheckListAdapter(items, listener);
    }

}
