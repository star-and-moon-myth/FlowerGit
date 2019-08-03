package com.lnsf.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.lnsf.bean.ConsigneeBean;
import com.lnsf.bean.ProductBean;
import com.lnsf.bean.TypeBean;
import com.lnsf.bean.UserBean;
import com.lnsf.bean.UserdetailBean;
import com.lnsf.dao.impl.ConsigneeDaoImpl;
import com.lnsf.dao.impl.ProductDaoImpl;
import com.lnsf.dao.impl.TypeDaoImpl;
import com.lnsf.dao.impl.UserDaoImpl;
import com.lnsf.dao.impl.UserdetailDaoImpl;
import com.lnsf.service.ConsigneeService;
import com.lnsf.service.ProductService;
import com.lnsf.service.TypeService;
import com.lnsf.service.UserService;
import com.lnsf.service.UserdetailService;
import com.lnsf.service.impl.ConsigneeServiceImpl;
import com.lnsf.service.impl.ProductServiceImpl;
import com.lnsf.service.impl.TypeServiceImpl;
import com.lnsf.service.impl.UserServiceImpl;
import com.lnsf.service.impl.UserdetailServiceImpl;
import com.lnsf.utils.C3p0Utils;
import com.lnsf.utils.VenomUtils;
import com.lnsf.utils.consoletable.ConsoleTable;
import com.lnsf.utils.consoletable.enums.Align;
import com.lnsf.utils.consoletable.table.Cell;

public class UserInterface {

	public static void cutline() {
		System.out.println("----------------------------------------");
	}
	public static void error() {
		System.out.println("+--------------------------------------+");
		System.out.println("|                输入错误                          |");
		System.out.println("+--------------------------------------+");
	}
	public static void outTrue() {
		System.out.println("+--------------------------------------+");
		System.out.println("|                注销成功                          |");
		System.out.println("+--------------------------------------+");
	}
	public static void inTrue() {
		System.out.println("+--------------------------------------+");
		System.out.println("|                登录成功                          |");
		System.out.println("+--------------------------------------+");
	}
	public static void inFalse() {
		System.out.println("+--------------------------------------+");
		System.out.println("|                登录失败                          |");
		System.out.println("+--------------------------------------+");
	}
	public static void registerTrue() {
		System.out.println("+--------------------------------------+");
		System.out.println("|                注册成功                          |");
		System.out.println("+--------------------------------------+");
	}

	public static void logo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:MM");
		SimpleDateFormat sdf1 = new SimpleDateFormat("aa好");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("*              破事儿多花店                       *");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
	
	public static int surePopup() {
		int sure = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("|                是否确认                          |");
		System.out.println("|  1.是                                                0.否   |");
		System.out.println("+--------------------------------------+");
		while (true) {
			System.out.print("请选择>");
			sure = sc.nextInt();
			if(sure != 1 && sure != 0){
				System.out.println("输入有误");
			}else{
				break;
			}
		}
		return sure;
	}
	public static int sexPopup() {
		int sure = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("|                您的性别                          |");
		System.out.println("|  1.男                                                0.女   |");
		System.out.println("+--------------------------------------+");
		while (true) {
			System.out.print("请选择>");
			sure = sc.nextInt();
			if(sure != 1 && sure != 0){
				System.out.println("输入有误");
			}else{
				break;
			}
		}
		return sure;
	}

	// 开始界面
	public static void nologMenu() {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		while (a != 0) {
			System.out.println();
			logo();
			System.out.println("1.进店");
			System.out.println("2.登录");
			System.out.println("3.注册");
			System.out.println("0.退出");
			System.out.print("请选择>");
			a = sc.nextInt();
			switch (a) {
			case 1:
				// 商品浏览
				shopMenu();
				break;
			case 2:
				// 登录界面
				loginMenu();
				if(User.getRole() != null){
					if(User.getRole() == 1){
						logMenu();
					}else if(User.getRole() == 0){
						//管理员界面
					}
				}else{
					inFalse();
				}
				break;
			case 3:
				// 注册界面
				registerMenu();
				break;
			case 0:
				cutline();
				System.out.println("感谢您的使用~~~");
				System.exit(0);
				break;

			default:
				error();
				break;
			}
		}
	}
	public static void logMenu() {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		while (a != 0) {
			System.out.println();
			logo();
			System.out.println("1.进店");
			System.out.println("2.注销");
			System.out.println("0.退出");
			System.out.print("请选择>");
			a = sc.nextInt();
			switch (a) {
			case 1:
				// 商品浏览
				shopMenu();
				break;
			case 2:
				// 注销
				User.logout();
				outTrue();
				nologMenu();
				break;
			case 0:
				User.logout();
				cutline();
				System.out.println("感谢您的使用~~~");
				System.exit(0);
				break;

			default:
				error();
				break;
			}
		}
	}

