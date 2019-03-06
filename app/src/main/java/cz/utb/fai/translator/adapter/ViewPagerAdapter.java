package cz.utb.fai.translator.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import cz.utb.fai.translator.R;

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;

    public ViewPagerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        int resId;
// set PAGE HOME as default
        if (position == 0) {
            resId = R.id.page_home;
        } else if (position == 1) {
            resId = R.id.page_history;
        } else {
            resId = R.id.page_dictionary;
        }
        return collection.findViewById(resId);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    // obarveni aktivniho okna
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    //getPageTitle meni nazev aktualne vybrane zalozky
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getResources().getString(R.string.home);
        } else if (position == 1) {
            return mContext.getResources().getString(R.string.history);
        } else if (position == 2) {
            return mContext.getResources().getString(R.string.dictionary);
        }
        return super.getPageTitle(position);
    }
}