package comp31.formdemo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import comp31.formdemo.model.Person;
import comp31.formdemo.repositories.Accounts;

@Service
public class LoginService {

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    Accounts accounts;

    public LoginService(Accounts accounts) {
        this.accounts = accounts;

        String[] userIds = { "admin", "sales", "orders" };

        for (String userId : userIds) {
            addPerson(userId);
            // TODO add more user info
        }

    }

    public void addPerson(String userId) {
        logger.info("Adding user: " + userId);
        Person person = new Person();
        person.setUserId(userId);
        accounts.add(person);
    }

    public void addPerson(Person person) {
        accounts.add(person);
    }

    public Person findByUserId(String userId) {
        return accounts.findByUserId(userId);
    }

}
