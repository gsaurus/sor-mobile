/* ag - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

class SpritePiece {

    public main.SpritePiecesGroup originalObjectArt;
    public byte pieceId;
    public byte rotation;

    public SpritePiece(main.SpritePiecesGroup var_l) {
        this.originalObjectArt = var_l;
        this.pieceId = (byte) -1;
    }

    public void readFromInputStream(java.io.DataInputStream datainputstream) {
        try {
            this.rotation = datainputstream.readByte();
            this.pieceId = datainputstream.readByte();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void draw(int i, int i_0_) {
        /* empty */
    }
}
