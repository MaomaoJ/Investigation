package com.investigation.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * author：qiuchunjia time：下午5:49:04 类描述：这个类是实现
 *
 */

public class ToastUtil {
	public static void toast(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
}
