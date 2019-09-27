package com.biomanuel97.akuretechexpo.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.biomanuel97.akuretechexpo.DataManager;
import com.biomanuel97.akuretechexpo.ProgrammeItemAdapter;
import com.biomanuel97.akuretechexpo.R;

public class ScheduleFragment extends Fragment {

    private ScheduleViewModel dashboardViewModel;
    private RecyclerView day1ProgrammeItemRV, day2ProgrammeItemRV;
    private LinearLayoutManager day1LinearLayoutManager, day2LinearLayoutManager;
    private ProgrammeItemAdapter mDay1ProgrammeItemAdapter, mDay2ProgrammeItemAdapter;
    private int day = 1;
    private DataManager mDm;
    TextView switchText;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel = ViewModelProviders.of(this).get(ScheduleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        mDm = DataManager.getInstance();

        day1ProgrammeItemRV = (RecyclerView) root.findViewById(R.id.day1programme_items_rv);
        day2ProgrammeItemRV = (RecyclerView) root.findViewById(R.id.day2programme_items_rv);

        setupDay1RV();

        setupDay2RV();

        displayProgrammeSchedule(day);

        switchText = (TextView) root.findViewById(R.id.txt_switch_day);
        switchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchDay(view);
            }
        });

        return root;
    }

    private void setupDay2RV() {
        day2LinearLayoutManager = new LinearLayoutManager(getContext());
        mDay2ProgrammeItemAdapter = new ProgrammeItemAdapter(getContext());
        mDay2ProgrammeItemAdapter.setProgrammeItems(mDm.getProgrammeItems(2));
        day2ProgrammeItemRV.setLayoutManager(day2LinearLayoutManager);
        day2ProgrammeItemRV.setAdapter(mDay2ProgrammeItemAdapter);
    }

    private void setupDay1RV() {
        day1LinearLayoutManager = new LinearLayoutManager(getContext());
        mDay1ProgrammeItemAdapter = new ProgrammeItemAdapter(getContext());
        mDay1ProgrammeItemAdapter.setProgrammeItems(mDm.getProgrammeItems(1));
        day1ProgrammeItemRV.setLayoutManager(day1LinearLayoutManager);
        day1ProgrammeItemRV.setAdapter(mDay1ProgrammeItemAdapter);
    }

    private void displayProgrammeSchedule(int day) {
        if (day == 1) {
            day2ProgrammeItemRV.setVisibility(View.GONE);
            day1ProgrammeItemRV.setVisibility(View.VISIBLE);
        }
        if (day == 2) {
            day1ProgrammeItemRV.setVisibility(View.GONE);
            day2ProgrammeItemRV.setVisibility(View.VISIBLE);
        }
    }


    public void switchDay(View view) {
        TextView switchText = (TextView) view;
        if (day == 1) {
            switchText.setText(R.string.txt_schedule_info2);
            day = 2;
            displayProgrammeSchedule(day);
        } else if (day == 2) {
            switchText.setText(R.string.txt_schedule_info1);
            day = 1;
            displayProgrammeSchedule(day);
        }
    }

}