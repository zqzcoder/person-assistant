package bingke.adapter;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;


public abstract class BaseAdapter<T> extends android.widget.BaseAdapter{

	private Context context;
	
	// 数据源，需要显示在AdapterView中的数据的集合
	private List<T> data;
	
	// 用于将XML加载为View对象的工具
	private LayoutInflater inflater;
	
	
	// context对象，data数据源，即需要显示在AdapterView中的数据的集合
	public BaseAdapter(Context context, List<T> data) {
		super();
			
		
		setContext(context);
		setData(data);
		setLayoutInflater();
	}

	@Override 
	public int getCount() {
		// 【功能】 返回数据源的数据量，即有多少条数据需要被显示
		return data.size();
	}

	public final Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		if (null == context) {
			throw new IllegalArgumentException("参数context不允许为null!");
		}
		this.context = context;
	}

	// 设置数据源，即需要显示在AdapterView中的数据的集合
	public final List<T> getData() {
		return data;
	}

	// 获取数据的List集合
	public final void setData(List<T> data) {
		if (null == data) {
			data = new ArrayList<T>();
		}
		this.data = data;
	}

	// 获取LayoutInflater对象
	public final LayoutInflater getLayoutInflater() {
		return inflater;
	}

	// 设置LayoutInflater属性的值，该方法必须在{@link #setContext(Context)} 方法之后调用
	public final void setLayoutInflater() {
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}


}
