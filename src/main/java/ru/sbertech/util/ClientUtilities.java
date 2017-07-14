package ru.sbertech.util;

import java.util.logging.Logger;

/**
 * Created by Сергей on 08.07.2017.
 */
public class ClientUtilities {

    static Logger log = Logger.getLogger(ClientUtilities.class.getName());


    public static Integer stringToInteger(String s, String description) {
        Integer res = null;
        try {
            res = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            log.warning("Не числовое поле: " + description);
        }
        return res;
    }
}
