package core.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import core.dao.JdbcBaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Transactional
public class JdbcBaseService {

	@Resource
	protected JdbcBaseDao jdbcBaseDao;

}
