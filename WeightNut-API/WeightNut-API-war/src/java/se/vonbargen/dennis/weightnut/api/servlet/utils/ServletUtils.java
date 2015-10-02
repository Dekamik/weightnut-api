/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.vonbargen.dennis.weightnut.api.servlet.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dennis
 */
public abstract class ServletUtils {
    
    public static String parseInputStream(InputStream stream) {
        try {
            return IOUtils.toString(stream);
        } catch (IOException ex) {
            Logger.getLogger(ServletUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static JSONObject parseJSON(String jsonStr) {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(jsonStr);
        } catch (ParseException ex) {
            Logger.getLogger(ServletUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static JSONObject parseStreamJSON(InputStream stream) {
        String str = parseInputStream(stream);
        if (str != null) {
            return parseJSON(str);
        }
        return null;
    }
}
