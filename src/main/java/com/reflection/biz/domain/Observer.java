package com.reflection.biz.domain;

import com.reflection.annotation.NameValue;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

public class Observer {

//	String getVOInfo(T vo);                         // save, find, delete

//	String getUpdateInfo(T before, T after);        // update

//	String getFindInfo(T vo);

//	String getDeleteInfo(T vo);

//	default String _getInfo(T vo) {
//		return "";
//	}

//	default String _getSimpleInfo(T vo) {
//		return "";
//	}

	//	default String _getUpdateInfo(T before, T after) {
//		return "";
//	}
	private static final String DIFF_FORMAT = "%s : %s -> %s\n";

	// save, find, delete
	public static <T> Map<String, String> getVoInfo(T vo) {
		return _getFieldNameValue(vo);
	}

	// update
	public static <T> String getUpdateInfo(T before, T after) {
		StringBuilder result = new StringBuilder();
		Map<String, String> beforeMap = _getFieldNameValue(before);
		Map<String, String> afterMap = _getFieldNameValue(after);

		for (Map.Entry<String, String> entry : afterMap.entrySet()) {
			result.append(_getDiffDetail(entry.getKey(), beforeMap.get(entry.getKey()), entry.getValue()));
		}

		return result.toString();
	}

	private static <T> Map<String, String> _getFieldNameValue(T vo) {
		Map<String, String> nameValueMap = new HashMap<>();
		List<Field> fields = new ArrayList<>(Arrays.asList(vo.getClass().getDeclaredFields()));
		fields.addAll(Arrays.asList(vo.getClass().getSuperclass().getDeclaredFields()));

		fields.forEach(field -> {
			NameValue annotation = field.getDeclaredAnnotation(NameValue.class);
			if (annotation != null) {
				ReflectionUtils.makeAccessible(field);
				Object fieldObject = ReflectionUtils.getField(field, vo);

				if (fieldObject != null) {
					nameValueMap.put(annotation.name(), fieldObject.toString());
				}
			}
		});

		return nameValueMap;
	}

	private static String _getDiffDetail(String fieldName, String fir, String sec) {
		fir = (fir == null) ? "" : fir;
		sec = (sec == null) ? "" : sec;
		return !fir.equals(sec) ? String.format(DIFF_FORMAT, fieldName, fir, sec) : "";
	}
}
