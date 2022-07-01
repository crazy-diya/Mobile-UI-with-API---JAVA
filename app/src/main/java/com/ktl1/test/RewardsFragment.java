package com.ktl1.test;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
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
    private List<DataModel> dataModelList = new ArrayList<>();
    private List<DataModel> dataModelList2 = new ArrayList<>();
    private CardView card3,card2,card1;
    private TextView t1,t2,t3;
    private ImageSlider imageSlider;

    public RewardsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);

        card3 = view.findViewById(R.id.card3);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t2);
        t3 = view.findViewById(R.id.t3);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView2 = view.findViewById(R.id.recycler_view2);


        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.aa,null));
        imageList.add(new SlideModel(R.drawable.aa,null));
        imageList.add(new SlideModel(R.drawable.aa,null));
        imageList.add(new SlideModel(R.drawable.aa,null));
        imageList.add(new SlideModel(R.drawable.aa,null));
        imageList.add(new SlideModel(R.drawable.aa,null));

        imageSlider.setImageList(imageList);


        rewardsAdapter = new RewardsAdapter(dataModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rewardsAdapter);

        rewardsAdapter2 = new RewardsAdapter(dataModelList2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(rewardsAdapter2);

        view.findViewById(R.id.card1).setOnClickListener(mListener);
        view.findViewById(R.id.card2).setOnClickListener(mListener);
        view.findViewById(R.id.card3).setOnClickListener(mListener);
        fetchData();



        return view;
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        boolean c1 = true,c2 = false,c3 = false;
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.card1:
                    c2 = false;
                    c3 =false;
                    c1 = !c1;
                    card1.setCardBackgroundColor(c1?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    card2.setCardBackgroundColor(c2?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    card3.setCardBackgroundColor(c3?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    t1.setTextColor(c1?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    t2.setTextColor(c2?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    t3.setTextColor(c3?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    break;
                case R.id.card2:
                    c3 =false;
                    c1 = false;
                    c2 = !c2;
                    card1.setCardBackgroundColor(c1?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    card2.setCardBackgroundColor(c2?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    card3.setCardBackgroundColor(c3?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    t1.setTextColor(c1?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    t2.setTextColor(c2?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    t3.setTextColor(c3?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    break;
                case R.id.card3:
                    c1 = false;
                    c2 = false;
                    c3 = !c3;
                    card1.setCardBackgroundColor(c1?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    card2.setCardBackgroundColor(c2?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    card3.setCardBackgroundColor(c3?Color.parseColor("#FFE7BF"):Color.TRANSPARENT);
                    t1.setTextColor(c1?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    t2.setTextColor(c2?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));
                    t3.setTextColor(c3?Color.parseColor("#FFB22A"):Color.parseColor("#B5494846"));

                    break;
            }

        }
    };

    private void fetchData() {
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

                    rewardsAdapter.notifyDataSetChanged();


                    rewardsAdapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}