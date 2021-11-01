package com.kollu.kubernetesone.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kollu.kubernetesone.feign.KubernetesTwoFeignProxy;

@RestController
public class KubeOneTestApplication {

	@Autowired
	private Environment env;
	
	@Autowired
	private KubernetesTwoFeignProxy kubernetesTwoFeignProxy;
	
	private Logger logger = LoggerFactory.getLogger(KubeOneTestApplication.class);
	
	@GetMapping("/kollu")
	public String getValues() throws UnknownHostException { 
		logger.info("KubeOneTestApplication ----getValues method ");
		String port = env.getProperty("local.server.port");
		String kubeHost = env.getProperty("HOSTNAME");
		
		String host = InetAddress.getLocalHost().getHostAddress();
		
		String testName = "I am from KubeOneTestApplication Module "+port +"===HOSTNAME:::"+host+"========kubeHost :::"+kubeHost;
		System.out.println("Console::: I am from KubeOneTestApplication :: PORT::"+port +"HOSTNAME:::"+host+"======kubeHost:::"+kubeHost);
		logger.info("I am from KubeOneTestApplication :: PORT::"+port +"===HOSTNAME:::"+host+"========kubeHost::::"+kubeHost); 
		return testName;
	}
	
	@GetMapping("/kolluid")
	public String getTwoIdValues() throws UnknownHostException { 
		logger.info("KubeOneTestApplication ----getTwoIdValues method ");
		String port = env.getProperty("local.server.port");
		String kubeHost = env.getProperty("HOSTNAME");
		
		String host = InetAddress.getLocalHost().getHostAddress();
		
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8183/kollutwoid", String.class);
 		
		
		//String testName = "I am from KubeOneTestApplication Module "+port +"===HOSTNAME:::"+host+"========kubeHost :::"+kubeHost;
		System.out.println("Console::: I am from KubeOneTestApplication :: PORT::"+port +"HOSTNAME:::"+host+"======kubeHost:::"+kubeHost);
		logger.info("I am from KubeOneTestApplication :: PORT::"+port +"===HOSTNAME:::"+host+"========kubeHost::::"+kubeHost); 
		return entity.getBody();
	}
	
	@GetMapping("/kollufeign")
	public ResponseEntity<String> getTwoIdValuesFeign() throws UnknownHostException {
		logger.info("KubeOneTestApplication ----getTwoIdValuesFeign method ");
		String port = env.getProperty("local.server.port");
		String kubeHost = env.getProperty("HOSTNAME");
		
		String host = InetAddress.getLocalHost().getHostAddress();
		
		ResponseEntity<String> responseEntity = null; 
		
		responseEntity = kubernetesTwoFeignProxy.getTwoValues();
		
		
		//String testName = "I am from KubeOneTestApplication Module "+port +"===HOSTNAME:::"+host+"========kubeHost :::"+kubeHost;
		System.out.println("Console::: I am from KubeOneTestApplication :: PORT::"+port +"HOSTNAME:::"+host+"======kubeHost:::"+kubeHost);
		logger.info("I am from KubeOneTestApplication :: PORT::"+port +"===HOSTNAME:::"+host+"========kubeHost::::"+kubeHost); 
		return  new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
	}
	
	
}
