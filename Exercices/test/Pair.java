package test;

public class Pair <X,Y> {
    private X xvalue;
    private Y yvalue;
    
    public Pair (final X xvalue, final Y yvalue) {
        this.xvalue = xvalue;
        this.yvalue = yvalue;
    }

    public X getXvalue() {
        return xvalue;
    }

    public Y getYvalue() {
        return yvalue;
    }

    public void setXvalue(final X xvalue) {
        this.xvalue = xvalue;
    }

    public void setYvalue(final Y yvalue) {
        this.yvalue = yvalue;
    }
}