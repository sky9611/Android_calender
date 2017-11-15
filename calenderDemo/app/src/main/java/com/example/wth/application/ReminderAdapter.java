package com.example.wth.application;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.BindView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//import static com.example.wth.application.R;

/**
 * Created by wth on 2017/11/9.
 */

public class ReminderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ReminderListItem> mList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private static MainRecycleViewClickListener mListener;
    private Context mContext;

    public ReminderAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<ReminderListItem> list) {
        mList.clear();
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReminderViewHolder viewHolder = new ReminderViewHolder(mLayoutInflater.inflate(R.layout.recycler_view, parent, false));
        viewHolder.setDelayAdapter(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ReminderViewHolder) holder).tvDelayTime.setText(mList.get(position).getTime());
        if (mList.get(position).getIsCheck() == 1) {
            ((ReminderViewHolder) holder).ivCheck.setVisibility(View.VISIBLE);
            ((ReminderViewHolder) holder).ivCheck.setBackgroundResource(R.drawable.ic_selected);
        } else {
            ((ReminderViewHolder) holder).ivCheck.setVisibility(View.INVISIBLE);
            ((ReminderViewHolder) holder).ivCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        v.setBackgroundResource(R.drawable.ic_selected);
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class ReminderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_advance_type_minute) TextView tvDelayTime;
        @BindView(R.id.iv_check) ImageView ivCheck;

        private WeakReference<ReminderAdapter> ref;
        private ReminderAdapter reminderAdapter;

        ReminderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(getLayoutPosition());
                }
            });
        }

        public void setDelayAdapter(ReminderAdapter adapter) {
            if (adapter!=null){
                ref = new WeakReference<ReminderAdapter>(adapter);
            }
            reminderAdapter = ref.get();
        }
    }


    public void setOnMainRecycleOnClickListener(MainRecycleViewClickListener itemOnClickListener) {
        mListener = itemOnClickListener;
    }

    public interface MainRecycleViewClickListener {
        void onItemClick(int pos);
    }

}
