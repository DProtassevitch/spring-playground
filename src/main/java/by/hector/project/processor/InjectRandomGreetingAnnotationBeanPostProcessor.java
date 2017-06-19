package by.hector.project.processor;

import by.hector.project.annotation.InjectRandomGreeting;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author i.sukach
 */
public class InjectRandomGreetingAnnotationBeanPostProcessor implements BeanPostProcessor {

    public List<String> greetingString = new ArrayList<String>();
    String eng = greetingString.set(1, "Hello");
    String bel = greetingString.set(2, "Прывiтанне");
    String rus = greetingString.set(3, "Привет");

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(InjectRandomGreeting.class)) {
                Random random = new Random();
//                InjectRandomGreeting annotation = declaredField.getAnnotation(InjectRandomGreeting.class);


                int randomString = random.nextInt(greetingString.size());
                String randomGreetingString = greetingString.get(randomString);
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, randomGreetingString);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
