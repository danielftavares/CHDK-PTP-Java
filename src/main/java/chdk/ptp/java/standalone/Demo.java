package chdk.ptp.java.standalone;

import chdk.ptp.java.Camera;

/**
 * Displays a panel with live view from camera.
 */
public class Demo {

    private static Camera cam;
    private static short canonVendor = 0x04a9;

    /**
     * Runs the demo.
     */
    public static void main() {
        cam = null;
        try {
            short someCanonCamera = 0x325a;
            short canonSX50 = 0x3259;
            cam = new Camera(canonVendor, canonSX50);
            cam.executeLuaScript("switch_mode_usb(1)");

            BufferedImagePannel d = null;
            while (true) {
                if (d == null)
                    d = new BufferedImagePannel(cam.getView());
                else
                    d.setImage(cam.getView());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            cam.disconnect();
        }
    }
}