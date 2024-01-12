package com.assignment.notes.model;

import com.assignment.notes.entities.Users;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class UserPatcher {

    public void updateUser(Users existingUser, Users newUser) throws IllegalAccessException {
        Class<?> userClass = Users.class;
        System.out.println("----------------ALL GOOD 1---------------------");
        Field[] userFields = userClass.getDeclaredFields();
        System.out.println("----------------ALL GOOD 2---------------------");
        for(Field field:userFields){
            if(field.getName().equals("Id"))
                continue;
            field.setAccessible(true);
            System.out.println("----------------ALL GOOD 3---------------------");
            Object value = field.get(newUser);
            System.out.println(field.getName()+" "+value);
            System.out.println("----------------ALL GOOD 4---------------------");
            if(value!=null){
                field.set(existingUser,value);
                System.out.println("----------------ALL GOOD 5---------------------");
            }
            field.setAccessible(false);
            System.out.println("----------------ALL GOOD 6---------------------");

        }

    }
}
