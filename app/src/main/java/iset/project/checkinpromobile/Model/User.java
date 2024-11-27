package iset.project.checkinpromobile.Model;

import java.time.LocalDate;

public class User {
        private  int id;
        private String firstName;
        private String lastName ;
        private String email;
        private String userName;
        private String password;
        private LocalDate birthDate;
        private LocalDate startworkDdate;
        private String position ;
        private String   adress;
        private byte[] imageData;

    public User(int id, String firstName, String lastName, String email,
                String userName, String password, LocalDate birthDate,
                LocalDate startworkDdate, String position,
                String adress, byte[] imageData) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.startworkDdate = startworkDdate;
        this.position = position;
        this.adress = adress;
        this.imageData = imageData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getStartworkDdate() {
        return startworkDdate;
    }

    public void setStartworkDdate(LocalDate startworkDdate) {
        this.startworkDdate = startworkDdate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

