/* a - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public class CollisionBox {

    main.Point position;
    main.Point size;
    main.Point lastCollisionAdjustment;

    public CollisionBox(main.Point position, main.Point size) {
        this.size = new main.Point(0, 0, 0);
        this.lastCollisionAdjustment = new main.Point(0, 0, 0);
        this.position = position; // store reference
        this.size.set(size);    // store copy of given size
    }

    public final void clearData() {
        this.position = null;
        this.size = null;
        this.lastCollisionAdjustment = null;
    }

    public final main.Point checkCollision(main.CollisionBox otherBox, boolean unusedArgument) {
        this.lastCollisionAdjustment.set(0, 0, 0);
        main.Point positionAdjustment = new main.Point(0, 0, 0);
        int dx = this.position.x - otherBox.position.x;
        int dz = this.position.z - otherBox.position.z;
        int minimumDistanceX = (this.size.x + otherBox.size.x) / 2;
        int minimumDistanceZ = (this.size.z + otherBox.size.z) / 2;
        boolean xIntersection = java.lang.Math.abs(dx) < minimumDistanceX;
        boolean zIntersection = java.lang.Math.abs(dz) < minimumDistanceZ;
        if (xIntersection && zIntersection) {
            // Intersected, compute position reajustment
            int dy = this.size.y - otherBox.position.y;
            if (dy >= 0 && dy <= 40960) {
                positionAdjustment.y = dy;
                return positionAdjustment;
            }
            if (dx >= 0) {
                positionAdjustment.x = minimumDistanceX - dx;
                if (positionAdjustment.x > 40960) {
                    positionAdjustment.x = 40960;
                }
            } else {
                positionAdjustment.x = -minimumDistanceX - dx;
                if (positionAdjustment.x < -40960) {
                    positionAdjustment.x = -40960;
                }
            }
            if (dz >= 0) {
                positionAdjustment.z = minimumDistanceZ - dz;
                if (positionAdjustment.z > 40960) {
                    positionAdjustment.z = 40960;
                }
            } else {
                positionAdjustment.z = -minimumDistanceZ - dz;
                if (positionAdjustment.z < -40960) {
                    positionAdjustment.z = -40960;
                }
            }
            // store only the component relative to the maximum adjustment value...
            if (java.lang.Math.abs(positionAdjustment.x) < java.lang.Math.abs(positionAdjustment.z)) {
                this.lastCollisionAdjustment.x = positionAdjustment.x;
            } else {
                this.lastCollisionAdjustment.z = positionAdjustment.z;
            }
            return positionAdjustment;
        }
        return null;
    }

    public CollisionBox() {
        /* empty */
    }
}