	// 商品浏览界面
	public static void shopMenu() {
		
		Scanner sc = new Scanner(System.in);
		int a = -1;
		
		ProductService ps = new ProductServiceImpl(new ProductDaoImpl());
		List<ProductBean> pl = new ArrayList<ProductBean>();
		pl = ps.selectAll();
		TypeService ts = new TypeServiceImpl(new TypeDaoImpl());
		List<TypeBean> tl = new ArrayList<TypeBean>();
		tl = ts.selectAll();
		
		while (a != 0) {
			System.out.println();
			logo();
			System.out.println("商品导航");
			System.out.println("1.对象送花");
			System.out.println("2.节日送花");
			System.out.println("3.鲜花用途");
			System.out.println("4.鲜花用材");
			System.out.println("5.购物车");
			System.out.println("0.返回");
			cutline();
			System.out.print("请选择>");
			a = sc.nextInt();
			switch (a) {
			case 1:
				// 对象送花
				typeShow(3,8);
				break;
			case 2:
				// 节日送花
				typeShow(9,14);
				break;
			case 3:
				// 鲜花用途
				typeShow(15,20);
				break;
			case 4:
				// 鲜花用材
				System.out.println("空");
				break;
			case 5:
				// 购物车
				if(User.getRole() != null && User.getRole() == 1){
					cartMenu();
				}else{
					System.out.print("请先登录");
					loginMenu();
				}
				break;
			case 0:
				if(User.getRole() != null && User.getRole() == 1){
					logMenu();
				}else{
					nologMenu();
				}
				break;

			default:
				error();
				break;
			}
		}
		
	}
	
	//分类界面
	public static void typeShow(int minId,int maxId) {

		Scanner sc = new Scanner(System.in);
		//查询所有商品与类型
		ProductService ps = new ProductServiceImpl(new ProductDaoImpl());
		List<ProductBean> pl = new ArrayList<ProductBean>();
		pl = ps.selectAll();
		TypeService ts = new TypeServiceImpl(new TypeDaoImpl());
		List<TypeBean> tl = new ArrayList<TypeBean>();
		tl = ts.selectAll();
		//获取所要的的类型的商品
		List<TypeBean> ut = new ArrayList<TypeBean>();
		for (TypeBean typeBean : tl) {
			if(typeBean.getTypeId()>=minId && typeBean.getTypeId()<=maxId){
				ut.add(typeBean);
			}
		}
		//输出商品列表，并选择
		int b = -1;
		List<List<Cell>> body = new ArrayList<List<Cell>>();
		for (TypeBean tb : ut) {
			body.add(tb.getBody());
		}
		while(b != 0){//选择类型
			System.out.println();
			
			new ConsoleTable.ConsoleTableBuilder().addHeaders(TypeBean.getHeader()).addRows(body).build().print();
			System.out.print("请选择编号,或者输入0返回>");
			b = sc.nextInt();
			if(b == 0) break;
			Integer c = -1;
			while(c != 0){//选择商品
				System.out.println();
				
				List<Integer> it = new ArrayList<Integer>();
				List<List<Cell>> pbo = new ArrayList<List<Cell>>();
				for (ProductBean pb : pl) {
					if(pb.getObjectId() != null && pb.getObjectId() == b){
						it.add(pb.getProductId());
						pbo.add(pb.getBody());
					}
				}
				if(pbo.isEmpty()){
					System.out.println("无该类商品");
					break;
				}else{
					new ConsoleTable.ConsoleTableBuilder().addHeaders(ProductBean.getHeader()).addRows(pbo).build().print();
					System.out.print("请选择编号加入购物车,或者输入0返回>");
					c = sc.nextInt();
					if(it.indexOf(c) >= 0 && c != 0){
						System.out.println("您选择的是");
						List<List<Cell>> showproduct = new ArrayList<List<Cell>>();
						showproduct.add(pl.get(c-1).getBody());
						if(showproduct.isEmpty()){
							System.out.println(">>加入购物车");
							error();
						}else{
							new ConsoleTable.ConsoleTableBuilder().addRows(showproduct).build().print();
							System.out.print("请输入您所要的数量>");
							int num = sc.nextInt();
							int sure = surePopup();
							if(sure == 1){//加入购物车
								CartProduct cp = new CartProduct(pl.get(c-1).getProductId(),pl.get(c-1).getProductName(),pl.get(c-1).getProductPrice(),num);
								int fff = Cart.add(cp);
								if(fff == 1){
									System.out.println("添加成功");
								}else{
									System.out.println("库存不足");
								}
							}
						}
					}else if(c == 0){
						break;
					}else{
						System.out.println(">>商品选择");
						error();
					}
				}
			}
		}

	}
	
