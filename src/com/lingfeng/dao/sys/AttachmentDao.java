package com.lingfeng.dao.sys;

import java.util.List;

import com.lingfeng.model.sys.Attachment;

import core.dao.Dao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface AttachmentDao extends Dao<Attachment> {

	List<Object[]> queryFlowerList(String epcId);

	void deleteAttachmentByForestryTypeId(Long forestryTypeId);

}
