/**
 * 
 */
package com.cxc.ms.service.mvc.model;

/**
 * <pre>
 * 分页参数model
 * @author Leo
 * 2017-4-17
 * </pre>
 */
public class Page {
	/**
	 * 页码
	 */
	private Long pageNo = 0L;
	/**
	 * 上一页最后一条记录id
	 */
	private Long pageMark = 0L;
	public Long getPageNo() {
		return pageNo;
	}
	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}
	public Long getPageMark() {
		return pageMark;
	}
	public void setPageMark(Long pageMark) {
		this.pageMark = pageMark;
	}
}
