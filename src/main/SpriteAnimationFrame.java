/* y - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

final class SpriteAnimationFrame {

    public int frameDuration;
    private main.SpriteNodes2Abstract[] spriteNodes;
    private main.FrameData[] awArray;
    private byte d;

    public final void load(java.io.DataInputStream datainputstream, main.SpritePiecesGroup spritePiecesGroup, main.ObjectArt objArt) {
        try {
            this.frameDuration = datainputstream.readByte();
            byte numNodes = datainputstream.readByte();
            this.spriteNodes = new main.SpriteNodes2Abstract[numNodes];
            this.awArray = null;
            this.d = (byte) 0;
            while (this.d < numNodes) {
                switch (datainputstream.readByte()) {
                    case 0:
                        this.spriteNodes[this.d] = new main.SpriteNode2();
                    /* fall through */
                    default:
                        this.spriteNodes[this.d].load(datainputstream, spritePiecesGroup, objArt);
                        this.d++;
                }
            }
            numNodes = datainputstream.readByte();
            this.awArray = new main.FrameData[numNodes];
            for (this.d = (byte) 0; this.d < numNodes; this.d++) {
                this.awArray[this.d] = new main.FrameData();
                this.awArray[this.d].readFromInputStream(datainputstream);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final void applyOffset(int x, int y) {
        for (this.d = (byte) 0; this.d < this.spriteNodes.length; this.d++) {
            this.spriteNodes[this.d].applyOffset(x, y);
        }
    }

    public final void a() {
        for (this.d = (byte) 0; this.d < this.spriteNodes.length; this.d++) {
            this.spriteNodes[this.d].clearAllData();
            this.spriteNodes[this.d] = null;
        }
        this.spriteNodes = null;
        for (this.d = (byte) 0; this.d < this.awArray.length; this.d++) {
            this.awArray[this.d] = null;
        }
        this.awArray = null;
    }

    public final main.FrameData[] getFrameDataArray() {
        return this.awArray;
    }

    public final void a(int i, main.IntPair var_an) {
        for (this.d = (byte) 0; this.d < this.spriteNodes.length; this.d++) {
            if (this.spriteNodes[this.d].index == i) {
                this.spriteNodes[this.d].a(var_an);
                break;
            }
        }
    }
}
