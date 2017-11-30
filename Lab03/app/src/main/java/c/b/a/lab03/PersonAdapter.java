package c.b.a.lab03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class PersonAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private String[] mDataSource;

    public PersonAdapter(Context context, String[] list) {
        mContext = context;
        mDataSource = list;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //1
    @Override
    public int getCount() {
        return mDataSource.length;
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource[position];
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.activity_main, parent, false);

        // Get name element
        TextView row_name =
                (TextView) rowView.findViewById(R.id.row_name);
        row_name.setText(mDataSource[position]);

        return rowView;
    }
}