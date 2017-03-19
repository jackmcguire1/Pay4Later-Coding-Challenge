package converters;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import entities.User;
import entities.Users;

import java.io.*;
import java.util.List;

/**
 * Created by jackm on 10/11/2016.
 */
public class CsvConverter implements ImportExport {

    public CsvConverter() {
    }

    public String exportUserDataAsString(Users users) throws Exception {
        String[] columns = new String[] {"User Id","First Name","Last Name","Username","User Type","Last Login Time"};
        StringBuilder csvString = new StringBuilder();

        for(String columnName : columns){
            csvString.append("\"" + columnName + "\""  +",");
        }
        csvString.append("\n");

        for (User user : users.getUsers()) {

            String[] userInfo = new String[6];
            userInfo[0] = String.valueOf(user.getUserId());
            userInfo[1] = String.valueOf(user.getFirstName());
            userInfo[2] = String.valueOf(user.getLastName());
            userInfo[3] = String.valueOf(user.getUsername());
            userInfo[4] = String.valueOf(user.getUserType());
            userInfo[5] = String.valueOf(user.getLastLoginTime());
            for(String info : userInfo){
                csvString.append("\"" + info + "\"" + ",");
            }
            csvString.append("\n");
        }
        return csvString.toString();
    }

    public File exportUserDataAsFile(Users users) throws Exception {
        String[] columns = new String[] {"entities.User Id", "First Name", "Last Name", "Username", "entities.User Type", "Last Login Time"};

        String csvFilename = "C:\\users.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilename));
        writer.writeNext(columns);

        for (User user : users.getUsers()) {
            String[] userInfo = new String[6];
            userInfo[0] = String.valueOf(user.getUserId());
            userInfo[1] = String.valueOf(user.getFirstName());
            userInfo[2] = String.valueOf(user.getLastName());
            userInfo[3] = String.valueOf(user.getUsername());
            userInfo[4] = String.valueOf(user.getUserType());
            userInfo[5] = String.valueOf(user.getLastLoginTime());
            writer.writeNext(userInfo);
        }
        writer.close();
        return null;
    }


    public Users importUserData() throws Exception {
        String defaultFileName = "users.csv";
        Users users = importUserData(defaultFileName);
        return users;
    }

    public Users importUserData(String fileName) throws Exception {
        CSVReader csvReader = loadUserFile(fileName);
        Users users = getUsersFromFile(csvReader);
        return users;
    }

    private Users getUsersFromFile(CSVReader csvReader) throws IOException {
        Users users = new Users();
        List content = csvReader.readAll();
        for (int i = 1; i < content.size(); i++) {
            Object line = content.get(i);
            String[] row = (String[]) line;
            users.getUsers().add(createNewUser(row));
        }
        csvReader.close();
        return users;
    }

    private CSVReader loadUserFile(String filePath) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        FileReader reader = new FileReader(new File(classLoader.getResource(filePath).getFile()));
        return new CSVReader(reader);
    }

    private User createNewUser(String[] row) {
        User newUser = new User();
        newUser.setUserId(getUserId(row));
        newUser.setUsername(getUsername(row));
        newUser.setFirstName(getFirstName(row));
        newUser.setLastName(getLastName(row));
        newUser.setUserType(getUserType(row));
        newUser.setLastLoginTime(getLastLoginTime(row));

        return newUser;
    }

    private Integer getUserId(String[] row) {
        String userIdCell = row[0];
        Integer userId = Integer.parseInt(userIdCell);
        return userId;
    }

    private String getFirstName(String[] row) {
        String firstName = row[1];
        return firstName;
    }

    private String getLastName(String[] row) {
        String lastName = row[2];
        return lastName;
    }

    private String getUsername(String[] row) {
        String username = row[3];
        return username;
    }

    private String getUserType(String[] row) {
        String userType = row[4];
        return userType;
    }

    private String getLastLoginTime(String[] row) {
        String lastLoginTime = row[5];
        return lastLoginTime;
    }
}
