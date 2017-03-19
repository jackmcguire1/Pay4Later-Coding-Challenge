import converters.CsvConverter;
import converters.JsonConverter;
import converters.XmlConverter;
import entities.User;
import entities.Users;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by jackm on 10/11/2016.
 */
public class ImportExportUtility {

    public static void main(String[] args) {
        try {
            XmlConverter xmlConverter = new XmlConverter();
            Users usersXml = xmlConverter.importUserData();

            JsonConverter jsonConverter = new JsonConverter();
            Users usersJson = jsonConverter.importUserData();

            CsvConverter csvConverter = new CsvConverter();
            Users usersCsv = csvConverter.importUserData();

            Users sortedUsers = new Users();
            sortedUsers.getUsers().addAll(usersXml.getUsers());
            sortedUsers.getUsers().addAll(usersJson.getUsers());
            sortedUsers.getUsers().addAll(usersCsv.getUsers());

            Collections.sort(sortedUsers.getUsers(), new Comparator<User>() {
                public int compare(User user2, User user1) {
                    return user1.getUserId() - user2.getUserId();
                }
            });

            Collections.reverse(sortedUsers.getUsers());

            xmlConverter.exportUserDataAsFile(sortedUsers);
            jsonConverter.exportUserDataAsFile(sortedUsers);
            csvConverter.exportUserDataAsFile(sortedUsers);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
