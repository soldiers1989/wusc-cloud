package com.cxc.chat.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.chat.model.ArticleDynamicInfo;
import com.cxc.chat.param.ArticleCommentParam;
import com.cxc.chat.param.ArticleDeployParam;
import com.cxc.chat.param.ArticleThumbsUPParam;
import com.cxc.chat.service.ArticleService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="article")
public class ArticleCtrl {
	private static final Logger log = LoggerFactory.getLogger(MongoDbCtrl.class); 
	
	@Resource
	private ArticleService articleService;
	
	@ApiOperation(value="发布一篇文章，category、title、author_id、content_url必填项",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="deploy", method=RequestMethod.POST)
	public Object deployArticle(@RequestBody ArticleDeployParam param){
		try {
			return articleService.addArticle(param);
		} catch(Exception e){
			log.error("ArticleCtrl  addArticle erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="搜索文章，按照分类、标题来搜索文章,支持分页，每页显示4篇文章",response=ArticleDynamicInfo.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="searchArticle", method=RequestMethod.GET)
	public Object searchArticle(@RequestParam(value="title",required=false)String title, @RequestParam(value="category",required=false) String category,@RequestParam(value="offset",required=false)Integer offset){
		try {
			return articleService.searchArticle(title, category, offset);
		} catch(Exception e){
			log.error("ArticleCtrl searchArticle erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据文章Id获取文章",response=ArticleDynamicInfo.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="getArticleById/{articleId}", method=RequestMethod.GET)
	public Object getArticleById(@PathVariable(value="articleId", required=true) String articleId){
		try {
			return articleService.getArticleDynamicInfoById(articleId);
		} catch(Exception e){
			log.error("ArticleCtrl searchArticle erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="增加/删除一条评论信息，article_id:文章的唯一标识，必填",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(path="commentArticle", method=RequestMethod.PUT)
	public Object commentArticle(@RequestBody ArticleCommentParam param){
		try {
			return articleService.commentArticle(param);
		} catch (Exception e) {
			log.error("ArticleCtrl commentArticle erro!", e);
			// TODO 自动生成的 catch 块
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="点赞/取消点赞,article_id:文章的唯一标识，必填;comment_id:一条评论的唯一标识，必填；is_add:true点赞，false：取消点赞",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(path="thumbsUp", method=RequestMethod.PUT)
	public Object thumbsUp(@RequestBody ArticleThumbsUPParam param){
		try {
			return articleService.thumbsUp(param);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.error("ArticleCtrl thumbsUp erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	@ApiOperation(value="根据ID删除一篇文章", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="deleteArticle/{id}", method=RequestMethod.DELETE)
	public Object deleteArticle(@PathVariable(value="id",required=true) String id){
		try {
			return articleService.deleteArticle(id);
		} catch (Exception e) {
			log.error("ArticleCtrl deleteArticle erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	

}
