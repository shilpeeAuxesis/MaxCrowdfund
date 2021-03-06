package maxcrowdfund.com.mvvm.ui.myinvestments.myinvestmentdetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import maxcrowdfund.com.R;
import maxcrowdfund.com.constant.MaxCrowdFund;
import maxcrowdfund.com.customClickListener.OnDownloadClickListener;
import maxcrowdfund.com.mvvm.activity.LoginActivity;
import maxcrowdfund.com.mvvm.ui.home.homeDetail.adapter.InvestmentDocumentAdapter;
import maxcrowdfund.com.mvvm.ui.home.homeDetail.adapter.MyInvestmentDetailAdapter;
import maxcrowdfund.com.mvvm.ui.home.homeDetail.adapter.MyInvestmentDetailRepayAdapter;
import maxcrowdfund.com.constant.ProgressDialog;
import maxcrowdfund.com.constant.Utils;
import maxcrowdfund.com.mvvm.activity.HomeActivity;
import maxcrowdfund.com.mvvm.ui.myinvestments.myinvestmentdetail.myinvestmentdetailmodel.CancelInvestmentResponce;
import maxcrowdfund.com.mvvm.ui.myinvestments.myinvestmentdetail.myinvestmentdetailmodel.MyInvestmentDetailResponse;
import maxcrowdfund.com.restapi.ApiClient;
import maxcrowdfund.com.restapi.EndPointInterface;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyInvestmentDetailFragment extends Fragment implements OnDownloadClickListener {
    private static final String TAG = "MyInvestmentDetailFragm";
    TextView tv_arrow_document, tv_arrow_repayment_schedule, tvInvestment, tv_investment_amount, tvInvested, tv_invested_amount, tv_document, tv_repayment_schedule;
    RelativeLayout rl_document_click, rl_repayment_schedule_click;
    LinearLayout ll_contant_document, ll_repayment_schedule_content;
    ProgressDialog pd;
    RecyclerView recyclerView, recyclerViewDocment, recyclerViewRepayment;
    Button btn_change, btn_view_pinch,btn_cancel;
    MyInvestmentDetailAdapter adapter;
    InvestmentDocumentAdapter documentadapter;
    MyInvestmentDetailRepayAdapter repaymentadapter;
    Activity mActivity;
    String mInvestmentId = "";
    String mLoanId = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_investment_detail, container, false);
        mActivity = getActivity();
        mInvestmentId = Utils.getPreference(mActivity, "investment_id");
        mLoanId = Utils.getPreference(mActivity, "loan_id");

        rl_document_click = root.findViewById(R.id.rl_document_click);
        rl_repayment_schedule_click = root.findViewById(R.id.rl_repayment_schedule_click);

        ll_contant_document = root.findViewById(R.id.ll_contant_document);
        ll_repayment_schedule_content = root.findViewById(R.id.ll_repayment_schedule_content);

        tv_arrow_document = root.findViewById(R.id.tv_arrow_document);
        tv_arrow_repayment_schedule = root.findViewById(R.id.tv_arrow_repayment_schedule);

        ll_contant_document.setVisibility(View.GONE);
        ll_repayment_schedule_content.setVisibility(View.GONE);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerViewDocment = root.findViewById(R.id.recyclerViewDocment);
        recyclerViewRepayment = root.findViewById(R.id.recyclerViewRepayment);

        tvInvestment = root.findViewById(R.id.tvInvestment);
        tv_investment_amount = root.findViewById(R.id.tv_investment_amount);
        tvInvested = root.findViewById(R.id.tvInvested);
        tv_invested_amount = root.findViewById(R.id.tv_invested_amount);
        tv_document = root.findViewById(R.id.tv_document);
        tv_repayment_schedule = root.findViewById(R.id.tv_repayment_schedule);

        btn_change = root.findViewById(R.id.btn_change);
        btn_cancel = root.findViewById(R.id.btn_cancel);
        btn_view_pinch = root.findViewById(R.id.btn_view_pinch);
        btn_cancel.setVisibility(View.GONE);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn_view_pinch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                if (mLoanId != null && !mLoanId.isEmpty()) {
                    Utils.setPreference(mActivity, "id",mLoanId);
                }
                navController.navigate(R.id.action_nav_my_investment_detail_to_investmentOppDetailFragment);
            }
        });
        if (Utils.isInternetConnected(getActivity())) {
            if (mInvestmentId != null && !mInvestmentId.isEmpty()) {
                getMyInvestmentDetail(mInvestmentId);
            }
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show();
        }

        rl_document_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_contant_document.isShown()) {
                    Utils.slide_up(getActivity(), ll_contant_document);
                    tv_arrow_document.setBackgroundResource(R.drawable.ic_arrow_down);
                    ll_contant_document.setVisibility(View.GONE);
                } else {
                    ll_contant_document.setVisibility(View.VISIBLE);
                    Utils.slide_down(getActivity(), ll_contant_document);
                    tv_arrow_document.setBackgroundResource(R.drawable.ic_arrow_up);
                }
            }
        });

        rl_repayment_schedule_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_repayment_schedule_content.isShown()) {
                    Utils.slide_up(getActivity(), ll_repayment_schedule_content);
                    tv_arrow_repayment_schedule.setBackgroundResource(R.drawable.ic_arrow_down);
                    ll_repayment_schedule_content.setVisibility(View.GONE);
                } else {
                    ll_repayment_schedule_content.setVisibility(View.VISIBLE);
                    Utils.slide_down(getActivity(), ll_repayment_schedule_content);
                    tv_arrow_repayment_schedule.setBackgroundResource(R.drawable.ic_arrow_up);
                }
            }
        });
        return root;
    }

    private void getMyInvestmentDetail(String investmentId) {
        pd = ProgressDialog.show(getActivity(), "Please Wait...");
        EndPointInterface git = ApiClient.getClient1(getActivity()).create(EndPointInterface.class);
        String XCSRF = Utils.getPreference(getActivity(), "mCsrf_token");
        Log.d(TAG, "getMyInvestmentDetail: "+investmentId);
        Call<MyInvestmentDetailResponse> call = git.getMyInvestmentDetail("application/json", XCSRF, investmentId);
        call.enqueue(new Callback<MyInvestmentDetailResponse>() {
            @Override
            public void onResponse(Call<MyInvestmentDetailResponse> call, Response<MyInvestmentDetailResponse> response) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
                if (response.code()==200) {
                    if (response != null && response.isSuccessful()) {
                        if (response.body().getUserLoginStatus() == 1) {
                            Log.d(TAG, "onResponse: " + "><s><" + new Gson().toJson(response.body()));
                            if (response.body().getDetails()!=null) {
                                tvInvestment.setText(response.body().getDetails().getMainheading().getTitle());
                                tv_investment_amount.setText(response.body().getDetails().getMainheading().getData());
                                tvInvested.setText(response.body().getDetails().getInvested().getTitle());
                                tv_invested_amount.setText(response.body().getDetails().getInvested().getData());
                                tv_document.setText(response.body().getDetails().getDocuments().getHeading());
                                if (response.body().getDetails().getChangeCancelAllowed()==1){
                                    btn_cancel.setVisibility(View.VISIBLE);
                                    btn_cancel.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (Utils.isInternetConnected(getActivity())) {
                                                getCancelInvestment(response.body().getDetails().getId());
                                            } else {
                                                Toast.makeText(getActivity(), getResources().getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else {
                                    btn_cancel.setVisibility(View.GONE);
                                }
                                if (response.body().getDetails().getChangeButtonAlowed()==1){
                                    btn_change.setVisibility(View.VISIBLE);
                                    btn_change.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                        }
                                    });
                                }else {
                                    btn_change.setVisibility(View.GONE);
                                }

                                if (response.body().getDetails().getLoanTerms().getData().size() > 0) {
                                    adapter = new MyInvestmentDetailAdapter(getActivity(), response.body().getDetails().getLoanTerms().getData());
                                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                                    recyclerView.setLayoutManager(mLayoutManager);
                                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                                    recyclerView.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }
                                //for document
                                if (response.body().getDetails().getDocuments().getData().size() > 0) {
                                    documentadapter = new InvestmentDocumentAdapter(getActivity(), MyInvestmentDetailFragment.this, response.body().getDetails().getDocuments().getData());
                                    RecyclerView.LayoutManager mdLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                                    recyclerViewDocment.setLayoutManager(mdLayoutManager);
                                    recyclerViewDocment.setItemAnimator(new DefaultItemAnimator());
                                    recyclerViewDocment.setAdapter(documentadapter);
                                    documentadapter.notifyDataSetChanged();
                                }
                                //For repayment_schedule
                                tv_repayment_schedule.setText(response.body().getDetails().getRepaymentSchedule().getHeading());
                                if (response.body().getDetails().getRepaymentSchedule().getData().size() > 0) {
                                    repaymentadapter = new MyInvestmentDetailRepayAdapter(getActivity(), response.body().getDetails().getRepaymentSchedule().getData());
                                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                                    recyclerViewRepayment.setLayoutManager(mLayoutManager);
                                    recyclerViewRepayment.setItemAnimator(new DefaultItemAnimator());
                                    recyclerViewRepayment.setAdapter(repaymentadapter);
                                    repaymentadapter.notifyDataSetChanged();
                                }
                            }
                        } else {
                            Utils.setPreference(getActivity(), "user_id", "");
                            Utils.setPreference(getActivity(), "mLogout_token", "");
                            MaxCrowdFund.getInstance().getClearCookies(getActivity(), "cookies", "");
                            Toast.makeText(getActivity(), getResources().getString(R.string.session_expire), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            startActivity(intent);
                            mActivity.finish();
                        }
                    } else {
                        Toast.makeText(mActivity, getResources().getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mActivity, getResources().getString(R.string.something_went), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MyInvestmentDetailResponse> call, Throwable t) {
                Log.e("response", "error " + t.getMessage());
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCancelInvestment(String id) {
        EndPointInterface git = ApiClient.getClient1(getActivity()).create(EndPointInterface.class);
        String XCSRF = Utils.getPreference(getActivity(), "mCsrf_token");
        Call<CancelInvestmentResponce> call = git.getCancelInvestment("application/json", XCSRF, id);
        call.enqueue(new Callback<CancelInvestmentResponce>() {
            @Override
            public void onResponse(Call<CancelInvestmentResponce> call, Response<CancelInvestmentResponce> response) {
                if (response!=null){
                    if (response.isSuccessful()){
                        if (response.body().getUserLoginStatus() == 1) {
                            Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Utils.setPreference(getActivity(), "user_id", "");
                            Utils.setPreference(getActivity(), "mLogout_token", "");
                            MaxCrowdFund.getInstance().getClearCookies(getActivity(), "cookies", "");
                            Toast.makeText(getActivity(), getResources().getString(R.string.session_expire), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            startActivity(intent);
                            mActivity.finish();
                        }
                    }
                }else {
                    Toast.makeText(getActivity(), getResources().getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CancelInvestmentResponce> call, Throwable t) {
                Log.e("response", "error " + t.getMessage());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onMyDownloadClick(String mdownload) {

    }
    public void onResume() {
        super.onResume();
        ((HomeActivity) getActivity()).setActionBarTitle(getString(R.string.my_investments_detail));
    }
}

