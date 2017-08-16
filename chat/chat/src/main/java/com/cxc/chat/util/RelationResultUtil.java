package com.cxc.chat.util;

import com.cxc.util.ErrorModel;

public class RelationResultUtil {

	public static final ErrorModel FriendsCountMax = new ErrorModel("400", "无法添加好友，好友数量已达上限");
	public static final ErrorModel DuplicateFriend = new ErrorModel("400", "无法重复添加好友");
	public static final ErrorModel IllegalStateWhenAddFriend = new ErrorModel("400", "添加失败，请先解除黑名单");
	public static final ErrorModel IllegalStateWhenDeleteFriend = new ErrorModel("400", "删除失败，你们已不是好友关系");
	public static final ErrorModel IllegalStateWhenAddRemark = new ErrorModel("400", "添加失败，你们还不是好友");
}
