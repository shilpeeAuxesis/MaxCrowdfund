package maxcrowdfund.com.mvvm.ui.home.homeDetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import maxcrowdfund.com.R;
import maxcrowdfund.com.mvvm.ui.home.homeDetail.model.FundraiserModel;
import java.util.List;

public class FundraiserAdapter extends RecyclerView.Adapter<FundraiserAdapter.MyHolder> {
    private static final String TAG = "FundraiserAdapter";
    private List<FundraiserModel> arrayList;
    Context mContext;

    public FundraiserAdapter(Context mContext, List<FundraiserModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_fundraiser, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv_name_tittle.setText(arrayList.get(position).getMfundraiserTitle());
        holder.tv_value.setText(arrayList.get(position).getMfundraiserValue().replaceAll("<br />", ""));
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
