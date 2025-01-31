package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReflectiveChecker {
    public static List<String> checkProperties(Object obj, Predicate<Object> function) {
        List<String> errors = new ArrayList<>();
        try {
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (isGetter(method)) {
                    Object value = method.invoke(obj);
                    if (!function.test(value)) errors.add("Falta " + method.getName().substring(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errors;
    }

    public static Vehicle setProperties (Vehicle vehicle, VehicleDTO vehicleDTO, Predicate<Object> function) {
        try {
            Method[] methods = vehicleDTO.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (isGetter(method)) {
                    Object value = method.invoke(vehicleDTO);
                    if (function.test(value)) {
                        String setterName = method.getName().replaceFirst("get", "set");
                        Method setter = vehicle.getClass().getMethod(setterName, method.getReturnType());
                        setter.invoke(vehicle, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterCount() != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }
}
