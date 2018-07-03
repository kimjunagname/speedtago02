package com.speedtago.common.service;

import com.speedtago.util.PageNavigation;

public interface CommonService {

	PageNavigation getPageNavigation(int bcode, int pg, String key, String word);
	
}
