package com.example.akshaypall.shutterdroid;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.akshaypall.shutterdroid.com.example.akshaypall.shutterdroi.ShutterStock.SImages;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Akshay Pall on 19/05/2015.
 */
public class SImagesAdapter extends RecyclerView.Adapter<SImagesAdapter.ViewHolder> {

    private List<SImages> mImages;
    private ImageView mImageView;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView;
        }

        @Override
        public void onClick(View v) {
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_image, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SImages image = mImages.get(i);
        Picasso.with(mContext).load(image.getLargeThumbnailURL()).into(mImageView);
    }



    public SImagesAdapter(Context context, List<SImages> images) {
        mImages = images;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }
}
