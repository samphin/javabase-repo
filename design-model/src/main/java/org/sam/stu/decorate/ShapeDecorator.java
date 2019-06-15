package org.sam.stu.decorate;

/**
 * 创建实现了 Shape 接口的抽象装饰类。
 */
public abstract class ShapeDecorator implements Shape{

    protected Shape decorator;

    public ShapeDecorator(Shape decorator){
        this.decorator = decorator;
    }

    @Override
    public void draw() {
        decorator.draw();
    }

}
