package com.stackroute.keepnote.model;

import java.util.Date;

public class Category {

	/*
	 * This class should have five fields
	 * (categoryId,categoryName,categoryDescription,
	 * categoryCreatedBy,categoryCreationDate). This class should also contain the
	 * getters and setters for the fields along with the toString method. The value
	 * of categoryCreationDate should not be accepted from the user but should be
	 * always initialized with the system date.
	 */
	private String categoryId;
	private String categoryName;
	private String categoryDescription;
	private String categoryCreatedBy;
	private Date categoryCreationDate;
	public Category() {
		super();
	}
	public Category(String categoryName, String categoryDescription, String categoryCreatedBy,
			Date categoryCreationDate) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryCreatedBy = categoryCreatedBy;
		this.categoryCreationDate = categoryCreationDate;
	}
	public Category(String categoryId, String categoryName, String categoryDescription, String categoryCreatedBy,
			Date categoryCreationDate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryCreatedBy = categoryCreatedBy;
		this.categoryCreationDate = categoryCreationDate;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getCategoryCreatedBy() {
		return categoryCreatedBy;
	}
	public void setCategoryCreatedBy(String categoryCreatedBy) {
		this.categoryCreatedBy = categoryCreatedBy;
	}
	public Date getCategoryCreationDate() {
		return categoryCreationDate;
	}
	public void setCategoryCreationDate(Date categoryCreationDate) {
		this.categoryCreationDate = categoryCreationDate;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryCreatedBy=" + categoryCreatedBy + ", categoryCreationDate="
				+ categoryCreationDate + "]";
	}
//    public String getCategoryId() {
//        return null;
//    }
//
//    public void setCategoryId(String categoryId) {
//       
//    }
//
//    public String getCategoryName() {
//        return null;
//    }
//
//    public void setCategoryName(String categoryName) {
//        
//    }
//
//    public String getCategoryDescription() {
//        return null;
//    }
//
//    public void setCategoryDescription(String categoryDescription) {
//      
//    }
//
//    public String getCategoryCreatedBy() {
//        return null;
//    }
//
//    public void setCategoryCreatedBy(String categoryCreatedBy) {
//       
//    }
//
//    public Date getCategoryCreationDate() {
//        return null;
//    }
//
//    public void setCategoryCreationDate(Date categoryCreationDate) {
//      
//    }

}
