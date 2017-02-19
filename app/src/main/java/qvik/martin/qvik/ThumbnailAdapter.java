package qvik.martin.qvik;

import android.content.Context;
import android.graphics.Color;
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

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    Context context;
    ArrayList<Thumbnail> thumbnails = new ArrayList<>();
    private Typeface helvetica_bold;
    private Typeface helvetica_extended;
    private Typeface helvetica_regular;

    public ThumbnailAdapter(Context context, ArrayList<Thumbnail> thumbnails) {
        super(context, R.layout.thumb_singleview, thumbnails);

        this.context = context;
        this.thumbnails = thumbnails;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.thumb_singleview, parent, false);
        }
        importFonts(convertView);

        // Get the Thumbnail object located at this position

        Thumbnail currentThumbnail = getItem(position);

        TextView description = (TextView) convertView.findViewById(R.id.categorie);
        description.setText(currentThumbnail.getDesc().toUpperCase());
        description.setTypeface(helvetica_extended);

        description.setTextSize(TypedValue.COMPLEX_UNIT_PT, 6);
        description.setBackgroundResource(currentThumbnail.getId());

        // Return the whole item layout
        return convertView;
    }

    public void importFonts(View view) {
        this.helvetica_bold = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/helve_bold.ttf");
        this.helvetica_extended = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/helve_extended.otf");
        this.helvetica_regular = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/helve_regular.ttf");
    }


}
