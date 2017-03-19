package converters;

import entities.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by jackm on 10/11/2016.
 */
public class XmlConverter implements ImportExport {

    private JAXBContext jaxbContext = null;

    public XmlConverter(){
    }

    public void createJaxbContext() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(Users.class);
    }

    public String exportUserDataAsString(Users users) throws Exception {
        createJaxbContext();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Writer writer = new StringWriter();
        jaxbMarshaller.marshal(users, writer);

        return writer.toString();
    }

    public File exportUserDataAsFile(Users users) throws Exception {
        createJaxbContext();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File("c:\\users.xml");
        jaxbMarshaller.marshal(users, file);

        return file;
    }

    public Users importUserData() throws Exception{
        createJaxbContext();
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("users.xml").getFile());
        return (Users) jaxbUnmarshaller.unmarshal(file);
    }

}
