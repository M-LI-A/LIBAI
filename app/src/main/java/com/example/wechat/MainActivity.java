package com.example.wechat;



import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.app.Fragment;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends Activity implements View.OnClickListener {

    private Fragment mTab01=new weixinFragment();
    private Fragment mTab02=new friendFragment();
    private Fragment mTab03=new contactFragment();
    private Fragment mTab04=new settingFragment();
    private FragmentManager fm;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabContact;
    private LinearLayout mTabSetting;

    private ImageButton mImgWeixin;
    private ImageButton mImgFriend;
    private ImageButton mImgContact;
    private ImageButton mImgSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        setselect(0);
        initEvent();
    }
    private void initFragment(){
        fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void initView(){
        mTabWeixin=(LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFriend=(LinearLayout)findViewById(R.id.id_tab_friend);
        mTabContact=(LinearLayout)findViewById(R.id.id_tab_contact);
        mTabSetting=(LinearLayout)findViewById(R.id.id_tab_setting);

        mImgWeixin=(ImageButton)findViewById(R.id.id_tab_weixin_img);
        mImgFriend=(ImageButton)findViewById(R.id.id_tab_friend_img);
        mImgContact=(ImageButton)findViewById(R.id.id_tab_contact_img);
        mImgSetting=(ImageButton)findViewById(R.id.id_tab_setting_img);
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    private void setselect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgContact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch(v.getId())
        {
            case R.id.id_tab_weixin:
                setselect(0);
                break;
            case R.id.id_tab_friend:
                setselect(1);
                break;
            case R.id.id_tab_contact:
                setselect(2);
                break;
            case R.id.id_tab_setting:
                setselect(3);
                break;
            default:
                break;
        }
    }

    public void resetImg(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFriend.setImageResource(R.drawable.tab_find_frd_normal);
        mImgContact.setImageResource(R.drawable.tab_address_normal);
        mImgSetting.setImageResource(R.drawable.tab_settings_normal);
    }//使图标变灰

    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }//监听函数
}
