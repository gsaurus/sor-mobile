/* ae - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

final class SpritePieceBounds extends main.SpritePiece {

    private short srcX;
    private short srcY;
    private short width;
    private short height;

    public SpritePieceBounds(main.SpritePiecesGroup var_l) {
        super(var_l);
    }

    public final void readFromInputStream(java.io.DataInputStream datainputstream) {
        try {
            super.readFromInputStream(datainputstream);
            this.srcX = datainputstream.readShort();
            this.srcY = datainputstream.readShort();
            this.width = datainputstream.readShort();
            this.height = datainputstream.readShort();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final void draw(int destX, int destY) {
        main.MainCanvas.drawRegion(
                main.ObjectArt.screenGraphics, this.originalObjectArt.objectArt.a(this.pieceId), destX, destY, this.srcX, this.srcY, this.width, this.height, this.rotation
        );
    }
}
