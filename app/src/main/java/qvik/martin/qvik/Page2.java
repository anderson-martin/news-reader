package qvik.martin.qvik;


/**
 * Created by Martin Anderson
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class Page2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private HashMap<Integer, Headline> headlinesHashMap;
    private ArrayList<Headline> headlinesArrayList = new ArrayList<Headline>();
    private Typeface helvetica_bold;
    private Typeface helvetica_extended;
    private Typeface helvetica_regular;
    private Data data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.data = Data.getInstance();
        setContentView(R.layout.page2);
        createToolbar();
        colorStatusBar();
        importFonts();
        getData();
        implementAdapter();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView title = (TextView) view.findViewById(R.id.news_title);
        TextView agency = (TextView) view.findViewById(R.id.agency);
        TextView date = (TextView) view.findViewById(R.id.date);
        Intent intent = new Intent(getBaseContext(), Page3.class);
        intent.putExtra("title", title.getText());
        intent.putExtra("agency", agency.getText());
        intent.putExtra("date", date.getText());
        intent.putExtra("categorie", getCategorie().toLowerCase());
        startActivity(intent);
    }

    public ArrayList<Headline> getData() {
        ArrayList<Headline> result = new ArrayList<>();
        Log.i("recieved cat", "this is recieved categorie:" + getCategorie());
        return this.data.getData(getCategorie());    }

    public void createToolbar() {
        // create toolbar and add "Up Button"
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back_button);
        actionbar.setDisplayShowTitleEnabled(false);
    }

    public void colorStatusBar() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
    }

    public void importFonts() {
        this.helvetica_bold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_bold.ttf");
        this.helvetica_extended = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_extended.otf");
        this.helvetica_regular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/helve_regular.ttf");
    }


    public void implementAdapter() {
        HeadlineAdapter headlineAdapter = new HeadlineAdapter(this, getData());
        ListView listView = (ListView) findViewById(R.id.listview_page2);

        listView.addHeaderView(createHeader(listView), null, false);
        listView.setAdapter(headlineAdapter);
        listView.setOnItemClickListener(this);

    }

    public ViewGroup createHeader(ListView listView) {
        //adding header to listview
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.page2_header, listView, false);

        LinearLayout linearLayout = (LinearLayout) header.findViewById(R.id.pictureChannel);
        linearLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), this.data.getCategorieImageId(getCategorie())));

        // set content of header
        TextView titleChannel = (TextView) header.findViewById(R.id.titleChannel);
        titleChannel.setText(getCategorie() + " Channel");
        titleChannel.setTypeface(helvetica_bold);
        titleChannel.setTextSize(TypedValue.COMPLEX_UNIT_PT, 11);

        Button follow = (Button) header.findViewById(R.id.button_follow);
        follow.setText("Following");
        follow.setTypeface(helvetica_bold);
        follow.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);


        TextView followers = (TextView) header.findViewById(R.id.followers);
        followers.setText("235K Followers");
        followers.setTypeface(helvetica_bold);
        followers.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);

        return header;
    }


    public String getCategorie() {
        Intent intent = getIntent();
        String categorie = intent.getStringExtra("categorie");
        return categorie.toLowerCase();
    }

}
