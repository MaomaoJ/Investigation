package com.investigation.app;

import java.io.File;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

public class MyApplication extends Application {
	public static File cacheDir;

	@Override
	public void onCreate() {
		// 如果使用美国节点，请加上这行代码 AVOSCloud.useAVCloudUS();
		super.onCreate();

	}

}
