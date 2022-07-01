package com.ktl1.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ktl1.test.model.DataModel;
import com.ktl1.test.model.Rewards;
import com.ktl1.test.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RewardsFragment extends Fragment {


    private RewardsAdapter rewardsAdapter, rewardsAdapter2;
    private RecyclerView recyclerView, recyclerView2;
//    private ProgressBar progressBar;
    private List<DataModel> dataModelList = new ArrayList<>();
    private List<DataModel> dataModelList2 = new ArrayList<>();

    public RewardsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView2 = view.findViewById(R.id.recycler_view2);
//        progressBar = view.findViewById(R.id.progress_bar);

        rewardsAdapter = new RewardsAdapter(dataModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rewardsAdapter);

        rewardsAdapter2 = new RewardsAdapter(dataModelList2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(rewardsAdapter2);

        fetchData();

        return view;
    }

    private void fetchData() {
//        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getData().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
//
                    List<DataModel> ModelList = response.body();

                    for (DataModel dd : ModelList) {
                        if(dd.isIs_completed()){
                            dataModelList.add(dd);
                        }else{
                            dataModelList2.add(dd);
                        }
                    }

                    System.out.println(dataModelList.size());
                    System.out.println(dataModelList2.size());

//                    dataModelList.addAll(response.body());
                    rewardsAdapter.notifyDataSetChanged();


//                    dataModelList2.addAll(response.body());
                    rewardsAdapter2.notifyDataSetChanged();
//                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
//                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}