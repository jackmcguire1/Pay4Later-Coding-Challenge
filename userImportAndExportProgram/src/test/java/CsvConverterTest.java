import converters.CsvConverter;
import entities.Users;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jackm on 10/11/2016.
 */
public class CsvConverterTest {

    CsvConverter csvConverter;
    @Before
    public void setup(){
        csvConverter = new CsvConverter();
    }

    @Test
    public void exportUserDataAsFile() throws Exception {
        Users users = csvConverter.importUserData();
        csvConverter.exportUserDataAsFile(users);
    }

    @Test
    public void exportUserDataAsString() throws Exception{
        Users users = csvConverter.importUserData();
        String userDataAsString = csvConverter.exportUserDataAsString(users);
        System.out.println(userDataAsString);
        assertNotNull(userDataAsString);
    }

    @Test
    public void importUserData() throws Exception {
        Users users = csvConverter.importUserData();
        assertTrue(users.getUsers().size() > 0);
    }

}