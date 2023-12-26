package Entities;

import Exceptions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class User implements IEntity {
    private String nickname;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String imagePath;


    public User(String nickname, String password, String name, String surname, String email, int age, String imagePath) throws IOException, InvalidAgeException, InvalidNameException, AlreadyExistsException, InvalidPasswordException, InvalidUsernameException, InvalidEmailException {
        this.imagePath = imagePath;
        try {
            UserValidator.validateAge(age);
            UserValidator.validateName(name, surname);
            UserValidator.validateEmail(email);
            UserValidator.validatePassword(password);
            UserValidator.validateUsername(nickname);
            UserValidator.validateExistence(this);
            this.nickname = nickname;
            this.password = password;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.age = age;
            File users = new File("src\\Logs\\users.txt");
            FileWriter writer = new FileWriter(users);
            writer.append(nickname + ";" + password + ";" + name + ";" + surname + ";" + email + ";" + age + ";" +imagePath + "\n");
            writer.close();
        } catch (InvalidAgeException e) {
            throw new InvalidAgeException("Invalid Age!");
        } catch (InvalidNameException e) {
            throw new InvalidNameException("Invalid Name!");
        } catch (InvalidPasswordException e) {
            throw new InvalidPasswordException("Invalid Password!");
        } catch (InvalidUsernameException e) {
            throw new InvalidUsernameException("Invalid Username!");
        } catch (InvalidEmailException e) {
            throw new InvalidEmailException("Invalid Email!");
        } catch (AlreadyExistsException e) {
            throw new AlreadyExistsException("Already Exists!");
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        try{
            UserValidator.validatePassword(password);
        } catch (InvalidPasswordException e) {
            throw new InvalidPasswordException("Invalid Password!");
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        try{
            UserValidator.validateEmail(email);
        } catch (InvalidEmailException e) {
            throw new InvalidEmailException("Invalid Email!");
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        try{
            UserValidator.validateAge(age);
        } catch (InvalidAgeException e) {
            throw new InvalidAgeException("Invalid Age!");
        }
        this.age = age;
    }
}
