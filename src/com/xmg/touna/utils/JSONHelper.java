package com.xmg.touna.utils;

import java.util.List;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONHelper {
	private static final SerializerFeature[] CONFIG = new SerializerFeature[] {
			SerializerFeature.WriteNullBooleanAsFalse,// boolean为null时输出false
			// SerializerFeature.WriteMapNullValue, //输出空置的字段
			SerializerFeature.WriteNonStringKeyAsString,// 如果key不为String
														// 则转换为String
														// 比如Map的key为Integer
			SerializerFeature.WriteNullListAsEmpty,// list为null时输出[]
			SerializerFeature.WriteNullNumberAsZero,// number为null时输出0
			SerializerFeature.WriteNullStringAsEmpty, // String为null时输出""
			SerializerFeature.DisableCircularReferenceDetect
	};

	public static String toJson(Object object) {
		SerializeWriter out = new SerializeWriter();
		try {
			JSONSerializer serializer = new JSONSerializer(out);

			for (com.alibaba.fastjson.serializer.SerializerFeature feature : CONFIG) {
				serializer.config(feature, true);
			}
			serializer.config(SerializerFeature.WriteEnumUsingToString, false);
			serializer.write(object);

			return out.toString();
		} finally {
			out.close();
		}
	}

	public static <T> T parseObject(String jsonString, TypeReference<T> type) {
		return JSON.parseObject(jsonString, type);
	}

	
}
