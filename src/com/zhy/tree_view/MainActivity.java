package com.zhy.tree_view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.zhy.bean.Bean;
import com.zhy.bean.FileBean;
import com.zhy.tree.bean.Node;
import com.zhy.tree.bean.TreeListViewAdapter;
import com.zhy.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;

public class MainActivity extends Activity {
	private List<Bean> mDatas = new ArrayList<Bean>();
	private List<FileBean> mDatas2 = new ArrayList<FileBean>();
	private List<FileBean> mDatas3 = new ArrayList<FileBean>();
	private ListView mTree, mTree2;
	private TreeListViewAdapter mAdapter, mAdapter2;
	ImageView iv = null;

	// 在这里实现onTouchEvent
	public boolean onTouchEvent(MotionEvent event) {
		// 在这里判断一下如果是按下操作就获取坐标然后执行方法
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// displayXY(event.getX(), event.getY());
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		// initDatas2();
		
		mTree = (ListView) findViewById(R.id.id_tree);

		// mTree2 = (ListView) findViewById(R.id.id_tree2);

		try {
			mAdapter = new SimpleTreeAdapter<Bean>(mTree, this, mDatas, 10);
			// mAdapter2 = new SimpleTreeAdapter<FileBean>(mTree2, this,
			// mDatas3, 10);
			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener() {
				@Override
				public void onClick(Node node, int position) {


					if (node.isLeaf()) {
                         
						if(node.getIcon() == 2130837505){
							int k = 0;
							int j = k;
						}
						
						
/*						if (node.getIcon() == 2130837505) {
							node.setIcon(R.drawable.app);
						} else if (node.getIcon() == 2130837504) {
							node.setIcon(R.drawable.ic_launcher);
						}*/
						mAdapter.notifyDataSetChanged();
						Toast.makeText(getApplicationContext(), node.getName(),
								100).show();
					}
				}

			});
			/*
			 * mAdapter2.setOnTreeNodeClickListener(new
			 * OnTreeNodeClickListener() {
			 * 
			 * @Override public void onClick(Node node, int position) { if
			 * (node.isLeaf()) { Toast.makeText(getApplicationContext(),
			 * node.getName(), Toast.LENGTH_SHORT).show(); } }
			 * 
			 * });
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		mTree.setAdapter(mAdapter);

	}

	private void initDatas() {
		mDatas.add(new Bean(1, 0, "根目录1"));
		/*
		 * mDatas.add(new Bean(2, 0, "根目录2")); mDatas.add(new Bean(3, 0,
		 * "根目录3")); mDatas.add(new Bean(4, 0, "根目录4"));
		 */
		mDatas.add(new Bean(5, 1, "子目录1-1"));
		mDatas.add(new Bean(6, 1, "子目录1-2"));

		mDatas.add(new Bean(7, 5, "子目录1-1-1"));
		// mDatas.add(new Bean(8, 2, "子目录2-1"));

		/*
		 * mDatas.add(new Bean(9, 4, "子目录4-1")); mDatas.add(new Bean(10, 4,
		 * "子目录4-2"));
		 */

		/*
		 * mDatas.add(new Bean(11, 10, "子目录4-2-1")); mDatas.add(new Bean(12, 10,
		 * "子目录4-2-3")); mDatas.add(new Bean(13, 10, "子目录4-2-2"));
		 */
		/*
		 * mDatas.add(new Bean(14, 9, "子目录4-1-1")); mDatas.add(new Bean(15, 9,
		 * "子目录4-1-2")); mDatas.add(new Bean(16, 9, "子目录4-1-3"));
		 */
		mDatas.add(new Bean(17, 6, "子目录1-2-1"));
		mDatas.add(new Bean(18, 6, "子目录1-2-2"));

		mDatas2.add(new FileBean(1, 0, "文件管理系统"));
		mDatas2.add(new FileBean(2, 1, "游戏"));
		mDatas2.add(new FileBean(3, 1, "文档"));
		mDatas2.add(new FileBean(4, 1, "程序"));
		mDatas2.add(new FileBean(5, 2, "war3"));
		mDatas2.add(new FileBean(6, 2, "刀塔传奇"));

		mDatas2.add(new FileBean(7, 4, "面向对象"));
		mDatas2.add(new FileBean(8, 4, "非面向对象"));

		mDatas2.add(new FileBean(9, 7, "C++"));
		mDatas2.add(new FileBean(10, 7, "JAVA"));
		mDatas2.add(new FileBean(11, 7, "Javascript"));
		// mDatas2.add(new FileBean(12, 8, "C"));

	}

	private void initDatas2() {
		/*
		 * mDatas.add(new Bean(1, 0, "根目录1")); mDatas.add(new Bean(2, 0,
		 * "根目录2")); mDatas.add(new Bean(3, 0, "根目录3")); mDatas.add(new Bean(4,
		 * 0, "根目录4")); mDatas.add(new Bean(5, 1, "子目录1-1")); mDatas.add(new
		 * Bean(6, 1, "子目录1-2"));
		 * 
		 * mDatas.add(new Bean(7, 5, "子目录1-1-1")); mDatas.add(new Bean(8, 2,
		 * "子目录2-1"));
		 * 
		 * mDatas.add(new Bean(9, 4, "子目录4-1")); mDatas.add(new Bean(10, 4,
		 * "子目录4-2"));
		 * 
		 * mDatas.add(new Bean(11, 10, "子目录4-2-1")); mDatas.add(new Bean(12, 10,
		 * "子目录4-2-3")); mDatas.add(new Bean(13, 10, "子目录4-2-2"));
		 * mDatas.add(new Bean(14, 9, "子目录4-1-1")); mDatas.add(new Bean(15, 9,
		 * "子目录4-1-2")); mDatas.add(new Bean(16, 9, "子目录4-1-3"));
		 */

		mDatas3.add(new FileBean(1, 0, "文件管理系统"));
		mDatas3.add(new FileBean(2, 1, "游戏"));
		mDatas3.add(new FileBean(3, 1, "文档"));
		mDatas3.add(new FileBean(4, 1, "程序"));
		mDatas3.add(new FileBean(5, 2, "war3"));
		mDatas3.add(new FileBean(6, 2, "刀塔传奇"));

		mDatas3.add(new FileBean(7, 4, "面向对象"));
		mDatas3.add(new FileBean(8, 4, "非面向对象"));

		mDatas3.add(new FileBean(9, 7, "C++"));
		mDatas3.add(new FileBean(10, 7, "JAVA"));
		mDatas3.add(new FileBean(11, 7, "Javascript"));
		mDatas3.add(new FileBean(12, 8, "C"));

	}

}
