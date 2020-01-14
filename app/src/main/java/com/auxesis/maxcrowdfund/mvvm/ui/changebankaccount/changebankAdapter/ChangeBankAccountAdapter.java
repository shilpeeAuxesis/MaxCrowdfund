package com.auxesis.maxcrowdfund.mvvm.ui.changebankaccount.changebankAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.auxesis.maxcrowdfund.R;
import com.auxesis.maxcrowdfund.activity.customInterface.OnCustomClickListener;
import com.auxesis.maxcrowdfund.mvvm.ui.changebankaccount.changebankaccountmodel.Datum;
import java.util.List;

public class ChangeBankAccountAdapter extends RecyclerView.Adapter<ChangeBankAccountAdapter.MyHolder> {
    private List<Datum> arrayList;
    Context mContext;
    String account = "";
    OnCustomClickListener onCustomClickListener;

    public ChangeBankAccountAdapter(Context mContext,OnCustomClickListener onCustomClickListener, List<Datum> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        this.onCustomClickListener =onCustomClickListener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_bank_account_, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.radioAccount.setText(arrayList.get(position).getAccount());
        if (arrayList.get(position).getActive() == 1) {
            holder.radioAccount.setChecked(true);
        } else {
            holder.radioAccount.setChecked(false);
        }
        holder.radioAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.get(position).getActive() == 1) {
                    holder.radioAccount.setChecked(true);
                    Toast.makeText(mContext, "Selected Bank Account is "+arrayList.get(position).getAccount(), Toast.LENGTH_SHORT).show();
                    account = arrayList.get(position).getAccount();
                } else {
                    holder.radioAccount.setChecked(false);
                    Toast.makeText(mContext, "Selected Bank Account is "+arrayList.get(position).getAccount(), Toast.LENGTH_SHORT).show();
                    account = arrayList.get(position).getAccount();
                }
                if (account!=null){
                    onCustomClickListener.onCustomClick(account);
                }else {
                    Toast.makeText(mContext, "Please select bank account", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (position == arrayList.size() - 1) {
            holder.btn_saveChanges.setVisibility(View.VISIBLE);
            holder.btn_saveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        } else {
            holder.btn_saveChanges.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void addItems(List<Datum> postItems) {
        arrayList.addAll(postItems);
        notifyDataSetChanged();
    }

    public void clear() {
        arrayList.clear();
        notifyDataSetChanged();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        Button btn_saveChanges;
        RadioButton radioAccount;
        RelativeLayout llChangebank;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            radioAccount = itemView.findViewById(R.id.radioAccount);
            btn_saveChanges = itemView.findViewById(R.id.btn_saveChanges);
            llChangebank = itemView.findViewById(R.id.llChangebank);
        }
    }
}
