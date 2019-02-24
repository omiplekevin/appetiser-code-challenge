package com.android.omiplekevin.appetiserplay.helper.adapter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.android.omiplekevin.appetiserplay.R;
import com.android.omiplekevin.appetiserplay.data.model.EntityModel;
import com.android.omiplekevin.appetiserplay.data.model.SearchResponseModel;
import com.android.omiplekevin.appetiserplay.view.DetailActivity;
import com.android.omiplekevin.appetiserplay.view.HomeActivity;
import com.android.omiplekevin.appetiserplay.view.viewholder.CardTypeOneViewHolder;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class EntityAdapter extends RecyclerView.Adapter<CardTypeOneViewHolder> {

    private Context context;
    private SearchResponseModel searchResponseModel;

    public EntityAdapter(Context context, SearchResponseModel searchResponseModel) {
        this.context = context;
        this.searchResponseModel = searchResponseModel;
    }

    @NonNull
    @Override
    public CardTypeOneViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_entity_detail, viewGroup, false);
        return new CardTypeOneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final @NonNull CardTypeOneViewHolder viewHolder, final int position) {
        EntityModel entity = this.searchResponseModel.getTrackSearchResult().get(position);
        Picasso.get()
                .load(entity.artworkUrl100)
                .error(R.drawable.placeholder)
                .transform(new RoundedCornersTransformation(
                10,
                0,
                RoundedCornersTransformation.CornerType.ALL))
                .into(viewHolder.getArtCover());
        viewHolder.getEntityTitle().setText(entity.trackName);
        viewHolder.getEntityGenre().setText(entity.primaryGenreName);
        viewHolder.getEntityPrice().setText(String.valueOf(entity.trackPrice));
        if (entity.trackHdPrice != null && entity.trackHdPrice > 0) {
            viewHolder.getEntityPriceHD().setVisibility(View.VISIBLE);
            viewHolder.getEntityPriceHD().invalidate();
            viewHolder.getEntityPriceHD().setText(this.context.getString(R.string.label_hd_price, entity.trackHdPrice));
        }

        final Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(viewHolder.getArtCover(), context.getString(R.string.artCoverTransition));
        pairs[1] = new Pair<View, String>(viewHolder.getEntityTitle(), context.getString(R.string.titleTransition));
        pairs[2] = new Pair<View, String>(viewHolder.getEntityGenre(), context.getString(R.string.genreTransition));
        viewHolder.getUnfoldBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(context, DetailActivity.class);
                detailIntent.putExtra("title", searchResponseModel.getTrackSearchResult().get(position).trackName);
                detailIntent.putExtra("genre", searchResponseModel.getTrackSearchResult().get(position).primaryGenreName);
                detailIntent.putExtra("description", searchResponseModel.getTrackSearchResult().get(position).longDescription);
                detailIntent.putExtra("artwork", searchResponseModel.getTrackSearchResult().get(position).artworkUrl100);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((HomeActivity) context, pairs);
                context.startActivity(detailIntent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.searchResponseModel.getResultCount();
    }
}
