package com.example.wechat;

import android.content.Context;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class friendFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> myList = new ArrayList<>();
    private Context context;
    private adapter_friend adapter;

    public friendFragment() {
        // Required empty public constructor
    }

    private void initData(){
        myList.add("亚特兰大老鹰");
        myList.add("夏洛特黄蜂");
        myList.add("迈阿密热火");
        myList.add("奥兰多魔术");
        myList.add("华盛顿奇才");
        myList.add("波士顿凯尔特人");
        myList.add("布鲁克林篮网");
        myList.add("纽约尼克斯");
        myList.add("费城76人");
        myList.add("多伦多猛龙");
        myList.add("芝加哥公牛");
        myList.add("克里夫兰骑士");
        myList.add("底特律活塞");
        myList.add("印第安纳步行者");
        myList.add("密尔沃基雄鹿");
        myList.add("达拉斯独行侠");
        myList.add("休斯顿火箭");
        myList.add("孟菲斯灰熊");
        myList.add("新奥尔良鹈鹕");
        myList.add("圣安东尼奥马刺");
        myList.add("丹佛掘金");
        myList.add("明尼苏达森林狼");
        myList.add("俄克拉荷马城雷霆");
        myList.add("波特兰开拓者");
        myList.add("犹他爵士");
        myList.add("金州勇士");
        myList.add("洛杉矶快船");
        myList.add("洛杉矶湖人");
        myList.add("菲尼克斯太阳");
        myList.add("萨克拉门托国王");
    }

    private void initView2(){
        context=this.getActivity();
        adapter=new adapter_friend(context,myList);

        LinearLayoutManager manager2=new LinearLayoutManager(context);
        manager2.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager2);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.tab02, container, false);
        recyclerView=view.findViewById(R.id.rcv2);
        initData();
        initView2();

        return view;
    }

}
