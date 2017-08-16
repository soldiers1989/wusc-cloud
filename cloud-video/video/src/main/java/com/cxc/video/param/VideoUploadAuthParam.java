package com.cxc.video.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class VideoUploadAuthParam {
	@Required
	@StringLength(min=1, max=128)
	private String fileName;
	@Required
	@Range(min=1)
	private Long fileSize;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
}
