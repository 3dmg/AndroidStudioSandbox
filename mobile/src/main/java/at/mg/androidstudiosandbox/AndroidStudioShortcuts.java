package at.mg.androidstudiosandbox;

import android.text.TextUtils;

/**
 * Created by Markus on 26.09.2014.
 * <p/>
 * list of key shortcuts and sandbox for AndroidStudio features
 * <p/>
 * <p/>
 * <p/>
 * Common shortcuts:
 * <p/>
 * SmartType Ctrl + Shift + Space
 * to insert possible values
 * <p/>
 * Alt + Enter
 * for quick help
 * <p/>
 * <p/>
 * Shift + Mouseclick close an open tab when clicking on it
 * <p/>
 * <p/>
 * <p/>
 * Alt + Insert show a code generator
 */
@SuppressWarnings({"ResultOfMethodCallIgnored", "RedundantIfStatement", "UnusedAssignment"})
class AndroidStudioShortcuts {


    /**
     * rename with Shift + F6
     *
     * @param messages test
     * @return boolean
     */
    private boolean rename(String messages) {
        String mes;
        if (TextUtils.isEmpty(messages)) {
            return false;
        }

        //press Alt + Enter to create an int
        messages.charAt(1);

        //change to messages.concat("t") with Ctrl + Space and then Tab --> replace split
        messages.split("t");


        if (messages.equals("rename")) {
            return true;
        }

        return false;
    }

    /**
     * override methods with Ctrl + O
     *
     * @return string
     */
    @Override
    public String toString() {
        return "AndroidStudioShortcuts";
    }


}
