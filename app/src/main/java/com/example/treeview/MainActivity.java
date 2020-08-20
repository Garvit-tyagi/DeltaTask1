package com.example.treeview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    File[] files;
    File f;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView  expandableListView;
    List<String> headers_list;
    HashMap<String,List<String>> childList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=findViewById(R.id.ex_listview);
     f =new File(Environment.getExternalStorageDirectory().getAbsolutePath());
     files =f.listFiles() ;

         showList();

         expandableListAdapter=new ExpandableListAdapter(this,headers_list,childList);
         expandableListView.setAdapter(expandableListAdapter);
    }

    private void showList() {
        headers_list=new ArrayList<String>();
        childList=new HashMap<String, List<String>>();
        if(files!=null) {
            for (int i = 0; i < files.length; i++) {
                headers_list.add(files[i].getName());
            }
//        headers_list.add("topic1");
//        headers_list.add("t2");
//        headers_list.add("t3");
            ArrayList<String> paths = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                paths.add(files[i].getAbsolutePath());
            }
            ArrayList<List<String>> child = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {

                File f1 = new File(paths.get(i));
                File[] files1 = f1.listFiles();
                List<String> l1 = new ArrayList<>();
                for (int j = 0; j < files1.length; j++) {
                    l1.add(files1[j].getName());
                }
                child.add(l1);

            }


//        List<String> child1=new ArrayList<>();
//        child1.add("c1");
//        child1.add("c2");
//        child1.add("c3");
//        List<String> child2=new ArrayList<>();
//        child2.add("c1");
//        child2.add("c2");
//        child2.add("c3");
//        List<String> child3=new ArrayList<>();
//        child3.add("c1");
//        child3.add("c2");
//        child3.add("c3");
            for (int i = 0; i < files.length; i++) {
                childList.put(headers_list.get(i), child.get(i));

            }


        }
    }
}