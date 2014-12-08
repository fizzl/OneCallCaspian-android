package uk.co.onecallcaspian.custom.adapter;

import uk.co.onecallcaspian.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class SmiliesListAdapter extends BaseAdapter {

	public SmiliesListAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return SmiliesManager.instance().getCount();
	}

	@Override
	public Object getItem(int position) {
		return SmiliesManager.instance().getSmilie(position, true);
	}

	@Override
	public long getItemId(int position) {
		return -1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		ViewGroup v = (ViewGroup) convertView;
		if(v == null) {
			v = (ViewGroup) inflater.inflate(R.layout.list_item_smilie, parent, false);
		}
		ImageView btn = (ImageView) v.findViewById(R.id.img_smilie);
		SmiliesListItem si = SmiliesManager.instance().getSmilie(position, true);
		btn.setImageResource(si.getImageResource());
		return v;
	}
	
	Context context;
}