package Entities;

import Exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public static void validatePassword(String password) throws InvalidPasswordException {
        boolean numberExists = false, letterExists= false;
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        boolean specialExists = matcher.find();

        char[] array = password.toCharArray();
        for(Character c: array){
            if (Character.isDigit(c)){
                numberExists = true;
            }
            if (Character.isLetter(c)){
                letterExists = true;
            }
        }

        if (!(specialExists && numberExists && letterExists)){
            throw new InvalidPasswordException("Invalid Password");
        }
    }

    public static void validateExistence(User user) throws FileNotFoundException, AlreadyExistsException {
        File file = new File("src\\Logs\\users.txt");
        Scanner reader = new Scanner(file);
        while(reader.hasNext()){
            String[] data = reader.nextLine().split(" ");
            if (data[0].equals(user.getNickname())|| data[1]. equals(user.getEmail())){
                throw new AlreadyExistsException("This user already exists!");
            }
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile("^[^@]+@[^@]+\\.com$", Pattern.CASE_INSENSITIVE);
        if (!email.matches(String.valueOf(pattern))) {
            throw new InvalidEmailException("Invalid email");
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 12) {
            throw new InvalidAgeException("You are too young!");
        }
    }

    public static void validateUsername(String username) throws InvalidUsernameException {
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        boolean specialExists = matcher.find();

        if (specialExists) {
            throw new InvalidUsernameException("Invalid username");
        }
    }

    public static void validateName(String name, String surname) throws InvalidNameException {
        char[] name_ = name.toCharArray();
        char[] surname_ = surname.toCharArray();

        boolean nameDigitExists= false, surnameDigitExists = false;
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern.matcher(name);
        boolean nameSpecialExists = matcher1.find();
        Matcher matcher2 = pattern.matcher(surname);
        boolean surnameSpecialExists = matcher2.find();

        for (Character c: name_) {
            if (Character.isDigit(c)){
                nameDigitExists = true;
            }
        }

        for (Character c: surname_) {
            if (Character.isDigit(c)){
                surnameDigitExists = true;
            }
        }

        if (nameDigitExists || surnameDigitExists || nameSpecialExists || surnameSpecialExists || name.length() < 3 || surname.length() < 3) {
            throw new InvalidNameException("Invalid name");
        }
    }
}
