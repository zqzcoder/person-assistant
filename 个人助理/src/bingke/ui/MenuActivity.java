package bingke.ui;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import bingke.adapter.AttendanceAdapter;
import bingke.adapter.BaseAdapter;
import bingke.entity.Application;

public class MenuActivity extends Activity implements OnClickListener{
	private Button btnTabItemMessage;      // 消息
	private Button btnTabItemAttendance;   // 考勤
	private Button btnTabItemApplication;  // 应用
	private Button btnTabItemMy;           // 我
	private TextView tvContent;
	
	
	private ListView lvContacts;
	
	private BaseAdapter messageadapter;
	
	private  List<Application> applications;
	private ImageView tvContents;
	private AttendanceAdapter attendanceadapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu);
		
		
		setViews();                        // 从界面获取控件
		setListeners();                    // 设置监听器
		selectButton(btnTabItemMessage);   // 设置初始状态
		
		createMessageData(); // 创建ListView数据源
		createMessageAdapter(); // 创建并配置Adapter
	}
	
	
	// Message选项卡
	private void createMessageData() {
		applications = new ArrayList<Application>();
		applications.add(new Application("未处理事项", "事情还未做完哟~", R.drawable.ic_message_matter));
		applications.add(new Application("提醒", "有紧急的事情，需要跟进!", R.drawable.ic_message_remind));
		applications.add(new Application("小助理", "分配任务，逐一跟踪", R.drawable.ic_message_assistant));
	}
	
	
	private void createMessageAdapter() {
		messageadapter = new AttendanceAdapter(this, applications);
		
		if (null == lvContacts) {
			Log.d("debug", "lvContacts null");
		}
		
		lvContacts.setAdapter(messageadapter);
	}
	
	
	// Attendance选项卡
		private void createAttendanceData() {
			applications = new ArrayList<Application>();
			applications.add(new Application("打卡", "打卡，记录每天的事情", R.drawable.ic_attendance_punch_card));
			applications.add(new Application("编辑", "更正考勤记录~~", R.drawable.ic_attendance_edit));
			applications.add(new Application("汇总", "回顾考勤事项，以便进行调整~~", R.drawable.ic_attendance_collect));
		}
		
		
		private void createAttendanceAdapter() {
			attendanceadapter = new AttendanceAdapter(this, applications);
			
			if (null == lvContacts) {
				Log.d("debug", "lvContacts null");
			}
			
			lvContacts.setAdapter(attendanceadapter);
		}
	
	
	// Application选项卡
	private void createApplicationAdapter() {
		messageadapter = new AttendanceAdapter(this, applications);
		
		if (null == lvContacts) {
			Log.d("debug", "lvContacts null");
		}
		
		lvContacts.setAdapter(messageadapter);
	}

	private void createApplicationData() {
		applications = new ArrayList<Application>();
		applications.add(new Application("每日主线", "日常和想做的", R.drawable.ic_application_circuit));
		applications.add(new Application("每周任务", "分配任务，逐一跟踪", R.drawable.ic_application_task));
		applications.add(new Application("日程提醒", "有事情，先定时!", R.drawable.ic_application_remind));
		applications.add(new Application("汇总", "日报、周报、月报", R.drawable.ic_application_collect));
		applications.add(new Application("人脉", "人脉，是你事业上升的推进器！", R.drawable.ic_application_people));
		applications.add(new Application("每月计划", "按长期目标，提前规划每月事项！", R.drawable.ic_application_menstrualplan));
		applications.add(new Application("长期计划", "规划长期目标，并朝着这个目标前进！", R.drawable.ic_application_strategy));
		
	}
	

	
	// My选项卡
	private void createMyData() {
		applications = new ArrayList<Application>();
		applications.add(new Application("设置", "", R.drawable.ic_my_setup));
		applications.add(new Application("收藏", "", R.drawable.ic_my_collect));
		applications.add(new Application("帮助和反馈", "", R.drawable.ic_my_help_and_response));
	}
	
	
	private void createMyAdapter() {
		messageadapter = new AttendanceAdapter(this, applications);
		
		if (null == lvContacts) {
			Log.d("debug", "lvContacts null");
		}
		
		lvContacts.setAdapter(messageadapter);
	}
		
	
	
	 // 设置监听器
	private void setListeners() {
		// 4. 创建监听器对象，配置给每一个Button
		btnTabItemMessage.setOnClickListener(MenuActivity.this);
		btnTabItemAttendance.setOnClickListener(MenuActivity.this);
		btnTabItemApplication.setOnClickListener(MenuActivity.this);
		btnTabItemMy.setOnClickListener(MenuActivity.this);
		
	}

	// 从界面获取控件
	private void setViews() {
		// 2. 初始化控件
		btnTabItemMessage = (Button) findViewById(R.id.btn_tab_item_message);
		btnTabItemAttendance = (Button) findViewById(R.id.btn_tab_item_attendance);
		btnTabItemApplication = (Button) findViewById(R.id.btn_tab_item_application);
		btnTabItemMy = (Button) findViewById(R.id.btn_tab_item_my);
		tvContent = (TextView) findViewById(R.id.tv_title);
		lvContacts = (ListView) findViewById(R.id.lv_contacts);
	}
	
	
	// 选中某个按钮
	private void selectButton(Button button) {
		btnTabItemMessage.setEnabled(true);
		btnTabItemAttendance.setEnabled(true);
		btnTabItemApplication.setEnabled(true);
		btnTabItemMy.setEnabled(true);
		
		button.setEnabled(false);
		
		tvContent.setText(button.getText());
	}
	
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_tab_item_message:
			selectButton(btnTabItemMessage);
			createMessageData(); // 创建ListView数据源
			createMessageAdapter(); // 创建并配置Adapter
			break;
			
		case R.id.btn_tab_item_attendance:
			selectButton(btnTabItemAttendance);
			createAttendanceData(); // 创建ListView数据源
			createAttendanceAdapter(); // 创建并配置Adapter
			break;
			
		case R.id.btn_tab_item_application:
			selectButton(btnTabItemApplication);
			createApplicationData(); // 创建ListView数据源
			createApplicationAdapter(); // 创建并配置Adapter
			break;
			
		case R.id.btn_tab_item_my:
			selectButton(btnTabItemMy);
			createMyData(); // 创建ListView数据源
			createMyAdapter(); // 创建并配置Adapter
			break;
		}
		
	}
	
	
	
	

}
