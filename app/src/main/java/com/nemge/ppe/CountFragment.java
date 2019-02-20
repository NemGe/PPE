package com.nemge.ppe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CountFragment extends Fragment {
    private TextView show;
    private ProgressBar progress;
    private Button button;
    int value = 0;
    int result = 200;

    public CountFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count, container, false);

        show = view.findViewById(R.id.title_count);
        progress = view.findViewById(R.id.progressBar1);
        progress.setProgress(result);
        button = view.findViewById(R.id.button_count);
        discount();
        return view;
    }

    public void discount() {
        show.setText(result + "");
        button.setOnClickListener(v -> {
            result--;
            progress.setProgress(result);
            if(result>=0){
                show.setText(result + "");
            }
        });
    }
}