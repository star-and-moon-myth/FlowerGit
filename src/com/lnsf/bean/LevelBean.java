package com.lnsf.bean;

public class LevelBean {

	private Integer levelId;
	private String levelName;
	private Integer lowPoint;
	private Integer highPoint;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(levelId != null){
			o[c++] = levelId;
		}
		if(levelName != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = levelName;
		}
		if(lowPoint != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = lowPoint;
		}
		if(highPoint != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = highPoint;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		return o;
	}
	
	public Object[] getAllbeforeId(){
		int c = 0;
		Object[] o = new Object[1];
		if(levelName != null){
			o[c++] = levelName;
		}
		if(lowPoint != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = lowPoint;
		}
		if(highPoint != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = highPoint;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(levelId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = levelId;
		}
		return o;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public Integer getLowPoint() {
		return lowPoint;
	}

	public Integer getHighPoint() {
		return highPoint;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setLowPoint(Integer lowPoint) {
		this.lowPoint = lowPoint;
	}

	public void setHighPoint(Integer highPoint) {
		this.highPoint = highPoint;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public LevelBean() {
		super();
	}

	public LevelBean(Integer levelId, String levelName, Integer lowPoint,
			Integer highPoint, Integer flag) {
		super();
		this.levelId = levelId;
		this.levelName = levelName;
		this.lowPoint = lowPoint;
		this.highPoint = highPoint;
		this.flag = flag;
	}
}