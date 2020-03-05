package week3;

class Fraction{
    double num;
    double denom;

    // default constructor
    public Fraction(){
        num = 0;
        denom = 0;
    }
    // constructor accepting 2 arguments
    public Fraction(long num, long denom){
        this.num = num;
        this.denom = denom;
    }

    public Fraction mult (Fraction f){
        Fraction tot = new Fraction();
        tot.num = f.num * num;
        tot.denom = f.denom *denom;
        return tot;
    }

    public Fraction add (Fraction f){
        Fraction tot = new Fraction();
        tot.denom = f.denom * denom;
        tot.num  = (f.num * denom) + (f.denom * num);
        return tot;
    }

    public void simplify(){
        double gdc = gdc();
        System.out.print(num/gdc + "/" + denom/gdc);
    }

    public Fraction simplifyRetFrac(){
        Fraction f = new Fraction();
        double gdc = gdc();
        
        f.num = (this.num / gdc);
        f.denom = (this.denom / gdc);

        return f;
    }

    private double gdc(){
        double num1 = num, denom1 = denom;
        while(num1 != 0){
            double r = 0;
            r = denom1 % num1;
            denom1 = num1;
            num1 = r;
        }
        return denom1;
    }

    public String toString(){
        String dig = "";
        double longNum = (num/denom) - ((num/denom) - (int)(num/denom)); // truncate the number
        dig = Double.toString(longNum); // or "" + dig (but poor style) or dig.valueOf();
        dig =  longNum +  " + " + (num - (longNum * denom)) + "/" + denom;

        return dig;
    }

}


public class EDextra {
    public static void main(String[] args){
        Fraction frac = new Fraction(2,3);
        Fraction frac1 = new Fraction(1,2);
        
        Fraction f2 = frac.add(frac1);
        System.out.println(f2);
    }
}