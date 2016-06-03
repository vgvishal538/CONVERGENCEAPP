package vishaldev.convergence;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private WebView wv;

    private String LASTURL = "";

    Menu myMenu = null;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("REGISTER");
        mToolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.backnew);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        wv = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = wv.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);


        final Activity activity = this;

        // start ProgressDialog with "Page loading..."
        dialog = new ProgressDialog(activity);
        dialog.setMessage("Page loading...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();

        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // set address bar and progress
                // activity.setTitle( " " + LASTURL );
                // activity.setProgress( progress * 100 );

                if (progress == 100) {
                    // stop ProgressDialog after loading
                    dialog.dismiss();

                    // activity.setTitle( " " + LASTURL );
                }
            }
        });

        wv.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(getApplicationContext(),
                        "Error: No Internet Connection ! ",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.indexOf("https://docs.google.com/forms/d/1sCH1GvNtn7yNelzLohXJor_99Wm-pZRrLXUXPqEUX1U/viewform?c=0&w=1") <= 0) {
                    // the link is not for a page on my site, so launch
                    // another Activity that handles URLs

                }
                return false;
            }
            /*****************************************************************/
                /*  Here the load of the page will start so we must launch the  */
                /*  ProgressDialog                                              */
            /*****************************************************************/
            public void onPageStarted(WebView view, String url,
                                      Bitmap favicon) {

                // this is what we should do
                dialog.setMessage("Page loading...");
                dialog.setIndeterminate(true);
                dialog.setCancelable(true);
                dialog.show();
                //
                LASTURL = url;
                view.getSettings().setLoadsImagesAutomatically(true);
                view.getSettings().setBuiltInZoomControls(true);
            }
            /*****************************************************************/
                /*  Here the load of the page will stop so we must dismiss the  */
                /*  ProgressDialog                                              */
            /*****************************************************************/
            public void onPageFinished(WebView view, String url) {
                // this is what we should do
                dialog.dismiss();

            }
        });
        wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wv.setScrollbarFadingEnabled(false);
        wv.loadUrl("https://docs.google.com/forms/d/1sCH1GvNtn7yNelzLohXJor_99Wm-pZRrLXUXPqEUX1U/viewform?c=0&w=1");

    }




    public void onBackPressed() {
        super.onBackPressed();

    }

}
