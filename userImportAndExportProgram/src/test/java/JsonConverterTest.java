import converters.JsonConverter;
import entities.Users;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by jackm on 10/11/2016.
 */
public class JsonConverterTest {

    public JsonConverter jsonConverter;

    @Before
    public void setup(){
        jsonConverter = new JsonConverter();
    }
    @Test
    public void exportUserDataAsString() throws Exception {
        Users users = jsonConverter.importUserData();
        String usersInXmlFormat = jsonConverter.exportUserDataAsString(users);
        assertNotNull(usersInXmlFormat);
        System.out.println(usersInXmlFormat);
    }

    @Test
    public void exportUserDataAsFile() throws Exception {
        Users users = jsonConverter.importUserData();
        File file = jsonConverter.exportUserDataAsFile(users);
    }

    @Test
    public void importUserData() throws Exception {
        Users users = jsonConverter.importUserData();
        assertTrue(users.getUsers().size() > 0);
    }

}