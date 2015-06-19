package com.investigation.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movestudy.R;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.biz.AShoppingDao;
import com.investigation.biz.AccountDao;
import com.investigation.biz.BaseDao;
import com.investigation.biz.HomeDao;
import com.investigation.config.Constants;
import com.investigation.entity.AShoppingResponseEntity;
import com.investigation.entity.AccountResponseEntity;
import com.investigation.entity.CategorysEntity;
import com.investigation.entity.HomeResponseEntity;
import com.investigation.entity.NavigationModel;
import com.investigation.entity.base.BaseResponseData;
import com.investigation.indicator.TitlePageIndicator;
import com.investigation.slidingmenu.SlidingMenu;
import com.investigation.ui.base.BaseSlidingFragmentActivity;
import com.investigation.utils.PopupWindowUtil1;
import com.investigation.view.HomePageFragment;

public class Vote_MainActivity extends BaseSlidingFragmentActivity implements
		OnClickListener, AnimationListener {
	private final String LIST_TEXT = "text";
	private final String LIST_IMAGEVIEW = "img";

	// [start]����
	/**
	 * ���ִ���б�˳��
	 */
	private int mTag = 0;

	private View title;
	private LinearLayout mlinear_listview;

	// title����
	// private ImageView imgQuery;
	// private ImageView imgMore;
	private ImageView imgLeft;
	private ImageView imgRight;
	private FrameLayout mFrameTv;// FrameLayout����򵥵Ĳ����ˡ����з��ڲ�����Ŀؼ��������ղ�ζѵ�����Ļ�����Ͻǡ���ӽ����Ŀؼ�����ǰ��Ŀؼ���
									// ��FrameLayout����������κοռ��λ����ص����Զ��������塣�ؼ��Զ��Ķѷ������Ͻǣ�������Ŀ��ơ�
	private ImageView mImgTv;

	// views
	private ViewPager mViewPager;// ViewPager������ͼ�������ƻ��������л�
	// private TestPageAdapter mBasePageAdapter;//��viewpager�������fragment
	private TitlePageIndicator mIndicator;
	private LinearLayout loadLayout;
	private FrameLayout myindacaterLayout;
	private LinearLayout loadFaillayout;
	private TmlsBasePageAdapter mStudyBasePageAdapter;

	private HomeDao homeDao;
	private AccountDao accountDao;
    private AShoppingDao aShoppingDao;
	
	private List<Object> categoryList;

	private List<NavigationModel> navs;

	private ListView lvTitle;
	private SimpleAdapter lvAdapter;
	// private LinearLayout llGoHome;
	private ImageButton imgLogin;
	private Button bn_refresh;

	private TextView mAboveTitle;
	private SlidingMenu sm;// �����˵�������
	private boolean mIsTitleHide = false;
	private boolean mIsAnim = false;
	HomePageFragment fragment;
	// 添加tab导航按钮
	private LinearLayout mHome_ll;
	private LinearLayout mAccount_ll;
	private LinearLayout mStore_ll;
	private ImageView mHomeiv;
	private ImageView mAccountiv;
	private ImageView mStoreiv;
	private TextView mHomeTv;
	private TextView mAccountTv;
	private TextView mStoreTv;

	private String current_page;

	private InputMethodManager imm;

	private boolean isShowPopupWindows = false;

	private Handler mHandler;

	// [end]

	// [start]��������
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initSlidingMenu();
		setContentView(R.layout.above_slidingmenu);
		initClass();
		initControl();
		initViewPager();
		initListView();
		initgoHome();
		initNav();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

	}

	// [end]

	// [start]��ʼ������
	private void initSlidingMenu() {
		setBehindContentView(R.layout.behind_slidingmenu);
		// customize the SlidingMenu
		sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		sm.setShadowDrawable(R.drawable.slidingmenu_shadow);
		// sm.setShadowWidth(20);
		sm.setBehindScrollScale(0);
	}

	private void initControl() {

		imm = (InputMethodManager) getApplicationContext().getSystemService(
				Context.INPUT_METHOD_SERVICE);
		// loadLayout = (LinearLayout) findViewById(R.id.view_loading);
		// loadFaillayout = (LinearLayout) findViewById(R.id.view_load_fail);

		// imgQuery.setVisibility(View.GONE);

		imgLeft = (ImageView) findViewById(R.id.imageview_above_left);
		imgRight = (ImageView) findViewById(R.id.imageview_above_right);
		// editSearch.setOnKeyListener(onkey);
		mViewPager = (ViewPager) findViewById(R.id.above_pager);
		mIndicator = (TitlePageIndicator) findViewById(R.id.above_indicator);
		myindacaterLayout = (FrameLayout) findViewById(R.id.myindicaterlayout);
		lvTitle = (ListView) findViewById(R.id.behind_list_show);
		imgLogin = (ImageButton) findViewById(R.id.login_login);
		// -------------------------------------
		mHome_ll = (LinearLayout) findViewById(R.id.home_ll);
		mAccount_ll = (LinearLayout) findViewById(R.id.account_ll);
		mStore_ll = (LinearLayout) findViewById(R.id.store_ll);
		mAccountiv = (ImageView) findViewById(R.id.account_iv);
		mHomeiv = (ImageView) findViewById(R.id.home_iv);
		mStoreiv = (ImageView) findViewById(R.id.store_iv);
		mHomeTv = (TextView) findViewById(R.id.home_tv);
		mAccountTv = (TextView) findViewById(R.id.account_tv);
		mStoreTv = (TextView) findViewById(R.id.store_tv);
		// ----------------------------------------------
		mAccount_ll.setOnClickListener(this);
		mStore_ll.setOnClickListener(this);
		mHome_ll.setOnClickListener(this);

		title = findViewById(R.id.main_title);
		mlinear_listview = (LinearLayout) findViewById(R.id.main_linear_listview);
		mHomeiv.setBackgroundResource(R.drawable.home_color);
		mHomeTv.setTextColor(0xff550000);

	}

	private void initClass() {

		homeDao = new HomeDao(this);
		accountDao = new AccountDao(this);
        aShoppingDao = new AShoppingDao(this);
	}

	private void initViewPager() {
		mHandler = new Handler() {
			public void handleMessage(Message msg) {
				NavigationModel navModel = navs.get(msg.what);
				mAboveTitle.setText(navModel.getName());
				current_page = navModel.getTags();
				View view = lvTitle.getChildAt(msg.what);// ��ȡListview�еĵ�msg.what����view
				if (lvTitle.getTag() != null) {
					if (lvTitle.getTag() == view) {
						Vote_MainActivity.this.showContent();
						return;
					}
					((View) lvTitle.getTag())
							.setBackgroundColor(Color.TRANSPARENT);
				}
				lvTitle.setTag(view);
				view.setBackgroundResource(R.drawable.back_behind_list);
				switch (msg.what) {
				case 0:
					// imgQuery.setVisibility(View.GONE);
					new MyTask().execute(homeDao);
					break;
				}
			};
		};
		mStudyBasePageAdapter = new TmlsBasePageAdapter(Vote_MainActivity.this,
				new MyTask(), mHandler, mHelper);
		mViewPager.setOffscreenPageLimit(0);

		mViewPager.setAdapter(mStudyBasePageAdapter);

		mIndicator.setViewPager(mViewPager);
		mIndicator.setOnPageChangeListener(new MyPageChangeListener());

		new MyTask().execute(homeDao);// ���øտ�ʼ��ʱ����ʾ��һҳ

	}

	private void initListView() {// mj��ɵ�����,Ҳ���ǲ˵���
		lvAdapter = new SimpleAdapter(this, getData(),
				R.layout.behind_list_show, new String[] { LIST_TEXT,
						LIST_IMAGEVIEW },
				new int[] { R.id.textview_behind_title,
						R.id.imageview_behind_icon }) {// ��һ������
														// ��ʾ�������androidӦ�ó���ӿڣ��������е��������Ҫ
			// �ڶ��������ʾ���һ��Map(String ,Object)�б�ѡ��
			// ����������ʾ���沼�ֵ�id ��ʾ���ļ���Ϊ�б�������
			// ���ĸ������ʾ��Map�������Щkey��Ӧvalue������б���
			// ����������ʾ��������� Map����key��Ӧ����Դһ���������� ˳���ж�Ӧ��ϵ
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub.
				View view = super.getView(position, convertView, parent);
				if (position == mTag) {
					view.setBackgroundResource(R.drawable.back_behind_list);
					lvTitle.setTag(view);// ��ʾѡ����position ==
											// mTag���������������һ��ʼ��������ʾ������ѡ����ʹ���������ı�����ɫ��ͬ��
				} else {
					view.setBackgroundColor(Color.TRANSPARENT);
				}
				return view;
			}
		};
		lvTitle.setAdapter(lvAdapter);
		lvTitle.setOnItemClickListener(new OnItemClickListener() {// OnItemClickListener
																	// �Ǽ���ListView������Ŀ�ĵ���¼�
			@Override
			// ����ȡÿһҳ������
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				NavigationModel navModel = navs.get(position);
				// mAboveTitle.setText(navModel.getName());

				current_page = navModel.getTags();
				if (lvTitle.getTag() != null) {
					if (lvTitle.getTag() == view) {
						Vote_MainActivity.this.showContent();
						return;
					}
					((View) lvTitle.getTag())
							.setBackgroundColor(Color.TRANSPARENT);
				}
				lvTitle.setTag(view);
				view.setBackgroundResource(R.drawable.back_behind_list);

				// ��Ӧslidingmeun�в˵��ĵ���¼�
				switch (position) {
				case Constants.Slidingmeun.TMLS_SLDM_HOME:
					// imgQuery.setVisibility(View.GONE);
					new MyTask().execute(homeDao);
					break;
				case Constants.Slidingmeun.TMLS_SLDM_SELL:
					// imgQuery.setVisibility(View.GONE);

				}
			}
		});

	}

	private void initNav() {
		navs = new ArrayList<NavigationModel>();
		NavigationModel nav1 = new NavigationModel(getResources().getString(
				R.string.tmls_menuHome), "");
		NavigationModel nav2 = new NavigationModel(getResources().getString(
				R.string.tmls_menuSell), Constants.TAGS.STUDY_TAG);
		NavigationModel nav3 = new NavigationModel(getResources().getString(
				R.string.tmls_menuStock), Constants.TAGS.NEWS_TAG);
		NavigationModel nav4 = new NavigationModel(getResources().getString(
				R.string.tmls_menuCount), Constants.TAGS.WIKI_TAG);
		NavigationModel nav5 = new NavigationModel(getResources().getString(
				R.string.tmls_menuHelp), Constants.TAGS.BLOG_TAG);
		NavigationModel nav6 = new NavigationModel(getResources().getString(
				R.string.tmls_menuAdvance), Constants.TAGS.ADVANCE_TAG);
		NavigationModel nav7 = new NavigationModel(getResources().getString(
				R.string.tmls_menuPerson), Constants.TAGS.PERSON_TAG);
		NavigationModel nav8 = new NavigationModel(getResources().getString(
				R.string.tmls_menuSet), Constants.TAGS.SET_TAG);
		Collections
				.addAll(navs, nav1, nav2, nav3, nav4, nav5, nav6, nav7, nav8);
	}

	private void initgoHome() {

	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuHome));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_handpick);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuSell));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_studio);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuStock));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_news);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuCount));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_blog);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuHelp));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_studio);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuAdvance));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_news);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuPerson));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_blog);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put(LIST_TEXT, getResources().getString(R.string.tmls_menuSet));
		map.put(LIST_IMAGEVIEW, R.drawable.dis_menu_studio);
		list.add(map);
		return list;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.Linear_above_toHome:// ����above_title�еĿؼ�
			showMenu();// �����˵���
			break;


		case R.id.home_ll:
			resetIvBackgroundAndText();
			mHomeiv.setBackgroundResource(R.drawable.home_color);
			mHomeTv.setTextColor(0xff550000);
			new MyTask().execute(homeDao);
			break;
		case R.id.account_ll:
			resetIvBackgroundAndText();
			mAccountiv.setBackgroundResource(R.drawable.account_color);
			mAccountTv.setTextColor(0xff550000);
			new MyTask().execute(accountDao);
			break;

		case R.id.store_ll:
			resetIvBackgroundAndText();
			mStoreiv.setBackgroundResource(R.drawable.store_color);
			mStoreTv.setTextColor(0xff550000);
			new MyTask().execute(aShoppingDao);
			break;
		}

	}

	// 重置颜色背景
	private void resetIvBackgroundAndText() {
		mHomeiv.setBackgroundResource(R.drawable.home);
		mAccountiv.setBackgroundResource(R.drawable.account);
		mStoreiv.setBackgroundResource(R.drawable.store);

		mHomeTv.setTextColor(Color.BLACK);
		mAccountTv.setTextColor(Color.BLACK);
		mStoreTv.setTextColor(Color.BLACK);
	}

	/**
	 * �������η��ؼ���˳�
	 */
	private int keyBackClickCount = 0;

	@Override
	protected void onResume() {
		super.onResume();
		keyBackClickCount = 0;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			switch (keyBackClickCount++) {
			case 0:
				Toast.makeText(this,
						getResources().getString(R.string.press_again_exit),
						Toast.LENGTH_SHORT).show();
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						keyBackClickCount = 0;
					}
				}, 3000);
				break;
			case 1:
				mFrameTv.setVisibility(View.VISIBLE);
				mImgTv.setVisibility(View.VISIBLE);
				Animation anim = AnimationUtils.loadAnimation(
						Vote_MainActivity.this, R.anim.tv_off);
				anim.setAnimationListener(new tvOffAnimListener());
				mImgTv.startAnimation(anim);
				break;
			default:
				break;
			}
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_MENU) {

			if (sm.isMenuShowing()) {
				toggle();
			} else {
				showMenu();
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		super.dispatchTouchEvent(event);
		if (mIsAnim || mViewPager.getChildCount() <= 1) {
			return false;
		}
		final int action = event.getAction();

		float x = event.getX();
		float y = event.getY();

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			lastY = y;
			lastX = x;
			return false;
		case MotionEvent.ACTION_MOVE:
			float dY = Math.abs(y - lastY);
			float dX = Math.abs(x - lastX);
			boolean down = y > lastY ? true : false;
			lastY = y;
			lastX = x;
			if (dX < 8 && dY > 8 && !mIsTitleHide && !down) {
				Animation anim = AnimationUtils.loadAnimation(
						Vote_MainActivity.this, R.anim.push_top_in);
				// anim.setFillAfter(true);
				anim.setAnimationListener(Vote_MainActivity.this);
				title.startAnimation(anim);
			} else if (dX < 8 && dY > 8 && mIsTitleHide && down) {
				Animation anim = AnimationUtils.loadAnimation(
						Vote_MainActivity.this, R.anim.push_top_out);
				// anim.setFillAfter(true);
				anim.setAnimationListener(Vote_MainActivity.this);
				title.startAnimation(anim);
			} else {
				return false;
			}
			mIsTitleHide = !mIsTitleHide;
			mIsAnim = true;
			break;
		default:
			return false;
		}
		return false;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	// [end]

	/**
	 * ���ط���list��task
	 *
	 * @author wangxin
	 */
	public class MyTask extends AsyncTask<BaseDao, String, Map<String, Object>> {// ʵ���첽�������

		private boolean mUseCache;

		public MyTask() {
			System.out.println(">>>>>>>>>>>>..............1");
			mUseCache = true;
		}

		public MyTask(boolean useCache) {
			mUseCache = useCache;
		}

		@Override
		protected void onPreExecute() {// ��execute(Params...
										// params)�����ú�����ִ�У�һ��������ִ�к�̨����ǰ��UI��һЩ��ǡ�
			// TODO Auto-generated method stub
			System.out.println(">>>>>>>>>>>>..............2");
			imgLeft.setVisibility(View.GONE);
			imgRight.setVisibility(View.GONE);
			// loadLayout.setVisibility(View.VISIBLE);
			mViewPager.setVisibility(View.GONE);
			mViewPager.removeAllViews();
			mStudyBasePageAdapter.Clear();
			Vote_MainActivity.this.showContent();
			super.onPreExecute();
			isShowPopupWindows = false;
		}

		@Override
		protected Map<String, Object> doInBackground(BaseDao... params) {// ��onPreExecute()��ɺ�����ִ�У�
			// ����ִ�н�Ϊ��ʱ�Ĳ������˷����������������ͷ��ؼ�����
			// ��ִ�й���п��Ե���publishProgress(Progress... values)�����½����Ϣ��
			System.out.println(">>>>>>>>>>>>..............3");
			BaseDao dao = params[0];
			List<CategorysEntity> categorys;
			Map<String, Object> map = new HashMap<String, Object>();
			/*
			 * ����û����������dao������ȥ�ӻ�ȡ���
			 */

			if (dao instanceof HomeDao) {

				mTag = 0;
				HomeResponseEntity myrespResponseEntity;
				if ((myrespResponseEntity = homeDao.mapperJson(true)) != null) {// ��ȡ��ݵ�ʵ��
					// mIndicator.setVisibility(View.GONE);
					try {

						if (myindacaterLayout.getVisibility() == View.VISIBLE) {
							myindacaterLayout.setVisibility(View.GONE);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					categorys = homeDao.getCategorys();
					map.put("tabs", categorys);
					map.put("Entity", myrespResponseEntity);
				}
			}
			else if (dao instanceof AccountDao) {
			     
			      mTag = 0;
			       AccountResponseEntity myrespResponseEntity;
			       if ((myrespResponseEntity = accountDao.mapperJson(true)) != null) {//��ȡ��ݵ�ʵ��
			        	//mIndicator.setVisibility(View.GONE);
			       	try {
							
			        	if(myindacaterLayout.getVisibility() == View.VISIBLE){
			        	   myindacaterLayout.setVisibility(View.GONE);
			        	}
			       	} catch (Exception e) {
							// TODO: handle exception
						}

			            categorys = homeDao.getCategorys();
			            map.put("tabs", categorys);
			            map.put("Entity", myrespResponseEntity);
			        }
			    }
			 else if (dao instanceof AShoppingDao) {
			     
			     mTag = 0;
			      AShoppingResponseEntity myrespResponseEntity;
			      if ((myrespResponseEntity = aShoppingDao.mapperJson(true)) != null) {//��ȡ��ݵ�ʵ��
			       	//mIndicator.setVisibility(View.GONE);
			      	try {
							
			       	if(myindacaterLayout.getVisibility() == View.VISIBLE){
			       	   myindacaterLayout.setVisibility(View.GONE);
			       	}
			      	} catch (Exception e) {
							// TODO: handle exception
						}

			           categorys = homeDao.getCategorys();
			           map.put("tabs", categorys);
			           map.put("Entity", myrespResponseEntity);
			       }
			 }

			return map;
		}

		@Override
		protected void onPostExecute(Map<String, Object> result) {// ����̨��������ʱ���˷������ᱻ���ã�
			// ��������Ϊ����ݵ��˷����У�ֱ�ӽ������ʾ��UI����ϡ�
			// TODO Auto-generated method stub
			System.out.println(">>>>>>>>>>>>..............4");
			super.onPostExecute(result);
			isShowPopupWindows = true;
			mStudyBasePageAdapter.Clear();
			mViewPager.removeAllViews();
			if (!result.isEmpty()) {// ��õ���Դ������pager����ƥ��
				mStudyBasePageAdapter.addFragment((List) result.get("tabs"),
						(BaseResponseData) result.get("Entity"));
				imgRight.setVisibility(View.VISIBLE);
				// loadLayout.setVisibility(View.GONE);//View.GONE����
				// ���Ҳ�ռ�ý���ռ䣺��ռ��ҳ��ռ����˵��ҳ���ϲ�������λ��
				// loadFaillayout.setVisibility(View.GONE);//VIew.InVisible�ؼ�����
				// ռ�ý���ռ�
			} else {
				mStudyBasePageAdapter.addNullFragment();

			}
			mViewPager.setVisibility(View.VISIBLE);// ��ʾ���pager
			//mStudyBasePageAdapter.notifyDataSetChanged();// notifyDataSetChanged����ͨ��һ���ⲿ�ķ�������
			// ��������������ݸı�ʱ��Ҫǿ�Ƶ���getView��ˢ��ÿ��Item������,����ʵ�ֶ�̬��ˢ���б�Ĺ��ܡ�
			mViewPager.setCurrentItem(0);
			//mIndicator.notifyDataSetChanged();

		}
	}

	/**
	 * viewPager�л�ҳ��
	 *
	 * @author mingxv
	 */
	class MyPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			if (arg0 == 0) {
				getSlidingMenu().setTouchModeAbove(
						SlidingMenu.TOUCHMODE_FULLSCREEN);
				imgLeft.setVisibility(View.GONE);
			} else if (arg0 == mStudyBasePageAdapter.mFragments.size() - 1) {
				imgRight.setVisibility(View.GONE);
				getSlidingMenu()
						.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
			} else {
				imgRight.setVisibility(View.VISIBLE);
				imgLeft.setVisibility(View.VISIBLE);
				getSlidingMenu()
						.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
			}
		}
	}

	class tvOffAnimListener implements AnimationListener {

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			defaultFinish();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		if (mIsTitleHide) {
			title.setVisibility(View.GONE);
		} else {

		}
		mIsAnim = false;
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		title.setVisibility(View.VISIBLE);
		if (mIsTitleHide) {
			FrameLayout.LayoutParams lp = (LayoutParams) mlinear_listview
					.getLayoutParams();
			lp.setMargins(0, 0, 0, 0);
			mlinear_listview.setLayoutParams(lp);
		} else {
			FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) title
					.getLayoutParams();
			lp.setMargins(0, 0, 0, 0);
			title.setLayoutParams(lp);
			FrameLayout.LayoutParams lp1 = (LayoutParams) mlinear_listview
					.getLayoutParams();
			lp1.setMargins(0,
					getResources().getDimensionPixelSize(R.dimen.title_height),
					0, 0);
			mlinear_listview.setLayoutParams(lp1);
		}
	}

	private float lastX = 0;
	private float lastY = 0;

}
