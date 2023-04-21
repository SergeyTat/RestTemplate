package init;



import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class InitUserAdminTable {




    @PostConstruct
    public void createUsers() {

        System.out.println("Привет");
    }
}
