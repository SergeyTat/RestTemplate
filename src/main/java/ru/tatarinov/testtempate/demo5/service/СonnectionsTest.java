package ru.tatarinov.testtempate.demo5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.tatarinov.testtempate.demo5.model.User;

import java.util.List;

@Service
public class СonnectionsTest {

    private final RestTemplate restTemplate;
    private final String URL = "http://94.198.50.185:7081/api/users";

    @Autowired

    public СonnectionsTest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,httpEntity, String.class);
        List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");
        String cookie = cookies.get(0);
        int start = cookie.indexOf('=');
        int end = cookie.indexOf(';');
        cookie.substring(start + 1, end);

        return cookie.substring(start + 1, end);
    }
    public void saveUsers(String s) {
        User user = new User(3L,"James","Brown", (byte) 35);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "JSESSIONID="+s);
        HttpEntity httpEntity = new HttpEntity(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST,httpEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    public void updateUsers(String s) {
        User user = new User(3L,"Thomas","Shelby", (byte) 35);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "JSESSIONID="+s);
        HttpEntity httpEntity = new HttpEntity(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT,httpEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    public void deleteUsers(String s) {
        User user = new User(3L,"Thomas","Shelby", (byte) 35);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "JSESSIONID="+s);
        HttpEntity httpEntity = new HttpEntity(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL+"/3", HttpMethod.DELETE,httpEntity, String.class);
        System.out.println(responseEntity.getBody());
    }
}


