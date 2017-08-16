package com.cxc.vo;

import java.util.List;
import com.cxc.course.model.Tutor;


public class TutorListData extends DataWrap<List<Tutor>> {
	public TutorListData() {
		super();
	}
	
	public TutorListData(List<Tutor>data){
		super(data);
	}
}
