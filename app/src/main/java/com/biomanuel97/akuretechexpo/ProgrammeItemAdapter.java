package com.biomanuel97.akuretechexpo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgrammeItemAdapter extends RecyclerView.Adapter<ProgrammeItemAdapter.ViewHolder> {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<ProgrammeItem> mProgrammeItems = new ArrayList<>();

    public ProgrammeItemAdapter(@NonNull Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
//        mProgrammeItems = DataManager.getInstance().getProgrammeItems();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.programme_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProgrammeItem currentItem = mProgrammeItems.get(position);
        holder.txtTitle.setText(currentItem.getItemTitle());
        holder.txtInfo.setText(currentItem.getItemInfo());
        holder.txtDurTime.setText(currentItem.itemDurationTime);
        if (currentItem.getItemTitle() == " REGISTRATION") {
            holder.itemIcon.setImageResource(R.drawable.ic_person_add_black);
        } else if (currentItem.getItemTitle() == " ANTHEM") {
            holder.itemIcon.setImageResource(R.drawable.ic_map_black_24dp);
        }
    }

    public void setProgrammeItems(ArrayList<ProgrammeItem> programmeItems) {
        mProgrammeItems = programmeItems;
    }

    public void clearProgrammeItemlist() {
        mProgrammeItems.clear();
    }

    @Override
    public int getItemCount() {
        return mProgrammeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtInfo;
        public TextView txtDurTime;
        public ImageView itemIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.programme_title);
            txtInfo = itemView.findViewById(R.id.programme_info);
            txtDurTime = itemView.findViewById(R.id.programme_duration_time);
            itemIcon = itemView.findViewById(R.id.item_icon);
        }
    }
}
