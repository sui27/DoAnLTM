
package doanltm;

import java.util.Date;

public class UserSession {
    private static UserSession instance;
    private String username;
    private String email;
    private String gender;
    private Date birthdate;

    private UserSession() {
        // Private constructor to prevent instantiation
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserInfo(String username, String email, String gender, Date birthdate) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}


