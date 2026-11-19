package org.hotl.genericsreflectionpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
@SpringBootApplication
public class GenericsReflectionPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericsReflectionPracticeApplication.class, args);
    }


    @Bean
    public CommandLineRunner reflectionTesting(FirstTaskClass targetObject){
        return args -> {
            log.info("Testing reflection");
            log.info("Initial value: {}", targetObject.getSomething());

            try{
                Field field = FirstTaskClass.class.getDeclaredField("something");
                field.setAccessible(true);
                field.set(targetObject, "changed viw private Field");

                String updatedValue = (String) field.get(targetObject);
                log.info("Value after Reflection by Field: {}", updatedValue);


            }catch (NoSuchFieldException | IllegalAccessException e){
                log.error(e.getStackTrace().toString());
                new RuntimeException(e);
            }

            Method[] methods = FirstTaskClass.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("setSomething")) {
                    method.setAccessible(true);
                    String secret = (String) method.invoke(targetObject, "changed via private Method");
                    log.info("Value after Reflection by Method: {}", secret);

                }
            }

        };
    }



}
