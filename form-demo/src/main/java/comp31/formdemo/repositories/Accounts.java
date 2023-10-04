package comp31.formdemo.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import comp31.formdemo.model.Person;

@Component
public class Accounts extends ArrayList<Person> {

    public Person findByUserId(String userId) {
        for (Person person : this) {
            if (person.getUserId().equals(userId))
                return person;
        }
        return null;
    }

    // TODO add findByDepartment
    // TODO add findAllEmployees

}
