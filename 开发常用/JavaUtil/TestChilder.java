class TestChilder extends TestPar{

	@Override
	public int f(int a, int b){
		if (a!=0 && b!=0) {
		int m=super.f(a,b);
		System.out.println("乘积为"+(a*b)/m);
		int temp=0;
		if (a%b==0 || b%a==0) {
			if (a>=b) {
				return a;
			}
		}else if (a<=b) {
				int i=2;
				while(true){
					temp =b * i;
					i++;
					if (temp%a==0) {
						break;
					}
				}
				return temp;
			}else if (a>=b) {
				int i=2;
				while(true){
					temp =a * i;
					i++;
					if (temp%b==0) {
						break;
					}
				}
				return temp;
			}
		}
			return 0;
	}

	

public static void main(String[] args) {
	TestPar a=new TestChilder();
	TestPar b=new TestPar();
	// TestPar a=new TestPar();
	// if (a.f(10,5)==0) {
	// 	System.out.println("非法输入");	
	// }else{
		System.out.println("最小公倍数为"+a.f(10,5));
		System.out.println("最大公因数为"+b.f(10,5));		
		b.p();
	// }
	}
}
