package com.cxc.ms.service.mvc.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxc.ms.service.mvc.model.Verification;

public interface VerificationMapper {
    int deleteByPrimaryKey(Long verificationId);

    int insert(Verification record);

    int insertSelective(Verification record);

    Verification selectByPrimaryKey(Long verificationId);

    int updateByPrimaryKeySelective(Verification record);

    int updateByPrimaryKey(Verification record);
    
    @Select("select verification_id from verification where phone = #{phone} and expire >= #{now} and status=#{status} and verification_code=#{code} order by updated desc limit 1")
    Long selectVerificationIdByPhoneAndExpire(@Param("phone") String phone, @Param("code") String code,  @Param("now") Long now, @Param("status") Short status);
}