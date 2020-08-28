package settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

    public Data() {
        names.add("Tom");
        names.add("Fedor");
        names.add("Sam");
        names.add("Ekaterina");

        lNames.add("Fisher");
        lNames.add("Portman");
        lNames.add("Kansher");
        lNames.add("Loblom");
        lNames.add("Quinsy");

        mail = "sampleMail29406949382@gmail.com";

        password = "ohgpsfduglzx093285rwlekf";
    }

    private List<String> names = new ArrayList<>();
    private List<String> lNames = new ArrayList<>();
    private String mail;
    private String password;

    public String getName() {
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    public String getLastName() {
        Random random = new Random();
        return lNames.get(random.nextInt(names.size()));
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}

