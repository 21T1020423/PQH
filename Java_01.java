import java.util.Scanner;
public class Java_01 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("1. Giải phương trình bậc 2");
		System.out.println("2. Fibo của n");
		System.out.println("3. Giai thừa của n");
		System.out.println("4. Ước chung lớn nhất của a và b");
		System.out.println("5. Bội chung nhỏ nhất của a và b");
		System.out.println("6. Liệt kê số nguyên tố");
		System.out.println("7. Tổng các chữ số của một số nguyên n");
		System.out.println("8. Kiểm tra số Fibo là số nguyên tố nhỏ hơn n");
		System.out.println("9. Số thuận nghịch n");
		System.out.println("Mời nhập lựa chọn: ");
		int choice = input.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Nhập a: ");
				float a = input.nextFloat();
				System.out.println("Nhập b: ");
				float b = input.nextFloat();
				System.out.println("Nhập b: ");
				float c = input.nextFloat();
				Java_01.PTB2(a,b,c);
				input.close();
				break;
			case 2:
				System.out.println("Nhập n: ");
				long n1 = input.nextLong();
				for(int i=0; i<n1; i++) {
					System.out.print(String.valueOf(Java_01.Fibo(i)+"\t"));
				}
				break;
			case 3:
				System.out.println("Nhập n: ");
				long n2 = input.nextLong();
				System.out.printf("Giai thừa của n là : %d", Java_01.GT(n2));
				//System.out.printf("Giai thừa của n là : %d", Java_01.GT_2(n2));
				break;
			case 4:
				System.out.println("Nhập a: ");
				long a1 = input.nextLong();
				System.out.println("Nhập b: ");
				long b1 = input.nextLong();
				System.out.printf("Ước chung lớn nhất của %d và %d là %d", a1,b1,UCLN(a1,b1));
				break;
			case 5:
				System.out.println("Nhập a: ");
				long a2 = input.nextLong();
				System.out.println("Nhập b: ");
				long b2 = input.nextLong();
				System.out.printf("Bội chung nhỏ nhất của %d và %d là %d", a2,b2,BCNN(a2,b2));
				break;
			case 6:
				System.out.println("Nhập n: ");
				long n3 = input.nextLong();
				//LietKeSNT(n3);
				LietKe_N_SNT(n3);
				break;
			case 7:
				System.out.println("Nhập n: ");
				long n4 = input.nextLong();		
				System.out.printf("Tong cac chu so cua mot so nguyen n: %d", tongSoNguyen(n4));
				break;
			case 8:
				System.out.println("Nhập n: ");
				long n5 = input.nextLong();
				checkFibo_SNT_nhoHonN(n5);
				break;	
			case 9:
				System.out.println("Nhập n: ");
				long n6 = input.nextLong();
				if(checkBangNhau(n6)) {
					System.out.println("La so thuan nghich");
				} else {
					System.out.println("Khong phai la so thuan nghich");
				}
				break;
		}
}
	static void PTB2(float a,float b, float c){
		double denta = Math.pow(b,2) - 4*a*c;
		if (denta <0)
			System.out.println("Vô nghiệm");
		else if(denta ==0){
			double x=-b/2*a;
			System.out.println("Có nghiệm kép: "+x);
		}
		else{
			double x1= (-b-Math.sqrt(denta))/2*a;
			double x2= (-b+Math.sqrt(denta))/2*a;
			System.out.printf("Nghiệm của PT là: x1= %.2f, x2=%.2f",x1,x2);
		}
	}
	static long GT(long n){
		if(n>0) {
			return n*GT(n-1);
		} else {
			return 1;
		}
	}
	static long GT_2(long n) {
		long rs = 1;
		for(long i=1; i<=n; i++) {
			rs *=i;
		}
		return rs;
	}
	static long Fibo(int n){
		int f0=0, f1=1, fn=1;
        if (n<0) {
            return -1;
        } else if((n==0)||(n==1)) {
            return n;
        } else {
            for (int i = 2; i < n; i++) {
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
        }
        return fn;
	}
	static long UCLN(long a, long b) {
		while(a!=b) {
			if(a>b) a-=b;
			else b-=a;
		}
		return a;
	}
	static long DQ_UCLN(long a, long b) {
		if(a==b) return a;
		else if(a>b) return DQ_UCLN(a-b,b);
		return DQ_UCLN(a, b-a);
	}
	static long BCNN(long a, long b) {
		return a*b/UCLN(a,b);
	}
	static boolean SNT(long n) {
		if(n<2) return false;
		for(long i=2; i<n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	static void LietKeSNT(long n) {
		String s = "";
		for(long i=2; i<=n; i++) {
			if(SNT(i)) s=s+i+" ";
		}
		System.out.print(s);
	}
	static void LietKe_N_SNT(long n) {
		String s = "";
		long dem = 0;
		long i=2;
		while(dem != n) {
			if(SNT(i)) {
				s=s+i+" ";
				dem++;
			}
			i++;
		}
		System.out.println(s);
	}
	static long tongSoNguyen(long n) {
		long temp = 0;
		while(n>0) {
			temp += n%10;
			n/=10;
		}
		return temp;
	}
	static void checkFibo_SNT_nhoHonN(long n) {
		String s = "";
		for(int i=2; i<n; i++) {
			if(SNT(Fibo(i))==true) {
				s = i + " ";
				System.out.print(s);
			}
		}
	}
	static long daoSo(long n) {
		long s = 0;
		while(n!=0) {
			s = s*10+n%10;
			n/=10;
		}
		return s;
	}
	static boolean checkBangNhau(long n6) {
		if(daoSo(n6)==n6) return true;
		else return false;
	}
}