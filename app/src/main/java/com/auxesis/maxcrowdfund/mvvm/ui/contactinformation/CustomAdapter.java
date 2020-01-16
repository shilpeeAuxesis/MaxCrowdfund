package com.auxesis.maxcrowdfund.mvvm.ui.contactinformation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.auxesis.maxcrowdfund.R;
import com.auxesis.maxcrowdfund.activity.MaxPropertyGroupDetailActivity;
import com.auxesis.maxcrowdfund.constant.BaseViewHolder;
import com.auxesis.maxcrowdfund.model.MyListModel;

import java.util.ArrayList;
import java.util.List;

import static com.auxesis.maxcrowdfund.constant.Utils.getCustomReplaceFormat;

public class CustomAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    private boolean isLoaderVisible = false;
    private static final String TAG = "MyListAdapter";
    public ArrayList<MyListModel> arrayList, filterList;

    Context mContext;
    Context mActivity;


    public CustomAdapter(Context context, Activity mActivity, ArrayList<MyListModel> arrayList) {
        this.mContext = context;
        this.mActivity = mActivity;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_home, parent, false));
            case VIEW_TYPE_LOADING:
                return new ProgressHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == arrayList.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public void addItems(List<MyListModel> postItems) {
        arrayList.addAll(postItems);
        notifyDataSetChanged();
    }

    public void addLoading() {
        isLoaderVisible = true;
        arrayList.add(new MyListModel());
        notifyItemInserted(arrayList.size() - 1);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = arrayList.size() - 1;
        MyListModel item = getItem(position);
        if (item != null) {
            arrayList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        arrayList.clear();
        notifyDataSetChanged();
    }

    MyListModel getItem(int position) {
        return arrayList.get(position);
    }

    public class ViewHolder extends BaseViewHolder {
        TextView tv_mTittle, tv_interest_pr, tv_risk_c, tv_cur_symbol_amt, tvAmount, tv_filled, tv_investors, tv_currency_left_amt,
                tv_left_amount, tv_months, tv_type, tv_location, tv_cur_total_rsd, tv_raised_amount, tv_active_investor, tv_cur_avr_return,
                tv_avr_return, tv_active_invest_2;
        RelativeLayout rl_mLayout;
        ImageView iv_location_img;
        ProgressBar progessBar;
        LinearLayout lLayoutFooter;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_mTittle = itemView.findViewById(R.id.tv_mTittle);
            tv_interest_pr = itemView.findViewById(R.id.tv_interest_pr);
            tv_risk_c = itemView.findViewById(R.id.tv_risk_c);
            //  tv_cur_symbol_amt = itemView.findViewById(R.id.tv_cur_symbol_amt);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tv_filled = itemView.findViewById(R.id.tv_filled);
            tv_investors = itemView.findViewById(R.id.tv_investors);
            tv_currency_left_amt = itemView.findViewById(R.id.tv_currency_left_amt);
            tv_left_amount = itemView.findViewById(R.id.tv_left_amount);
            tv_months = itemView.findViewById(R.id.tv_months);
            tv_type = itemView.findViewById(R.id.tv_type);
            tv_location = itemView.findViewById(R.id.tv_location);
            rl_mLayout = itemView.findViewById(R.id.rl_mLayout);
            progessBar = itemView.findViewById(R.id.progessBar);
            iv_location_img = itemView.findViewById(R.id.iv_location_img);
            lLayoutFooter = itemView.findViewById(R.id.lLayoutFooter);
            cardView = itemView.findViewById(R.id.cardView);
            tv_cur_total_rsd = itemView.findViewById(R.id.tv_cur_total_rsd);
            tv_raised_amount = itemView.findViewById(R.id.tv_raised_amount);
            tv_active_investor = itemView.findViewById(R.id.tv_active_investor);
            tv_cur_avr_return = itemView.findViewById(R.id.tv_cur_avr_return);
            tv_avr_return = itemView.findViewById(R.id.tv_avr_return);
            tv_active_invest_2 = itemView.findViewById(R.id.tv_active_invest_2);
        }

        @Override
        protected void clear() {
        }

        public void onBind(int position) {
            super.onBind(position);
            MyListModel item = arrayList.get(position);

            for (int i = 0; i < arrayList.size() - 1; i++) {
                Log.d(TAG, "onBind: " + "Position---------" + arrayList.get(i).getmTitle());
                Log.d(TAG, "onBind: " + "Position------s---" + arrayList.get(i).getInvestment_status());

                if ((i%4)==0) {
                    cardView.setVisibility(View.GONE);
                    lLayoutFooter.setVisibility(View.VISIBLE);
                } else {
                    cardView.setVisibility(View.VISIBLE);
                    lLayoutFooter.setVisibility(View.GONE);

                }
            }

           /* Log.d(TAG, "onBind: " + "Position-----else----" + position);
            Log.d(TAG, "onBind: " + "Position---------" + arrayList.get(position).getmTitle());
            Log.d(TAG, "onBind: " + "Position------s---" + arrayList.get(position).getInvestment_status());
            Log.d(TAG, "onBind: " + "Position-------sz--" + String.valueOf(arrayList.size()-1));
*/

          /*  cardView.setVisibility(View.VISIBLE);
            lLayoutFooter.setVisibility(View.VISIBLE);
*/
            tv_mTittle.setText(item.getmTitle());
            tv_interest_pr.setText(item.getInterest_pa() + "%");
            tv_risk_c.setText(item.getRisk_class());
            String currencyBymbol = item.getCurrency_symbol();
            //tv_cur_symbol_amt.setText(currencyBymbol);
            tvAmount.setText(String.valueOf(getCustomReplaceFormat(item.getAmount()) + ".00"));
            int mFilled = item.getFilled();
            tv_filled.setText(String.valueOf(mFilled) + "%");
            tv_currency_left_amt.setText(currencyBymbol);
            tv_investors.setText(String.valueOf(item.getNo_of_investors()));
            tv_left_amount.setText(String.valueOf(item.getAmount_left()));
            tv_months.setText(String.valueOf(item.getMonths()));
            tv_type.setText(item.getType());
            tv_location.setText(item.getLocation());
            progessBar.setProgress(mFilled);

            tv_cur_total_rsd.setText(currencyBymbol);
            tv_raised_amount.setText(String.valueOf(item.getTotal_raised()));
            tv_active_investor.setText(String.valueOf(item.getActive_investors()));
            tv_cur_avr_return.setText(currencyBymbol);
            tv_avr_return.setText(String.valueOf(item.getAverage_return()));
            tv_active_invest_2.setText(String.valueOf(item.getActive_investors()));





            /*if (position==7) {
                cardView.setVisibility(View.GONE);
                lLayoutFooter.setVisibility(View.VISIBLE);
                tv_mTittle.setText(item.getmTitle());
                tv_interest_pr.setText(item.getInterest_pa() + "%");
                tv_risk_c.setText(item.getRisk_class());
                String currencyBymbol = item.getCurrency_symbol();
                //tv_cur_symbol_amt.setText(currencyBymbol);
                tvAmount.setText(String.valueOf(getCustomReplaceFormat(item.getAmount()) + ".00"));
                int mFilled = item.getFilled();
                tv_filled.setText(String.valueOf(mFilled) + "%");
                tv_currency_left_amt.setText(currencyBymbol);
                tv_investors.setText(String.valueOf(item.getNo_of_investors()));
                tv_left_amount.setText(String.valueOf(item.getAmount_left()));
                tv_months.setText(String.valueOf(item.getMonths()));
                tv_type.setText(item.getType());
                tv_location.setText(item.getLocation());
                progessBar.setProgress(mFilled);

                tv_cur_total_rsd.setText(currencyBymbol);
                tv_raised_amount.setText(String.valueOf(item.getTotal_raised()));
                tv_active_investor.setText(String.valueOf(item.getActive_investors()));
                tv_cur_avr_return.setText(currencyBymbol);
                tv_avr_return.setText(String.valueOf(item.getAverage_return()));
                tv_active_invest_2.setText(String.valueOf(item.getActive_investors()));

            } else {
                cardView.setVisibility(View.VISIBLE);
                lLayoutFooter.setVisibility(View.GONE);

                tv_mTittle.setText(item.getmTitle());
                tv_interest_pr.setText(item.getInterest_pa() + "%");
                tv_risk_c.setText(item.getRisk_class());
                String currencyBymbol = item.getCurrency_symbol();
                //tv_cur_symbol_amt.setText(currencyBymbol);
                tvAmount.setText(String.valueOf(getCustomReplaceFormat(item.getAmount()) + ".00"));
                int mFilled = item.getFilled();
                tv_filled.setText(String.valueOf(mFilled) + "%");
                tv_currency_left_amt.setText(currencyBymbol);
                tv_investors.setText(String.valueOf(item.getNo_of_investors()));
                tv_left_amount.setText(String.valueOf(item.getAmount_left()));
                tv_months.setText(String.valueOf(item.getMonths()));
                tv_type.setText(item.getType());
                tv_location.setText(item.getLocation());
                progessBar.setProgress(mFilled);

                tv_cur_total_rsd.setText(currencyBymbol);
                tv_raised_amount.setText(String.valueOf(item.getTotal_raised()));
                tv_active_investor.setText(String.valueOf(item.getActive_investors()));
                tv_cur_avr_return.setText(currencyBymbol);
                tv_avr_return.setText(String.valueOf(item.getAverage_return()));
                tv_active_invest_2.setText(String.valueOf(item.getActive_investors()));
            }*/

            /*tv_mTittle.setText(item.getmTitle());
            tv_interest_pr.setText(item.getInterest_pa() + "%");
            tv_risk_c.setText(item.getRisk_class());
            String currencyBymbol = item.getCurrency_symbol();
            //tv_cur_symbol_amt.setText(currencyBymbol);
            tvAmount.setText(String.valueOf(getCustomReplaceFormat(item.getAmount()) + ".00"));
            int mFilled = item.getFilled();
            tv_filled.setText(String.valueOf(mFilled) + "%");
            tv_currency_left_amt.setText(currencyBymbol);
            tv_investors.setText(String.valueOf(item.getNo_of_investors()));
            tv_left_amount.setText(String.valueOf(item.getAmount_left()));
            tv_months.setText(String.valueOf(item.getMonths()));
            tv_type.setText(item.getType());
            tv_location.setText(item.getLocation());
            progessBar.setProgress(mFilled);*/

            /*if (item.getInvestment_status().equals("expired")) {
                cardView.setVisibility(View.GONE);
                lLayoutFooter.setVisibility(View.VISIBLE);
                tv_cur_total_rsd.setText(currencyBymbol);
                tv_raised_amount.setText(String.valueOf(item.getTotal_raised()));
                tv_active_investor.setText(String.valueOf(item.getActive_investors()));
                tv_cur_avr_return.setText(currencyBymbol);
                tv_avr_return.setText(String.valueOf(item.getAverage_return()));
                tv_active_invest_2.setText(String.valueOf(item.getActive_investors()));
            } else {
                lLayoutFooter.setVisibility(View.GONE);
                cardView.setVisibility(View.VISIBLE);
            }*/

            Log.d(TAG, "onBind: " + arrayList.size());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, MaxPropertyGroupDetailActivity.class));
                }
            });
        }
    }

    public class ProgressHolder extends BaseViewHolder {
        ProgressBar mProgressbar;

        ProgressHolder(View itemView) {
            super(itemView);
            mProgressbar = itemView.findViewById(R.id.mProgressbar);
        }

        @Override
        protected void clear() {
        }
    }

}

