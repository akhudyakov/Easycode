package lesson10;

import hometask.collection.StoreHolidaysOnTreeMap;

import java.lang.reflect.Method;

/**
 * Created by Andrey on 10.02.2017.
 */
public class CheckAnnotation {

    public static void main(String[] args) {

        Class<StoreHolidaysOnTreeMap> storeHolidaysClass = StoreHolidaysOnTreeMap.class;

        for (Method method : storeHolidaysClass.getMethods()) {

            if (method.isAnnotationPresent(Author.class)) {
                System.out.println(method);
                System.out.println(method.getAnnotations().toString());

            }
        }


    }
}

