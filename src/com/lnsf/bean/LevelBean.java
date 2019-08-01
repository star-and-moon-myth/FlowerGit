package com.lnsf.bean;

public class LevelBean {

	private Integer levelId;
	private String levelName;
	private Integer lowPoint;
	private Integer highPoint;
	private Integer flag;

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