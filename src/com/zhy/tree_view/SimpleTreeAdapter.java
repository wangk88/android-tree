package com.zhy.tree_view;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.tree.bean.Node;
import com.zhy.tree.bean.TreeListViewAdapter;
import com.zhy.tree_view.R;

public class SimpleTreeAdapter<T> extends TreeListViewAdapter<T> {

	public SimpleTreeAdapter(ListView mTree, Context context, List<T> datas,
			int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException {
		super(mTree, context, datas, defaultExpandLevel);
	}

	@Override
	public View getConvertView(final Node node, int position, View convertView,
			ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			viewHolder.icon2 = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon2);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (node.getIcon() == -1) {
			viewHolder.icon.setVisibility(View.INVISIBLE);
			viewHolder.icon2.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {

					if (node.getIcon2() == 2130837505) {
						node.setIcon2(R.drawable.app);
					} else if (node.getIcon2() == 2130837504) {
						node.setIcon2(R.drawable.ic_launcher);
					}

					notifyDataSetChanged();
				}
			});
			viewHolder.icon2.setImageResource(node.getIcon2());
			
		} else {
			viewHolder.icon.setVisibility(View.VISIBLE);
			viewHolder.icon2.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {

					if (node.getIcon2() == 2130837505) {
						node.setIcon2(R.drawable.app);
					} else if (node.getIcon2() == 2130837504) {
						node.setIcon2(R.drawable.ic_launcher);
					}

					notifyDataSetChanged();
				}
			});
			viewHolder.icon.setImageResource(node.getIcon());
			viewHolder.icon2.setImageResource(node.getIcon2());
		}

		viewHolder.label.setText(node.getName());

		return convertView;
	}

	private final class ViewHolder {
		ImageView icon;
		TextView label;
		ImageView icon2;
	}

}
