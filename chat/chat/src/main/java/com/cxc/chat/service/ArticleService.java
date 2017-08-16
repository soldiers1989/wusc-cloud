package com.cxc.chat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cxc.chat.model.ArticleCommentInfo;
import com.cxc.chat.model.ArticleDynamicInfo;
import com.cxc.chat.param.ArticleCommentParam;
import com.cxc.chat.param.ArticleDeployParam;
import com.cxc.chat.param.ArticleThumbsUPParam;
import com.cxc.chat.ret.ArticleData;
import com.cxc.util.Empty;
import com.cxc.util.ParamUtil;
import com.cxc.util.ResultUtil;
import com.mongodb.WriteResult;

@Service
public class ArticleService {
	@Resource
	MongoTemplate mongoTemplate;
	
	/**
	 * 新增一遍文章
	 * @param param
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object addArticle(ArticleDeployParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		ArticleDynamicInfo info = new ArticleDynamicInfo();
		info.setTitle(param.getTitle());
		info.setAuthorId(param.getAuthorId());
		info.setTag(param.getTag());
		info.setContentUrl(param.getContentUrl());
		info.setDeployTime(param.getDeployTime());
		info.setCategory(param.getCategory());
		info.setHits(param.getHits());
		mongoTemplate.insert(info);
		return ResultUtil.EMPTY_RESULT;
	}
	
	
	/**
	 * 根据文章id获取文章
	 * @param id
	 * @return
	 * @author linmei.yan
	 */
	public ArticleDynamicInfo getArticleDynamicInfoById(String id){
		//Query query=new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findById(id, ArticleDynamicInfo.class);
	}
	
	/**
	 * 搜索文章
	 * @param title
	 * @param category
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public ArticleData searchArticle(String title, String category, Integer offset) throws Exception {
		if(offset == null){
			offset = 0;
		}
		Query query=new Query();
		if(title != null && !title.isEmpty()){
			query.addCriteria(Criteria.where("title").regex(title));
		}
		
		if(category != null && !category.isEmpty()){
			List<String> lstCategory = Arrays.asList(category.split(","));
			Criteria criteria = new Criteria();
			lstCategory.forEach(t->{
				criteria.orOperator(Criteria.where("category").all(t));
			});
			query.addCriteria(criteria);
		}
		query.with(new Sort(new Order(Direction.DESC, "deploy_time"))); 
		query.skip(offset);
		query.limit(4);
		return new ArticleData(mongoTemplate.find(query, ArticleDynamicInfo.class),
				mongoTemplate.count(query, ArticleDynamicInfo.class));
	}
	
	/**
	 * 评论文章
	 * @param param
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object commentArticle(ArticleCommentParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		//根据id获取一条要点评的文章
		ArticleDynamicInfo info = getArticleDynamicInfoById(param.getArticleId());
		if(info == null){
			throw new RuntimeException("commentArticle error");
		}
		List<ArticleCommentInfo> lstComments = info.getReply();
		if(lstComments == null ){
			lstComments = new ArrayList<>();
		}
		if(param.isAdd()){
			ArticleCommentInfo addComment = new ArticleCommentInfo();
			addComment.setCommentId(ObjectId.get().toString());
			addComment.setReplyUserId(param.getReplyUserId());
			addComment.setReplyToUserId(param.getReplyToUserId());
			addComment.setReplyNickName(param.getReplyNickName());
			addComment.setReplyToNickName(param.getReplyToNickName());
			addComment.setReplyPhotoUrl(param.getReplyPhotoUrl());
			addComment.setReplyToPhotoUrl(param.getReplyToPhotoUrl());
			addComment.setCommentText(param.getCommentText());
			addComment.setCommentTime(param.getCommentTime());
			addComment.setThumbsCount(0);
			lstComments.add(addComment);
		} else {
			//delete the comment
			lstComments = lstComments.stream().filter((t)->t.getCommentId() != param.getCommentId()).collect(Collectors.toList());
		}
		Query query = new Query(Criteria.where("_id").is(param.getArticleId()));  
        Update update = Update.update("reply", lstComments); 
        if(mongoTemplate.updateMulti(query, update, ArticleDynamicInfo.class).getN() != 1){
        	return ResultUtil.SYSTEM_ERROR;
        }
        return ResultUtil.EMPTY_RESULT;		
	}
	
	
	/**
	 * 对一条评论点赞
	 * @param param
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object thumbsUp(ArticleThumbsUPParam param) throws Exception{
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		//根据id获取一条要点赞的文章评论
		ArticleDynamicInfo info = getArticleDynamicInfoById(param.getArticleId());
		if(info == null){
			throw new RuntimeException("thumbsUp error");
		}
		List<ArticleCommentInfo> lstComments = info.getReply();
		
		List<ArticleCommentInfo> lstResult = lstComments.stream().filter(t->t.getCommentId().equals(param.getCommentId())).collect(Collectors.toList());
		if(lstResult == null || lstResult.isEmpty()){
			return ResultUtil.SYSTEM_ERROR;
		}
		lstComments.forEach(t->{
			if(t.getCommentId().equals(param.getCommentId())){
				int thumbsCount = t.getThumbsCount();
				if(param.isAdd()){
					thumbsCount++;
				} else {
					thumbsCount--;
				}
				t.setThumbsCount(thumbsCount);
			}
		});
		
		//更新mongo的文档时，不能只更新reply中的thumbs_count字段，要更新整个reply
		Query query = new Query(Criteria.where("_id").is(param.getArticleId()));  
        Update update = Update.update("reply", lstComments);
        if(mongoTemplate.updateMulti(query, update, ArticleDynamicInfo.class).getN() != 1){
        	return ResultUtil.SYSTEM_ERROR;
        }
        return ResultUtil.EMPTY_RESULT;		
	}
	
	/**
	 * 删除一遍文章
	 * @param id
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Empty deleteArticle(String id) throws Exception {
		Query query = Query.query(Criteria.where("_id").is(id));
		WriteResult result = mongoTemplate.remove(query, ArticleDynamicInfo.class);
		if(result.getN() != 1){
			throw new RuntimeException("delete ArticleDynamicInfo error!");
		}
		return ResultUtil.EMPTY_RESULT;
	}

}
