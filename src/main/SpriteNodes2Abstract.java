/* t - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

abstract class SpriteNodes2Abstract {

    public int index;
    public main.SpriteNodes2Abstract[] nodes;
    
    private byte auxNodesIterator;

    public void load(java.io.DataInputStream datainputstream, main.SpritePiecesGroup spritePiecesGroup, main.ObjectArt objArt) {
        try {
            this.index = datainputstream.readInt();
            byte totalNodes;
            if ((totalNodes = datainputstream.readByte()) > 0) {
                this.nodes = new main.SpriteNodes2Abstract[totalNodes];
                this.auxNodesIterator = (byte) 0;
                while (this.auxNodesIterator < totalNodes) {
                    switch (datainputstream.readByte()) {
                        case 0:
                            this.nodes[this.auxNodesIterator] = new main.SpriteNode2();
                        /* fall through */
                        default:
                            this.nodes[this.auxNodesIterator].load(datainputstream, spritePiecesGroup, objArt);
                            this.auxNodesIterator++;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public abstract void applyOffset(int i, int i_0_);

    public void clearAllData() {
        for (this.auxNodesIterator = (byte) 0; this.auxNodesIterator < this.nodes.length; this.auxNodesIterator++) {
            this.nodes[this.auxNodesIterator].clearAllData();
            this.nodes[this.auxNodesIterator] = null;
        }
        this.nodes = null;
    }

    public boolean a(main.IntPair var_an) {
        return false;
    }
}
