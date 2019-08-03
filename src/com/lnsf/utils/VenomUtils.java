package com.lnsf.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class VenomUtils {

	// 实现java控制台的清屏，仅适用eclipse
	public static void clear() {
		Robot r;
		try {
			r = new Robot();
			r.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键
			r.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键
			r.keyPress(KeyEvent.VK_CONTROL); // 按下Ctrl键
			r.keyPress(KeyEvent.VK_R); // 按下R键
			r.keyRelease(KeyEvent.VK_R); // 释放R键
			r.keyRelease(KeyEvent.VK_CONTROL); // 释放Ctrl键
			r.delay(100);
		} catch (AWTException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
