package maxcrowdfund.com.mvvm.ui.changePreference.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import maxcrowdfund.com.R;
import maxcrowdfund.com.mvvm.ui.changePreference.model.Option;
import java.util.List;

public class LanguagePreferenceAdapter extends BaseAdapter {
    Context mContext;
    List<Option> modelList;

    public LanguagePreferenceAdapter(Context mContext,List<Option> modelList) {
        this.mContext = mContext;
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Option getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.spinner_item, null);
        TextView textView = view.findViewById(R.id.tvName);
        /*if (position == 0) {
            if (modelList.get(position).getKey().equals(mSelected)) ;
            {
                textView.setText(modelList.get(position).getVal());
            }
        }*/
        textView.setText(modelList.get(position).getVal());
        return view;
    }
}
