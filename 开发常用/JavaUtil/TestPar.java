
class TestPar{

	public  int f(int a, int b){
		if (a!=0 && b!=0) {
		int temp=1;
		if (a%b==0 || b%a==0) {
			if (a>=b) {
				return b;
			}
		}else if (a<=b) {
			for (int i=1;i<=a ;i++ ) {
				if(a%i==0 && b%i==0){
					 temp=i;
				}
		    }
		    return temp;
		}else if (a>=b) {
			for (int i=1;i<=b ;i++ ) {
				if(a%i==0 && b%i==0){
					 temp=i;
				}
		    }
		    return temp;
		}
	}
		return 0;
	}

	public void p(){
		System.out.println("¸¸ÀàÌØÓĞ");
	}
}