package com.cxc.redis.param;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.util.Base64Utils;
import org.springframework.util.SerializationUtils;

import redis.clients.jedis.Jedis;

public class RedisParam implements Serializable{

	private static final long serialVersionUID = 1L;
	private String method;
	private Class<?>[] clazzs;
	private Object[] values;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Class<?>[] getClazzs() {
		return clazzs;
	}
	public void setClazzs(Class<?>[] clazzs) {
		this.clazzs = clazzs;
	}
	public Object[] getValues() {
		return values;
	}
	public void setValues(Object[] values) {
		this.values = values;
	}
	public static void aa(String[] args) {
		RedisParam rp = new RedisParam();
		//jedis.set(key, values, "NX".getBytes(), "PX".getBytes(), sessionExpire);
		rp.setValues(new Object[]{"123".getBytes()/*, "{\"name\":\"jack\"}".getBytes(), "NX".getBytes(), "PX".getBytes(), 600000L*/});
		rp.setMethod("get");
		rp.setClazzs(new Class<?>[]{byte[].class/*, byte[].class, byte[].class, byte[].class, long.class*/});
		
		byte[] bs = SerializationUtils.serialize(rp);
		RedisParam p = (RedisParam) SerializationUtils.deserialize(bs);
		System.out.println(p.getMethod());
		System.out.println(Arrays.toString(p.getClazzs()));
		System.out.println(Arrays.toString(p.getValues()));
		System.out.println(new String( (byte[]) p.getValues()[0]));
		System.out.println(Base64Utils.encodeToString(bs));
		bs = Base64Utils.decodeFromString(Base64Utils.encodeToString(bs));
		p = (RedisParam) SerializationUtils.deserialize(bs);
		System.out.println(p.getMethod());
		System.out.println(Arrays.toString(p.getClazzs()));
		System.out.println(Arrays.toString(p.getValues()));
		System.out.println(new String( (byte[]) p.getValues()[0]));
		System.out.println(Base64Utils.encodeToString(bs));
		
		try {
			Jedis.class.getMethod("set", byte[].class, byte[].class, byte[].class, byte[].class, Long.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*ObjectMapper om = new ObjectMapper();
		try {
			String s = om.writeValueAsString(rp);
			System.out.println(s);
			String ss = "{\"method\":\"shit\",\"clazzs\":[\"java.lang.String\",\"int\",\"[B\"],\"values\":[\"123\",222,\"YmJi\"]}";
			RedisParam p = om.readValue(ss, RedisParam.class);
			System.out.println(p.getMethod());
			System.out.println(Arrays.toString(p.getClazzs()));
			System.out.println(Arrays.toString(p.getValues()));
			System.out.println(p.getValues()[2].getClass());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
