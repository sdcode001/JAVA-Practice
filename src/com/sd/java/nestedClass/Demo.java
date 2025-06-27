package com.sd.java.nestedClass;

public class Demo {

	public static void main(String[] args) {
		//Demo for Adapter pattern by using Non-Static-Member class
        Item item1 = new Item(1000, "P1");
        Item item2 = new Item(1001, "P2");
        Item item3 = new Item(1002, "P3");
        
        Cache myCache = new Cache(4);
        myCache.add(item1);
        myCache.add(item2);
        myCache.add(item3);
        
        ICacheIterator iterator = myCache.iterator();
        
        while(iterator.hasNext()) {
        	System.out.println(iterator.next());
        }
        
        //Demo for Static-Member class
        
        
	}

}
