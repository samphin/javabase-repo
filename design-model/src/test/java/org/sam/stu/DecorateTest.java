package org.sam.stu;

import org.junit.Test;
import org.sam.stu.decorate.*;

/**
 * 装饰者模式-->测试类
 */
public class DecorateTest {


    @Test
    public void test(){
        Shape rectangle = new Rectangle();
        rectangle.draw();

        //生成一个红色矩形
        Shape redRectangle = new RedShapeDecorator(rectangle);
        redRectangle.draw();

        Shape circle = new Circle();
        circle.draw();

        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();
    }
}
