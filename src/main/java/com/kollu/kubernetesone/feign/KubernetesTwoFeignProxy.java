package com.kollu.kubernetesone.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="BankModule", url="localhost:8183") 
//@FeignClient(name="kubernetestwo", url="${KUBERNETESTWO_SERVICE_HOST:http://localhost}:8183")

@FeignClient(name="kubernetestwo", url="${KUBERNETESTWO_URI:http://localhost}:8183")

//@FeignClient(name="kubernetestwo")
public interface KubernetesTwoFeignProxy {
	
	@GetMapping("/kollutwoid")
	public ResponseEntity<String> getTwoValues(); 

}
