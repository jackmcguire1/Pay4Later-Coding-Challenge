package converters;

import entities.Users;

import java.io.File;

/**
 * Created by jackm on 10/11/2016.
 */
public interface ImportExport {
    public String exportUserDataAsString(Users users) throws Exception;
    public File exportUserDataAsFile(Users users)throws Exception;
    public Users importUserData() throws Exception;
}
