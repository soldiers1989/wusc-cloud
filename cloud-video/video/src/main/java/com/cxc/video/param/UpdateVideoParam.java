package com.cxc.video.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

/**
@see <a href="https://help.aliyun.com/document_detail/52836.html?spm=5176.doc52835.6.575.PsvzXk">阿里云视频点播业务-更新视频信息</a>
<table>
<thead>
<tr>
<th>名称</th>
<th>类型</th>
<th>必填项</th>
<th>描述</th>
</tr>
</thead>
<tbody>
<tr>
<td>VideoId</td>
<td>String</td>
<td>是</td>
<td>视频ID</td>
</tr>
<tr>
<td>Title</td>
<td>String</td>
<td>否</td>
<td>视频标题，长度不超过128个字节</td>
</tr>
<tr>
<td>Description</td>
<td>String</td>
<td>否</td>
<td>视频描述，长度不超过1024个字节</td>
</tr>
<tr>
<td>CoverURL</td>
<td>String</td>
<td>否</td>
<td>视频封面URL地址</td>
</tr>
<tr>
<td>CateId</td>
<td>Number</td>
<td>否</td>
<td>视频分类ID</td>
</tr>
<tr>
<td>Tags</td>
<td>String</td>
<td>否</td>
<td>视频标签，单个标签不超过32字节，最多不超过16个标签</td>
</tr>
</tbody>
</table>
@author wanglei
 */
public class UpdateVideoParam {

	@StringLength(max=32)
	@Required
	private String videoId;
	@Required
	@StringLength(max=128)
	private String title;
	@StringLength(max=512)
	private String tags;
	@StringLength(max=1024)
	private String description;
	@StringLength(max=256)
	private String coverURL;
	@Range(min=1)
	private Integer cateId;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoverURL() {
		return coverURL;
	}
	public void setCoverURL(String coverURL) {
		this.coverURL = coverURL;
	}
	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
}
