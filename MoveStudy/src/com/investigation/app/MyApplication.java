package com.investigation.app;

import java.io.File;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.investigation.entity.Integration;
import com.investigation.entity.Option;
import com.investigation.entity.Questionnaire;
import com.investigation.entity.Solution4Questionnaire;
import com.investigation.entity.Solution4Topic;
import com.investigation.entity.Topic;

public class MyApplication extends Application {
	public static File cacheDir;

	@Override
	public void onCreate() {
		super.onCreate();
		// 如果使用美国节点，请加上这行代码 AVOSCloud.useAVCloudUS();
		// AVObject.registerSubclass(User.class);
		AVObject.registerSubclass(Questionnaire.class);
		AVObject.registerSubclass(Topic.class);
		AVObject.registerSubclass(Option.class);
		AVObject.registerSubclass(Solution4Questionnaire.class);
		AVObject.registerSubclass(Solution4Topic.class);
		AVObject.registerSubclass(Integration.class);
		AVOSCloud.initialize(this,
				"4d1w9bpmg2kgvjvwe5t5r1525s4ab6mxi8m8ibabv7i32ldy",
				"zoqyx2c9zu1uym4sls3e80oa2silbkb063arfx6w66yoopwp");

	}

}
