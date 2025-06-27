package com.sd.java.nestedClass;

import java.util.ArrayList;
import java.util.List;

//Here is the implementation of Adapter pattern by using Non-Static-Member class

interface ICacheIterator {
	boolean hasNext();
	Item next();
}

public class Cache {
    private List<Item> items;
    private int size;
    
    public Cache(int size) {
    	this.size = size;
    	this.items = new ArrayList<Item>();
    }
    
    public boolean add(Item item) {
    	if(this.items.size() < this.size) {
    		this.items.add(item);
    		return true;
    	}
    	return false;
    }
    
    public ICacheIterator iterator() {
    	return new CacheIterator();
    }
    
    private class CacheIterator implements ICacheIterator {
    	private int cursorIndex = 0;

		@Override
		public boolean hasNext() {
			return this.cursorIndex < items.size();
		}

		@Override
		public Item next() {
			if(this.cursorIndex < items.size()) {
				Item result = items.get(cursorIndex);
				this.cursorIndex++;
				return result;
			}
			return null;
		}
    	
    }
    
}
