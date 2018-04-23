package sg.edu.np.twq2.e13webbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private WebView browser;
    private EditText textbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        textbox = findViewById(R.id.tbURL);
        textbox.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    String url = textbox.getText().toString();
                    browser.loadUrl(url);

                    return true;
                }
                return false;
            }
        });
    }

    public void onClick(View v)
    {
        String url = textbox.getText().toString();
        browser.loadUrl(url);
    }
}
