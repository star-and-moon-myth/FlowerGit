package com.lnsf.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.lnsf.bean.OrderdetailBean;
import com.lnsf.bean.OrdersBean;
import com.lnsf.dao.impl.InputDaoImpl;
import com.lnsf.dao.impl.OrderdetailDaoImpl;
import com.lnsf.dao.impl.OrdersDaoImpl;
import com.lnsf.dao.impl.UserdetailDaoImpl;
import com.lnsf.service.InputService;
import com.lnsf.service.OrderdetailService;
import com.lnsf.service.OrdersService;
import com.lnsf.service.UserdetailService;
import com.lnsf.service.impl.InputServiceImpl;
import com.lnsf.service.impl.OrderdetailServiceImpl;
import com.lnsf.service.impl.OrdersServiceImpl;
import com.lnsf.service.impl.UserdetailServiceImpl;
import com.lnsf.utils.consoletable.ConsoleTable;
import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class ManagerController {
	public static void cutline() {
		System.out.println("-------------------------------------------------");
	}
	public static int orderPopup(){
		Scanner sc = new Scanner(System.in);
		int o = -1;
		System.out.println("-------------------------------------------------");
		System.out.println("                    1.接受订单                                   ");
		System.out.println("                    2.拒绝订单                                   ");
		System.out.println("-------------------------------------------------");
		while(true){
			System.out.println("请选择>");
			o = sc.nextInt();
			if(o == 1){
				o = 3;
				break;
			}else if(o == 2){
				break;
			}else{
				System.out.println("输入有误");
			}
		}
		return o;
	}
	public static int applyPopup(){
		Scanner sc = new Scanner(System.in);
		int o = -1;
		System.out.println("-------------------------------------------------");
		System.out.println("                    1.接受申请                                   ");
		System.out.println("                    2.拒绝申请                                   ");
		System.out.println("-------------------------------------------------");
		while(true){
			System.out.println("请选择>");
			o = sc.nextInt();
			if(o == 1){
				o = 2;
				break;
			}else if(o == 2){
				o = 3;
				break;
			}else{
				System.out.println("输入有误");
			}
		}
		return o;
	}
	
	private static void logo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:MM");
		SimpleDateFormat sdf1 = new SimpleDateFormat("aa好");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("*                   破事儿多花店                              *");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if(User.getUserName() != null){
			if(User.getUserSex() != null){
				if(User.getUserSex().equals("男"))
					System.out.println(sdf.format(date)+" "+User.getUserName()+"先生,"+sdf1.format(date));
				else
					System.out.println(sdf.format(date)+" "+User.getUserName()+"女士,"+sdf1.format(date));
			}else{
				System.out.println(sdf.format(date)+" "+User.getUserName()+","+sdf1.format(date));
			}
		}else{
			System.out.println(sdf.format(date)+" "+sdf1.format(date));
		}
		cutline();
	}

	public static void managerMenu() {
		logo();
		System.out.println("-----------------破事儿多管理界面-----------------");
		System.out.println("                                                 ");
		System.out.println("                    1.会员管理                                   ");
		System.out.println("                    2.商品管理                                   ");
		System.out.println("                    3.订单管理                                   ");
		System.out.println("                    4.财务管理                                   ");
		System.out.println("                    5.分类管理                                   ");
		System.out.println("                    0.返回                                          ");
		System.out.println("                                                 ");
		System.out.println("-------------------------------------------------");
		System.out.println("输入序号进行管理：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			Member();
			break;
		case 2:
			Product();
			break;
		case 3:
			Order();
			break;
		case 4:
			Finace();
			break;
		case 5:
			Type();
			break;
		case 0:
			break;
		default:
			System.out.println("输入错误！请重新选择！");
			cutline();
			managerMenu();
			break;
		}
	}

	private static void Type() {
		logo();
		System.out.println("---------------------分类管理--------------------");
		System.out.println("                                                 ");
		System.out.println("                   1.分类查询                                     ");
		System.out.println("                   2.分类设置                                     ");
		System.out.println("                   0.返回                                            ");
		System.out.println("                                                 ");
		System.out.println("-------------------------------------------------");
		System.out.println("输入序号进行管理：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		InputService ts = new InputServiceImpl(new InputDaoImpl());
		switch (choose) {
		case 1:
			Type();
			break;
		case 2:
			Type();
			break;
		case 0:
			managerMenu();
			break;
		default:
			System.out.println("输入错误！请重新选择！");
			cutline();
			Type();
			break;
		}
	}

	private static void Finace() {
		logo();
		System.out.println("---------------------财务管理---------------------");
		System.out.println("                                                  ");
		System.out.println("                     1.月报表                                      ");
		System.out.println("                     2.进货录入                                  ");
		System.out.println("                     3.利润                                         ");
		System.out.println("                     0.返回                                         ");
		System.out.println("                                                  ");
		System.out.println("--------------------------------------------------");
		System.out.println("输入序号进行管理：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			System.out.println(">>>月报表");
			while(true){
				System.out.println("请输入月份(输入0返回):");
				int month = sc.nextInt();
				if(month == 0) break;
				MonthlyPeport mp = new MonthlyPeport();
				List<InOut> list = new ArrayList<InOut>();
				list = mp.all(month);
				List<List<Cell>> body = new ArrayList<List<Cell>>();
				for (InOut inOut : list) {
					body.add(inOut.getBody());
				}
				new ConsoleTable.ConsoleTableBuilder().addHeaders(InOut.getHeader()).addRows(body).build().print();
				
				List<Cell> header = new ArrayList<Cell>() {
					{
						add(new Cell("入库总数"));
						add(new Cell("入库总金额"));
						add(new Cell("出库总数"));
						add(new Cell("出库总金额"));
					}
				};
				int incount = 0;int outcount = 0;
				float inpay = 0;float outpay = 0;
				for (InOut inOut : list) {
					incount += inOut.getInNum();
					outcount += inOut.getOutNum();
					inpay += inOut.getInMoney();
					outpay += inOut.getOutMoney();
				}
				String str1 = String.valueOf(incount);
				String str2 = String.valueOf(inpay);
				String str3 = String.valueOf(outcount);
				String str4 = String.valueOf(outpay);
				List<List<Cell>> body1 = new ArrayList<List<Cell>>() {
					{
						add(new ArrayList<Cell>() {
							{
								add(new Cell(Align.CENTER, str1));
								add(new Cell(Align.CENTER, str2));
								add(new Cell(Align.CENTER, str3));
								add(new Cell(Align.CENTER, str4));
							}
						});
					}
				};
				new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body1).build().print();
			}
			Finace();
			break;
		case 2:
			Finace();
			break;
		case 3:
			Finace();
			break;
		case 0:
			managerMenu();
			break;
		default:
			System.out.println("输入错误！请重新选择！");
			cutline();
			Finace();
			break;
		}
	}

	private static void Order() {
		OrdersService os = new OrdersServiceImpl(new OrdersDaoImpl());
		OrderdetailService ods = new OrderdetailServiceImpl(new OrderdetailDaoImpl());
		List<OrdersBean> ol = new ArrayList<OrdersBean>();
		List<OrderdetailBean> odl = new ArrayList<OrderdetailBean>();
		ol = os.selectAll();
		odl = ods.selectAll();
		logo();
		System.out.println("---------------------订单管理--------------------");
		System.out.println("                                                 ");
		System.out.println("                     1.查询订单                                 ");
		System.out.println("                     2.处理订单                                 ");
		System.out.println("                     3.取消订单                                 ");
		System.out.println("                     0.返回                                        ");
		System.out.println("                                                 ");
		System.out.println("-------------------------------------------------");
		System.out.println("输入序号进行管理：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			cutline();
			System.out.println("所有订单:");
			List<List<Cell>> showob = new ArrayList<List<Cell>>();
			for (OrdersBean ordersBean : ol) {
				showob.add(ordersBean.getBody());
			}
			if (showob.isEmpty()) {
				System.out.println("订单列表为空");
				break;
			} else {
				new ConsoleTable.ConsoleTableBuilder()
						.addHeaders(OrdersBean.getHeader()).addRows(showob)
						.build().print();
				while (true) {
					System.out.println("输入订单编号查询详细信息(输入0返回)：");
					int b = sc.nextInt();
					if (b == 0)
						break;
					System.out.println("该订单详情为:");
					List<List<Cell>> showodb = new ArrayList<List<Cell>>();
					OrderdetailBean odb = new OrderdetailBean();
					for (OrderdetailBean odb1 : odl) {
						if (odb1.getOrderId().equals(String.valueOf(b))) {
							odb = odb1;
						}
					}
					showodb.add(odb.getBody());
					if (showodb.isEmpty()) {
						System.out.println("无该订单详情");
					} else {
						new ConsoleTable.ConsoleTableBuilder()
								.addHeaders(OrderdetailBean.getHeader())
								.addRows(showodb).build().print();
					}
				}
			}
			Order();
			break;
		case 2:
			while(true){
				cutline();
				System.out.println("所有未处理订单:");
				List<List<Cell>> showob1 = new ArrayList<List<Cell>>();
				for (OrdersBean ordersBean : ol) {
					if((ordersBean.getState() == 0 || ordersBean.getState() == 1) && ordersBean.getState() != null){
						showob1.add(ordersBean.getBody());
					}
				}
				if(showob1.isEmpty()){
					System.out.println("无未处理订单:");
					break;
				}else{
					new ConsoleTable.ConsoleTableBuilder().addHeaders(OrdersBean.getHeader()).addRows(showob1).build().print();
					System.out.println("请输入所要处理的订单的编号(输入0返回)：");
					int a = sc.nextInt();
					if(a == 0) break;
					OrdersBean ob = new OrdersBean();
					for (OrdersBean ob1 : ol) {
						if(ob1.getOrderId().equals(String.valueOf(a))){
							ob = ob1;
						}
					}
					System.out.println("您将处理以下订单:");
					List<List<Cell>> showob2 = new ArrayList<List<Cell>>();
					showob2.add(ob.getBody());
					new ConsoleTable.ConsoleTableBuilder().addRows(showob2).build().print();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(ob.getState() != null){
						if(ob.getState() == 0){
							int o = orderPopup();
							ob.setState(o);
							ob.setDeliverDate(sdf.format(new Date()));
							if(os.updateByIdSelective(ob) > 0){
								System.out.println("处理完毕");
							}else{
								System.out.println("处理失败");
							}
						}else{
							int o = applyPopup();
							ob.setState(o);
							if(os.updateByIdSelective(ob) > 0){
								System.out.println("处理完毕");
							}else{
								System.out.println("处理失败");
							}
						}
					}
				}
			}
			Order();
			break;
		case 3:
			while(true){
				cutline();
				System.out.println("所有已发货订单:");
				List<List<Cell>> showob3 = new ArrayList<List<Cell>>();
				for (OrdersBean ordersBean : ol) {
					if(ordersBean.getState() == 3 && ordersBean.getState() != null){
						showob3.add(ordersBean.getBody());
					}
				}
				if(showob3.isEmpty()){
					System.out.println("无已发货订单");
					break;
				}else{
					new ConsoleTable.ConsoleTableBuilder().addHeaders(OrdersBean.getHeader()).addRows(showob3).build().print();
					System.out.println("请输入所要处理的订单的编号(输入0返回)：");
					int a = sc.nextInt();
					if(a == 0) break;
					OrdersBean ob = new OrdersBean();
					for (OrdersBean ob1 : ol) {
						if(ob1.getOrderId().equals(String.valueOf(a))){
							ob = ob1;
						}
					}
					System.out.println("您将取消以下订单:");
					List<List<Cell>> showob1 = new ArrayList<List<Cell>>();
					showob1.add(ob.getBody());
					new ConsoleTable.ConsoleTableBuilder().addRows(showob1).build().print();
					ob.setState(2);
					if(os.updateByIdSelective(ob) > 0){
						System.out.println("取消成功");
					}else{
						System.out.println("取消失败");
					}
				}
			}
			Order();
			break;
		case 0:
			managerMenu();
			break;
		default:
			System.out.println("输入错误！请重新选择！");
			cutline();
			Order();
			break;
		}
	}

	private static void Product() {
		logo();
		System.out.println("---------------------商品管理--------------------");
		System.out.println("                                                 ");
		System.out.println("                     1.查询                                        ");
		System.out.println("                     2.更新                                        ");
		System.out.println("                     3.商品上架                                 ");
		System.out.println("                     4.商品下架                                 ");
		System.out.println("                     0.返回                                        ");
		System.out.println("                                                 ");
		System.out.println("-------------------------------------------------");
		System.out.println("输入序号进行管理：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			Product();
			break;
		case 2:
			Product();
			break;
		case 3:
			Product();
			break;
		case 4:
			Product();
			break;
		case 0:
			managerMenu();
			break;
		default:
			System.out.println("输入错误！请重新选择！");
			cutline();
			Product();
			break;
		}
	}

	private static void Member() {
		logo();
		System.out.println("---------------------会员管理--------------------");
		System.out.println("                                                 ");
		System.out.println("                     1.查看会员                                 ");
		System.out.println("                     0.返回                                        ");
		System.out.println("                                                 ");
		System.out.println("-------------------------------------------------");
		System.out.println("输入序号进行操作：");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		UserdetailService uds = new UserdetailServiceImpl(
				new UserdetailDaoImpl());
		switch (choose) {
		case 1:
			Member();
			break;
		case 0:
			managerMenu();
			break;
		default:
			System.out.println("输入错误！请重新选择！");
			cutline();
			Member();
			break;
		}
	}

}
