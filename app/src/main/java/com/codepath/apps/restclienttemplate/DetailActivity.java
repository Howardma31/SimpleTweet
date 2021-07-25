package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImage;
    TextView tvScreenName;
    TextView tvBody;
    TextView tvTimestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvScreenName = findViewById(R.id.tvScreenNameDetail);
        tvBody = findViewById(R.id.tvBodyDetail);
        tvTimestamp = findViewById(R.id.tvTimestampDetail);
        ivProfileImage = findViewById(R.id.ivProfilePictureDetail);

        Tweet tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvScreenName.setText(tweet.getScreenName());
        tvBody.setText(tweet.getBody());
        tvTimestamp.setText(tweet.getFormattedTimestamp());
        Glide.with(this).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);
    }

}
