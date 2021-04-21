package ex7.ex7.상속;

import java.util.Random;


// ����
public class Lotto {
	private int[] nums;
	private int size;
	
	public void init() {
		size = 6;
		nums = new int[size];
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public int getNum(int i) {
		
		int num = nums[i];
		
		return num;
	}
	
	public void gen() {
		//int[] lotto = new int[6];
		Random rand = new Random();
		
		for (int i = 0; i < this.size; i++) {
			nums[i] = rand.nextInt(45) + 1;
		}
	}
	
	
	// ��ü���� ���� ǥ�������� �ٲ� �Լ�
	// ��ü�� ����ϴ� �Լ� : Object function / Instance function / Method
	public void sort() {		
		for (int j = 0; j < size-1; j++) {
			for (int i = 0; i < size-1-j ; i++) {
				int compare;
				if (nums[i] > nums[i + 1]) {
					compare = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = compare;
				}
			}
		}
	}

}
