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
    int top;
	int bottom;
	Fraction(){
		top = 0;
		bottom = 0;
	}
	Fraction(int top, int bottom){
		if(bottom % top == 0 || top % bottom == 0){
			this.top = top / top;
			this.bottom = bottom / top;
		}else{
			this.top = top;
			this.bottom = bottom; 
		}
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
}