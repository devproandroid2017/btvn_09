package btvn_09;

import java.util.ArrayList;
import java.util.List;

public class MyBigNumber {
	private final static int PART = 3;
	List<Integer> value = new ArrayList<>();//(0,dv) -> (1, nghin) ->(2, trieu)
	
	public MyBigNumber() {
	}
	
	public MyBigNumber(String s) {
//		System.out.println("input number: " + s);
		//tach s -> array(3)
		for(int i = s.length(); i >0;){
//			System.out.println("loop : " + i);
			String number = "";
			if(i - PART > 0){
				number = s.substring(i - PART, i);
			}else{// 0,1,2
				number = s.substring(0, i);
			}
			
//			System.out.println("number :" + number);
			value.add(Integer.parseInt(number));
			i = i - PART;
		}
		
//		print();
	}
	
//	public void print(){
//		System.out.println();
//		int size = value.size();
//		for(int i = size - 1; i >=0; i--){
//			int apart = value.get(i);
//			System.out.print(apart + ".");
//		}
//	}
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		int size = value.size();
		for(int i = size - 1; i >=0; i--){
			int apart = value.get(i);
			ret.append(convertIntToString(apart));
		}
		return ret.toString();
	}
	
	private String convertIntToString(int number){
		if(number >= 100){
			return Integer.toString(number);
		}else if(number >= 10){
			return "0" + Integer.toString(number);
		}else{
			return "00" + Integer.toString(number);
		}
	}
	private void printArray(List<Integer> temp){
		//in temp
		StringBuilder ret = new StringBuilder();
		int size = temp.size();
		for(int k = size - 1; k >=0; k--){
			int apart = temp.get(k);
			ret.append(convertIntToString(apart));
		}
		System.out.println("ket qua=" + ret.toString());
	}
	public MyBigNumber multiple(MyBigNumber bigNumber){
		MyBigNumber result = new MyBigNumber("100010");
		//nhan
		List<List> temps = new ArrayList<>(); //dv -> nghin -> trieu
		
		for(int i = 0 ; i < value.size(); i++){
			List<Integer> temp = new ArrayList<Integer>();
			int parta1 = value.get(i);///dv -> nghin -> trieu
			System.out.println("parta1 = " + parta1);
			int sonho = 0;
			for(int j = 0; j < bigNumber.getValue().size(); j++){//dv -> nghin -> trieu
				int partb1 = bigNumber.getValue().get(j);
				System.out.println("partb1 = " + partb1);
				int parttemp1 = parta1 * partb1 + sonho;//123456
				System.out.println("parttemp1 = " + parttemp1);
				int sodeluu = parttemp1 % 1000;
				sonho = parttemp1 / 1000;
				//
				temp.add(sodeluu);
			}
			temp.add(sonho);
			//print temp
			printArray(temp);
			temps.add(temp);
		}
		//
		int tempssize = temps.size();
		for(int i = 0; i < tempssize; i++){
			List<Integer> t1 = temps.get(i);
			for(int j = 0; j < i; j++){
				t1.add(0, 0);
			}
			temps.set(i, t1);
			printArray(t1);
		}
		//
		//temps cong cac temp
		List<Integer> ret = new ArrayList<>();
		int max = bigNumber.getValue().size() * value.size();
		int sonho2 = 0;
		for(int i = 0; i < max; i++){
			int sum = sonho2;
			for(int j = 0; j < temps.size(); j++){
				List<Integer> temp1 = temps.get(j);
				if(temp1.size() > i){
					sum += temp1.get(i);	
				}
			}
			int soluu = sum % 1000;
			sonho2 = sum / 1000;
			ret.add(soluu);
		}
		result.setValue(ret);
		return result;
	}

	public List<Integer> getValue() {
		return value;
	}

	public void setValue(List<Integer> value) {
		this.value = value;
	}
	
//	public static void main(String[] args) {
//		System.out.println(MyBigNumber.convertIntToString(1));
//		System.out.println(MyBigNumber.convertIntToString(10));
//		System.out.println(MyBigNumber.convertIntToString(102));
//	}
}
