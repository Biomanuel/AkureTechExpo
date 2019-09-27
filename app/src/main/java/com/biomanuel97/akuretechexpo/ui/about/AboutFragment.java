package com.biomanuel97.akuretechexpo.ui.about;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.biomanuel97.akuretechexpo.R;

import java.util.List;

public class AboutFragment extends Fragment {

    private AboutViewModel mAboutViewModel;
    Button TweetButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        mAboutViewModel = ViewModelProviders.of(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        mAboutViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        TweetButton = root.findViewById(R.id.social_media_button);
        TweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postTweet();
            }
        });
        return root;
    }

    private void postTweet() {
        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "\n\n" + getString(R.string.hashtags));
        tweetIntent.setType("text/plain");

        PackageManager packManager = getContext().getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for (ResolveInfo resolveInfo : resolvedInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name);
                resolved = true;
                break;
            }
        }
        if (resolved) {
            startActivity(tweetIntent);
        } else {
            Toast.makeText(getContext(), "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }
    }

}