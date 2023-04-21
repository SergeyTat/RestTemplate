package ru.tatarinov.testtempate.demo5.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.tatarinov.testtempate.demo5.service.СonnectionsTest;

import javax.annotation.PostConstruct;


@Component
public class InitUserAdminTable {


    private final СonnectionsTest сonnectionsTest;

    @Autowired
    public InitUserAdminTable(СonnectionsTest сonnectionsTest) {
        this.сonnectionsTest = сonnectionsTest;
    }


    @PostConstruct
    public void createUsers() {
        RestTemplate restTemplate = new RestTemplate();
        String s = сonnectionsTest.getUsers();

        сonnectionsTest.saveUsers(s);
        сonnectionsTest.updateUsers(s);
        сonnectionsTest.deleteUsers(s);


    }
}
