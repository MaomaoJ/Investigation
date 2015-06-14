package com.investigation.entity;

public class NavigationModel {
	
	private String name;
	//��ΪΨһ��ʶ�� news blog wiki ������ÿ��ҳ���������Ӧ�ĵ�ַ
	private String tags;
	
	public  NavigationModel(String name1,String tags1){
		this.name = name1;
		this.tags = tags1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
	

}
