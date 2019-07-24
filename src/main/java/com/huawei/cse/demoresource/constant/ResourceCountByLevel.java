package com.huawei.cse.demoresource.constant;

import java.util.HashMap;
import java.util.Map;

public class ResourceCountByLevel {
	public enum Level{
		V0,V1,V2,V3,V4,V5
	}

	public static final Map<Level,Integer> QUOTA = new HashMap<>();
	static {
		QUOTA.put(Level.V0,2);
		QUOTA.put(Level.V1,2);
		QUOTA.put(Level.V2,2);
		QUOTA.put(Level.V3,2);
		QUOTA.put(Level.V4,5);
		QUOTA.put(Level.V5,10);

	}
}
