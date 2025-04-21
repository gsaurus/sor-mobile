package extra;

/* c - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.io.InputStream;

import javax.microedition.lcdui.Image;

public final class ImageData // ImageData
{

    private Image image = null;
    private IntArray imagePalette;
    private byte[] imageBytes;
    private int d;
    private int e;
    private int f;
    private boolean needRecreateImage;

    private ImageData() {
        /* empty */
    }

    public final IntArray getPalette() {
        return imagePalette;
    }

    public final Image getImage() {
        if (needRecreateImage) {
            int i = extra.ImageBuildHelper.interpolateBytes(this.imageBytes, this.d - 4, this.f * 3 + 4);
            this.imageBytes[this.e]     = (byte) (i >>> 24);
            this.imageBytes[this.e + 1] = (byte) (i >> 16);
            this.imageBytes[this.e + 2] = (byte) (i >> 8);
            this.imageBytes[this.e + 3] = (byte) i;
            this.image = null;
            this.image = Image.createImage(this.imageBytes, 0, this.imageBytes.length);
            this.needRecreateImage = false;
            System.gc();
        }
        return image;
    }

    public static ImageData createFromInputStream(InputStream inputstream) {
        byte[] imageBytesFromStream = null;
        try {
            imageBytesFromStream = new byte[inputstream.available()];
            inputstream.read(imageBytesFromStream);
            inputstream.close();
        } catch (Exception exception) {
            /* empty */
        }
        ImageData out;
        (out = new ImageData()).imageBytes = imageBytesFromStream;
        int i = 0;
        int byteIndex;
        for (byteIndex = 8;
                (out.imageBytes[byteIndex + 4] != 80 || out.imageBytes[byteIndex + 5] != 76
                || out.imageBytes[byteIndex + 6] != 84 || out.imageBytes[byteIndex + 7] != 69);
                byteIndex += i + 8 + 4) {
            i = out.pixelValue(byteIndex);
        }
        i = out.pixelValue(byteIndex);
        out.f = i / 3;
        out.d = byteIndex + 8;
        out.e = byteIndex + 8 + i;
        out.imagePalette = new IntArray(out.f);
        byteIndex = 0;
        i = out.d;
        while (byteIndex < out.f) {
            int pixelValue = ((out.imageBytes[i] & 0xff) << 16
                    | (out.imageBytes[i + 1] & 0xff) << 8
                    | out.imageBytes[i + 2] & 0xff);
            out.imagePalette.data[byteIndex] = pixelValue;
            byteIndex++;
            i += 3;
        }
        out.image = Image.createImage(out.imageBytes, 0, out.imageBytes.length);
        return out;
    }

    private int pixelValue(int i) {
        return ((imageBytes[i] & 0xff) << 24 | (imageBytes[i + 1] & 0xff) << 16
                | (imageBytes[i + 2] & 0xff) << 8 | imageBytes[i + 3] & 0xff);
    }

    public final void setPaletteData(IntArray palette) {
        imagePalette = palette;
        int i = 0;
        int byteIndex = d;
        while (i < palette.data.length) {
            imageBytes[byteIndex]     = (byte) (palette.data[i] >> 16); // r
            imageBytes[byteIndex + 1] = (byte) (palette.data[i] >> 8);  // g
            imageBytes[byteIndex + 2] = (byte) palette.data[i];         // b
            i++;
            byteIndex += 3;
        }
        needRecreateImage = true;
    }
}
