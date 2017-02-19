package qvik.martin.qvik;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Martin Anderson
 */

public class HeadlineAdapter extends ArrayAdapter<Headline> {
    private Typeface helvetica_bold;
    private Typeface helvetica_extended;
    private Typeface helvetica_regular;

    public HeadlineAdapter(Activity context, ArrayList<Headline> headlines) {
        super(context, 0, headlines);
        importFonts(context);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.page2_listitem, parent, false);
        }

        // Get the Headline object located at this position
        Headline currentHeadline = getItem(position);

        // set contents
        TextView agency = (TextView) convertView.findViewById(R.id.agency);
        agency.setText(currentHeadline.getAgency());
        agency.setTypeface(helvetica_bold);
        agency.setTextSize(TypedValue.COMPLEX_UNIT_PT, 5);

        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(currentHeadline.getDate());
        date.setTypeface(helvetica_bold);
        date.setTextSize(TypedValue.COMPLEX_UNIT_PT, 5);

        TextView title = (TextView) convertView.findViewById(R.id.news_title);
        title.setText(currentHeadline.getTitle());
        title.setTypeface(helvetica_bold);
        title.setTextSize(TypedValue.COMPLEX_UNIT_PT, 9);

        return convertView;
    }

    public void importFonts(Activity context) {
        this.helvetica_bold = Typeface.createFromAsset(context.getAssets(), "fonts/helve_bold.ttf");
        this.helvetica_extended = Typeface.createFromAsset(context.getAssets(), "fonts/helve_extended.otf");
        this.helvetica_regular = Typeface.createFromAsset(context.getAssets(), "fonts/helve_regular.ttf");
    }


}
