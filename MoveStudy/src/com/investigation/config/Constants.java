package com.investigation.config;

import android.R.integer;

public class Constants {

	public static final class TAGS {
		public static final String STUDY_TAG = "study";
		public static final String NEWS_TAG = "news";
		public static final String BLOG_TAG = "blog";
		public static final String WIKI_TAG = "wiki";
		public static final String ADVANCE_TAG = "advance";
		public static final String PERSON_TAG = "person";
		public static final String SET_TAG = "set";
	}

	public static final class DBContentType {
		public static final String Content_list = "list";
		public static final String Content_content = "content";
		public static final String Discuss = "discuss";
	}

	public static final class WebSourceType {
		public static final String Json = "json";
		public static final String Xml = "xml";
	}

	public static final class Slidingmeun {

		public static final int TMLS_SLDM_HOME = 0;
		public static final int TMLS_SLDM_SELL = 1;
		public static final int TMLS_SLDM_STOCK = 2;
		public static final int TMLS_SLDM_COUNT = 3;
		public static final int TMLS_SLDM_HELP = 4;
		public static final int TMLS_SLDM_ADVANCE = 5;
		public static final int TMLS_SLDM_PERSON = 6;
		public static final int TMLS_SLDM_SET = 7;

	}

	public static final class Home {
		public static final String home_intent = "question";
		public static final String home_bundle_extra = "question_item";
		public static final String home_bundle_ToFragment = "ToFragment";
		public static final int question_content_type_radio = 0;
		public static final int question_content_type_checkbox = 1;
		public static final int question_content_type_anwer = 2;
		public static final int question_content_type_photo = 3;

	}
}
