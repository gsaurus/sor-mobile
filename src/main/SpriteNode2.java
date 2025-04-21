/* i - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

final class SpriteNode2 extends main.SpriteNodes2Abstract {

    private main.SpriteNode[] spriteNodes;
    private byte d;

    public final void load(java.io.DataInputStream datainputstream,
            main.SpritePiecesGroup piecesGroup, main.ObjectArt objArt) {
        try {
            super.load(datainputstream, piecesGroup, objArt);
            int numNodes = datainputstream.readByte();
            this.spriteNodes = new main.SpriteNode[numNodes];
            for (int i = 0; i < numNodes; i++) {
                switch (datainputstream.readByte()) {
                    case 3:
                        this.spriteNodes[i] = new main.SpriteNode(objArt);
                        break;
                    case 4:
                        this.spriteNodes[i] = new main.SpriteLeaf1(objArt);
                        break;
                    case 6:
                        this.spriteNodes[i] = new main.SpriteLeaf2(objArt);
                        break;
                }
                this.spriteNodes[i].load(datainputstream, piecesGroup);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final void applyOffset(int dx, int dy) {
        for (this.d = (byte) 0; this.d < this.spriteNodes.length; this.d++) {
            this.spriteNodes[this.d].applyOffset(dx, dy);
        }
    }

    public final void clearAllData() {
        for (this.d = (byte) 0; this.d < this.spriteNodes.length; this.d++) {
            this.spriteNodes[this.d].clearAllData();
            this.spriteNodes[this.d] = null;
        }
        this.spriteNodes = null;
    }

    public final boolean a(main.IntPair offset) {
        for (this.d = (byte) 0; this.d < this.spriteNodes.length; this.d++) {
            if (this.spriteNodes[this.d].a(offset)) {
                return true;
            }
        }
        return false;
    }
}
