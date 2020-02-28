package week3;

//import java.util.Arrays;

class Point {
    int x, y;
    int[] points = new int[1];
 
    Point() {
       x = y = 0;
    }
    
    //using varargs to store arbitrary number of args
/*     Point(int dimensions, int... varargs){

        points = Arrays.copyOf(points, dimensions);

        int i = 0;

        for(int arg: varargs){
            points[i] = arg;
            i++;
        }

    } */

    Point(int x0, int y0) {
       x = x0;
       y = y0;
    }
 
    public String toString() {
       return "(" + x + "," + y + ")";
    }
 }

class Rectangle {

    //Atributos
    int x1, y1, x2 ,y2;

    int[] points = new int[1];
    int[] pointsR = new int[1];


    //Constructor 1 (2d)
    Rectangle(int x1,int y1,int x2,int y2){
        this.x1 = x1;   // this keyword para distinguir entre x1 atributo da classe
        this.x2 = x2;   // e x1 argumento passado a este construtor, this.x1 é o
        this.y1 = y1;   // o x1 da classe
        this.y2 = y2; 

    }

    // Constructor 1 (nth d)
/*     public Rectangle (int dimensions, int... varargs){
        points = Arrays.copyOf(points, dimensions);

        int i = 0;
        for(int arg: varargs){
            points[i] = arg;
            i++;
        }

    } */
    // Constructor 2 (nth d)
/*     public Rectangle (Point p1){

        int length = p1.points.length;

        pointsR = Arrays.copyOf(pointsR, length);

        for(int i = 0; i < length; i++){
            pointsR[i] = p1.points[i];
        }
  
    } */
    // perimeter of (nth d)
/*     int perimeterNTHD(){
        int sum = 0;
        for(int i = 0; i < pointsR.length; i++){
            sum += pointsR[i];
        }
        return sum;
    } */
    // what is the formula for nth d area ??

    //Constructor 2 (2d)
    public Rectangle (Point p1, Point p2){
        x1 = p1.x;
        y1 = p1.y;
        x2 = p2.x;
        y2 = p2.y;
    }

    //metodo para area
    int area (){
        return (y2 - y1) * (x2 - x1);
    }

    //metodo para perimetro
    int perimeter() {
        return ((y2 - y1) + (x2 - x1)) * 2;
    }

    //verificar se coordenas de p estao entre coordenadas do retangulo
    boolean pointInside(Point p){
        if ( x1 <= p.x && p.x <= x2 && y1 <= p.y && p.y <= y2){
            return true;
        }
        return false;
    }
    
    //verificar 2 a 2 se os 4 pontos do retangulo estao dentro do retangulo maior 
    boolean rectangleInside(Rectangle r){

        Point coords1 = new Point(r.x1, r.y1);
        Point coords2 = new Point(r.x2, r.y2);

        if(pointInside(coords1) && pointInside(coords2)){
            return true;
        }

        return false;
    }

}

public class _186 {

    public static void main (String[] args){

        Point a = new Point(1,1);
        Point b = new Point(2,2);
        Point c = new Point(3,4);
        Point d = new Point(8,2);
        Point z = new Point(4,1);

        Rectangle amarelo  = new Rectangle(a, c);
        Rectangle laranja  = new Rectangle(2, 3, 9, 6);
        Rectangle verde    = new Rectangle(3, 4, 4, 5);
        Rectangle azul     = new Rectangle(5, 1, 6, 5);
        Rectangle vermelho = new Rectangle(7, 3, 9, 5);

        System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
        System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20
        
        System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
        System.out.println("Area do retangulo laranja = " + laranja.area()); // 21    

        System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
        System.out.println("Ponto D dentro rectangulo azul? " + azul.pointInside(d)); // false
        System.out.println("Ponto C dentro rectangulo laranja? " + laranja.pointInside(c)); //true
        System.out.println("Ponto A dentro rectangulo amarelo? " + amarelo.pointInside(a)); //true
        System.out.println("Ponto Z dentro rectangulo vermelho? " + vermelho.pointInside(z)); //false

        System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
        System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
        System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true

    }
}