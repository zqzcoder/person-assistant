package bingke.entity;



public class Application {
	private String matter;
	private String remark;
	private int ImageResId; // image resource id
	
	public Application( String matter, String remark, int imageResId) {
		super();
		ImageResId = imageResId;
		this.matter = matter;
		this.remark = remark;
	}

	public int getImageResId() {
		return ImageResId;
	}

	public void setImageResId(int imageResId) {
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
	
	
	
}
