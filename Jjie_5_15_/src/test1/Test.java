package test1;

public class Test {
}
class Complex{
    public int a;
    public int b;

    public Complex() {
    }

    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public Complex add(Complex a1,Complex a2){
        Complex tem=new Complex(a1.a+a2.a,a1.b+a2.b);
        return tem;
    }
    public Complex minus(Complex a1,Complex a2){
        Complex tem=new Complex(a1.a-a2.a,a1.b-a2.b);
        return tem;
    }

    @Override
    public String toString() {
        return this.a+"+"+this.b+"i";
    }
}
