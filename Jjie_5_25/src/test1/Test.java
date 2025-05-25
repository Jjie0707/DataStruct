package test1;

/**
 * 设计一个名为GeometricObject类，和一个名为Triangle类，要求包括： ~~~
 * (1) GeometricObject类为抽象类，有getArea()和getPerimeter()两个抽象方法；~~~
 * (2) Triangle类继承于GeometricObject类；~~~~
 * (3) Triangle类有三个名为side1、side2、side3的double类型的属性，用于表示各边的长度，他们的默认值都为1.0；~~~
 * (4) Triangle类有1个无参数的构造方法，和1个带参数的构造方法，该方法有3个参数用于指定三条边；~~~
 * (5) Triangle类中为side1、side2、side3这三个属性分别提供setter和getter；~~~
 * (6) 重载Triangle类中的getArea()方法，返回该三角形的面积；~~~
 * (7) 重载Triangle类中的getPerimeter()，返回该三角形的周长；~~~
 * (8) 编写Triangle类中的main(String[] args)方法测试上述功能。
 * 将源代码以附件形式上传。
 */
public class Test {
    public static void main(String[] args) {

        Triangle s1=new Triangle();
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());

        System.out.println( );
        
        Triangle s2=new Triangle(3,4,5);
        System.out.println(s2.getPerimeter());
        System.out.println(s2.getArea());
    }
}
