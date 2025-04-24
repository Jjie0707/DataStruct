package test0;

public abstract class Teacher extends Person implements  Teach{
    @Override
    public abstract void teach();

    public Teacher(int age) {
        super(age);
    }

    public Teacher() {
    }
}
