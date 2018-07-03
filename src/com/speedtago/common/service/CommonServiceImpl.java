package com.speedtago.common.service;

import java.util.HashMap;
import java.util.Map;

import com.speedtago.common.dao.CommonDaoImpl;
import com.speedtago.util.KitriConstance;
import com.speedtago.util.PageNavigation;

public class CommonServiceImpl implements CommonService {

	private static CommonService commonService;
	
	static {
		commonService = new CommonServiceImpl();
	}
	
	private CommonServiceImpl() {}
	
	public static CommonService getCommonService() {
		return commonService;
	}

	@Override
	public PageNavigation getPageNavigation(int bcode, int pg, String key, String word) {
		int listSize = KitriConstance.BOARD_LIST_SIZE;//TODO ���߿� �ٹ��Խ��� ���鶧 ��������.
		int pageSize = KitriConstance.NAVIGATOR_SIZE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + "");
		map.put("key", key);
		map.put("word", word);
		PageNavigation navigator = new PageNavigation();
		navigator.setPageNo(pg);
		int newArticleCount = CommonDaoImpl.getCommonDao().getNewArticleCount(bcode);
		navigator.setNewArticleCount(newArticleCount);
		int totalArticleCount = CommonDaoImpl.getCommonDao().getTotalArticleCount(map);
		navigator.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / listSize + 1;
		navigator.setTotalPageCount(totalPageCount);
		navigator.setNowFirst(pg <= pageSize);
		navigator.setNowEnd((totalPageCount - 1) / pageSize * pageSize < pg);
		return navigator;
	}


}








