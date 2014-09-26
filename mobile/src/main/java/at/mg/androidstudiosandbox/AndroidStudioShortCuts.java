package at.mg.androidstudiosandbox;

import android.text.TextUtils;

/**
 * Created by Markus on 26.09.2014.
 *
 * list of key shortcuts and sandbox for AndroidStudio features
 *
 */
class AndroidStudioShortcuts {


    /**
     * rename with Shift + F6
     * @param messages
     * @return
     */
    private final boolean rename(String messages){
        if(TextUtils.isEmpty(messages)){
            return false;
        }

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
