/* d - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.util.Enumeration;

public final class Garcia extends main.AbstractObject {

    private static boolean W = false;
    private static final int[] X = {2500, 5000, 5000, 5000, 7500, 2500};
    
    private static final int[] velX1 = {8192, 10240, 12288, 8192, 8192, 8192};
    private static final int[] velZ1 = {8192, 10240, 12288, 8192, 8192, 8192};
    
    private static final int[] velX2 = {16384, 20480, 24576, 8192, 8192, 8192};
    private static final int[] velZ2 = {12288, 15155, 18432, 8192, 8192, 8192};
    
    private static final int[] velX3 = {11468, 11468, 8192, 8192, 8192, 11468};
    private static final int[] velZ3 = {9011, 9011, 8192, 8192, 8192, 9011};
    
    private static final int[] velX4 = {23756, 23756, 23756, 23756, 23756, 23756};
    private static final int[] velZ4 = {11468, 11468, 11468, 11468, 11468, 11468};
    
    private static final int[][][][] probabilities1 =
    {
        { // Easy
            {
                {60, 40, 20},
                {70},
                {70}
            },
            {
                {75, 60, 50},
                {70},
                {70}
            },
            {
                {65, 70, 90},
                {70},
                {70}
            }
        },
        { // Normal
            {
                {70, 50, 30},
                {80},
                {80}
            },
            {
                {85, 70, 60},
                {80},
                {80}
            },
            {
                {75, 80, 95},
                {80},
                {80}
            }
        },
        { // Hard
            {
                {80, 60, 40},
                {95},
                {95}
            },
            {
                {95, 80, 70},
                {95},
                {95}
            },
            {
                {85, 90, 100},
                {95},
                {95}
            }
       }
    };
    private static final int[][][] probabilities2 =
    {
        { {33, 33, 33}, {33, 33, 33}, {33, 33, 33}}, // Easy
        { {15, 15, 15}, {18, 18, 18}, {20, 20, 20}}, // Normal
        { {5, 5, 5}, {7, 7, 7}, {10, 10, 10}   // Hard
        }
    };
    private static final int[][][] probabilities3 =
    {
        {{50, 50, 50}, {33, 33, 33}, {33, 33, 33}}, // Easy
        {{60, 60, 60}, {55, 55, 55}, {44, 44, 44}}, // Normal
        {{80, 80, 80}, {73, 73, 73}, {53, 53, 53}}  // Hard
    };
    private static final int[] aj = {10, 3, 1};
    private static final int[] ak = {208896, 348160, 450560};
    private int probRow;
    private boolean am;
    private boolean an;
    private boolean ao;
    private int probColumn;
    private int aq;
    private static final int[][][][] settings4 =
    {
        // Easy and Normal
        {
            {
                {500, 500, 500},
                {700},
                {2000},
                {800}
            },
            {
                {500, 500, 500},
                {700},
                {2000},
                {800}},
            {
                {500, 500, 500},
                {700},
                {2000},
                {800}
            }
        },
        
        // Hard
        {
            {
                {500, 500, 500},
                {700},
                {2000},
                {800}
            },
            {
                {500, 500, 500},
                {700},
                {2000},
                {800}
            },
            {
                {500, 500, 500},
                {700},
                {2000},
                {800}
            }
        }
    };

    public Garcia(main.ObjectArt var_ad, int i, int posX, int posZ,
            int posY, int i_3_, int i_4_, int i_5_) {
        super(4, i, posX, posZ, posY, i_3_, i_4_);
        this.stateFlags |= 0x8201;
        //this.c |= 0x8101; // Debug
        this.r = new main.eExtendsAr(0, var_ad, 26);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(131072,
                                131072,
                                131072));
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.D = false;
        this.am = false;
        this.grabbedObject = null;
        if ((this.probRow = i_5_) == 3) {
            this.x = 2;
        }
        int[] is = {0, 1, 2, 1};
        this.comboCounter = is[i_5_];
        this.K = new main.Point(this.position.x, this.position.z, this.position.y);
        this.O = 0;
        this.energy = X[this.probRow == 0 ? this.difficultyAi : 2 + this.probRow];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "REGENT";
    }

    private void j(int i) {
        switch (i) {
            case 0: {
                int[] is = {0, 1, 3, 2};
                this.c(is[this.probRow]);
                break;
            }
            case 4: {
                int[] is = {4, 6, 8, 0};
                this.c(is[this.probRow]);
                break;
            }
            case 9: {
                int[] is = {9, 10, 12, 11};
                this.c(is[this.probRow]);
                break;
            }
            default:
                this.c(i);
        }
    }

    private void k(int i) {
        this.g.x = 0;
        this.g.z = 0;
        j(i);
    }

    public final void setState(int i) {
        main.AbstractObject target = getPlayerTarget();
        this.state = i;
        this.w();
        if (this.probRow == 3) {
            this.x = 2;
        }
        this.soundToPlayOnContact = (this.probRow & 0x1) != 0 ? 4 : this.soundToPlayOnContact;
        this.ao = false;
        if (i != 27 && i != 28 && i != 31 && i != 32) {
            this.an = false;
        }
        int i_8_ = i;
        switch (i_8_) {
            case 3:
                this.j(9);
                break;
            case 4:
                this.j(0);
                break;
            case 5:
                this.k(19);
                break;
            case 14:
                this.n = 32;
                this.k(17);
                break;
            case 12:
            case 13:
                this.k(15);
                break;
            case 15:
                if ((this.probRow == 3 && 2 != main.GameManager.currentDifficulty ? 75 : 50) > main.GameManager.getRandomNumber(100)) {
                    if (this.position.y >= 0) {
                        this.dropWeapon();
                    }
                    this.probRow = 0;
                }
                switch (this.y) {
                    default:
                        this.direction = this.C;
                        this.k(14);
                        break;
                    case 2:
                        this.F();
                        this.j(18);
                }
                break;
            case 20:
                if (50 < main.GameManager.getRandomNumber(100)) {
                    this.probRow = 0;
                    if (this.position.y >= 0) {
                        this.dropWeapon();
                    }
                }
                this.k(16);
                break;
            case 19:
                this.k(21);
                break;
            case 16:
                this.k(23);
                break;
            case 17:
                this.y = 9;
                this.k(20);
                break;
            case 18:
                this.E();
                this.j(22);
                break;
            case 22:
                this.d(25);
                break;
            case 23:
                if ((this.stateFlags & 0x1000000) == 0) {
                    this.nextFrameToMove = main.GameManager.getRandomNumber(29);
                }
                this.j(9);
                break;
            case 26:
            case 29:
            case 30:
                this.velocityX = this.calculateVelX();
                this.velocityZ = this.calculateVelZ();
                this.j(0);
                if ((this.stateFlags & 0x800000) != 0) {
                    this.state = 26;
                }
                break;
            case 7:
                main.AbstractObject.i(this);
                this.j(0);
                break;
            case 8:
                main.AbstractObject.h(this);
                this.j(0);
                break;
            case 9:
                main.AbstractObject.g(this);
                this.j(0);
                break;
            case 10:
                main.AbstractObject.f(this);
                this.j(0);
                break;
            case 11:
                main.AbstractObject.e(this);
                this.j(0);
                break;
            case 25:
                this.velocityX = this.calculateVelX();
                this.velocityZ = this.calculateVelZ();
                this.targetPosition.x = target.position.x + (this.getDirectionTowardObject(target) == 0 ? -196608 : 196608);
                this.targetPosition.y = target.position.z;
                this.j(0);
                break;
            case 27:
            case 28:
                this.velocityX = this.calculateVelX();
                this.velocityZ = this.calculateVelZ();
                if (main.GameManager.getRandomNumber(2) == 0) {
                    this.ao = true;
                }
                this.targetPosition.x
                        = target.position.x + 245760 * (this.getDirectionTowardObject(target) == 0 ? 1 : -1);
                if (this.ao && 40960 > this.getDistanceZ(target)) {
                    this.targetPosition.y = target.position.z - 122880;
                } else {
                    this.targetPosition.y = target.position.z + 122880 * (this.position.z < target.position.z
                            ? -1 : 1);
                }
                this.D();
                if ((this.stateFlags & 0x800000) != 0) {
                    this.state = 27;
                }
                this.j(0);
                break;
            case 24:
                this.velocityX = this.calculateVelX();
                this.velocityZ = this.calculateVelZ();
                this.nextFrameToMove = main.GameManager.getRandomNumber(40) + 8;
                this.j(0);
                break;
            case 31:
                this.velocityX = this.calculateVelX();
                this.velocityZ = this.calculateVelZ();
                this.targetPosition.x
                        = this.position.x + 196608 * (this.getDirectionTowardObject(target) == 0 ? -1 : 1);
                this.targetPosition.y = this.position.z;
                this.j(0);
                break;
            case 32: {
                this.velocityX = this.calculateVelX();
                this.velocityZ = this.calculateVelZ();
                int i_10_ = target.position.x < this.position.x ? 1 : -1;
                this.targetPosition.x
                        = (main.GameManager.screenLockX
                        + (main.GameManager.screenWidth / 2 << 12) * (i_10_ > 0 ? 1
                        : -1)
                        + (main.GameManager.getRandomNumber(50) << 12) * (i_10_ > 0 ? -1
                        : 1));
                this.targetPosition.y = this.position.z;
                this.j(0);
                break;
            }
            case 33:
                if ((i_8_ = main.GameManager.getRandomNumber(100)) > 90) {
                    this.setState(27);
                } else if (i_8_ > 33) {
                    this.setState(31);
                } else {
                    this.setState(23);
                }
                break;
            case 35:
                if (target.state == 5) {
                    this.setState(33);
                } else {
                    this.x = 1;
                    this.am = false;
                    this.j(9);
                }
                break;
            case 34:
                this.probColumn = 0;
                this.soundToPlayOnContact = (this.probRow & 0x1) != 0 ? 4 : this.soundToPlayOnContact;
            /* fall through */
            case 36:
                main.Garcia.playSound(0);
                if (target.state == 5) {
                    this.setState(33);
                } else if (i_8_ == 36) {
                    this.x = 2;
                    this.am = false;
                    this.j(5);
                    this.am = false;
                } else {
                    if (this.probRow == 2) {
                        this.x = 2;
                    } else {
                        this.x = 1;
                    }
                    this.j(4);
                }
                break;
            case 37:
                if (this.grabbedObject == null) {
                    this.setState(3);
                }
                this.aq = 5;
                this.nextFrameToMove = 0;
                this.grabbedObject.onAttackContact(this, 0, 11, this.direction, 0);
                this.a(false, 147456);
                this.j(13);
                break;
            case 38: {
                this.targetPosition.x = target.position.x;
                if (target.position.x < this.position.x) {
                    this.velocityX = -this.calculateVelX();
                } else {
                    this.velocityX = this.calculateVelX();
                }
                i_8_ = java.lang.Math.abs(((this.targetPosition.x
                        - this.position.x)
                        / this.calculateVelX() / 3)
                        << 1);
                int i_11_ = 0;
                if (i_8_ > 0) {
                    i_11_ = (target.position.z - this.position.z) / i_8_;
                }
                this.velocityZ = i_11_;
                if (this.calculateVelZ() < java.lang.Math.abs(this.velocityZ)) {
                    this.velocityZ = this.calculateVelZ() * (this.velocityZ > 0 ? 1 : -1);
                }
                this.direction = this.getDirectionTowardObject(target);
                this.x = 2;
                this.j(0);
                break;
            }
        }
        this.h();
    }

    public final void update() {
        super.update();
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            int rand100 = main.GameManager.getRandomNumber(100);
            main.AbstractObject target = getPlayerTarget();
            int distX = 0;
            int distY = 0;
            if (target == null) {
                if (!this.j()) {
                    this.q = 10;
                }
            } else {
                distX = this.getDistanceX(target);
                distY = this.getDistanceZ(target);
            }
            this.D = false;
            if (this.state != 3 && this.q > 0) {
                this.setState(3);
            }
            main.AbstractObject.j(this);
            if (5 <= this.state && this.state <= 22) {
                this.a(this.state, V, target);
            } else if ((this.stateFlags & 0x1000000) == 0) {
                int distX2 = distX;
                int distY2 = distY;
                distY = distY2;
                distX = distX2;
                switch (this.state) {
                    case 0:
                        this.setState(3);
                    /* fall through */
                    case 3:
                        this.A = 0;
                        this.B = 0;
                        this.g.set(0, 0, this.g.y);
                        if (this.probRow == 3) {
                            this.o++;
                        }
                        if (this.q > 0) {
                            this.q--;
                        } else if (target != null) {
                            if (this.probRow == 3) {
                                this.setState(38);
                            } else {
                                this.setState(25);
                            }
                        } else {
                            this.q = 10;
                        }
                        break;
                    case 4:
                    case 31:
                    case 32:
                        this.A = 0;
                        this.B = 0;
                        main.AbstractObject.moveToTarget(this, target);
                        if (!this.P()) {
                            if (this.e(0, 0)) {
                                this.setState(3);
                            } else if (main.GameManager.currentLevel != 7) {
                                this.R = 7;
                            } else {
                                this.R = 3;
                            }
                        }
                        break;
                    case 25:
                        if (this.currAnimFrame % aj[this.difficultyAi] == 0) {
                            this.targetPosition.x
                                    = (target.position.x
                                    + ak[this.probRow] * (this.getDirectionTowardObject(target) == 0
                                    ? -1 : 1));
                            this.targetPosition.y = target.position.z;
                        }
                        if (!this.P()) {
                            main.AbstractObject.moveToTarget(this, target);
                            if (this.e(0, 0)) {
                                this.setState(23);
                            } else if ((this.stateFlags & 0x2000000) == 0) {
                                this.R = 7;
                            } else {
                                this.R = 3;
                            }
                        }
                        break;
                    case 26:
                        main.AbstractObject.moveToTarget(this, target);
                        if (this.currAnimFrame % aj[this.difficultyAi] == 0) {
                            if (target.position.x < this.position.x) {
                                this.targetPosition.x = target.position.x + 196608;
                            } else {
                                this.targetPosition.x = target.position.x - 196608;
                            }
                            this.targetPosition.y = target.position.z;
                            if (this.P()) {
                                break;
                            }
                            boolean bool;
                            if (bool = (this.getDistanceX(target) < 204800 && this.getDistanceZ(target) < 20480)) {
                                if (this.getProbabilityByState(0) > rand100) {
                                    this.setState(30);
                                } else if (this.getProbabilityByState(1) > rand100) {
                                    this.setState(24);
                                } else {
                                    this.setState(27);
                                }
                                break;
                            }
                        }
                        if ((this.stateFlags & 0x2000000) == 0) {
                            this.R = 7;
                        } else {
                            this.R = 3;
                        }
                        break;
                    case 23:
                        if (!this.P() && this.nextFrameToMove < this.currAnimFrame) {
                            if (distX <= ak[this.probRow] && distY < 81920) {
                                if (this.getProbabilityByState(0) > rand100) {
                                    this.setState(30); // Attack
                                } else if (this.getProbabilityByState(1) > rand100) {
                                    this.setState(24);
                                } else {
                                    this.setState(27); // go around...
                                }
                            } else {
                                this.setState(3);
                            }
                        }
                        break;
                    case 24:
                        this.targetPosition.x = target.position.x + 348160 * (this.getDirectionTowardObject(target) == 0 ? -1 : 1);
                        this.targetPosition.y = target.position.z;
                        main.AbstractObject.moveToTarget(this, target);
                        if (!this.P()) {
                            if (this.nextFrameToMove <= 0) {
                                this.setState(3);
                            }
                            if ((this.stateFlags & 0x2000000) == 0) {
                                this.R = 7;
                            } else {
                                this.R = 3;
                            }
                        }
                        break;
                    case 29:
                        if (this.getDirectionTowardObject(target) == 0) {
                            this.targetPosition.x = target.position.x - 40960;
                        } else {
                            this.targetPosition.x = target.position.x + 40960;
                        }
                        this.targetPosition.y = target.position.z;
                        main.AbstractObject.moveToTarget(this, target);
                        if (!this.P()) {
                            if (this.isFacedToTarget(target)) {
                                this.setState(31);
                            } else if (!target.d()) {
                                this.setState(31);
                            } else if (40960 >= distX && 20480 >= distY) {
                                if ((target = this.enemyCheckGrabPlayer(131072, 20480))
                                        != null) {
                                    this.grabbedObject = target;
                                    this.setState(37);
                                } else {
                                    this.setState(3);
                                }
                            } else if ((this.stateFlags & 0x2000000) == 0) {
                                this.R = 7;
                            } else {
                                this.R = 3;
                            }
                        }
                        break;
                    case 30:
                        if (this.currAnimFrame % aj[this.difficultyAi] == 0) {
                            this.targetPosition.x
                                    = (target.position.x
                                    + ak[this.probRow] * (this.getDirectionTowardObject(target) == 0
                                    ? -1 : 1));
                            this.targetPosition.y = target.position.z;
                        }
                        main.AbstractObject.moveToTarget(this, target);
                        if (!this.P()) {
                            if (distX < ak[this.probRow] + 4096 && distY < 20480) {
                                this.setState(34);
                            } else if ((this.stateFlags & 0x2000000) == 0) {
                                this.R = 7;
                            } else {
                                this.R = 3;
                            }
                        }
                        break;
                    case 27:
                    case 28:
                        main.AbstractObject.moveToTarget(this, target);
                        if (this.e(0, 0)) {
                            if (this.getProbabilityByState(0) > rand100) {
                                if (target.d() && !this.isFacedToTarget(target)) {
                                    this.setState(29);
                                } else {
                                    this.setState(3);
                                    this.q = 30;
                                }
                            } else {
                                this.setState(30);
                            }
                        } else {
                            if (!this.P()) {
                                if ((this.stateFlags & 0x2000000) == 0) {
                                    this.R = 7;
                                } else {
                                    this.R = 3;
                                }
                            }
                            break;
                        }
                        break;
                    case 34:
                        if (this.loopMovement) {
                            if (this.am) {
                                if (this.probRow == 0) {
                                    if (this.getProbabilityByState(0) >= rand100) {
                                        this.nextFrameToMove = 8;
                                        this.probColumn++;
                                        this.setState(35);
                                    } else {
                                        this.setState(31);
                                    }
                                } else {
                                    this.setState(31);
                                }
                            } else {
                                this.setState(3);
                                this.q = 10;
                            }
                        }
                        break;
                    case 35:
                        if (this.nextFrameToMove > 0) {
                            this.nextFrameToMove--;
                            if (this.nextFrameToMove == 0) {
                                main.Garcia.playSound(0);
                                this.c(4);
                            }
                        } else if (this.loopMovement) {
                            if (this.am) {
                                if (this.getProbabilityByState(0) >= rand100) {
                                    this.setState(36);
                                } else {
                                    this.setState(31);
                                }
                            } else {
                                this.setState(3);
                                this.q = 10;
                            }
                        }
                        break;
                    case 36:
                        if (this.loopMovement) {
                            if (this.am) {
                                if (target.state == 5) {
                                    if (40 > main.GameManager.getRandomNumber(100)) {
                                        this.setState(32);
                                    }
                                } else {
                                    this.setState(31);
                                }
                            } else {
                                this.q = 16;
                            }
                        }
                        break;
                    case 37:
                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)
                                || main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)
                                || main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT)
                                || main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT)) {
                            this.nextFrameToMove = 10;
                            this.aq--;
                            if (this.aq <= 0) {
                                this.onAttackContact(this.grabbedObject, 0, 2,
                                        this.direction == 0 ? 1 : 0, 0);
                                break;
                            }
                        }
                        if (this.nextFrameToMove > 0) {
                            this.nextFrameToMove--;
                            if (this.currAnimFrame % 2 == 0) {
                                this.position.x += 4096;
                                this.grabbedObject.position.x += 4096;
                            } else {
                                this.position.x -= 4096;
                                this.grabbedObject.position.x -= 4096;
                            }
                        }
                        if (48 < this.currAnimFrame) {
                            this.releaseGrabbedObj();
                            this.setState(3);
                        } else {
                            if (!this.grabbedObject.G) {
                                this.grabbedObject = null;
                                this.setState(3);
                            }
                            break;
                        }
                        break;
                    case 38:
                        this.position.x += this.velocityX;
                        this.position.z += this.velocityZ;
                        if (this.direction == 0) {
                            if (this.position.x - target.position.x > 614400) {
                                this.direction = this.getDirectionTowardObject(target);
                                this.q = 10;
                            }
                        } else if (target.position.x - this.position.x > 614400) {
                            this.direction = this.getDirectionTowardObject(target);
                            this.q = 10;
                        }
                        this.R = 2;
                        break;
                }
            } else {
                switch (this.state) {
                    case 0:
                        this.setState(3);
                    /* fall through */
                    case 3:
                        this.A = 0;
                        this.B = 0;
                        this.g.set(0, 0, this.g.y);
                        if (this.q > 0) {
                            this.q--;
                        } else if (target != null) {
                            this.setState(25);
                        } else {
                            this.q = 10;
                        }
                        break;
                    case 25:
                        main.AbstractObject.moveToTarget(this, target);
                        if (this.e(0, 0)) {
                            this.setState(23);
                        }
                        break;
                }
            }
            super.i();
            this.h();
        }
    }

    public final void checkHammerSmash() {
        int difficultyIndex = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        if (this.checkAttackObjects((settings4[difficultyIndex][this.difficultyAi][this.probRow][this.probColumn]
                + (2 == main.GameManager.currentDifficulty ? 100 : 0)),0)) {
            this.am = true;
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_24_, int i_25_, int i_26_) {
        if (!main.GameManager._a1()) {
            int i_27_;
            if ((i_27_ = this.onBeingAttacked(var_af, i, i_24_, i_25_, i_26_)) > 0) {
                this.setState(i_27_);
            }
        }
    }

    public final void e() {
        if (this.N()) {
            this.y = 2;
            this.setState(15);
        }
    }

    public final void b() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            main.ar.addElementToVector1(this.r);
        }
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
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 22:
            case 23:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                return true;
        }
        return false;
    }

    private boolean P() {
        if (this.an) {
            return false;
        }
        boolean bool = false;
        java.util.Enumeration enumeration
                = main.GameManager.collidableObjects.elements();
        while (enumeration.hasMoreElements()) {
            main.AbstractObject var_af
                    = (main.AbstractObject) enumeration.nextElement();
            if (this != var_af && var_af.objectType == 4 && 204800 > this.getDistanceX(var_af)
                    && 122880 > this.getDistanceZ(var_af)) {
                main.Garcia var_d_28_;
                if (!(var_d_28_ = (main.Garcia) var_af).an) {
                    if (var_d_28_.state == 27 || var_d_28_.state == 28) {
                        this.setState(32);
                    } else {
                        this.setState(27);
                    }
                    this.an = true;
                    bool = true;
                    break;
                }
                if ((this.state == 31 || this.state == 32)
                        && (var_af.state == 31 || var_af.state == 32)) {
                    this.setState(27);
                    bool = true;
                    break;
                }
                if ((this.state == 27 || this.state == 28)
                        && (var_af.state == 27 || var_af.state == 28)) {
                    this.setState(32);
                    bool = true;
                    break;
                }
            }
        }
        return bool;
    }

    private int calculateVelX() {
        if ((this.stateFlags & 0x1000000) != 0) {
            return velX1[0];
        }
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
            case 25:
            case 26:
            case 29:
            case 30:
            case 31:
                i = velX1[this.difficultyAi];
                break;
            case 27:
            case 28:
                i = velX2[this.difficultyAi];
                break;
            case 32:
                i = velX3[this.difficultyAi];
                break;
            case 38:
                i = velX4[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int calculateVelZ() {
        if ((this.stateFlags & 0x1000000) != 0) {
            return velZ1[0];
        }
        int res = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
            case 25:
            case 26:
            case 29:
            case 30:
            case 31:
                res = velZ1[this.difficultyAi];
                break;
            case 27:
            case 28:
                res = velZ2[this.difficultyAi];
                break;
            case 32:
                res = velZ3[this.difficultyAi];
                break;
            case 38:
                res = velZ4[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            res = (int) ((long) res * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return res;
    }

    private int getProbabilityByState(int i) {
        int ret = 0;
        int difficultyIndex = GameManager.currentDifficulty; //2 == main.GameManager.currentDifficulty ? 1 : 0;
        switch (this.state) {
            case 0:
                break;
            case 23:
            case 26:
                switch (i) {
                    case 0:
                        ret = probabilities1[difficultyIndex][this.difficultyAi][this.probRow][this.probColumn];
                        break;
                    case 1:
                        ret = (probabilities1[difficultyIndex][this.difficultyAi][this.probRow][this.probColumn]
                                + probabilities2[difficultyIndex][this.difficultyAi][this.probRow]);
                }
                break;
            case 27:
            case 28:
                ret = probabilities3[difficultyIndex][this.difficultyAi][this.probRow];
                break;
            case 34:
            case 35:
                ret = probabilities1[difficultyIndex][this.difficultyAi][this.probColumn][this.probRow];
                break;
        }
        return ret + (this.isFacedToAnyPlayer() ? 0 : ret == 0 ? 0 : 10);
    }
    
    
}
