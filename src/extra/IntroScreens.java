package extra;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class IntroScreens // IntroScreens
{

    private static boolean a;
    private static boolean b;
    //private static final boolean c = false; // Unused field
    private static final int[] d = {01};
    private static Image[] introImages;
    private static final String[] introImageNames = {"/standard/bbx.png", "/standard/cp.png"};
    private static int g;
    private static int h;
    private static int state;
    private static long j;
    private static long k;
    private static long l;

    public static void activateA() {
        a = true;
    }

    public static void activateB() {
        b = true;
    }

    public static int updateState() {
        if ((l = (k = System.currentTimeMillis()) - j) > 100L) {
            l = 100L;
        }
        int m = 0;
        switch (state) {
            case 0:
                introImages = new Image[introImageNames.length];
                g = 0;
                state = 1;
                h = 0;
                break;
            case 1:
                if (g < introImages.length) {
                    try {
                        introImages[g] = Image.createImage(introImageNames[g]);
                    } catch (IOException localIOException2) {
                        localIOException2.printStackTrace();
                    }
                    g += 1;
                } else {
                    state = 2;
                }
                break;
            case 2:
                if (a) {
                    state = 4;
                    m = 1;
                } else if (b) {
                    state = 4;
                    m = 2;
                }
                break;
            case 4:
                if ((h = (int) (h + l)) > 4000) {
                    for (int n = 0; n < introImages.length; n++) {
                        introImages[n] = null;
                    }
                    introImages = null;
                    m = 3;
                    state = 0;
                }
                break;
            case 5:
                if (a) {
                    state = 0;
                    m = 4;
                }
                break;
        }
        j = k;
        a = false;
        b = false;
        return m;
    }

    public static void draw(Graphics paramGraphics, int width, int height) {
        paramGraphics.setColor(16777215);
        paramGraphics.fillRect(0, 0, width, height);
        switch (state) {
            case 0:
            case 2:
                paramGraphics.setColor(0);
                paramGraphics.drawString("Yes", 1, height - 1, 36);
                paramGraphics.drawString("No", width - 1, height - 1, 40);
            case 1:
                paramGraphics.setColor(0);
                paramGraphics.drawString("Sound On?", width / 2, height / 2 + 20, 17);
                width = (width >> 1) - 32;
                height = (height >> 1) - 48;
                paramGraphics.setColor(5263440);
                paramGraphics.fillRoundRect(width - 1, height - 1, 66, 66, 16, 16);
                paramGraphics.setColor(16777215);
                paramGraphics.fillRoundRect(width, height, 64, 64, 16, 16);
                paramGraphics.setColor(22708);
                paramGraphics.fillRoundRect(width + 2, height + 2, 60, 60, 16, 16);
                paramGraphics.setColor(5263440);
                height += 2;
                paramGraphics.fillArc(width + 12, height + 36, 16, 16, 0, 360);
                paramGraphics.fillArc(width + 36, height + 32, 16, 16, 0, 360);
                paramGraphics.drawLine(width + 12 + 8, height + 36 + 8, width + 12 + 16, height + 36 + 8);
                paramGraphics.drawLine(width + 36 + 8, height + 32 + 8, width + 36 + 16, height + 32 + 8);
                paramGraphics.fillRect(width + 24, height + 12, 4, 34);
                paramGraphics.fillRect(width + 24, height + 12, 24, 4);
                paramGraphics.fillRect(width + 48, height + 12, 4, 26);
                paramGraphics.setColor(16777215);
                width -= 2;
                height -= 2;
                paramGraphics.fillArc(width + 12, height + 36, 16, 16, 0, 360);
                paramGraphics.fillArc(width + 36, height + 32, 16, 16, 0, 360);
                paramGraphics.fillRect(width + 24, height + 12, 4, 34);
                paramGraphics.fillRect(width + 24, height + 12, 24, 4);
                paramGraphics.fillRect(width + 48, height + 12, 4, 26);
                return;
            case 4:
                if (h < 4000) {
                    paramGraphics.drawImage(introImages[d[(h / 2000)]], width / 2, height / 2, 3);
                    return;
                }
                break;
            case 5:
                paramGraphics.setColor(0);
                paramGraphics.drawString("Play on your phone", width / 2, height / 2, 17);
        }
    }
}



/* Location:           C:\Users\Ebrar\Hacking\sor\sor_mobile_hack\KEmulator_lite\BKM_n73.jar

 * Qualified Name:     a

 * JD-Core Version:    0.7.0.1

 */
