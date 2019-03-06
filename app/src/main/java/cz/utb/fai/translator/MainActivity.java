package cz.utb.fai.translator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cz.utb.fai.translator.adapter.HistoryAdapter;
import cz.utb.fai.translator.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private RecyclerView mRecyclerViewHistory;
    private RecyclerView.Adapter mHistoryAdapter;


    private List<String> mHistory;
    private List<String> mDictionary;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mHistory = new ArrayList<String>();
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new ViewPagerAdapter(this));
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout = (TabLayout)findViewById(R.id.tableLayout);

        mTabLayout.setupWithViewPager(mViewPager);
        new PageHome(this);
        new PageDictionary(this);
        textView=(TextView)findViewById(R.id.TEST);
        textView.setMovementMethod(new ScrollingMovementMethod());

        //set history recycler view
        mRecyclerViewHistory = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerViewHistory.setHasFixedSize(true);
        LinearLayoutManager mLayoutManagerHistory = new LinearLayoutManager(this);
        mRecyclerViewHistory.setLayoutManager(mLayoutManagerHistory);

        mHistoryAdapter = new HistoryAdapter(mHistory);

        mRecyclerViewHistory.setAdapter(mHistoryAdapter);
    }

    public List<String> getHistoryList() {
        return this.mHistory;
    }

    public String getLastOfHistoryList() {
        return this.mHistory.get(mHistory.size()-1);
    }

    public RecyclerView.Adapter returnHistoryAdapter () {
        return mHistoryAdapter;
    }

    public void writeToFile(String FileName, String saveText) {
        try {
            saveText+="\r\n";
            FileOutputStream fileOutputStream = openFileOutput(FileName,MODE_APPEND);
            fileOutputStream.write(saveText.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String fileName) {
        try {
            FileInputStream fileInputStream= openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines=bufferedReader.readLine())!=null) {
                stringBuffer.append(lines + "\n");
            }

            textView.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}