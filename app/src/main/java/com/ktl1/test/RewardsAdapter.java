package com.ktl1.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.ktl1.test.model.DataModel;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.ViewHolder> {

    private List<DataModel> dataModelList;
    int[] sampleImage = {};

    public RewardsAdapter(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.reward_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.crdView2.setBackgroundResource(R.drawable.detail_card);
        holder.title.setText(dataModelList.get(position).getTitle());
        holder.description.setText(dataModelList.get(position).getSub_title());
        holder.btnText.setText(dataModelList.get(position).isIs_completed() ? "Completed" : "Not Completed");
        holder.btn.setCardBackgroundColor(dataModelList.get(position).isIs_completed() ? Color.parseColor("#25A363") : Color.parseColor("#9B9B9D"));
        holder.date.setText(dataModelList.get(position).getExpire_date());
        String link = dataModelList.get(position).getImage().replace("p:", "ps:");
        Picasso.get().load(link).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, description, date, btnText;
        CardView btn, crdView2;
        //        Carousel carousel;
//        ImageSlider imageSlider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            carousel = itemView.findViewById(R.id.carouselView);
//            imageSlider = itemView.findViewById(R.id.image_slider);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.crd_title);
            description = itemView.findViewById(R.id.crd_dec);
            btnText = itemView.findViewById(R.id.btn_text);
            date = itemView.findViewById(R.id.date);
            btn = itemView.findViewById(R.id.button_id);
            crdView2 = itemView.findViewById(R.id.cardView2);
        }
    }

}
