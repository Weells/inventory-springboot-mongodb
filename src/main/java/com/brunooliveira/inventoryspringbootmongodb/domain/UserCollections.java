package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "created_by_user_id", "folder_name", "folder_icon"})
public abstract class UserCollections {

	@Id
	protected String id;
	
	@Field("created_by_user_id")
	protected String createdByUserId;
	
	@Field("folder_name")
	protected String folderName;
	
	@Field("folder_icon")
	protected String folderIcon;
	
	public UserCollections() {}
	
	public UserCollections(String id, String folderName, String folderIcon) {
		this.id = id;
		this.folderName = folderName;
		this.folderIcon = folderIcon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty(value="created_by_user_id")
	public String getCreatedByUserId() {
		return createdByUserId;
	}
	
	public void setCreatedByUserId(String createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	@JsonProperty(value="folder_name")
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	@JsonProperty(value="folder_icon")
	public String getFolderIcon() {
		return folderIcon;
	}

	public void setFolderIcon(String folderIcon) {
		this.folderIcon = folderIcon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCollections other = (UserCollections) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
