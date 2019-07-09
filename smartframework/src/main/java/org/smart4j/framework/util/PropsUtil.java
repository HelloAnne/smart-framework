package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " is not found.");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure.", e);
                }
            }
        }
        return props;

    }

    public static String getString(Properties props, String key, String defaultValue) {
        return defaultValue;
    }

    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    public static int getInt(Properties props, String key, int defaultValue) {
        return defaultValue;
    }

    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        return defaultValue;
    }

    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

}
