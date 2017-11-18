package com.example.wth.application;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

/**
 * Created by Inspiron on 2017/11/18.
 */

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<EventItem> mList = new ArrayList<>();
    private Context mContext;
    private static EventListViewClickListener mListener;

    public EventAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<EventItem> list) {
        mList.clear();
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EventListViewHolder viewHolder = new EventListViewHolder(mLayoutInflater.inflate(R.layout.event_item_view, parent, false));
        viewHolder.setDelayAdapter(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((EventListViewHolder) holder).tvEvent.setText(mList.get(position).getEvent());
        RecyclerView.ViewHolder itemViewHolder = (RecyclerView.ViewHolder)holder;
        ViewGroup.LayoutParams layoutParam = itemViewHolder.itemView.getLayoutParams();
        layoutParam.height = WRAP_CONTENT;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setOnMainRecycleOnClickListener(EventListViewClickListener itemOnClickListener) {
        mListener = itemOnClickListener;
    }



    class EventListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_event)
        TextView tvEvent;


        private WeakReference<EventAdapter> ref;
        private EventAdapter eventAdapter;

        EventListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mListener.onItemClick(getLayoutPosition());
                    Intent i = new Intent(v.getContext(),CreationEventActivity.class);
                    v.getContext().startActivity(i);
                }
            });
        }

        public void setDelayAdapter(EventAdapter adapter) {
            if (adapter!=null){
                ref = new WeakReference<EventAdapter>(adapter);
            }
            eventAdapter = ref.get();
        }
    }
    public interface EventListViewClickListener {
        void onItemClick(int pos);
    }
}
