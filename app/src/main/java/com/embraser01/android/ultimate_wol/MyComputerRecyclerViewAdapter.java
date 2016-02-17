package com.embraser01.android.ultimate_wol;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.embraser01.android.ultimate_wol.model.Computer;

import java.util.List;

public class MyComputerRecyclerViewAdapter extends RecyclerView.Adapter<MyComputerRecyclerViewAdapter.ViewHolder> {

    private final List<Computer> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyComputerRecyclerViewAdapter(List<Computer> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.computer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // TODO Adapt data displayed
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getId());
        holder.mContentView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                // Handle selection
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView mIdView;
        public TextView mContentView;
        public Computer mItem;

        public ViewHolder(View view) {
            // TODO Adapt view with computer info
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.computer_id);
            mContentView = (TextView) view.findViewById(R.id.computer_mac);
        }
    }
}
