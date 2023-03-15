package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return this.findValuesFromClass(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return this.findValuesFromClass(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }

    private BigDecimal findValuesFromClass(Object object, Class annotation){

        if (!isThereAnnotation(object)){
            return BigDecimal.ZERO;
        }

        BigDecimal soma = BigDecimal.ZERO;
        Method[] methods = object.getClass().getDeclaredMethods();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields){
            try{
                if (field.getType().equals(BigDecimal.class) && field.getDeclaredAnnotation(annotation) != null){
                    for( Method method : methods){
                        if (method.getName().toUpperCase().equals("GET"+field.getName().toUpperCase())){
                            soma = soma.add((BigDecimal) method.invoke(object));
                        }
                    }
                }else{
                    soma = soma.add(BigDecimal.ZERO);
                }
            }catch (IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }
        return soma;
    }
    private boolean isThereAnnotation(Object object){
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields){
            if (field.getDeclaredAnnotations().length > 0){
                return true;
            }
        }
        return false;
    }
}
