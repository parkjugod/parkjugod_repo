package com.sample.app.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeDao.class);
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public List<Map<String, Object>> selectTest() throws SQLException {
		return sqlSession.selectList("mapper.test.selectTest");
	}

}
