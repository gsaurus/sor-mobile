/* w - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Abadede extends main.AbstractObject {

    private static final int[] W = {5000, 10000, 12500};
    private static final int[] X = {10240, 11468, 12288};
    private static final int[] Y = {10240, 11468, 12288};
    private static final int[] Z = {21299, 9011, 9011};
    private static final int[] aa = {9011, 9011, 9011};
    private static final int[] ab = {11468, 11468, 11468};
    private static final int[] ac = {9011, 9011, 9011};
    private static final int[] ad = {24576, 24576, 24576};
    private static final int[] ae = {9011, 11059, 13107};
    private static final int[][] af = {{15, 30, 40}, {20, 20, 20}};
    private static final int[][] ag = {{15, 30, 40}, {15, 30, 40}};
    private static final int[][] ah = {{15, 20, 25}, {15, 20, 25}};
    private static final int[][][] ai
            = {{{35, 20, 5}, {15, 30, 20}, {10, 30, 30}},
            {{50, 20, 5}, {50, 30, 20}, {50, 30, 30}}};
    private static final int[][] aj = {{20, 30, 50}, {50, 50, 50}};
    private static final int[][] ak = {{70, 70, 70}, {70, 70, 70}};
    private int al;
    private int am;
    private boolean an;
    private int ao;
    private static final int[][] ap = {{800, 800, 800}, {800, 800, 800}};
    private static final int[][] aq
            = {{1500, 1500, 1500}, {1500, 1500, 1500}};
    private static final int[][] ar
            = {{1000, 1000, 1000}, {1000, 1000, 1000}};
    private static final int[][] as
            = {{1800, 1800, 1800}, {1800, 1800, 1800}};
    private static final int[][] at
            = {{2300, 2300, 2300}, {2300, 2300, 2300}};

    public Abadede(main.ObjectArt var_ad, int i, int posX, int posZ,
            int posY, int i_3_, int i_4_) {
        super(9, i, posX, posZ, posY, i_3_, i_4_);
        this.stateFlags |= 0x8201;
        this.r = new main.eExtendsAr(0, var_ad, 22);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(65536,
                                32768,
                                131072));
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.K = new main.Point(this.position.x, this.position.z, this.position.y);
        this.O = 0;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "WRESTLER";
    }

    public final void setState(int i) {
        int i_6_ = i;
        main.AbstractObject target = getPlayerTarget();
        this.state = i_6_;
        this.w();
        this.an = false;
        this.g.set(0, 0, this.g.y);
        switch (i_6_) {
            case 3:
                this.g.set(0, 0, this.g.y);
                this.velocityX = this.Q();
                this.velocityZ = this.R();
                this.c(1);
                break;
            case 4:
                this.c(0);
                break;
            case 5:
                this.d(15);
                break;
            case 14:
                this.n = 32;
                this.d(13);
                break;
            case 12:
                this.d(7);
                break;
            case 13:
                this.d(8);
                break;
            case 15:
                switch (this.y) {
                    default:
                        this.d(5);
                        break;
                    case 2:
                        this.F();
                        this.c(9);
                }
                break;
            case 43:
                if (this.grabbedObject == null) {
                    this.setState(3);
                } else {
                    this.a(true, 122880);
                    this.c(17);
                }
                break;
            case 44:
                this.grabbedObject.onAttackContact(this, this.A, 7, this.direction, this.P());
                this.x = 6;
                this.c(18);
                break;
            case 20:
                this.d(6);
                break;
            case 19:
                this.d(12);
                break;
            case 16:
                this.d(16);
                break;
            case 17:
                this.d(11);
                break;
            case 18:
                this.E();
                this.c(10);
                break;
            case 22:
                this.d(21);
                break;
            case 7:
                main.AbstractObject.i(this);
                this.c(0);
                break;
            case 8:
                main.AbstractObject.h(this);
                this.c(0);
                break;
            case 9:
                main.AbstractObject.g(this);
                this.c(0);
                break;
            case 10:
                main.AbstractObject.f(this);
                this.c(0);
                break;
            case 11:
                main.AbstractObject.e(this);
                this.c(0);
                break;
            case 24:
                this.direction = this.getDirectionTowardObject(target);
                this.velocityX = this.Q();
                this.velocityZ = this.R();
                i_6_ = ((i_6_ = 5 + main.GameManager.getRandomNumber(45) << 12)
                        * (main.GameManager.getRandomNumber(2) == 0 ? 1 : -1));
                this.targetPosition.y = target.position.z + i_6_;
                this.D();
                this.c(0);
                break;
            case 25:
                this.velocityX = this.Q();
                this.velocityZ = this.R();
                this.targetPosition.y = target.position.z + 122880 * (this.position.z < target.position.z ? -1 : 1);
                this.D();
                this.c(0);
                break;
            case 33:
                if (this.getDirectionTowardObject(target) == 0) {
                    this.direction = 0;
                    this.targetPosition.x = target.position.x + 204800;
                } else {
                    this.direction = 1;
                    this.targetPosition.x = target.position.x - 204800;
                }
                this.velocityX = this.Q();
                this.targetPosition.y = target.position.z;
                this.velocityZ = this.R();
                this.c(19);
                break;
            case 37:
                this.direction = this.getDirectionTowardObject(target);
                this.x = 2;
                this.c(2);
                break;
            case 28:
                this.ao = 0;
                if (this.getDirectionTowardObject(target) == 0) {
                    this.direction = 1;
                    this.targetPosition.x = target.position.x - 614400;
                    this.velocityX = -this.Q();
                } else {
                    this.direction = 0;
                    this.targetPosition.x = target.position.x + 614400;
                    this.velocityX = this.Q();
                }
                this.targetPosition.y = target.position.z;
                this.velocityZ = (int) (((long) target.position.z - (long) this.position.z << 12)
                        / (java.lang.Math.abs(((long) target.position.x - (long) this.position.x
                                << 12) / (long) this.velocityX)));
                if (this.R()
                        < java.lang.Math.abs(this.velocityZ)) {
                    i_6_ = 1;
                    if (this.velocityZ < 0) {
                        i_6_ = -1;
                    }
                    this.velocityZ = this.R() * i_6_;
                }
                this.c(19);
                break;
            case 29:
            case 34:
                this.direction = this.getDirectionTowardObject(target);
                this.g.x = this.velocityX;
                this.velocityX = -this.velocityX / 10;
                this.g.z = this.velocityZ;
                this.velocityZ = -this.velocityZ / 10;
                this.u = 6;
                this.c(3);
                break;
            case 30:
                this.ao++;
                this.direction = this.getDirectionTowardObject(target);
                this.velocityX = this.Q() * (this.direction == 0 ? 1 : -1);
                this.targetPosition.y = target.position.z;
                this.velocityZ = (int) (((long) target.position.z - (long) this.position.z << 12)
                        / (java.lang.Math.abs(((long) target.position.x - (long) this.position.x
                                << 12) / (long) this.velocityX)));
                if (this.R()
                        < java.lang.Math.abs(this.velocityZ)) {
                    i_6_ = 1;
                    if (this.velocityZ < 0) {
                        i_6_ = -1;
                    }
                    this.velocityZ = this.R() * i_6_;
                }
                this.c(19);
                break;
            case 31:
                this.velocityX = this.Q() * (this.getDirectionTowardObject(target) == 0 ? 1 : -1);
                this.c(19);
                break;
            case 39:
                this.x = 2;
                this.c(20);
                break;
            case 32:
                this.u = 23;
                this.c(2);
                break;
            case 38:
                this.direction = this.getDirectionTowardObject(target);
                this.x = 2;
                this.c(20);
                break;
            case 23:
                this.nextFrameToMove = main.GameManager.getRandomNumber(15) + 15;
                this.c(1);
                break;
            case 26:
                this.al
                        = target.position.x + 204800 * (this.getDirectionTowardObject(target) == 0 ? -1 : 1);
                this.am
                        = target.position.z + (25 - main.GameManager.getRandomNumber(50) << 12);
                this.c(0);
                break;
            case 35:
                this.velocityX = this.Q();
                this.velocityZ = this.R();
                this.c(0);
                break;
            case 40:
            case 41:
                this.x = 1;
                this.c(4);
                break;
            case 42:
                this.x = 2;
                this.c(3);
                break;
            case 36:
                this.velocityX = this.Q();
                this.velocityZ = this.R();
                this.c(0);
                break;
            case 27:
                this.targetPosition.x
                        = target.position.x + 245760 * (this.getDirectionTowardObject(target) == 0 ? -1 : 1);
                this.targetPosition.y = (main.GameManager.getRandomNumber(2) == 0
                        ? target.position.z + 20480 : target.position.z - 20480);
                if ((this.Q & 0x3) == 0) {
                    this.direction = this.getDirectionTowardObject(target);
                }
                this.velocityX = this.Q();
                this.velocityZ = this.R();
                this.c(0);
                break;
        }
        this.h();
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        int i = 0;
        int i_8_ = 0;
        if (target == null) {
            if (!this.j()) {
                this.q = 10;
            }
        } else {
            i = this.getDistanceX(target);
            i_8_ = this.getDistanceZ(target);
        }
        this.D = false;
        if (43 <= this.state && this.state <= 44) {
            if (this.grabbedObject == null) {
                this.setState(3);
                this.q = 4;
            }
        } else {
            this.releaseGrabbedObj();
        }
        if (this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        main.AbstractObject.j(this);
        if (5 < this.state && this.state <= 22) {
            this.a(this.state, V, target);
        } else {
            main.AbstractObject var_af_10_ = target;
            int i_11_ = i;
            int i_12_ = i_8_;
            i_8_ = i_11_;
            main.AbstractObject var_af_13_ = var_af_10_;
            int i_15_ = main.GameManager.getRandomNumber(100);
            switch (this.state) {
                case 0:
                    this.setState(3);
                /* fall through */
                case 3:
                    this.A = 0;
                    this.B = 0;
                    if (this.q > 0) {
                        this.q--;
                    } else if (var_af_13_ != null) {
                        this.setState(24);
                    } else {
                        this.q = 10;
                    }
                    break;
                case 4:
                    this.A = 0;
                    this.B = 0;
                    break;
                case 5:
                    if (this.loopMovement) {
                        if (327680 < i_8_ && 61440 < i_12_
                                && this.j(0) > i_15_) {
                            this.setState(37);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 44:
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 43:
                    this.b(true, 122880);
                    if (this.currAnimFrame > 8) {
                        this.grabbedObject.p = 16;
                        this.setState(44);
                    }
                    break;
                case 24:
                    this.targetPosition.x
                            = var_af_13_.position.x + 163840 * (this.getDirectionTowardObject(var_af_13_) == 0
                            ? -1 : 1);
                    main.AbstractObject.moveToTarget(this, target);
                    if (327680 > i_8_ && 40960 > i_12_ && this.j(0) > i_15_) {
                        this.setState(37);
                    } else if (450560 < i_8_ && 40960 >= i_12_
                            && this.j(1) > i_15_) {
                        this.setState(31);
                    } else if (163840 > i_8_ && 20480 <= i_12_ && i_8_ <= 204800) {
                        this.setState(26);
                    } else if (this.currAnimFrame % 24 == 0) {
                        this.setState(23);
                    }
                    break;
                case 37:
                    if (7 == this.currAnimFrame) {
                        if (this.position.x < var_af_13_.position.x) {
                            this.g.x = this.Q();
                        } else {
                            this.g.x = -this.Q();
                        }
                    }
                    if (15 == this.currAnimFrame) {
                        this.g.x = 0;
                        main.GameManager.e();
                    }
                    if (15 < this.currAnimFrame) {
                        this.d(5 - main.GameManager.getRandomNumber(10), 0, 0);
                        this.d(25 - main.GameManager.getRandomNumber(10), 0, 0);
                        this.d(-15 - main.GameManager.getRandomNumber(10), 0, 0);
                    }
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 28:
                case 33:
                    this.position.x += this.velocityX;
                    this.position.z += this.velocityZ;
                    if (this.e(40960, 409600)) {
                        this.setState(++this.state);
                    }
                    this.R = 3;
                    break;
                case 29:
                case 34:
                    this.g.x += this.velocityX;
                    this.g.z += this.velocityZ;
                    this.d(0, 0, 0);
                    this.u = 6;
                    if (10 < this.currAnimFrame) {
                        this.setState(this.state == 29 ? 3 > this.ao ? 30 : 32
                                : 37);
                    }
                    this.R = 2;
                    break;
                case 30:
                    this.position.x += this.velocityX;
                    this.position.z += this.velocityZ;
                    if (this.direction == this.getDirectionTowardObject(var_af_13_) && 286720 > i_8_
                            && 40960 > i_12_) {
                        this.setState(38);
                    } else if (this.direction != this.getDirectionTowardObject(var_af_13_)
                            && 204800 < i_8_) {
                        this.setState(29);
                    } else {
                        this.R = 7;
                    }
                    break;
                case 32:
                    this.u = 23;
                    if (30 < this.currAnimFrame) {
                        this.setState(3);
                    }
                    break;
                case 38:
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 31:
                    this.position.x += this.velocityX;
                    this.d(0, 0, 0);
                    if (286720 > i_8_ && 40960 > i_12_) {
                        this.setState(39);
                    } else {
                        this.R = 7;
                    }
                    break;
                case 39:
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 23:
                    if (this.nextFrameToMove < this.currAnimFrame) {
                        if (this.j(0) > i_15_) {
                            this.setState(35);
                        } else if (this.j(1) > i_15_) {
                            this.setState(36);
                        } else if (this.j(2) > i_15_) {
                            this.setState(28);
                        } else if (163840 > i_8_ && 20480 <= i_12_ && i_8_ <= 204800) {
                            this.setState(26);
                        } else {
                            this.setState(24);
                        }
                    }
                    break;
                case 26:
                    this.targetPosition.x = var_af_13_.position.x + this.al;
                    this.targetPosition.y = var_af_13_.position.z + this.am;
                    main.AbstractObject.moveToTarget(this, target);
                    if (32 < this.currAnimFrame) {
                        this.setState(23);
                    }
                    break;
                case 35:
                    if (this.getDirectionTowardObject(var_af_13_) == 0) {
                        this.targetPosition.x = var_af_13_.position.x - 204800;
                    } else {
                        this.targetPosition.x = var_af_13_.position.x + 204800;
                    }
                    this.targetPosition.y = var_af_13_.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(20480, 40960)) {
                        this.setState(40);
                    } else {
                        this.R = 7;
                    }
                    break;
                case 40:
                case 41:
                    if (this.loopMovement) {
                        if (this.j(0) > i_15_) {
                            this.setState(++this.state);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 42:
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 36:
                    if (this.getDirectionTowardObject(var_af_13_) == 0) {
                        this.targetPosition.x = var_af_13_.position.x - 122880;
                    } else {
                        this.targetPosition.x = var_af_13_.position.x + 122880;
                    }
                    this.targetPosition.y = var_af_13_.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(4096, 20480)) {
                        if ((var_af_13_ = this.enemyCheckGrabPlayer(131072, 20480)) != null) {
                            this.grabbedObject = var_af_13_;
                            this.setState(43);
                        } else {
                            this.q = 10;
                            this.setState(3);
                        }
                    } else {
                        this.R = 7;
                    }
                    break;
                case 27:
                    main.AbstractObject.moveToTarget(this, target);
                    if (32 < this.currAnimFrame) {
                        this.setState(23);
                    } else if (this.e(0, 0)) {
                        this.q = 32 - this.currAnimFrame;
                    }
                    break;
            }
        }
        super.i();
        this.h();
    }

    private int P() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_16_;
        switch (this.state) {
            default:
                return 1000;
            case 40:
            case 41:
                i_16_ = ap[i][this.difficultyAi];
                break;
            case 42:
                i_16_ = aq[i][this.difficultyAi];
                break;
            case 37:
                i_16_ = ar[i][this.difficultyAi];
                break;
            case 38:
            case 39:
                i_16_ = as[i][this.difficultyAi];
                break;
            case 44:
                i_16_ = at[i][this.difficultyAi];
        }
        return i_16_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        this.checkAttackObjects(P(), 0);
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_17_,
            int i_18_, int i_19_) {
        int i_20_;
        if ((i_20_ = this.onBeingAttacked(var_af, i, i_17_, i_18_, i_19_)) > 0) {
            this.setState(i_20_);
        }
    }

    public final void e() {
        if (this.N()) {
            this.y = 2;
            this.setState(15);
        }
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
    }

    public final void clearData() {
        this.clearAbstractData();
    }

    public final boolean d() {
        if (this.p > 0 || this.G) {
            return false;
        }
        switch (this.state) {
            case 15:
                if (this.y != 1) {
                    break;
                }
            /* fall through */
            case 3:
            case 4:
            case 9:
            case 10:
            case 11:
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 32:
            case 35:
            case 36:
                return true;
        }
        return false;
    }

    private int Q() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
            case 27:
            case 35:
            case 36:
                i = X[this.difficultyAi];
                break;
            case 25:
                i = Z[this.difficultyAi];
                break;
            case 33:
            case 37:
                i = ab[this.difficultyAi];
                break;
            case 28:
            case 30:
            case 31:
                i = ad[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int R() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a0()) {
            return 0;
        }
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
            case 27:
            case 35:
            case 36:
                i = Y[this.difficultyAi];
                break;
            case 25:
                i = aa[this.difficultyAi];
                break;
            case 33:
                i = ac[this.difficultyAi];
                break;
            case 28:
            case 30:
                i = ae[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int j(int i) {
        int i_21_ = 0;
        int i_22_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        switch (this.state) {
            case 0:
                break;
            case 5:
                i_21_ = ak[i_22_][this.difficultyAi];
                break;
            case 24:
                switch (i) {
                    case 0:
                        i_21_ = af[i_22_][this.difficultyAi];
                        break;
                    case 1:
                        i_21_ = ah[i_22_][this.difficultyAi];
                }
                break;
            case 23:
                switch (i) {
                    case 0:
                        i_21_ = ai[i_22_][this.difficultyAi][0];
                        break;
                    case 1:
                        i_21_ = ai[i_22_][this.difficultyAi][0] + aj[i_22_][this.difficultyAi];
                        break;
                    case 2:
                        i_21_ = (ai[i_22_][this.difficultyAi][0] + aj[i_22_][this.difficultyAi]
                                + ag[i_22_][this.difficultyAi]);
                }
                break;
            case 40:
            case 41:
                i_21_ = ai[i_22_][this.difficultyAi][this.state - 40];
                break;
        }
        return i_21_;
    }
}
