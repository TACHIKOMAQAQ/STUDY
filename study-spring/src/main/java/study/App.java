package study;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author cyq
 * @date 2020-06-02
 */
public class App {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println(beanFactory.isSingleton("user1"));
//        User user = beanFactory.getBean("user1");
//        user.say();
    }
}
