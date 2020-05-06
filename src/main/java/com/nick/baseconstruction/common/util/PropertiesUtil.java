package com.nick.baseconstruction.common.util;

import com.nick.baseconstruction.common.constants.AttrConstants;
import com.nick.baseconstruction.common.constants.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties pro = new Properties();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public PropertiesUtil(){

    }

    public String getProperties(String propertiesName,String properties){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesName);
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            return ErrorCode.ERROR_CODE;
        }
        return pro.getProperty(properties, AttrConstants.PROPERTY_NO_ANSWER);
    }
}
