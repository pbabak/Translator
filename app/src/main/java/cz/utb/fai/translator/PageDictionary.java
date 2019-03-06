package cz.utb.fai.translator;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class PageDictionary implements View.OnClickListener{
    private MainActivity mActivity;
    private Button mShow;
    private Spinner mInputSpinner;
    private Spinner mOutputSpinner;
    private String[] mAbbrs;

    public PageDictionary(MainActivity activity){
        mActivity = activity;
        mAbbrs = activity.getResources().getStringArray(R.array.languages_abbr);
        mShow = (Button)activity.findViewById(R.id.btnShow);
        mShow.setOnClickListener(this);
        mInputSpinner = (Spinner)activity.findViewById(R.id.inputSpinner1);

        mInputSpinner.setSelection(0); // Czech
        mOutputSpinner = (Spinner)activity.findViewById(R.id.outputSpinner1);
        mOutputSpinner.setSelection(1); //  English
    }

    public void onClick(View view) {
        int inputPos = mInputSpinner.getSelectedItemPosition();
        int outPos = mOutputSpinner.getSelectedItemPosition();
        switch (view.getId()) {
            case R.id.btnShow:
                mActivity.readFromFile(mAbbrs[inputPos] + "To" + mAbbrs[outPos] + ".txt");
                break;

        }
    }
}