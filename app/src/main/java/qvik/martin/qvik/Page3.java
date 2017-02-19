package qvik.martin.qvik;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import static android.text.Html.FROM_HTML_MODE_COMPACT;
import static android.text.Html.FROM_HTML_MODE_LEGACY;


/**
 * Created by Martin Anderson
 */

public class Page3 extends AppCompatActivity {
    private Typeface helvetica_bold;
    private Typeface helvetica_extended;
    private Typeface helvetica_regular;
    private Data data;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        overridePendingTransition(0, R.anim.slide_down);
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        overridePendingTransition(R.anim.slide_up, R.anim.slide_fixed);
        this.data = Data.getInstance();
        importFonts();
        createToolbar();
        colorStatusBar();
        setContent();
    }

    public void importFonts() {
        this.helvetica_bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_bold.ttf");
        this.helvetica_extended = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_extended.otf");
        this.helvetica_regular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_regular.ttf");
    }

    public void createToolbar() {
        // create toolbar and add "Up Button"
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.icon_navbar_close);
        actionbar.setDisplayShowTitleEnabled(false);
        TextView textView = (TextView) findViewById(R.id.titleChannel);
        textView.setText(getCategorie().toUpperCase() + " CHANNEL");
        textView.setTypeface(helvetica_bold);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, 9);

    }

    public void colorStatusBar() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
    }

    public String getMyTitle() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        return title;
    }

    public String getAgency() {
        Intent intent = getIntent();
        String agency = intent.getStringExtra("agency");
        return agency;
    }

    public String getDate() {
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        return date;
    }

    public String getCategorie() {
        Intent intent = getIntent();
        String categorie = intent.getStringExtra("categorie");
        return categorie;
    }

    public void setContent() {

        String bodyText = "<p> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p> <p> <b> Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </b> </p> <p> Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p> ";


        TextView articleTitle = (TextView) findViewById(R.id.artcle_title);
        articleTitle.setText(getMyTitle());
        articleTitle.setTypeface(helvetica_bold);
        articleTitle.setTextSize(TypedValue.COMPLEX_UNIT_PT, 10);


        TextView body = (TextView) findViewById(R.id.body);

        if (Build.VERSION.SDK_INT >= 24) {
            body.setText(Html.fromHtml(bodyText, FROM_HTML_MODE_LEGACY)); // for 24 api and more
        } else {
            body.setText(Html.fromHtml(bodyText));
        }
        body.setTypeface(helvetica_extended);
        body.setTextSize(TypedValue.COMPLEX_UNIT_PT, 7);

        TextView agency = (TextView) findViewById(R.id.agency);
        agency.setText(getAgency());
        agency.setTypeface(helvetica_bold);
        agency.setTextSize(TypedValue.COMPLEX_UNIT_PT, 5);

        TextView date = (TextView) findViewById(R.id.date);
        date.setText(getDate());
        date.setTypeface(helvetica_bold);
        date.setTextSize(TypedValue.COMPLEX_UNIT_PT, 5);

        TextView tag = (TextView) findViewById(R.id.tag);
        tag.setText(getCategorie().toUpperCase());

        tag.setPaintFlags(tag.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tag.setTypeface(helvetica_bold);
        tag.setTextSize(TypedValue.COMPLEX_UNIT_PT, 5);
    }


}
