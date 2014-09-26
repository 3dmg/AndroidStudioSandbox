package at.mg.androidstudiosandbox;

import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Markus on 26.09.2014.
 *
 * list of key shortcuts and sandbox for AndroidStudio features
 *
 *
 *
 * Common shortcuts:
 *
 * SmartType Ctrl + Shift + Space
 * to insert possible values
 *
 * Alt + Enter
 * for quick help
 *
 *
 * Shift + Mouseclick close an open tab when clicking on it
 *
 *
 *
 * Alt + Insert show a code generator
 */
class AndroidStudioShortcuts {


    /**
     * rename with Shift + F6
     *
     * @param messages
     * @return
     */
    private final boolean rename(String messages){
        String mes;
        if(TextUtils.isEmpty(messages)){
            return false;
        }

        //press Alt + Enter to create an int
        messages.charAt(1);

        //change to messages.concat("t") with Ctrl + Space and then Tab --> replace split
        messages.split("t");


        if(messages.equals("rename")){
            return true;
        }

        return false;
    }

    /**
     * override methods with Ctrl + O
     * @return
     */
    @Override
    public String toString() {
        return "AndroidStudioShortcuts";
    }


}
