package comp31.formdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    String userId;
    String firstName;
    String lastName;
    String password;
    String role;

    public Person(String userId) {
        super();
        this.userId = userId;
    }

}
