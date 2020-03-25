package com.auxesis.maxcrowdfund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.auxesis.maxcrowdfund.R;
import com.auxesis.maxcrowdfund.mvvm.ui.MaxPropertyGroupDetail.model.LoanTermModel;

import java.util.List;

public class LoanTermAdapter extends RecyclerView.Adapter<LoanTermAdapter.MyHolder> {
    private static final String TAG = "LoanTermAdapter";
    private List<LoanTermModel> arrayList;
    Context mContext;

    public LoanTermAdapter(Context mContext, List<LoanTermModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_loan_term_, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv_name_tittle.setText(arrayList.get(position).getmLoanTermTitle());
        holder.tv_value.setText(arrayList.get(position).getmLoanTermValue());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_name_tittle,tv_value;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_tittle = itemView.findViewById(R.id.tv_name_tittle);
            tv_value = itemView.findViewById(R.id.tv_value);
        }
    }
}
