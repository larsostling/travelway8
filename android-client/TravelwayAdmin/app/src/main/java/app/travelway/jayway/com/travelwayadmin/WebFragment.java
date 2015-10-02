package app.travelway.jayway.com.travelwayadmin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by mattias on 2015-10-02.
 */
public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_web, container, false);

        WebView webView = (WebView) rootView.findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);

        webView.loadUrl("http://52.29.24.118/#/register/nils.nilsson@travelway.com");



        return rootView;
    }
}
