package com.example.application.fragment;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application.Model;
import com.example.application.Name;
import com.example.application.R;
import com.example.application.RetrofitConnection;
import com.example.application.dto;
import com.example.application.recycler.ItemAdapter;
import com.example.application.recycler.hoItemAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<Name> nameArrayList = new ArrayList<>();
    ArrayList<Model.Contents> lisss = new ArrayList<>();

    JsonObject jsonObject = new JsonObject();
    JsonArray array = new JsonArray();
    JsonArray array1 = new JsonArray();
    RecyclerView recyclerView;

    RecyclerView recyclerView2;
    ItemAdapter adapter;

    TextView textView ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first,container,false);

        textView = view.findViewById(R.id.text_re);

        RetrofitConnection.getApi().DayInfo().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model model = response.body();
                Model.ResultModel model1 = model.getResult();
                Log.d("model1",model1.getTotal());
                ArrayList<Model.Contents> contents = model1.getContents();
                for(int i = 0 ; i < contents.size() ; i++){
                    lisss.add(contents.get(i));
                }



                 adapter = new ItemAdapter(lisss);

                recyclerView.setAdapter(adapter);



                adapter.setOnClickListener(new ItemAdapter.onClickListener() {
                    @Override
                    public void onItem(String item) {
                        Toast.makeText(getContext(), item, Toast.LENGTH_SHORT).show();
                    }
                });



                Log.d("contents",contents.get(0).getId());
                textView.setText(model.getResponse().toString());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("retrofit",t.toString());
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);

        // Inflate the layout for this fragment

        PackageManager pm = getContext().getPackageManager();
        List<ApplicationInfo> packageInfos = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo applicationInfo : packageInfos){


//            list.add(applicationInfo.loadLabel(pm).toString());

            if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1){
                /* == 0 true 사용자 앱 , false =  시스템 앱 */
                list.add(applicationInfo.loadLabel(pm).toString());


                Log.d("AppList",applicationInfo.loadLabel(pm).toString());
            }else {
//                list.add(applicationInfo.packageName+applicationInfo.flags);
                Log.d("AppList",applicationInfo.packageName);
            }



        }

        nameArrayList.add(new Name("이름 1",1));
        nameArrayList.add(new Name("이름 2",2));
        nameArrayList.add(new Name("이름 3",3));
        nameArrayList.add(new Name("이름 4",4));
        nameArrayList.add(new Name("이름 5",5));
        nameArrayList.add(new Name("이름 6",6));
        nameArrayList.add(new Name("이름 7",7));
        nameArrayList.add(new Name("이름 8",8));
        nameArrayList.add(new Name("이름 9",9));
        nameArrayList.add(new Name("이름 10",10));
        nameArrayList.add(new Name("이름 11",11));
        nameArrayList.add(new Name("이름 12",12));
        nameArrayList.add(new Name("이름 13",13));
        nameArrayList.add(new Name("이름 14",14));








//        가로 Layout Adapter
        hoItemAdapter adapter1 = new hoItemAdapter(list);

        adapter1.setClickListener(new hoItemAdapter.onClickListener() {
            @Override
            public void onCount(String count) {
                Toast.makeText(getContext(),count,Toast.LENGTH_SHORT).show(); }
        });

        recyclerView2.setAdapter(adapter1);



        return view;
    }

}