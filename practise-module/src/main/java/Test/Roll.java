package Test;

import java.util.ArrayList;
import java.util.Random;

public class Roll {
	
	private static int rollIndex(int[] ranks){
		int sum=0;
		for(int i:ranks){
			sum += i;
		}
		Random rand = new Random();
		for(int i=0; i<ranks.length; i++){
			int rnd = rand.nextInt(sum) + 1;
			if( rnd<ranks[i] ){
				return i;
			}
			sum -= ranks[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		//????????????
		ArrayList<Gift> gifts = new ArrayList<Gift>();
		gifts.add(new Gift("1",255)); //25.5% ?? ???????????????????????????????????
		gifts.add(new Gift("2",245));
		gifts.add(new Gift("3",400));
		gifts.add(new Gift("4",100));
		
		
		//?????????????????????
		int[] ranks = new int[gifts.size()]; 
		Gift tmp = null;
		for(int i=0;i<ranks.length;i++){
			tmp = (Gift)gifts.get(i);
			ranks[i] = tmp.rank;
		}
		
		//??index??
		int index = Roll.rollIndex(ranks);
		Gift result = (Gift)gifts.get(index);
		
		System.out.println(result.giftName);  
	}
}

class Gift{
	public String giftName;
	//???????????
	public int rank; //????????????????
	public Gift(String n,int r){
		this.giftName = n;
		this.rank = r;
	}
}