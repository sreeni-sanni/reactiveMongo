package com.sreeni.reactiveMongo.utils;

import java.util.UUID;

public class Utils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
