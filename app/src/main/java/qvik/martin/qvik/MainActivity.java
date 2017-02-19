package qvik.martin.qvik;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Thread.sleep;


/**
 * Created by Martin Anderson
 */

public class MainActivity extends AppCompatActivity {
    private ArrayList<Thumbnail> thumbnails;
    private TextView categorie;
    private Typeface helvetica_bold;
    private Typeface helvetica_extended;
    private Typeface helvetica_regular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("here", "till here is processed");
        Data data = Data.getInstance();
        createToolbar();
        colorStatusBar();
        this.thumbnails = data.getThumbnails();
        useAdapter();
        importFonts();
        setButtonContent();
    }
    public void colorStatusBar() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
    }

    public void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar_main);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

    }

    public void useAdapter() {
        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(this, thumbnails);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(thumbnailAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                    categorie = (TextView) v.findViewById(R.id.categorie);
                    Intent i = new Intent(getApplicationContext(), Page2.class);
                    i.putExtra("categorie", categorie.getText());
                    startActivity(i);
            }
        });
    }

    public void importFonts() {
        this.helvetica_bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_bold.ttf");
        this.helvetica_extended = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_extended.otf");
        this.helvetica_regular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_regular.ttf");
    }
    public void setButtonContent(){
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("Following");
        button1.setTypeface(helvetica_bold);
        button1.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("Popular");
        button2.setTypeface(helvetica_bold);
        button2.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("Explore");
        button3.setTypeface(helvetica_bold);
        button3.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);
    }
}
