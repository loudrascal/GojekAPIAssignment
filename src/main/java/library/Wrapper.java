package library;

public class Wrapper<S, T> {

    S s;
    T t;

    public S getS() {
        return s;
    }


    public T getT() {
        return t;
    }

    public void setS(S s) {
        this.s = s;
    }

    public void setT(T t) {
        this.t = t;
    }
}
