package com.springbook.ioc.injection;
import java.util.Properties;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.springbook.ioc.injection.CollectionBean;

public class CollectionBeanClient {
    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("applicationContext.xml");
        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
        Properties addressList = bean.getAddressList();
        addressList.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        factory.close();
    }
}