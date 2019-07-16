package org.sam.stu;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 数字类型精确度计算
 */
public class NumberTest {

    private double number1 = 50.5D;

    private double number2 = 150D;

    @Test
    public void test(){
        //这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
        double percent = number1 / number2;

        //输出一下，确认你的小数无误
        System.out.println("小数：" + percent);

        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();

        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);

        //最后格式化并输出
        System.out.println("百分数：" + nt.format(percent));
    }

    @Test
    public void test1(){
        BigDecimal b1 = new BigDecimal(number1);
        BigDecimal b2 = new BigDecimal(number2);
        //精确到小数点后两位（四舍五入）
        BigDecimal result = b1.divide(b2,new MathContext(2));
        System.out.println("result = " + result);
    }
}
