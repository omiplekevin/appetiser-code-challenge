package com.android.omiplekevin.appetiserplay.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.omiplekevin.appetiserplay.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.artCoverDetail)
    ImageView artCoverDetail;

    @BindView(R.id.entityTitleDetail)
    TextView entityTitleDetail;

    @BindView(R.id.entityGenreDetail)
    TextView entityGenreDetail;

    @BindView(R.id.entityDescription)
    TextView entityDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Bundle bundle = this.getIntent().getExtras();
        String title = bundle.getString("title");
        String genre = bundle.getString("genre");
        String description = bundle.getString("description");
        String artwork = bundle.getString("artwork");

        Picasso.get()
                .load(artwork)
                .error(R.drawable.placeholder)
                .transform(new RoundedCornersTransformation(
                        10,
                        0,
                        RoundedCornersTransformation.CornerType.ALL))
                .into(artCoverDetail);
        entityTitleDetail.setText(title);
        entityGenreDetail.setText(genre);
        entityDescription.setText(description);
    }
}
