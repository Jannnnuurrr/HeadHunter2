package com.example.headhunter.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.headhunter.Activity.JobDetailsActivity;
import com.example.headhunter.Model.Data;
import com.example.headhunter.R;

import java.util.List;

public class AllJobAdapter extends RecyclerView.Adapter<AllJobAdapter.ViewHolder> {

    private final List<Data> mValues;
    private OnItemClickListener mListener;

    public AllJobAdapter(List<Data> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_job, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mValues.get(position));
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(mValues.get(position));
            }
        });
        Data data = mValues.get(position);
        holder.bindData(data);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), JobDetailsActivity.class);
            intent.putExtra("title", data.getTitle());
            intent.putExtra("date", data.getDate());
            intent.putExtra("description", data.getDescription());
            intent.putExtra("skills", data.getSkills());
            intent.putExtra("salary", data.getSalary());
            intent.putExtra("email", data.getEmail());
            intent.putExtra("companyName", data.getCompanyName());
            intent.putExtra("companyEmail", data.getCompanyEmail());
            intent.putExtra("companyAddress", data.getCompanyAddress());
            intent.putExtra("aboutCompany", data.getAboutCompany());
            intent.putExtra("companyName", data.getCompanyName());
            intent.putExtra("logoImageResource", data.getLogoImageResource());
            v.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle, mDate, mDescription, mSkills, mSalary, mCompanyName;
        ImageView mLogoImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.all_job_post_title);
            mDate = itemView.findViewById(R.id.all_job_post_date);
            mDescription = itemView.findViewById(R.id.all_job_post_description);
            mSkills = itemView.findViewById(R.id.all_job_post_skills);
            mSalary = itemView.findViewById(R.id.all_job_post_salary);
            mLogoImageView = itemView.findViewById(R.id.icon_worker_profile);
            mCompanyName = itemView.findViewById(R.id.about_company_name);
        }

        public void bindData(Data model) {
            mTitle.setText(model.getTitle());
            mDate.setText(model.getDate());
            mDescription.setText(model.getDescription());
            mSkills.setText(model.getSkills());
            mSalary.setText(model.getSalary());
            mCompanyName.setText(model.getCompanyName());
            mCompanyName.setVisibility(View.VISIBLE);
            mLogoImageView.setImageResource(model.getLogoImageResource());

        }


    }

    public interface OnItemClickListener {
        void onItemClick(Data data);
    }

}

