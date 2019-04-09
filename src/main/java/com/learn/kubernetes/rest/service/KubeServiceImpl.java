package com.learn.kubernetes.rest.service;

import io.kubernetes.client.apis.AppsV1Api;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1ConfigMapList;
import io.kubernetes.client.models.V1DeploymentList;
import io.kubernetes.client.models.V1NodeList;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.models.V1ServiceList;
import io.kubernetes.client.models.V1SecretList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class KubeServiceImpl implements KubeService {

	private CoreV1Api coreV1Api;
	private AppsV1Api appsV1Api;


	@Override
	public V1NodeList getKubeNodes() throws Exception {
		V1NodeList nodeList = coreV1Api.listNode(null, null, null, null, null, null, null, null, null);
		System.out.println("#################################");
		System.out.println("List of NODES in the cluster");
		System.out.println("#################################");
		return nodeList;
	}

	@Override
	public V1DeploymentList getKubeDeployments() throws Exception {
		V1DeploymentList deployList = appsV1Api.listDeploymentForAllNamespaces(null, null, null, null, null, null, null, null, null);
		System.out.println("#################################");
		System.out.println("List of DEPLOYMENTS in the cluster");
		System.out.println("#################################");
		return deployList;
	}

	@Override
	public V1ServiceList getKubeServices() throws Exception {
		V1ServiceList svcList = coreV1Api.listServiceForAllNamespaces(null, null, null, null, null, null, null, null, null);
		System.out.println("#################################");
		System.out.println("List of SERVICES in the cluster");
		System.out.println("#################################");
		return svcList;
	}

	@Override
	public V1PodList getKubePods() throws Exception {
		V1PodList podList = coreV1Api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
		System.out.println("#################################");
		System.out.println("List of PODS in the cluster");
		System.out.println("#################################");
		return podList;
	}

	@Override
	public V1SecretList getKubeSecrets() throws Exception {
		V1SecretList secretList = coreV1Api.listSecretForAllNamespaces(null, null, false, null, null, null, null, null, false);
		System.out.println("#################################");
		System.out.println("List of SECRETS in the cluster");
		System.out.println("#################################");
		return secretList;
	}

	@Override
	public V1ConfigMapList getKubeConfigmaps() throws Exception {
		V1ConfigMapList configList = coreV1Api.listConfigMapForAllNamespaces(null, null, false, null, null, null, null, null, false);
		System.out.println("#################################");
		System.out.println("List of CONFIGMAPS in the cluster");
		System.out.println("#################################");
		return configList;
	}

	@Override
	public List<String> getAllKubeObjects() throws Exception {
		return new ArrayList<String>();
	}

	@Autowired
	public void setCoreV1Api(CoreV1Api coreV1Api) {
		this.coreV1Api = coreV1Api;
	}

	@Autowired
	public void setAppsV1Api(AppsV1Api appsV1Api) {
		this.appsV1Api = appsV1Api;
	}


}

