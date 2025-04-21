package extra;

/* d - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
public final class IntArray // IntArray
{

    int[] data;

    public IntArray(int capacity) {
        this.data = new int[capacity];
    }

    public final int length() {
        return this.data.length;
    }

    public final int get(int i) {
        return this.data[i];
    }

    public final void set(int index, int value) {
        this.data[index] = value;
    }
}
