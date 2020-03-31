package com.auxesis.maxcrowdfund.restapi;
import android.content.Context;
import com.auxesis.maxcrowdfund.constant.MaxCrowdFund;
import java.io.IOException;
import java.util.HashSet;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * This Interceptor add all received Cookies to the app DefaultPreferences.
 * Your implementation on how to save the Cookies on the Preferences may vary.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    private Context context;
    public ReceivedCookiesInterceptor(Context context) {
        this.context = context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
                for (String header : originalResponse.headers("Set-Cookie")) {
                    cookies.add(header);
                }
            MaxCrowdFund.setCookies(context, cookies);
        }
        return originalResponse;
    }


}
