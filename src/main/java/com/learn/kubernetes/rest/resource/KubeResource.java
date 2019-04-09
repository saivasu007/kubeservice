package com.learn.kubernetes.rest.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.kubernetes.model.Link;
import com.learn.kubernetes.model.Links;
import com.learn.kubernetes.rest.service.KubeService;
import io.kubernetes.client.models.V1ConfigMap;
import io.kubernetes.client.models.V1ConfigMapList;
import io.kubernetes.client.models.V1Deployment;
import io.kubernetes.client.models.V1DeploymentList;
import io.kubernetes.client.models.V1Node;
import io.kubernetes.client.models.V1NodeList;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.models.V1Secret;
import io.kubernetes.client.models.V1SecretList;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.models.V1ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kube")
public class KubeResource extends ResourceSupport {

	@Autowired
	private KubeService service;
	private ObjectMapper mapper = new ObjectMapper();
	@Context
	private HttpServletRequest httpRequest;

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello, Welcome to Kubernetes Service";
	}

	@GetMapping("/apiinfo")
	public String apiInfo()  throws Exception {
		StringBuffer info = new StringBuffer();
		Links links = new Links();
		Link link1 = new Link();
		List<Link> linkList = new ArrayList<Link>();
		link1.setRel("Self");
		link1.setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString() +"/" + "nodes");
		linkList.add(link1);

		Link link2 = new Link();
		link2.setRel("Self");
		link2.setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()+"/"+"deployments");
		linkList.add(link2);

		Link link3 = new Link();
		link3.setRel("Self");
		link3.setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()+"/"+"svcs");
		linkList.add(link3);

		Link link4 = new Link();
		link4.setRel("Self");
		link4.setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()+"/"+"pods");
		linkList.add(link4);

		Link link5 = new Link();
		link5.setRel("Self");
		link5.setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()+"/"+"secrets");
		linkList.add(link5);

		Link link6 = new Link();
		link6.setRel("Self");
		link6.setHref(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()+"/"+"configmaps");
		linkList.add(link6);

		links.setLinks(linkList);
		/*
		info.append("/nodes").append("\n")
			.append("/deployments").append("\n")
			.append("/svcs").append("\n")
			.append("/pods").append("\n")
			.append("/screts").append("\n")
			.append("/configmaps").append("\n");
		return info.toString();
		*/
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(links);
	}

	@GetMapping(value = "/nodes")
	public List<List<String>> getNodes() throws Exception {
		List<List<String>> output = new ArrayList<List<String>>();
		V1NodeList list = service.getKubeNodes();
		for (V1Node item : list.getItems()) {
			List<String> printList = new ArrayList<String>();
			printList.add(item.getMetadata().getName());
			printList.add(item.getStatus().getAddresses().get(0).getAddress());
			printList.add(item.getStatus().getNodeInfo().getOperatingSystem());
			printList.add(item.getStatus().getNodeInfo().getKernelVersion());
			printList.add(item.getMetadata().getSelfLink());
			output.add(printList);
		}
		System.out.println(output);
		return output;
	}

	@GetMapping(value = "/deployments")
	public List<List<String>> getDeployments() throws Exception {
		List<List<String>> output = new ArrayList<List<String>>();
		V1DeploymentList list = service.getKubeDeployments();
		for (V1Deployment item : list.getItems()) {
			List<String> printList = new ArrayList<String>();
			printList.add(item.getMetadata().getName());
			printList.add(item.getStatus().getReplicas().toString());
			printList.add(item.getSpec().getTemplate().getSpec().getContainers().get(0).getName());
			printList.add(item.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
			printList.add(item.getMetadata().getNamespace());
			printList.add(item.getMetadata().getSelfLink());
			output.add(printList);

		}
		System.out.println(output);
		return output;
	}

	@GetMapping(value = "/svcs")
	public List<String> getServices() throws Exception {
		List<String> printList = new ArrayList<String>();
		V1ServiceList list = service.getKubeServices();
		for (V1Service item : list.getItems()) {
			printList.add(item.getMetadata().getName());
			printList.add(item.getSpec().getPorts().get(0).getPort().toString());
			printList.add(item.getMetadata().getNamespace());
		}
		System.out.println(printList);
		return printList;
	}

	@GetMapping(value = "/pods")
	public List<String> getPods() throws Exception {
		List<String> printList = new ArrayList<String>();
		V1PodList list = service.getKubePods();
		for (V1Pod item : list.getItems()) {
			printList.add(item.getMetadata().getName());
			printList.add(item.getStatus().getPhase());
			printList.add(item.getMetadata().getNamespace());
		}
		System.out.println(printList);
		return printList;
	}

	@GetMapping(value = "/secrets")
	public String getsecrets() throws Exception {
		List<String> printList = new ArrayList<String>();
		V1SecretList list = service.getKubeSecrets();
		for (V1Secret item : list.getItems()) {
			printList.add(item.getMetadata().getName());
			printList.add(item.getType());
			printList.add(item.getMetadata().getNamespace());
		}
		System.out.println(printList);
		return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(printList);
	}

	@GetMapping(value = "/configmaps")
	public List<String> getConfigMaps() throws Exception {
		List<String> printList = new ArrayList<String>();
		V1ConfigMapList list = service.getKubeConfigmaps();
		for (V1ConfigMap item : list.getItems()) {
			printList.add(item.getMetadata().getName());
			printList.add(item.getMetadata().getNamespace());
			printList.add(item.getMetadata().getSelfLink());
		}
		System.out.println(printList);
		return printList;
	}

	@GetMapping(value = "/all")
	public String getAllObjects() throws Exception {
		List<String> printList = new ArrayList<String>();
		System.out.println(printList);
		return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(printList);
	}
}
