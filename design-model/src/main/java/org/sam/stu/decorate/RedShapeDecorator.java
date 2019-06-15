package org.sam.stu.decorate;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decorator){
        super(decorator);
    }

    @Override
    public void draw(){
        //这是公共抽象装饰者做的事情
        decorator.draw();

        //添加自定义在装饰的动作
        setShapeBorderColor(decorator);
    }

    private void setShapeBorderColor(Shape decorator){
        System.out.println("将已画好的形状线条颜色变成红色");
    }
}
