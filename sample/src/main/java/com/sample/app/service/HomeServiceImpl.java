package com.sample.app.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sample.app.dao.HomeDao;
import com.sample.util.CrawlingUtil;

@Service
public class HomeServiceImpl implements HomeService {

	private static final Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	@Resource
	private HomeDao homeDao;
	
	@Override
	public void homeTest() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {

			list = homeDao.selectTest();
			
			for (Map<String, Object> map : list) {
				logger.debug(map.get("test").toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void crawling(Map<String, Object> inParam) {
		
		String url = inParam.get("url").toString();
		
		String webSources = CrawlingUtil.getOpenStreamHTML(url);
		String str;
		str = CrawlingUtil.removeTag("style", true, webSources);
		str = CrawlingUtil.removeTag("head", true, webSources);
		str = CrawlingUtil.removeTag("script", true, webSources);
		str = str.replace("<!doctype html>", "");
		logger.debug(str);
		
	}
	
	
}
