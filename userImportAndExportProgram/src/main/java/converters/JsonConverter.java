package converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import entities.Users;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jackm on 10/11/2016.
 */
public class JsonConverter implements ImportExport {


    public JsonConverter(){

    }

    public String exportUserDataAsString(Users users) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(users.getUsers());

        return jsonInString;
    }

    public File exportUserDataAsFile(Users users) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("c:\\users.json");
        mapper.writeValue(file, users.getUsers());

        return file;
    }

    public Users importUserData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("users.json").getFile());

        User[] usersFromFile = mapper.readValue(file, User[].class);
        List<User> userList = new ArrayList<User>(Arrays.asList(usersFromFile));
        Users users = new Users();
        users.setUsers(userList);

        return users;
    }
}
