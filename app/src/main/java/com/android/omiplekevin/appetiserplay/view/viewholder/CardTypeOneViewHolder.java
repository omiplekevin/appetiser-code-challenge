package com.android.omiplekevin.appetiserplay.view.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.omiplekevin.appetiserplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

public class CardTypeOneViewHolder extends RecyclerView.ViewHolder{


    @Getter
    @BindView(R.id.artCover)
    ImageView artCover;

    @Getter
    @BindView(R.id.entityTitle)
    TextView entityTitle;

    @Getter
    @BindView(R.id.entityGenre)
    TextView entityGenre;

    @Getter
    @BindView(R.id.entityPrice)
    TextView entityPrice;

    @Getter
    @BindView(R.id.entityPriceHD)
    TextView entityPriceHD;

    @Getter
    @BindView(R.id.unfoldBtn)
    ImageButton unfoldBtn;

    private View.OnClickListener onClickListener;

    public CardTypeOneViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setTag(this);
        itemView.setOnClickListener(this.onClickListener);
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