	//购物车菜单
	public static void cartMenu() {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		
		while(a != 0){
			System.out.println();
			
			System.out.println("购物车内容");
			List<List<Cell>> showcp = new ArrayList<List<Cell>>();
			for (CartProduct cp : Cart.l) {
				showcp.add(cp.getBody());
			}
			if(showcp.isEmpty()){
				System.out.println("购物车为空");
			}else{
				new ConsoleTable.ConsoleTableBuilder().addHeaders(CartProduct.getHeader()).addRows(showcp).build().print();
			}

			System.out.println();
			System.out.println("1.删除商品");
			System.out.println("2.清空购物车");
			System.out.println("3.结算");
			System.out.println("0.返回");
			cutline();

			System.out.print("请选择>");
			a = sc.nextInt();
			switch (a) {
			case 1:
				System.out.print("请输入所要删除商品的ID>");
				int b = sc.nextInt();
				if(Cart.countById(b) > 0){
					int sure = surePopup();
					if(sure == 1){
						Cart.remove(b);
						System.out.println("删除成功");
					}		
				}else{
					System.out.println("ID无效");
				}
				break;
			case 2:
				System.out.println("即将清空购物车");
				int sure = surePopup();
				if(sure == 1){
					Cart.clear();
					System.out.println("购物车已清空");
				}
				break;
			case 3:
				float paynum = Cart.bill();
				ConsigneeService cd = new ConsigneeServiceImpl(new ConsigneeDaoImpl());
				List<Integer> it = new ArrayList<Integer>();
				List<List<Cell>> showcon = new ArrayList<List<Cell>>();
				for (ConsigneeBean cb : cd.selectAll()) {
					showcon.add(cb.getBody());
					it.add(cb.getConId());
				}
				new ConsoleTable.ConsoleTableBuilder().addHeaders(ConsigneeBean.getHeader()).addRows(showcon).build().print();
				System.out.println("请选择地址编号>");
				while(true){
					int conId = sc.nextInt();
					if(it.indexOf(conId) >= 0){
						System.out.println("应支付"+paynum+"元");
						int sure1 = surePopup();
						if(sure1 == 1){
							//结算
							if(Cart.settlement(conId)){
								System.out.println("结算成功");
							}else{
								System.out.println("结算失败");
							}				
						}
						break;
					}else{
						System.out.println(">>选择地址");
						error();
					}
				}
				break;

			default:
				error();
				break;
			}
		}
		
	}

	// 登录界面
	public static void loginMenu() {
		System.out.println();
		logo();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("UserID:");
			String userId = sc.next();
			User.setUserId(userId);
			System.out.print("Password:");
			String password = sc.next();
			User.setPassword(password);
			if(User.login() == 1)
				break;
			inFalse();
		}
	}

	// 注册界面
	public static void registerMenu() {
		Scanner sc = new Scanner(System.in);
		UserBean ub = new UserBean();
		UserService us = new UserServiceImpl(new UserDaoImpl());
		UserdetailBean udb = new UserdetailBean();
		UserdetailService uds = new UserdetailServiceImpl(new UserdetailDaoImpl());
		System.out.println();
		logo();
		
		System.out.println("主页>>>注册界面(输入0返回)");
		cutline();
		
		System.out.println("UserName:");
		String userName = sc.nextLine();
		ub.setUserName(userName);
		if(userName.equals("0")){
			return;
		}
		while(us.countSelective(ub) > 0){
			System.out.println("!*已有该UserName*!");
			System.out.println("UserName:");
			userName = sc.nextLine();
			ub.setUserName(userName);
		}
		
		System.out.println("Sex:");
		String userSex;
		int sex = sexPopup();
		if(sex == 1){
			userSex = "男";
		}else{
			userSex = "女";
		}
		
		System.out.println("Tel:");
		String userTel = sc.nextLine();
		if(userTel.equals("0")){
			return;
		}
		while(userTel.length() != 11){
			System.out.println("!*Tel格式错误*!");
			System.out.println("Tel:");
			userTel = sc.nextLine();
		}
		
		System.out.println("Password:");
		String password1 = sc.nextLine();
		if(password1.equals("0")){
			return;
		}
		System.out.println("PasswordConfirm:");
		String password2 = sc.nextLine();
		if(password2.equals("0")){
			return;
		}
		while(!password1.equals(password2)){
			System.out.println("!*两次输入密码不一致*!");
			System.out.println("Password:");
			password1 = sc.nextLine();	
			System.out.println("PasswordConfirm:");
			password2 = sc.nextLine();
		}
		ub.setPassword(password1);
		ub.setUserId(String.valueOf(us.maxId()+1));
		ub.setRole(1);ub.setFlag(1);
		
		udb.setUserDetailId(uds.maxId()+1);
		udb.setUserId(String.valueOf(us.maxId()+1));
		udb.setUserTel(userTel);
		udb.setRegisterTime(new Date());
		udb.setFlag(1);
		
		try {
			C3p0Utils.beginTransaction();
			us.insertRecord(ub);
			uds.insertRecord(udb);
			C3p0Utils.commitTransaction();
		} catch (SQLException e) {
			try {
				C3p0Utils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		registerTrue();
	}

}
