package bingke.entity;

public class Attendance {
	private String matter;
	private String remark;
	private int ImageResId; // image resource id
	
	public Attendance(String matter, String remark, int imageResId) {
		super();
		this.matter = matter;
		this.remark = remark;
		ImageResId = imageResId;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getImageResId() {
		return ImageResId;
	}

	public void setImageResId(int imageResId) {
		ImageResId = imageResId;
	}
	
	
	
}
