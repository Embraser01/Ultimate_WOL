package com.embraser01.android.ultimate_wol;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.embraser01.android.ultimate_wol.model.Computer;
import com.embraser01.android.ultimate_wol.model.ListComputer;

import java.util.List;

public class MyComputerRecyclerViewAdapter extends RecyclerView.Adapter<MyComputerRecyclerViewAdapter.ViewHolder> {

    private final ListComputer mValues;
    private final OnListFragmentInteractionListener mListener;

    private Context context;
    private int lastPosition = -1;

    public MyComputerRecyclerViewAdapter(Context context, ListComputer items, OnListFragmentInteractionListener listener) {
        this.context = context;
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

        holder.mItem = mValues.getList().get(position);


        TextDrawable textDrawable = TextDrawable.builder()
                .buildRound(holder.mItem.getName().substring(0, 1),
                        ColorGenerator.MATERIAL.getRandomColor());
        holder.mImage.setImageDrawable(textDrawable);

        holder.mNameView.setText(holder.mItem.getName());
//        holder.mContentView.setText(mValues.getList().get(position).getName());

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

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Handle selection
                return false;
            }
        });

        setAnimation(holder.mView, position);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        holder.clearAnimation();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView mNameView;
        public TextView mContentView;
        public Computer mItem;
        public ImageView mImage;

        public ViewHolder(View view) {
            // TODO Adapt view with computer info
            super(view);

            mImage = (ImageView) view.findViewById(R.id.computer_image);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.computer_name);
//            mContentView = (TextView) view.findViewById(R.id.com);
        }

        public void clearAnimation() {
            this.mView.clearAnimation();
        }
    }
}
