package com.junbaor.jump;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Scanner;

public class WechatJump extends JFrame {
    public static double COEFFICIENT;
    private static boolean first = true;
    private static Point point1;
    private static Point point2;

    public WechatJump(int width, int height, double coefficient) {
        setSize(width, height);
        COEFFICIENT = coefficient;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //526 946  2.9
        System.out.println("请确保你可以执行 adb 命令,配置好环境变量");
        System.out.println("可以利用 QQ 截图工具测量投屏界面的宽和高\n");
        System.out.println("输入屏幕的宽(整数):");
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        System.out.println("输入屏幕的高(整数):");
        int height = scanner.nextInt();
        System.out.println("输入跳跃系数(小数):");
        double coefficient = scanner.nextDouble();

        WechatJump.setDefaultLookAndFeelDecorated(true);
        final WechatJump appJFrameJframe = new WechatJump(width, height, coefficient);
        AWTUtilities.setWindowOpacity(appJFrameJframe, 0.4f);
        appJFrameJframe.setVisible(true);
        appJFrameJframe.setAlwaysOnTop(true);

        appJFrameJframe.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Point currentPoint = e.getPoint();
                if (first) {
                    System.out.print("起跳点 ");
                    point1 = currentPoint;
                    first = false;
                } else {
                    System.out.print("落点 ");
                    point2 = currentPoint;
                    int distance = distance(point1, point2);
                    onClickPhone(distance * COEFFICIENT);
                    first = true;
                }
                System.out.println(e.getX() + " " + e.getY());
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });

    }


    public static void onClickPhone(double timeMilli) {
        try {
            Runtime.getRuntime().exec("adb shell input touchscreen swipe 170 187 170 187 " + (int) timeMilli);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算两点距离
     *
     * @param a
     * @param b
     * @return
     */
    public static int distance(Point a, Point b) {
        return (int) Math.sqrt((a.x - b.getX()) * (a.x - b.getX()) + (a.y - b.getY()) * (a.y - b.getY()));
    }
}
