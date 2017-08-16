package com.cxc.util; 

import java.lang.reflect.Field;

public class PropertyUtil { 	
	/** 	 
	 * 将source里的属性值赋值给dest 	
	 * @param source 	 
	 * @param dest 	 
	 **/ 	
	public static void copy(Object source, Object dest) { 		
		Field[] sfs = source.getClass().getDeclaredFields(); 		
		for (Field sf : sfs) {
			try {
				sf.setAccessible(true);
				if (source.getClass().isInstance(dest)) {
					sf.set(dest, sf.get(source));
					continue;
				}
				Field df = dest.getClass().getDeclaredField(sf.getName());
				df.setAccessible(true);			
				df.set(dest, sf.get(source));
				} catch (Exception e){	
					e.printStackTrace();
				} 		
		} 	
	}
}

