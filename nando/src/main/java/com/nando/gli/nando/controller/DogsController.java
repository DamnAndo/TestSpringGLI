package com.nando.gli.nando.controller;

import com.nando.gli.nando.vo.DogsSubreadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/dogs")
public class DogsController {

    @Autowired
    RestTemplate restTemplate;

//    @GetMapping("/all")
//    public String getProductList() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        return restTemplate.exchange("http://api-recruitment-test.alfacart.com/dogs", HttpMethod.GET, entity, String.class).getBody();
//    }

    @GetMapping("/subread/{name}")
    public DogsSubreadVO getSubread(@PathVariable("name") String name) {
        final String uri = "https://dog.ceo/api/breed/"+name+"/list";
        RestTemplate restTemplate = new RestTemplate();
        DogsSubreadVO hasil = restTemplate.getForObject(uri, DogsSubreadVO.class);
        return hasil;
    }

    @GetMapping("/all")
    public String getProductList() {
        final String uri = "https://dog.ceo/api/breeds/list/all";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;

    }




}
