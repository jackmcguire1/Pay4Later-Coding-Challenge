import converters.XmlConverter;
import entities.Users;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by jackm on 10/11/2016.
 */
public class XmlConverterTest {

    XmlConverter xmlConverter;

    @Before
    public void setup() throws JAXBException {
        xmlConverter = new XmlConverter();
    }

    @Test
    public void exportUserDataAsStringTest() throws Exception {
        Users users = xmlConverter.importUserData();
        String output = xmlConverter.exportUserDataAsString(users);
        assertNotNull(output);
        System.out.println(output);
    }

    @Test
    public void exportUserDataAsFileTest() throws Exception {
        Users users = xmlConverter.importUserData();
        File file = xmlConverter.exportUserDataAsFile(users);
        assertNotNull(file);
    }

    @Test
    public void importUserDataTest() throws Exception {
        Users users = xmlConverter.importUserData();
        assertTrue(users.getUsers().size() > 0);
    }

}