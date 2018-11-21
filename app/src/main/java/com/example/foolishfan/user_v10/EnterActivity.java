package com.example.foolishfan.user_v10;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EnterActivity extends AppCompatActivity {
    private RadioGroup navGroup;
    private String tabs[] = {"首页", "新闻", "组图", "更多"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        navGroup =(RadioGroup)findViewById(R.id.navgroup);

        navGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.radioButton1:
                        switchFragmentSupport(R.id.content,tabs[0]);
                        break;
                    case R.id.radioButton2:
                        switchFragmentSupport(R.id.content,tabs[1]);
                        break;
                    case R.id.radioButton3:
                        switchFragmentSupport(R.id.content,tabs[2]);
                        break;
                    case R.id.radioButton4:
                        switchFragmentSupport(R.id.content,tabs[3]);
                        break;
                }

            }
        });

        RadioButton btn =(RadioButton)navGroup.getChildAt(0);
        btn.toggle();
    }

    public void switchFragmentSupport(int containerId,String tag)
    {
        FragmentManager manager = getSupportFragmentManager();
        Fragment destFragment = manager.findFragmentByTag(tag);

        if(destFragment == null)
        {
            if(tag.equals(tabs[0])) destFragment = new Fragment1();
            if(tag.equals(tabs[1])) destFragment = new Fragment2();
            if(tag.equals(tabs[2])) destFragment = new Fragment3();
            if(tag.equals(tabs[3])) destFragment = new Fragment4();
        }
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(containerId,destFragment,tag);
        //ft.addToBackStack(null);
        ft.commit();
    }
}
