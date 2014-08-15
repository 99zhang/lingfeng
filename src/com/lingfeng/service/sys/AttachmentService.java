package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.Attachment;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface AttachmentService extends Service<Attachment> {

	List<Object[]> queryFlowerList(String epcId);

	void deleteAttachmentByForestryTypeId(Long forestryTypeId);

}
