package com.lnsf.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.List;

import com.lnsf.dao.impl.ConsigneeDaoImpl;
import com.lnsf.service.ConsigneeService;
import com.lnsf.service.impl.ConsigneeServiceImpl;
import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class OrdersBean {

	private String orderId;
	private Date orderDate;
	private Date deliverDate;
	private Date finishDate;
	private Integer conId;
	private Float orderPrice;
	private Integer state;
	private Integer flag;
	
	public Object[] getAll(){
		int c = 0;
		Object[] o = new Object[1];
		if(orderId != null){
			o[c++] = orderId;
		}
		if(orderDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderDate;
		}
		if(deliverDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = deliverDate;
		}
		if(finishDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = finishDate;
		}
		if(conId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conId;
		}
		if(orderPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderPrice;
		}
		if(state != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = state;
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
		if(orderDate != null){
			o[c++] = orderDate;
		}
		if(deliverDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = deliverDate;
		}
		if(finishDate != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = finishDate;
		}
		if(conId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = conId;
		}
		if(orderPrice != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderPrice;
		}
		if(state != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = state;
		}
		if(flag != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = flag;
		}
		if(orderId != null){
			if(c == o.length){
				Object[] temp = new Object[c+1];
				System.arraycopy(o, 0, temp, 0, o.length);
				o = temp;
			}
			o[c++] = orderId;
		}
		return o;
	}

	public String getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public Integer getConId() {
		return conId;
	}

	public Float getOrderPrice() {
		return orderPrice;
	}

	public Integer getState() {
		return state;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public OrdersBean() {
		super();
	}

	public OrdersBean(String orderId, Date orderDate, Date deliverDate,
			Date finishDate, Integer conId, Float orderPrice, Integer state,
			Integer flag) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.deliverDate = deliverDate;
		this.finishDate = finishDate;
		this.conId = conId;
		this.orderPrice = orderPrice;
		this.state = state;
		this.flag = flag;
	}
	
	public static List<Cell> getHeader() {
		List<Cell> header = new ArrayList<Cell>() {
			{
				add(new Cell("订单号"));
				add(new Cell("下单日期"));
				add(new Cell("发货日期"));
				add(new Cell("收货日期"));
				add(new Cell("收货地址"));
				add(new Cell("订单金额"));
				add(new Cell("订单状态"));
			}
		};
		return header;
	}
	
	public List<Cell> getBody() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strPrice = String.valueOf(orderPrice);
		ConsigneeService cs = new ConsigneeServiceImpl(new ConsigneeDaoImpl());
//		String strAddr = cs.selectById(conId).getConAddr();
		String strAddr = String.valueOf(conId);
		String strState = "";
		if(state != null){
			if(state == 0){
				strState = "用户已下单";
			}else if(state == 1){
				strState = "申请取消中";
			}else if(state == 2){
				strState = "订单已取消";
			}else if(state == 3){
				strState = "订单已发货";
			}else if(state == 4){
				strState = "已确认收货";
			}
		}
		String strstate = "" + strState;
		String strorderDate = "",strdeliverDate = "",strfinishDate = "";
		if (orderDate != null) {
			strorderDate = sdf.format(orderDate);
		} else {

		}
		if (deliverDate != null) {
			strdeliverDate = sdf.format(deliverDate);
		} else {

		}
		if (finishDate != null) {
			strfinishDate = sdf.format(finishDate);
		} else {

		}
		String s1 = strorderDate;
		String s2 = strdeliverDate;
		String s3 = strfinishDate;
		List<Cell> body = new ArrayList<Cell>() {
			{
				add(new Cell(Align.CENTER, orderId));
				add(new Cell(Align.CENTER, s1));
				add(new Cell(Align.CENTER, s2));
				add(new Cell(Align.CENTER, s3));
				add(new Cell(Align.CENTER, strPrice));
				add(new Cell(Align.CENTER, strAddr));
				add(new Cell(Align.CENTER, strstate));
			}
		};
		return body;
	}
}