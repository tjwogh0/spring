package com.springbook.ioc.injection;
import java.util.Properties;

public class CollectionBean {
    private Properties addressList;
    public void setAddressList(Properties mappings){
        this.addressList = mappings;
    }
    public Properties getAddressList(){
        return addressList;
    }
}
