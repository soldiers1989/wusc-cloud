package com.cxc.video.mapper;

import com.cxc.video.model.AliVideoUpload;

public interface AliVideoUploadMapper {
    int deleteByPrimaryKey(Long uploadId);

    int insert(AliVideoUpload record);

    int insertSelective(AliVideoUpload record);

    AliVideoUpload selectByPrimaryKey(Long uploadId);

    int updateByPrimaryKeySelective(AliVideoUpload record);

    int updateByPrimaryKey(AliVideoUpload record);
}