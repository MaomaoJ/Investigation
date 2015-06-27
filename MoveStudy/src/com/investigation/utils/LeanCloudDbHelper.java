package com.investigation.utils;

import java.util.List;

import android.os.Handler;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

/**
 * author：qiuchunjia time：下午6:40:56 类描述：这个类是实现链接云端数据库
 *
 */

public class LeanCloudDbHelper {
	public static AVObject getAllAvObjectByClazz(Class<AVObject> clazz,
			Handler handler) {
		AVQuery<AVObject> avQuery = AVObject.getQuery(clazz);
		avQuery.findInBackground(new FindCallback<AVObject>() {

			@Override
			public void done(List<AVObject> list, AVException arg1) {
				if (arg1 == null) {
					Log.i("tag", list.size() + "");
				}
			}
		});
		return null;
	}
}
