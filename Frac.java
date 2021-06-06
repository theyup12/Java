package hw;
import java.util.Scanner;
public class Frac {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
    }
}

class Fraction{
    private int top;
	private int bottom;
	Fraction(){
		top = 0;
		bottom = 0;
	}
	Fraction(int top, int bottom){
			this.top = top;
			this.bottom = bottom; 
			simp();
	}

	void print(){
		if(top != bottom){
			System.out.println(top + "/" + bottom);
		}else{
			System.out.println(top);
		}
	}
	Fraction multiply(Fraction b){
		int new_top = this.top * b.top;
		int new_bottom = this.bottom * b.bottom;
		return new Fraction(new_top, new_bottom);
	}

	Fraction plus(Fraction b){
		Fraction new_frac = new Fraction();
		if(this.bottom != b.bottom){
			int new_top = this.top * b.bottom;
			int new_bottom = this.bottom * b.bottom;
			int another_top = b.top * this.bottom;
			new_top += another_top;
			new_frac = new Fraction(new_top, new_bottom);
		}else{
			new_frac = new Fraction(this.top + b.top, this.bottom);
		}
		return new_frac;
	}
	private void simp(){
		int gcd = gcd(top, bottom);
		if(gcd != 1){
			this.top = top / gcd;
			this.bottom = bottom / gcd;
		}
	}
	private int gcd(int a, int b){
		if(b == 0){return a;}
		return gcd(b, a%b);
	}
}