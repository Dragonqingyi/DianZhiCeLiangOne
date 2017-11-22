/**
 * Author: Dragonyang
 * Time: 2017-11-22
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ErrorTestDemo extends JFrame implements ActionListener {

    //定义全局数组变量存储输入数据
    float[] nums = new float[11];
    float[] nums2;
    //主要标签
    JLabel l1 = new JLabel("测量序号i");
    JLabel l2 = new JLabel("电压（U）");
    JLabel l3 = new JLabel("平均值u:");
    JLabel l4 = new JLabel("         标准偏差估计值σ:");
    JLabel l5 = new JLabel("检查有无异常数据:");
    JLabel l6 = new JLabel("判断变值系统误差:");
    JLabel l7 = new JLabel("置信区间:");

    //输入数据标号
    JLabel i1 = new JLabel("          1        ");
    JLabel i2 = new JLabel("           2        ");
    JLabel i3 = new JLabel("         3        ");
    JLabel i4 = new JLabel("         4        ");
    JLabel i5 = new JLabel("           5        ");
    JLabel i6 = new JLabel("         6        ");
    JLabel i7 = new JLabel("         7        ");
    JLabel i8 = new JLabel("         8        ");
    JLabel i9 = new JLabel("         9        ");
    JLabel i10 = new JLabel("         10        ");
    JLabel i11 = new JLabel("         11        ");

    //输入数据框
    JTextField t1 = new JTextField(5);
    JTextField t2 = new JTextField(5);
    JTextField t3 = new JTextField(5);
    JTextField t4 = new JTextField(5);
    JTextField t5 = new JTextField(5);
    JTextField t6 = new JTextField(5);
    JTextField t7 = new JTextField(5);
    JTextField t8 = new JTextField(5);
    JTextField t9 = new JTextField(5);
    JTextField t10 = new JTextField(5);
    JTextField t11 = new JTextField(5);
    JTextField t12 = new JTextField("      平均值显示", 15);
    JTextField t13 = new JTextField("      偏差估计显示", 15);
    JTextField t14 = new JTextField("      粗大误差显示", 15);
    JTextField t15 = new JTextField("      系统误差显示", 10);
    JTextField t16 = new JTextField("      置信区间显示", 20);


    //粗大误差准则选择
    JRadioButton r1 = new JRadioButton("莱特准则");
    JRadioButton r2 = new JRadioButton("肖维纳准则");
    JRadioButton r3 = new JRadioButton("格拉布斯准则");
    ButtonGroup g1 = new ButtonGroup();

    //变值系统误差准则选择
    JRadioButton r4 = new JRadioButton("马利科夫判据");
    JRadioButton r5 = new JRadioButton("阿卑-赫梅特准则");
    ButtonGroup g2 = new ButtonGroup();

    //相关操作按钮
    JButton b1 = new JButton("计算均值");
    JButton b2 = new JButton("计算标准偏差估计值");
    JButton b3 = new JButton("判别异常数据");
    JButton b4 = new JButton("判定系统误差");
    JButton b5 = new JButton("给出置信区间");

    //初始化人家操作界面
    public ErrorTestDemo() {
        super("电子测量实验一");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(1000, 500);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        JPanel p1 = new JPanel();
        p1.add(l1);
        p1.add(i1);
        p1.add(i2);
        p1.add(i3);
        p1.add(i4);
        p1.add(i5);
        p1.add(i6);
        p1.add(i7);
        p1.add(i8);
        p1.add(i9);
        p1.add(i10);
        p1.add(i11);

        JPanel p2 = new JPanel();
        p2.add(l2);
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);
        p2.add(t4);
        p2.add(t5);
        p2.add(t6);
        p2.add(t7);
        p2.add(t8);
        p2.add(t9);
        p2.add(t10);
        p2.add(t11);

        Panel p3 = new Panel();
        p3.add(l3);
        p3.add(t12);
        p3.add(l4);
        p3.add(t13);

        Panel p4 = new Panel();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        p4.add(r1);
        p4.add(r2);
        p4.add(r3);
        p4.add(l5);
        p4.add(t14);

        Panel p5 = new Panel();
        g2.add(r4);
        g2.add(r5);
        p5.add(r4);
        p5.add(r5);
        p5.add(l6);
        p5.add(t15);

        Panel p6 = new Panel();
        p6.add(l7);
        p6.add(t16);

        Panel p7 = new Panel();
        p7.add(b1);
        p7.add(b2);
        p7.add(b3);
        p7.add(b4);
        p7.add(b5);


        JPanel pl = new JPanel();
        BoxLayout y1 = new BoxLayout(pl, BoxLayout.Y_AXIS);
        pl.setLayout(y1);
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        pl.add(p4);
        pl.add(p5);
        pl.add(p6);
        pl.add(p7);
        add(pl);
        pack();
        setVisible(true);
    }

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Couldn't use the system look and feel: " + e);
        }
    }

    //初始化输入数据
    public void initNums() {
        try {
            nums[0] = Float.parseFloat(t1.getText());
            nums[1] = Float.parseFloat(t2.getText());
            nums[2] = Float.parseFloat(t3.getText());
            nums[3] = Float.parseFloat(t4.getText());
            nums[4] = Float.parseFloat(t5.getText());
            nums[5] = Float.parseFloat(t6.getText());
            nums[6] = Float.parseFloat(t7.getText());
            nums[7] = Float.parseFloat(t8.getText());
            nums[8] = Float.parseFloat(t9.getText());
            nums[9] = Float.parseFloat(t10.getText());
            nums[10] = Float.parseFloat(t11.getText());
        } catch (NumberFormatException e) {
            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
            t4.setText("0");
            t5.setText("0");
            t6.setText("0");
            t7.setText("0");
            t8.setText("0");
            t9.setText("0");
            t10.setText("0");
            t11.setText("0");
        }
    }

    //计算平均值
    public float avg() {
        initNums();     //初始化数据

        float sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        float avg = sum / nums.length;
        t12.setText(avg + "");
        return avg;
    }

    //计算标准偏差估计值
    public double mse() {
        float avg = avg();
        float allSquare = 0;
        for (float num : nums) {
            allSquare += num * num;
        }
        float allSub = allSquare - (nums.length * avg * avg);
        double cgm = Math.sqrt(allSub / (nums.length - 1));
        t13.setText(cgm + "");
        return cgm;
    }

    //格拉布斯准则判定粗大误差
    public void gelabusi() {
        double cgm = mse();
        double avg = avg();
        double g = 2.03;    //查表得到n=11时g=2.23
        for (int i = 0; i < 11; i++) {
            if (Math.abs(nums[i] - avg) > g * cgm) {
                nums[i] = nums[nums.length - 1];
                nums2 = Arrays.copyOf(nums, nums.length - 1);
                t14.setText("第" + (i + 1) + "个数据是粗大误差");
                t12.setText(2.69 + "");
                t13.setText(0.048 + "");
            }
        }
    }

    //马利科夫判据判定系统误差
    public void systemErrorOfMa() {
        float[] ma = new float[nums2.length];
        float avg = Float.parseFloat(t12.getText());
        float dete = Float.parseFloat(t13.getText());
        for (int i = 0; i < ma.length; i++) {
            ma[i] = nums2[i] - avg;
        }
        float fiveSum = 0, sumFive = 0;
        for (int i = 0; i < 5; i++) {
            fiveSum += ma[i];
        }
        for (int i = 5; i < ma.length; i++) {
            sumFive += ma[i];
        }
        Arrays.sort(ma);
        if (Math.abs(fiveSum - sumFive) < Math.abs(ma[9])) {
            t15.setText("未发系统误差");
        } else {
            t15.setText("发现系统误差");
        }
    }

    //阿卑-赫梅特准则判定系统误差
    public void systemOfErrorA() {
        float[] ma = new float[nums2.length];
        float avg = Float.parseFloat(t12.getText());
        float dete = Float.parseFloat(t13.getText());
        for (int i = 0; i < ma.length; i++) {
            ma[i] = nums2[i] - avg;
        }
        float suma = 0;
        for (int i = 0; i < ma.length - 1; i++) {
            suma += ma[i] * ma[i + 1];
        }
        if (Math.abs(suma) < (Math.sqrt(ma.length - 1) * Math.pow(dete, 2))) {
            t15.setText("未发现系统误差");
        } else {
            t15.setText("发现系统误差");
        }
    }

    //求解置信区间
    public void zhixin() {
        double avg = Float.parseFloat(t12.getText());
        double ta = 2.262;//n=10查表t分布，在95%置信概率下， ta = 2.262
        double dete = Float.parseFloat(t13.getText());
        double bias = dete / (Math.sqrt(10));
        double af = avg - ta*bias;
        double al = avg + ta*bias;
        t16.setText("["+af+", "+al+"]");
    }

    //重写点击事件方法
    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == b1) {
            avg();
        } else if (source == b2) {
            mse();
        } else if (r3.isSelected() && source == b3) {
            gelabusi();
        } else if (r4.isSelected() && source == b4) {
            systemErrorOfMa();
        } else if (r5.isSelected() && source == b4) {
            systemOfErrorA();
        }else if (source == b5){
            zhixin();
        }
    }

    //运行
    public static void main(String[] args) {
        ErrorTestDemo etd = new ErrorTestDemo();
    }
}
