package com.newlecture.web;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Member;

public class CollectionProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object[] members = new Object[10];
		members[0] = new Member();
		
		((Member)members[0]).getNicName();
		
		
		//		os[0] = "Hello";
//		os[1] = "hi";
//		os[2] = "okay";
//		os[3] = 3;
		

		List<Member> list = new ArrayList();
		
		list.add(10);
		list.add(100);
		list.add("hello");
		list.add(2.3);
		
		System.out.println(list.get(1));
		
		Set set = new Hashset();
		set.add(10);
		set.add(100);
		set.add("hello");
		set.add(2.3);
		
		System.out.println(100);
		
		Map map = new HashMap();
		map.put("id",1);
		map.put("title","hello");
		map.put("hit",1);
		
		System.out.println(map.get("title"));

	}

}
