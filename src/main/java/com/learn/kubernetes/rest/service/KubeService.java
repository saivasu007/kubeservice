package com.learn.kubernetes.rest.service;

import io.kubernetes.client.models.V1DeploymentList;
import io.kubernetes.client.models.V1NodeList;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.models.V1ServiceList;
import io.kubernetes.client.models.V1SecretList;
import io.kubernetes.client.models.V1ConfigMapList;

import java.util.List;

public interface KubeService {

	public V1NodeList getKubeNodes() throws Exception;
	public V1DeploymentList getKubeDeployments() throws Exception;
	public V1ServiceList getKubeServices() throws Exception;
	public V1PodList getKubePods() throws Exception;
	public V1SecretList getKubeSecrets() throws Exception;
	public V1ConfigMapList getKubeConfigmaps() throws Exception;
	public List<String> getAllKubeObjects() throws Exception;
}
