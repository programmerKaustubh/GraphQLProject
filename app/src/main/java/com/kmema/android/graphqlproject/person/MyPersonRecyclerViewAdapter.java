package com.kmema.android.graphqlproject.person;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kmema.android.graphqlproject.AllPeopleQuery;
import com.kmema.android.graphqlproject.person.PersonFragment.OnListFragmentInteractionListener;
import com.kmema.android.graphqlproject.R;
import com.kmema.android.graphqlproject.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPersonRecyclerViewAdapter extends RecyclerView.Adapter<MyPersonRecyclerViewAdapter.ViewHolder> {

    private final List<AllPeopleQuery.person> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context context;
    PersonClickListner personClickListner;
    public MyPersonRecyclerViewAdapter(List<AllPeopleQuery.person> items, OnListFragmentInteractionListener listener, Context context, PersonClickListner personClickListner) {
        mValues = items;
        mListener = listener;
        this.context = context;
        this.personClickListner = personClickListner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mPersonName.setText(mValues.get(position).name());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                Toast.makeText(context, ""+ mValues.get(position).name(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mPersonName;
        public AllPeopleQuery.person mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPersonName = view.findViewById(R.id.textViewPersonGrid);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPersonName.getText() + "'";
        }
    }
}
