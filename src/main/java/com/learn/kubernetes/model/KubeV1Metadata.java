package com.learn.kubernetes.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "annotations", "clusterName", "creationTimestamp", "deletionGracePeriodSeconds",
					 "deletionTimestamp", "finalizers", "generateName", "generation", "initializers", "name",
					 "namespace", "resourceVersion", "selfLink", "uid" })
public class KubeV1Metadata implements Serializable {

	@JsonProperty("annotations")
	private Object annotations;
	@JsonProperty("clusterName")
	private Object clusterName;
	@JsonProperty("creationTimestamp")
	private String creationTimestamp;
	@JsonProperty("deletionGracePeriodSeconds")
	private Object deletionGracePeriodSeconds;
	@JsonProperty("deletionTimestamp")
	private Object deletionTimestamp;
	@JsonProperty("finalizers")
	private Object finalizers;
	@JsonProperty("generateName")
	private String generateName;
	@JsonProperty("generation")
	private Object generation;
	@JsonProperty("initializers")
	private Object initializers;
	@JsonProperty("name")
	private String name;
	@JsonProperty("namespace")
	private String namespace;
	@JsonProperty("resourceVersion")
	private Integer resourceVersion;
	@JsonProperty("selfLink")
	private String selfLink;
	@JsonProperty("uid")
	private String uid;

	@JsonProperty("annotations")
	public Object getAnnotations() {
		return annotations;
	}

	@JsonProperty("annotations")
	public void setAnnotations(Object annotations) {
		this.annotations = annotations;
	}

	@JsonProperty("clusterName")
	public Object getClusterName() {
		return clusterName;
	}

	@JsonProperty("clusterName")
	public void setClusterName(Object clusterName) {
		this.clusterName = clusterName;
	}

	@JsonProperty("creationTimestamp")
	public String getCreationTimestamp() {
		return creationTimestamp;
	}

	@JsonProperty("creationTimestamp")
	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	@JsonProperty("deletionGracePeriodSeconds")
	public Object getDeletionGracePeriodSeconds() {
		return deletionGracePeriodSeconds;
	}

	@JsonProperty("deletionGracePeriodSeconds")
	public void setDeletionGracePeriodSeconds(Object deletionGracePeriodSeconds) {
		this.deletionGracePeriodSeconds = deletionGracePeriodSeconds;
	}

	@JsonProperty("deletionTimestamp")
	public Object getDeletionTimestamp() {
		return deletionTimestamp;
	}

	@JsonProperty("deletionTimestamp")
	public void setDeletionTimestamp(Object deletionTimestamp) {
		this.deletionTimestamp = deletionTimestamp;
	}

	@JsonProperty("finalizers")
	public Object getFinalizers() {
		return finalizers;
	}

	@JsonProperty("finalizers")
	public void setFinalizers(Object finalizers) {
		this.finalizers = finalizers;
	}

	@JsonProperty("generateName")
	public String getGenerateName() {
		return generateName;
	}

	@JsonProperty("generateName")
	public void setGenerateName(String generateName) {
		this.generateName = generateName;
	}

	@JsonProperty("generation")
	public Object getGeneration() {
		return generation;
	}

	@JsonProperty("generation")
	public void setGeneration(Object generation) {
		this.generation = generation;
	}

	@JsonProperty("initializers")
	public Object getInitializers() {
		return initializers;
	}

	@JsonProperty("initializers")
	public void setInitializers(Object initializers) {
		this.initializers = initializers;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("namespace")
	public String getNamespace() {
		return namespace;
	}

	@JsonProperty("namespace")
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@JsonProperty("resourceVersion")
	public Integer getResourceVersion() {
		return resourceVersion;
	}

	@JsonProperty("resourceVersion")
	public void setResourceVersion(Integer resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	@JsonProperty("selfLink")
	public String getSelfLink() {
		return selfLink;
	}

	@JsonProperty("selfLink")
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("KubeV1Metadata{");
		sb.append("annotations=").append(annotations);
		sb.append(", clusterName=").append(clusterName);
		sb.append(", creationTimestamp='").append(creationTimestamp).append('\'');
		sb.append(", deletionGracePeriodSeconds=").append(deletionGracePeriodSeconds);
		sb.append(", deletionTimestamp=").append(deletionTimestamp);
		sb.append(", finalizers=").append(finalizers);
		sb.append(", generateName='").append(generateName).append('\'');
		sb.append(", generation=").append(generation);
		sb.append(", initializers=").append(initializers);
		sb.append(", name='").append(name).append('\'');
		sb.append(", namespace='").append(namespace).append('\'');
		sb.append(", resourceVersion=").append(resourceVersion);
		sb.append(", selfLink='").append(selfLink).append('\'');
		sb.append(", uid='").append(uid).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
