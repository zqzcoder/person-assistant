package bingke.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bingke.entity.Application;
import bingke.ui.R;

public class ApplicationAdapter extends BaseAdapter<Application>{

	public ApplicationAdapter(Context context, List<Application> data) {
		super(context, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		// 1.根据position获取需要显示的数据
		Application message = getData().get(position);
		
		// 2. 判断convertView是否为null
		if (null == convertView) {
			
			
			// 2.1 如果convertView为null，则根据XML的模板加载
			convertView = getLayoutInflater()
				.inflate(R.layout.contact_item_application, null);
			
			// 2.2 从convertView中检索到具体显示数据的控件，并封装到holder中
			holder = new ViewHolder();
			holder.ivImage = (ImageView) convertView.findViewById(R.id.iv_contact_item_image);
			holder.tvMatter = (TextView) convertView.findViewById(R.id.tv_contact_item_matter);
			holder.tvRemark = (TextView) convertView.findViewById(R.id.tv_contact_item_remark);
		
			// 2.3 将holder封装进convertView
			convertView.setTag(holder);
		} else {
			// convertView不为null，则从convertView中获取holder对象
			holder = (ViewHolder) convertView.getTag();
		}
		
		// 3. 向控件中填充数据
		
		holder.tvMatter.setText(message.getMatter());
		holder.tvRemark.setText(message.getRemark());
		holder.ivImage.setImageResource(message.getImageResId());
		
		
		// 4. 返回convertView
		return convertView;
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}

	class ViewHolder {
		ImageView ivImage;
		TextView tvMatter;
		TextView tvRemark;
	}
	
}
