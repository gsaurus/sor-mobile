/* z - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Onihime extends main.AbstractObject {

    private static final int[] W = {20000, 20000};
    private static final int[] X = {16793, 20480, 20480};
    private static final int[] Y = {16793, 8192, 8192};
    private static final int[] Z = {20480, 20480, 20480};
    private static final int[] aa = {9011, 9011, 9011};
    private static final int[] ab = {20480, 20480, 20480};
    private static final int[] ac = {9011, 9011, 9011};
    private static final int[] ad = {20480, 20480, 20480};
    private static final int[] ae = {2048, 9011, 9011};
    private static final int[] af = {24576, 20480, 20480};
    private static final int[] ag = {6144, 9011, 9011};
    private static final int[] ah = {16384, 20480, 20480};
    private static final int[] ai = {4096, 8192, 8192};
    private static final int[] aj = {61440, 61440, 61440};
    private static final int[] ak = {0, 9011, 9011};
    private static final int[] al = {20480, 20480, 20480};
    private static final int[][] am = {{30, 50}, {30, 50}};
    private static final int[][][] an = {
        { {25, 15}, {30, 30}, {20, 15} },
        { {35, 25}, {40, 40}, {30, 25} }
    };
    private static final int[] ao = {10, 60};
    private static final int[][] ap = {{50, 25}, {50, 25}};
    private static final int[][] aq = {{30, 50}, {30, 50}};
    private static final int[][] ar = {{35, 60}, {35, 60}};
    private static final int[][] as = {{50, 50, 50}, {50, 50, 50}};
    private static final int[] at = {4, 2};
    private static final int[] au = {44, 32};
    private static final int[] av = {21, 5};
    private static int aw = -1;
    private boolean ax;
    private boolean ay;
    private int az;
    private int aA;
    private int aB;
    private static final int[][] aC = {{2000, 2000, 2000}, {2000, 2000, 2000}};
    private static final int[][] aD = {{1200, 1200, 1200}, {1200, 1200, 1200}};
    private static final int[][] aE = {{500, 500, 500}, {1000, 1000, 1000}};
    private static final int[][] aF = {{2000, 2000, 2000}, {5000, 5000, 5000}};
    private static final int[][] aG = {{1400, 1400, 1400}, {1400, 1400, 1400}};
    private static final int[][] aH = {{900, 900, 900}, {900, 900, 900}};
    private static final int[][] aI = {{2500, 2500, 2500}, {2500, 2500, 2500}};

    public Onihime(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_, int i_5_) {
        super(i_5_ == 0 ? 2 : 1 == i_5_ ? 14 : 13, i, i_0_, i_1_, i_2_, i_3_,
                i_4_);
        if (i_5_ != 0) {
            this.stateFlags |= 0x8401;
            //this.c |= 0x8101; // Debug
            this.collisionBox
                    = (new main.CollisionBox(this.position, new main.Point(65536, 32768, 131072)));
            this.nextFrameToMove = 0;
            this.Q = 0;
            this.energy = W[this.difficultyAi];
            this.maxEnergy = this.energy;
            this.visualEnergy = main.GameManager.f(this.energy);
            if (1 == i_5_) {
                this.r = new main.eExtendsAr(0, var_ad, 43);
                this.name = "ONIHIME";
            } else {
                this.r = new main.eExtendsAr(0, var_ad, 43);
                this.name = "YAKSA";
            }
            if (aw < 0) {
                this.c(31);
                aw = this.r.a();
            }
        }
    }

    public final void setState(int i) {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            this.state = i;
            this.w();
            this.g.set(0, 0, 0);
            main.AbstractObject targetObj = getTarget();
            int i_6_ = main.GameManager.getRandomNumber(100);
            int i_7_ = 0;
            if (targetObj != null) {
                i_7_ = this.getDirectionTowardObject(targetObj);
            }
            main.Onihime var_z_8_ = this;
            main.AbstractObject var_af_9_ = targetObj;
            int i_10_ = this.state;
            int i_11_ = i_6_;
            int i_12_ = i_7_;
            int i_13_ = i_11_;
            i_7_ = i_10_;
            main.AbstractObject var_af_14_ = var_af_9_;
            main.Onihime var_z_15_ = var_z_8_;
            int i_16_ = main.GameManager.h + 655360;
            switch (i_7_) {
                case 23:
                    var_z_15_.c(0);
                    break;
                case 30:
                    var_z_15_.stateFlags &= ~INVINCIBILITY_FLAG;
                    var_z_15_.direction = 1;
                    var_z_15_.nextFrameToMove = 0;
                    var_z_15_.velocityX = var_z_15_.Q();
                    var_z_15_.c(33);
                    break;
                case 3:
                    var_z_15_.g.set(0, 0, 0);
                    var_z_15_.q = at[2 == main.GameManager.currentDifficulty ? 1 : 0];
                    var_z_15_.c(0);
                    break;
                case 4:
                    var_z_15_.c(1);
                    break;
                case 5:
                    var_z_15_.d(22);
                    break;
                case 14:
                    var_z_15_.n = 32;
                    var_z_15_.d(23);
                    break;
                case 12:
                    var_z_15_.d(14);
                    break;
                case 13:
                    var_z_15_.d(15);
                    break;
                case 15:
                    if (var_z_15_.y == 1) {
                        var_z_15_.d(17);
                    } else if (var_z_15_.y == 2) {
                        var_z_15_.F();
                        var_z_15_.c(19);
                    } else {
                        var_z_15_.d(26);
                    }
                    break;
                case 20:
                    var_z_15_.d(14);
                    break;
                case 16:
                    var_z_15_.d(27);
                    break;
                case 17:
                    var_z_15_.d(16);
                    break;
                case 18:
                    var_z_15_.E();
                    var_z_15_.c(36);
                    break;
                case 19:
                    var_z_15_.d(35);
                    break;
                case 24:
                    var_z_15_.nextFrameToMove = 15 + main.GameManager.getRandomNumber(15);
                    var_z_15_.c(29);
                    break;
                case 25:
                    var_z_15_.nextFrameToMove = main.GameManager.getRandomNumber(12) + 12;
                    var_z_15_.velocityX = var_z_15_.Q();
                    var_z_15_.velocityZ = var_z_15_.R();
                    var_z_15_.c(1);
                    break;
                case 28:
                    var_z_15_.targetPosition.x
                            = i_16_ + 102400 * (var_z_15_.position.x < i_16_ ? 1 : -1);
                    var_z_15_.velocityX = (var_z_15_.targetPosition.x - var_z_15_.position.x) / (aw - 2);
                    var_z_15_.c(31);
                    break;
                case 43:
                    var_z_15_.aB = 0;
                    var_z_15_.direction = i_12_;
                    var_z_15_.velocityX = (var_af_14_.position.x - var_z_15_.position.x) / 14;
                    var_z_15_.velocityZ = (var_af_14_.position.z - var_z_15_.position.z) / 14;
                    var_z_15_.nextFrameToMove = 0;
                    var_z_15_.stateFlags |= 0x100000;
                    var_z_15_.c(42);
                    break;
                case 51:
                    if (var_z_15_.grabbedObject == null) {
                        var_z_15_.setState(3);
                    } else {
                        var_z_15_.position.set(var_z_15_.grabbedObject.position.x, var_z_15_.grabbedObject.position.z,
                                var_z_15_.position.y);
                        var_z_15_.grabbedObject.direction = var_z_15_.direction ^ 0x1;
                        var_z_15_.G();
                        var_z_15_.grabbedObject.onAttackContact(var_z_15_, 0, 10, var_z_15_.direction,
                                var_z_15_.P());
                        var_z_15_.c(12);
                        main.Onihime.playSound(45);
                    }
                    break;
                case 58:
                    var_z_15_.aB = 0;
                    var_z_15_.x = 7;
                    var_z_15_.grabbedObject.onAttackContact(var_z_15_, var_z_15_.A, 7, var_z_15_.direction,
                            var_z_15_.P());
                    var_z_15_.grabbedObject.p = 16;
                    var_z_15_.c(10);
                    main.Onihime.playSound(46);
                    break;
                case 56:
                    var_z_15_.aB = 0;
                    if (var_z_15_.grabbedObject == null) {
                        var_z_15_.setState(3);
                    } else {
                        var_z_15_.grabbedObject.position.set(var_z_15_.position.x, var_z_15_.position.z,
                                var_z_15_.position.y);
                        var_z_15_.grabbedObject.direction = var_z_15_.direction;
                        var_z_15_.G();
                        var_z_15_.grabbedObject.onAttackContact(var_z_15_, 0, 9, var_z_15_.direction, var_z_15_.P());
                        var_z_15_.c(8);
                        main.Onihime.playSound(46);
                    }
                    break;
                case 31:
                    var_z_15_.velocityX = ah[var_z_15_.difficultyAi];
                    var_z_15_.velocityZ = ai[var_z_15_.difficultyAi];
                    var_z_15_.c(1);
                    break;
                case 39:
                    var_z_15_.aB = 0;
                    var_z_15_.direction = i_12_;
                    var_z_15_.g.x = var_z_15_.Q() * (var_z_15_.direction == 0 ? 1 : -1);
                    var_z_15_.g.z = var_z_15_.R() * (var_z_15_.position.z < var_af_14_.position.z
                            ? 1 : -1);
                    var_z_15_.x = 2;
                    var_z_15_.c(32);
                    break;
                case 26:
                    if (var_z_15_.objectType == 14) {
                        var_z_15_.direction = i_12_;
                        var_z_15_.velocityX = (var_af_14_.position.x - var_z_15_.position.x) / 11;
                        if (var_z_15_.Q()
                                < java.lang.Math.abs(var_z_15_.velocityX)) {
                            var_z_15_.velocityX
                                    = var_z_15_.Q() * (var_z_15_.velocityX >= 0 ? 1 : -1);
                        }
                        var_z_15_.velocityZ = (var_af_14_.position.z - var_z_15_.position.z) / 11;
                        if (var_z_15_.R()
                                < java.lang.Math.abs(var_z_15_.velocityZ)) {
                            var_z_15_.velocityZ
                                    = var_z_15_.R() * (var_z_15_.velocityZ >= 0 ? 1 : -1);
                        }
                        var_z_15_.c(34);
                    } else if (var_z_15_.objectType == 13) {
                        var_z_15_.direction = i_12_;
                        var_z_15_.targetPosition.x
                                = var_af_14_.position.x + 122880 * (i_12_ == 0 ? -1 : 1);
                        var_z_15_.targetPosition.y = var_af_14_.position.z;
                        var_z_15_.velocityX = (var_z_15_.targetPosition.x - var_z_15_.position.x) / 14;
                        var_z_15_.velocityZ = (var_z_15_.targetPosition.y - var_z_15_.position.z) / 14;
                        var_z_15_.c(31);
                    }
                    break;
                case 27:
                    if (var_z_15_.objectType == 13 || !var_z_15_.ax) {
                        var_z_15_.direction = i_12_;
                    }
                    var_z_15_.ax = false;
                    var_z_15_.g.x = var_z_15_.Q() * (i_12_ == 0 ? -1 : 1);
                    var_z_15_.g.z = ((var_z_15_.R() + (var_z_15_.ay ? 20480 : 0))
                            * (var_z_15_.position.z < var_af_14_.position.z ? 1 : -1));
                    var_z_15_.c(33);
                    break;
                case 29:
                    var_z_15_.targetPosition.x
                            = var_af_14_.position.x + 532480 * (i_12_ == 0 ? -1 : 1);
                    var_z_15_.targetPosition.y = var_af_14_.position.z;
                    var_z_15_.velocityX = (var_z_15_.targetPosition.x - var_z_15_.position.x) / 14;
                    var_z_15_.velocityZ = (var_z_15_.targetPosition.y - var_z_15_.position.z) / 14;
                    var_z_15_.c(31);
                    break;
                case 32:
                    var_z_15_.aB = 0;
                    var_z_15_.velocityX = var_z_15_.Q() * (i_12_ == 0 ? 1 : -1);
                    var_z_15_.velocityZ = 0;
                    var_z_15_.direction = i_12_;
                    var_z_15_.x = 2;
                    var_z_15_.c(7);
                    break;
                case 37:
                    var_z_15_.x = 1;
                    var_z_15_.c(3);
                    break;
                case 33:
                    var_z_15_.aB = 0;
                    var_z_15_.setState(var_z_15_.j(0) > i_13_ ? 37 : 34);
                    break;
                case 34:
                    var_z_15_.direction = i_12_;
                    var_z_15_.x = 1;
                    var_z_15_.c(4);
                    break;
                case 38:
                    var_z_15_.aB = 0;
                    var_z_15_.x = 1;
                    var_z_15_.c(5);
                    break;
                case 42:
                    var_z_15_.velocityX = var_z_15_.Q() * (var_z_15_.direction == 0 ? -1 : 1);
                    var_z_15_.x = 2;
                    main.Onihime.playSound(46);
                    var_z_15_.c(21);
                    break;
                case 45:
                    var_z_15_.direction = i_12_;
                    var_z_15_.targetPosition.x
                            = var_af_14_.position.x + 122880 * (i_12_ == 0 ? -1 : 1);
                    var_z_15_.targetPosition.y = var_af_14_.position.z;
                    var_z_15_.velocityX = (var_z_15_.targetPosition.x - var_z_15_.position.x) / 14;
                    var_z_15_.velocityZ = (var_z_15_.targetPosition.y - var_z_15_.position.z) / 14;
                    var_z_15_.c(31);
                    break;
            }
            this.e(0);
            this.h();
        }
    }

    public final void update() {
        super.update();
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            this.D = false;
            if (49 > this.state || this.state > 58) {
                this.releaseGrabbedObj();
            }
            if (this.state != 3 && this.q > 0 && this.state != 23) {
                this.setState(3);
            }
            main.AbstractObject target = getTarget();
            int i = 0;
            int i_17_ = 0;
            int i_18_ = 0;
            int i_19_ = main.GameManager.getRandomNumber(100);
            if (target == null) {
                if (this.state != 23 && !this.j()) {
                    this.q = 10;
                    this.setState(3);
                }
            } else {
                i = this.getDirectionTowardObject(target);
                i_17_ = this.getDistanceX(target);
                i_18_ = this.getDistanceZ(target);
            }
            if (target != null && this.state == 5 && this.loopMovement) {
                if (i_17_ < 204800 && i_18_ < 122880) {
                    this.setState(27);
                } else {
                    this.setState(3);
                }
            }
            if (5 <= this.state && this.state <= 22) {
                this.a(this.state, V, target);
            } else if (14 == this.objectType) {
                main.AbstractObject var_af_21_ = target;
                int i_22_ = i_17_;
                int i_23_ = i_18_;
                i_19_ = i_19_;
                i_18_ = i_23_;
                i_17_ = i_22_;
                main.AbstractObject var_af_24_ = var_af_21_;
                while_12_:
                do {
                    switch (this.state) {
                        case 23:
                            if ((this.stateFlags & INVINCIBILITY_FLAG) == 0) {
                                break;
                            }
                            break while_12_;
                        case 0:
                            if ((this.stateFlags & INVINCIBILITY_FLAG) != 0) {
                                this.setState(23);
                                break while_12_;
                            }
                            this.setState(3);
                        /* fall through */
                        case 3:
                            this.A = 0;
                            this.B = 0;
                            if (this.q > 0) {
                                this.q--;
                            } else if (var_af_24_ != null) {
                                if (160 <= this.aB) {
                                    this.aB = 0;
                                    this.setState(45);
                                } else {
                                    this.setState(24);
                                }
                            } else {
                                this.q = 10;
                            }
                            break while_12_;
                        case 30:
                            this.position.x += this.velocityX;
                            if (this.loopMovement) {
                                if (2 == ++this.nextFrameToMove) {
                                    this.c(31);
                                }
                                if (3 == this.nextFrameToMove) {
                                    break;
                                }
                            }
                            break while_12_;
                        case 4:
                            this.A = 0;
                            this.B = 0;
                            break while_12_;
                        case 58:
                            this.b(true, 0);
                            if (this.currAnimFrame == 7) {
                                main.Onihime.playSound(30);
                            }
                            if (this.loopMovement) {
                                this.ax = true;
                                this.direction ^= 0x1;
                                this.setState(27);
                            }
                            break while_12_;
                        case 56:
                            if (this.loopMovement) {
                                this.releaseGrabbedObj();
                                break;
                            }
                            break while_12_;
                        case 28:
                            if (this.currAnimFrame < 14) {
                                this.position.x += this.velocityX;
                            }
                            if (this.loopMovement) {
                                break;
                            }
                            break while_12_;
                        case 24:
                            if (204800 > i_17_) {
                                this.setState(27);
                            } else if (!this.h(-307200)) {
                                this.setState(28);
                            } else if (main.Onihime.S()) {
                                this.ay = true;
                                this.setState(27);
                            } else {
                                if (this.nextFrameToMove < this.currAnimFrame) {
                                    if (this.j(0) > i_19_) {
                                        this.setState(31);
                                    } else if (this.j(1) > i_19_) {
                                        this.setState(43);
                                    } else {
                                        this.setState(25);
                                    }
                                }
                                break while_12_;
                            }
                            break while_12_;
                        case 25:
                            if (main.Onihime.S()) {
                                this.ay = true;
                                this.setState(27);
                            } else {
                                this.targetPosition.x
                                        = (var_af_24_.position.x
                                        + 61440 * (this.getDirectionTowardObject(var_af_24_) == 0 ? -1
                                        : 1));
                                this.targetPosition.y = var_af_24_.position.z;
                                main.AbstractObject.moveToTarget(this, target);
                                if (327680 > i_17_) {
                                    if (81920 > i_18_) {
                                        this.setState(26);
                                    } else {
                                        this.setState(27);
                                    }
                                }
                                break while_12_;
                            }
                            break while_12_;
                        case 31:
                            if (main.Onihime.S()) {
                                this.ay = true;
                                this.setState(27);
                            } else {
                                this.targetPosition.x
                                        = (var_af_24_.position.x
                                        + 204800 * (this.getDirectionTowardObject(var_af_24_) == 0
                                        ? -1 : 1));
                                this.targetPosition.y
                                        = (var_af_24_.position.z
                                        + 122880 * (this.position.z < var_af_24_.position.z
                                        ? -1 : 1));
                                main.AbstractObject.moveToTarget(this, target);
                                if (450560 > i_17_) {
                                    this.setState(81920 > i_18_ ? 27 : 39);
                                }
                                break while_12_;
                            }
                            break while_12_;
                        case 39:
                            if (8 == this.currAnimFrame) {
                                main.Onihime.playSound(46);
                            }
                            if (this.loopMovement) {
                                break;
                            }
                            break while_12_;
                        case 26:
                            if (2 == this.currAnimFrame) {
                                main.Onihime.playSound(45);
                            }
                            this.position.x += this.velocityX;
                            this.position.z += this.velocityZ;
                            if (this.loopMovement) {
                                if (102400 > i_17_ && 40960 > i_18_) {
                                    main.AbstractObject var_af_26_;
                                    if (((var_af_26_ = this.enemyCheckGrabPlayer(81920, 40960))
                                            != null)
                                            && var_af_26_.objectType != 3) {
                                        this.grabbedObject = var_af_26_;
                                        this.setState(56);
                                        main.GameManager.d();
                                        main.Onihime.playSound(57);
                                        var_af_26_.c(0, 0, 32);
                                        var_af_26_.w = 10;
                                        this.w = 10;
                                        this.g.set(0, 0, 0);
                                    } else {
                                        this.setState(3);
                                    }
                                } else {
                                    this.setState(27);
                                }
                            }
                            break while_12_;
                        case 27:
                            if (2 == this.currAnimFrame) {
                                main.Onihime.playSound(45);
                            }
                            if (this.loopMovement) {
                                break;
                            }
                            break while_12_;
                        case 43:
                            if (2 == this.currAnimFrame) {
                                main.Onihime.playSound(45);
                            }
                            if (14 > this.currAnimFrame) {
                                this.position.x += this.velocityX;
                                this.position.z += this.velocityZ;
                            }
                            if (this.loopMovement) {
                                this.w++;
                                this.u = this.r.a() - 1;
                                this.nextFrameToMove++;
                                if (av[2 == main.GameManager.currentDifficulty ? 1 : 0]
                                        < this.nextFrameToMove) {
                                    break;
                                }
                            }
                            break while_12_;
                        case 51:
                            this.b(false, 81920);
                            if (this.loopMovement) {
                                this.direction ^= 0x1;
                                this.setState(58);
                            }
                            break while_12_;
                        case 45:
                            if (2 < this.currAnimFrame && this.currAnimFrame < 17) {
                                this.position.x += this.velocityX;
                                this.position.z += this.velocityZ;
                            }
                            if (this.loopMovement) {
                                this.aB = 0;
                                main.AbstractObject var_af_27_;
                                if (((var_af_27_ = this.enemyCheckGrabPlayer(163840, 40960))
                                        != null)
                                        && var_af_27_.objectType != 3) {
                                    this.direction = this.getDirectionTowardObject(var_af_27_);
                                    this.grabbedObject = var_af_27_;
                                    this.setState(56);
                                    main.GameManager.d();
                                    main.Onihime.playSound(57);
                                    var_af_27_.c(0, 0, 32);
                                    var_af_27_.w = 10;
                                    this.w = 10;
                                    this.g.set(0, 0, 0);
                                } else {
                                    break;
                                }
                            }
                            break while_12_;
                        default:
                            break while_12_;
                    }
                    this.setState(3);
                } while (false);
            } else {
                main.AbstractObject var_af_29_ = target;
                int i_30_ = i_17_;
                int i_31_ = i_18_;
                int i_32_ = i_19_;
                int i_33_ = i;
                i_19_ = i_32_;
                i_18_ = i_31_;
                i_17_ = i_30_;
                main.AbstractObject var_af_34_ = var_af_29_;
                switch (this.state) {
                    case 23:
                        if ((this.stateFlags & INVINCIBILITY_FLAG) == 0) {
                            this.setState(3);
                        }
                        break;
                    case 0:
                        if ((this.stateFlags & INVINCIBILITY_FLAG) != 0) {
                            this.setState(23);
                            break;
                        }
                        this.setState(3);
                    /* fall through */
                    case 3:
                        this.A = 0;
                        this.B = 0;
                        if (this.q > 0) {
                            this.q--;
                        } else if (var_af_34_ != null) {
                            if (160 <= this.aB) {
                                this.aB = 0;
                                this.setState(26);
                            } else {
                                this.setState(24);
                            }
                        } else {
                            this.q = 10;
                        }
                        break;
                    case 4:
                        this.A = 0;
                        this.B = 0;
                        break;
                    case 58:
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                    case 49:
                        this.grabbedObject.p = 2;
                        this.grabbedObject.position.set(this.position);
                        this.grabbedObject.direction = this.direction ^ 0x1;
                        this.stateFlags |= 0x10;
                        if (this.currAnimFrame > 8) {
                            this.grabbedObject.onAttackContact(this, this.A, 6, this.direction,
                                    800);
                            this.grabbedObject.p = 16;
                            this.setState(58);
                        }
                        break;
                    case 24:
                        if (main.Onihime.S()) {
                            this.ay = true;
                            this.setState(27);
                        } else {
                            this.nextFrameToMove--;
                            if (204800 > i_17_) {
                                this.setState(27);
                            } else if (!this.h(-307200)) {
                                this.setState(28);
                            } else if (this.nextFrameToMove == 0) {
                                this.setState(this.j(0) > i_19_ ? 29 : 26);
                            }
                        }
                        break;
                    case 28:
                        if (this.currAnimFrame < 14) {
                            this.position.x += this.velocityX;
                        }
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                    case 25:
                        this.targetPosition.x
                                = var_af_34_.position.x + 61440 * (i_33_ == 0 ? -1 : 1);
                        this.targetPosition.y = var_af_34_.position.z;
                        main.AbstractObject.moveToTarget(this, target);
                        if (327680 > i_17_) {
                            this.setState(40960 > i_18_ ? 26 : 27);
                        }
                        break;
                    case 29:
                        if (2 < this.currAnimFrame && this.currAnimFrame < 17) {
                            this.position.x += this.velocityX;
                            this.position.z += this.velocityZ;
                        }
                        if (this.loopMovement) {
                            this.setState(32);
                        }
                        break;
                    case 32:
                        if (2 < this.currAnimFrame) {
                            this.position.x += this.velocityX;
                            this.position.z += this.velocityZ;
                        }
                        if (7 < this.currAnimFrame && this.currAnimFrame < 26) {
                            this.d(24, 0, 0);
                        }
                        if (11 <= this.currAnimFrame
                                && (this.currAnimFrame
                                <= au[2 == main.GameManager.currentDifficulty ? 1 : 0])) {
                            this.velocityX -= this.velocityX / 5;
                            this.u--;
                        }
                        if (this.loopMovement) {
                            this.setState(24);
                        }
                        break;
                    case 26:
                        if (2 == this.currAnimFrame) {
                            main.Onihime.playSound(45);
                        }
                        if (2 < this.currAnimFrame && this.currAnimFrame < 17) {
                            this.position.x += this.velocityX;
                            this.position.z += this.velocityZ;
                        }
                        if (this.loopMovement) {
                            this.setState((this.energy < W[this.difficultyAi] / 10 * 7
                                    && this.j(0) > i_19_) ? 38 : 33);
                        }
                        break;
                    case 27:
                        if (2 == this.currAnimFrame) {
                            main.Onihime.playSound(45);
                        }
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                    case 37:
                        if (this.loopMovement) {
                            this.setState(34);
                        }
                        break;
                    case 34:
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                    case 38:
                        if (this.loopMovement) {
                            this.setState(42);
                        }
                        break;
                    case 42:
                        if (4 <= this.currAnimFrame && this.currAnimFrame < 16) {
                            this.position.x += this.velocityX;
                        }
                        if (13 == this.u) {
                            this.d(0, 0, 0);
                        }
                        if (16 <= this.currAnimFrame && this.currAnimFrame <= 23) {
                            this.u--;
                        }
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                }
            }
            super.i();
            this.h();
            this.aB++;
            if (32 <= ++this.aA) {
                this.az = 0;
                this.aA = 0;
            }
        }
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
    }

    private int P() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_36_ = 0;
        switch (this.state) {
            case 35:
                return 200;
            case 36:
                return 200;
            case 37:
                return 500;
            case 33:
            case 34:
                i_36_ = aD[i][this.difficultyAi];
                break;
            case 38:
                i_36_ = aE[i][this.difficultyAi];
                break;
            case 39:
                i_36_ = aH[i][this.difficultyAi];
                break;
            case 32:
            case 40:
                i_36_ = aC[i][this.difficultyAi];
                break;
            case 53:
                return 500;
            case 54:
                return 500;
            case 55:
                return 1000;
            case 56:
                i_36_ = aI[i][this.difficultyAi];
                break;
            case 42:
                i_36_ = aF[i][this.difficultyAi];
                break;
            case 43:
            case 58:
                i_36_ = aG[i][this.difficultyAi];
                break;
        }
        return i_36_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        boolean bool;
        main.Onihime var_z_37_;
        if (bool = (var_z_37_ = this).checkAttackObjects(var_z_37_.P(), 0)) {
            if (var_z_37_.state != 43) {
                var_z_37_.w += 2;
            }
            if (var_z_37_.state == 32 || var_z_37_.state == 42) {
                main.Onihime.playSound(30);
                main.GameManager.d();
            }
            main.AbstractObject var_af;
            if (var_z_37_.state == 43
                    && (var_af = var_z_37_.enemyCheckGrabPlayer(122880, 40960)) != null
                    && var_af.objectType != 3) {
                var_z_37_.grabbedObject = var_af;
                var_z_37_.grabbedObject.c(0, 0, 36);
                main.GameManager.d();
                var_z_37_.w = 10;
                var_z_37_.stateFlags |= 0x10;
                main.Onihime.playSound(57);
                var_z_37_.setState(51);
                var_z_37_.g.set(0, 0, 0);
            }
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_38_,
            int i_39_, int i_40_) {
        int i_41_;
        if ((i_41_ = this.onBeingAttacked(var_af, i, i_38_, i_39_, i_40_)) > 0) {
            this.setState(i_41_);
        }
        if (this.state == 15) {
            this.aA = 0;
            if (7 <= ++this.az) {
                this.az = 0;
                if (this.y != 2) {
                    this.setState(27);
                }
            }
        }
    }

    public final boolean d() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a0()) {
            return false;
        }
        if (this.p > 0 || this.G || this.q > 0) {
            return false;
        }
        switch (this.state) {
            case 43:
                if (!this.loopMovement) {
                    break;
                }
            /* fall through */
            case 3:
            case 4:
            case 24:
            case 25:
            case 32:
            case 42:
                if (this.state != 42 || this.u >= 16) {
                    return true;
                }
                break;
        }
        return false;
    }

    public final void e() {
        if (this.N()) {
            this.y = 2;
            this.setState(15);
        }
    }

    public final void clearData() {
        this.clearAbstractData();
    }

    private int Q() {
        int i = 0;
        switch (this.objectType) {
            case 0:
                break;
            case 14: {
                main.Onihime var_z_42_ = this;
                i = 0;
                switch (var_z_42_.state) {
                    case 0:
                        break;
                    case 30:
                        i = X[var_z_42_.difficultyAi];
                        break;
                    case 25:
                    case 31:
                        i = X[var_z_42_.difficultyAi];
                        break;
                    case 39:
                        i = af[var_z_42_.difficultyAi];
                        break;
                    case 26:
                        i = ad[var_z_42_.difficultyAi];
                        break;
                    case 27:
                    case 28:
                        i = ab[var_z_42_.difficultyAi];
                        break;
                }
                i = i;
                break;
            }
            case 13: {
                main.Onihime var_z_43_ = this;
                i = 0;
                switch (var_z_43_.state) {
                    case 0:
                        break;
                    case 3:
                    case 25:
                        i = X[var_z_43_.difficultyAi];
                        break;
                    case 32:
                        i = aj[var_z_43_.difficultyAi];
                        break;
                    case 42:
                        i = al[var_z_43_.difficultyAi];
                        break;
                    case 26:
                        i = Z[var_z_43_.difficultyAi];
                        break;
                    case 27:
                        i = ab[var_z_43_.difficultyAi];
                        break;
                }
                i = i;
                break;
            }
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i;
    }

    private int R() {
        int i = 0;
        switch (this.objectType) {
            case 0:
                break;
            case 14: {
                main.Onihime var_z_44_ = this;
                i = 0;
                switch (var_z_44_.state) {
                    case 0:
                        break;
                    case 25:
                    case 31:
                        i = Y[var_z_44_.difficultyAi];
                        break;
                    case 39:
                        i = ag[var_z_44_.difficultyAi];
                        break;
                    case 26:
                        i = ae[var_z_44_.difficultyAi];
                        break;
                    case 27:
                        i = ac[var_z_44_.difficultyAi];
                        break;
                }
                i = i;
                break;
            }
            case 13: {
                main.Onihime var_z_45_ = this;
                i = 0;
                switch (var_z_45_.state) {
                    case 0:
                        break;
                    case 3:
                    case 25:
                        i = Y[var_z_45_.difficultyAi];
                        break;
                    case 32:
                        i = ak[var_z_45_.difficultyAi];
                        break;
                    case 26:
                        i = aa[var_z_45_.difficultyAi];
                        break;
                    case 27:
                        i = ac[var_z_45_.difficultyAi];
                        break;
                }
                i = i;
                break;
            }
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i;
    }

    private int j(int i) {
        int i_46_ = 0;
        int i_47_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_48_ = W[this.difficultyAi] / 2 < this.energy ? 0 : 1;
        switch (this.objectType) {
            case 0:
                break;
            case 14: {
                main.Onihime var_z_49_ = this;
                int i_50_ = i;
                int i_51_ = i_47_;
                i_47_ = i_48_;
                i_46_ = i_51_;
                i = i_50_;
                main.Onihime var_z_52_ = var_z_49_;
                i_48_ = 0;
                switch (var_z_52_.state) {
                    case 0:
                        break;
                    case 25:
                        switch (i) {
                            case 0:
                                i_48_ = ap[i_46_][i_47_];
                                break;
                            case 1:
                                i_48_ = aq[i_46_][i_47_];
                        }
                        break;
                    case 26:
                        switch (i) {
                            case 0:
                                i_48_ = ar[i_46_][i_47_];
                                break;
                            case 1:
                                i_48_ = as[i_46_][i_47_];
                        }
                        break;
                    case 24:
                        switch (i) {
                            case 0:
                                i_48_ = aq[i_46_][i_47_];
                                break;
                            case 1:
                                i_48_ = aq[i_46_][i_47_] + ap[i_46_][i_47_];
                                break;
                            default:
                                break;
                        }
                        break;
                }
                i_46_ = i_48_;
                break;
            }
            case 13: {
                main.Onihime var_z_53_ = this;
                int i_54_ = i_47_;
                i_46_ = i_48_;
                i = i_54_;
                main.Onihime var_z_55_ = var_z_53_;
                i_47_ = 0;
                if ((i_48_ = W[var_z_55_.difficultyAi] / 2 < var_z_55_.energy ? 0 : 1) > 0) {
                    i_48_ = W[var_z_55_.difficultyAi] / 100 * 36 < var_z_55_.energy ? 1 : 2;
                }
                switch (var_z_55_.state) {
                    case 0:
                        break;
                    case 33:
                        i_47_ = an[i][i_48_][1];
                        break;
                    case 24:
                        i_47_ = am[i][i_46_];
                        break;
                    case 26:
                        i_47_ = ao[i];
                        break;
                }
                i_46_ = i_47_;
                break;
            }
        }
        return i_46_;
    }

    private static boolean S() {
        boolean bool = false;
        for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
            main.AbstractObject var_af;
            if ((var_af = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i))).objectType == 3
                    && var_af.state == 33) {
                bool = true;
            }
        }
        return bool;
    }
    
    
    private AbstractObject getTarget()
    {
        return getPlayerTarget();
        //return main.Adam.getTarget(this, 1536, 655360, main.Onihime.B());  // Debug
    }
    
}
