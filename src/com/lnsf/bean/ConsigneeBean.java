package com.lnsf.bean;

public class ConsigneeBean {

	private Integer conId;
	private String conName;
	private String conTel;
	private String conAddr;
	private String userId;
	private Integer flag;

	public Integer getConId() {
		return conId;
	}

	public String getConName() {
		return conName;
	}

	public String getConTel() {
		return conTel;
	}

	public String getConAddr() {
		return conAddr;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public void setConTel(String conTel) {
		this.conTel = conTel;
	}

	public void setConAddr(String conAddr) {
		this.conAddr = conAddr;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public ConsigneeBean() {
		super();
	}

	public ConsigneeBean(Integer conId, String conName, String conTel,
			String conAddr, String userId, Integer flag) {
		super();
		this.conId = conId;
		this.conName = conName;
		this.conTel = conTel;
		this.conAddr = conAddr;
		this.userId = userId;
		this.flag = flag;
	}
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(conId != null){
			o[c++] = conId;
		}
		if(conName != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conName;
		}
		if(conTel != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conTel;
		}
		if(conAddr != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conAddr;
		}
		if(userId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userId;
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
		if(conName != null){
			o[c++] = conName;
		}
		if(conTel != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conTel;
		}
		if(conAddr != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conAddr;
		}
		if(userId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = userId;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(conId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conId;
		}
		return o;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conAddr == null) ? 0 : conAddr.hashCode());
		result = prime * result + ((conId == null) ? 0 : conId.hashCode());
		result = prime * result + ((conName == null) ? 0 : conName.hashCode());
		result = prime * result + ((conTel == null) ? 0 : conTel.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsigneeBean other = (ConsigneeBean) obj;
		if (conAddr == null) {
			if (other.conAddr != null)
				return false;
		} else if (!conAddr.equals(other.conAddr))
			return false;
		if (conId == null) {
			if (other.conId != null)
				return false;
		} else if (!conId.equals(other.conId))
			return false;
		if (conName == null) {
			if (other.conName != null)
				return false;
		} else if (!conName.equals(other.conName))
			return false;
		if (conTel == null) {
			if (other.conTel != null)
				return false;
		} else if (!conTel.equals(other.conTel))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsigneeBean [conId=" + conId + ", conName=" + conName
				+ ", conTel=" + conTel + ", conAddr=" + conAddr + ", userId="
				+ userId + ", flag=" + flag + "]";
	}
	
	
}