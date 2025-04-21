/* k - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Image;

public final class Blaze extends main.AbstractObject {

    // custom
    private int altComboPress;
    
    private static final short[][] W;
    private boolean canPerformSpecial;
    private int comboState;
    private int nextState;
    private int comboResetTimer;
    private boolean ab;
    private int grabComboCount;
    private boolean grabAttack;
    private boolean attackHoldingCondittion;
    private boolean slamFrontToBack;
    private main.Point2D ag;
    private main.oExtendsAr ah;
    private javax.microedition.lcdui.Image[] ai
            = new javax.microedition.lcdui.Image[2];
    private final int aj;
    private boolean ak;
    private int attackMoveScore;
    
    private final InputController controller;
    private final int playerId;

    static {
        (new short[][]{{-1, -1}, {289, 125, 16, 15, -5, -5, 0},
        {289, 119, 19, 6, 6, 0, 0},
        {225, 150, 33, 36, 16, -20, 0}, null})[4]
                = new short[]{245, 240, 8, 15, -2, 3, 0};
        W = new short[][]{{-1, -1}, {289, 125, 16, 15, -5, -5, 0},
        {289, 119, 19, 6, 6, 0, 0},
        {225, 150, 33, 36, 16, -20, 0},
        {186, 324, 8, 15, -2, 3, 0}};
    }

    public Blaze(main.ObjectArt var_ad, int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, InputController pl, int playerId) {
        super(2, 0, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.controller = pl;
        this.playerId = playerId;
        this.stateFlags |= 0x8101;
        this.energy = 10000;
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.r = new main.eExtendsAr(0, var_ad, 43);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(65536,
                                32768,
                                131072)
                );
        
        altComboPress = 0;
        this.u = 0;
        this.t = 0;
        this.comboState = 0;
        this.nextState = 0;
        this.comboResetTimer = 0;
        this.ab = false;
        this.ag = new main.Point2D(0, 0);
        this.ai[0] = var_ad.a(3);
        this.ai[1] = main.MainCanvas.imageStatusAll;
        this.ah = new main.oExtendsAr(0, this.ai[0], W);
        this.ah.a(0);
        if (main.GameManager.currentDifficulty == 0) {
            this.aj = 500;
        } else {
            this.aj = 900;
        }
        this.name = "Blaze";
    }
    
    
    public InputController getController(){
        return controller;
    }
    
    
    private void checkSor2AltCombo(){
        // check alt combos
        if (InputController.useSor2Controlls) {
            if (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP))
                altComboPress = 1;
            else if (controller.holded(InputController.ACTION_DOWN) || controller.pressed(InputController.ACTION_DOWN))
                altComboPress = 2;
        }
    }

    public final void setState(int newState) {
        if (this.state != 1 && this.state != 2 && this.state != 6) {
            this.state = newState;
            this.w();
            this.comboState = this.state;
            this.nextState = 0;
            this.ab = false;
            this.attackMoveScore = 0;
            this.T = 500;
            this.ag.set(0, 0);
            this.I.set(0, 0);
            this.canPerformSpecial = true;
            this.D = false;
            // lol this while is something (not!), funny reverse engineering stuff..
            while_9_:
            do {
                switch (newState) {
                    case 1:
                        this.canPerformSpecial = false;
                        this.setupPlayerInitialPosition();
                        this.c(1);
                        break while_9_;
                    case 2:
                        this.canPerformSpecial = false;
                        this.g.set(0, 0, 0);
                        this.c(1);
                        break while_9_;
                    case 3:
                        this.g.set(0, 0, this.g.y);
                        this.x = 0;
                        this.y = 0;
                        this.A = 0;
                        this.G = false;
                        this.grabComboCount = 0;
                        vaultCount = 0;
                        this.releaseGrabbedObj();
                        this.c(0);
                        break while_9_;
                    case 4:
                        this.releaseGrabbedObj();
                        this.x = 0;
                        this.y = 0;
                        this.grabComboCount = 0;
                        vaultCount = 0;
                        break while_9_;
                    case 5:
                        this.canPerformSpecial = false;
                        this.d(22);
                        break while_9_;
                    case 6:
                        this.canPerformSpecial = false;
                        break;
                    case 14:
                        this.canPerformSpecial = false;
                        this.n = 32;
                        main.Blaze.playSound(51);
                        this.d(25);
                        break while_9_;
                    case 12:
                        this.d(14);
                        break while_9_;
                    case 13:
                        this.d(15);
                        break while_9_;
                    case 15:
                        this.canPerformSpecial = false;
                        switch (this.y) {
                            default:
                                this.canPerformSpecial = true;
                                this.d(17);
                                break while_9_;
                            case 2:
                                this.F();
                                this.c(19);
                                break;
                            case 6:
                                this.d(26);
                        }
                        break while_9_;
                    case 38:
                        if (this.grabbedObject == null) {
                            this.setState(3);
                        } else {
                            this.a(true, 81920);
                            this.c(9);
                        }
                        break while_9_;
                    case 39:
                        if (this.grabbedObject == null) {
                            this.setState(3);
                        } else {
                            this.a(false, 81920);
                            this.c(9);
                        }
                        break while_9_;
                    case 40:
                    case 41:
                        this.canPerformSpecial = false;
                        if (this.grabbedObject == null) {
                            this.setState(3);
                        } else {
                            this.G();
                            this.c(12);
                            main.Blaze.playSound(45);
                        }
                        break while_9_;
                    case 23:
                        this.attackMoveScore = 20;
                        this.T = 200;
                        this.x = 1;
                        this.comboResetTimer = 17;
                        this.c(2);
                        main.Blaze.playSound(0);
                        break while_9_;
                    case 24:
                        this.x = 1;
                        this.T = 400;
                        this.attackMoveScore = 20;
                        this.comboResetTimer = 17;
                        this.c(2);
                        main.Blaze.playSound(0);
                        break while_9_;
                    case 25:
                        this.attackMoveScore = 30;
                        this.T = 300;
                        this.soundToPlayOnContact = 59;
                        this.x = 1;
                        this.comboResetTimer = 17;
                        this.c(3);
                        break while_9_;
                    case 42:
                    case 43:
                        this.attackMoveScore = 30;
                        this.T = 500;
                        this.soundToPlayOnContact = 59;
                        if (newState == 42) {
                            this.grabComboCount = 1;
                        } else {
                            this.grabComboCount = 2;
                        }
                        this.x = 4;
                        this.comboResetTimer = 10;
                        this.stateFlags |= 0x10;
                        this.c(13);
                        break while_9_;
                    case 44:
                        if (this.grabbedObject != null) {
                            this.grabbedObject.p = 16;
                        }
                        this.attackMoveScore = 50;
                        this.soundToPlayOnContact = 59;
                        this.T = 1600;
                        this.stateFlags |= 0x10;
                        this.x = 2;
                        this.comboResetTimer = 0;
                        this.grabComboCount = 0;
                        this.c(11);
                        main.Blaze.playSound(46);
                        break while_9_;
                    case 26:
                        this.attackMoveScore = 40;
                        this.soundToPlayOnContact = 60;
                        this.T = 800;
                        this.x = 1;
                        this.comboResetTimer = 16;
                        this.c(4);
                        main.Blaze.playSound(46);
                        break while_9_;
                    case 27:
                        this.attackMoveScore = 40;
                        this.soundToPlayOnContact = 59;
                        this.T = 800;
                        this.x = 1;
                        this.p = 5;
                        this.comboResetTimer = 16;
                        this.c(5);
                        break while_9_;
                    case 28:
                        this.canPerformSpecial = false;
                        this.stateFlags |= 0x30000;
                        this.attackMoveScore = 30;
                        this.T = 1600;
                        this.soundToPlayOnContact = 60;
                        this.x = 2;
                        this.comboResetTimer = 0;
                        this.c(6);
                        break while_9_;
                    case 29:
                        this.canPerformSpecial = false;
                        this.stateFlags |= 0x10000;
                        this.attackMoveScore = 50;
                        this.soundToPlayOnContact = 57;
                        this.comboResetTimer = 0;
                        this.c(7);
                        main.Blaze.playSound(46);
                        break while_9_;
                    case 30: {
                        this.canPerformSpecial = false;
                        main.AbstractObject enemy = main.Blaze.getEnemyInFront(this, 1536, 262144, 81920);
                        if (enemy == null) {
                            this.setState(3); // new code: ignore throw if no object in front
                            //this.setState(32);
                        } else {
                            this.grabbedObject = enemy;
                            if (this.getDistanceX(enemy) < 163840) {
                                this.setState(47);
                            } else {
                                this.setState(45);
                            }
                        }
                        break while_9_;
                    }
                    case 31:
                        this.canPerformSpecial = false;
                        this.ak = false;
                        this.releaseGrabbedObj();
                        this.T = 2000;
                        this.stateFlags |= 0x10;
                        this.d(21);
                        this.dropWeapon();
                        break while_9_;
                    case 32:
                        this.stateFlags |= 0x10;
                        this.g.x = this.direction == 0 ? 4096 : -4096;
                        this.c(24);
                        main.Blaze.playSound(46);
                        break while_9_;
                    case 47:
                        this.canPerformSpecial = false;
                        if (this.grabbedObject == null) {
                            this.setState(3);
                        } else {
                            this.grabbedObject.direction = this.direction;
                            this.G();
                            this.attackMoveScore = 100;
                            this.T = main.GameManager.currentDifficulty == 0 ? 3200 : 2200;
                            this.grabbedObject.onAttackContact(this, 0, 7, this.direction, this.T);
                            this.c(10);
                            main.Blaze.playSound(46);
                        }
                        break while_9_;
                    case 45:
                        this.canPerformSpecial = false;
                        if (this.grabbedObject == null) {
                            this.setState(3);
                        } else {
                            this.grabbedObject.position.set(this.position.x, this.position.z, this.position.y);
                            this.G();
                            this.grabbedObject.direction = this.direction;
                            this.attackMoveScore = 100;
                            main.Blaze.addPlayerScore(playerId, this.attackMoveScore);
                            this.T = main.GameManager.currentDifficulty == 0 ? 3000 : 2000;
                            this.grabbedObject.onAttackContact(this, 0, 9, this.direction, this.T);
                            this.grabbedObject.p = 8;
                            this.c(8);
                            main.Blaze.playSound(46);
                        }
                        break while_9_;
                    case 19:
                        this.canPerformSpecial = false;
                        this.d(35);
                        break while_9_;
                    case 17:
                        this.canPerformSpecial = false;
                        this.d(16);
                        break while_9_;
                    case 18:
                        this.canPerformSpecial = false;
                        this.E();
                        this.c(36);
                        break while_9_;
                    case 33:
                        this.canPerformSpecial = false;
                        this.g.x = 0;
                        this.position.y = 0;
                        this.c(31);
                        this.p = 10;
                        main.Blaze.playSound(46);
                        break while_9_;
                    case 46:
                        this.canPerformSpecial = false;
                        if (this.grabbedObject == null) {
                            this.setState(3);
                        } else {
                            this.x = 9;
                            this.grabbedObject.onAttackContact(this, 0, 9, this.direction, 0);
                            this.position.set(this.grabbedObject.position.x, this.grabbedObject.position.z, this.position.y);
                            this.grabbedObject.direction = this.direction ^ 0x1;
                            this.G();
                            this.c(9);
                            main.Blaze.playSound(46);
                        }
                        break while_9_;
                    case 34:
                        this.attackMoveScore = 40;
                        this.T = 2500;
                        this.x = 2;
                        this.soundToPlayOnContact = 4;
                        main.Blaze.playSound(0);
                        this.c(38);
                        break while_9_;
                    case 35:
                        this.attackMoveScore = 40;
                        this.T = 3200;
                        this.x = 2;
                        main.Blaze.playSound(0);
                        this.c(39);
                        break while_9_;
                    case 36:
                        this.comboCounter = 0;
                        main.GameManager.spawnObject(108, this.position.x, this.position.z, 0,
                                this.direction, 0, 0);
                        main.Blaze.playSound(0);
                        this.c(40);
                        break while_9_;
                    case 37:
                        break;
                    default:
                        break while_9_;
                }
                this.d(28);
            } while (false);
            this.e(0);
            this.h();
        }
    }

    public final void update() {
        if (38 > this.state || this.state > 47) {
            this.releaseGrabbedObj();
        }
        if (this.q > 0 && this.state != 3 && this.state != 2 && this.state != 1
                && this.state != 6) {
            this.setState(3);
        }
        if (this.direction == 0) {
            this.grabAttack = controller.pressedExceptSpecials(InputController.ACTION_RIGHT);
            this.attackHoldingCondittion = controller.holdedExceptSpecials(InputController.ACTION_RIGHT);
            this.slamFrontToBack = controller.pressedExceptSpecials(InputController.ACTION_LEFT);
        } else {
            this.grabAttack = controller.pressedExceptSpecials(InputController.ACTION_LEFT);
            this.attackHoldingCondittion = controller.holdedExceptSpecials(InputController.ACTION_LEFT);
            this.slamFrontToBack = controller.pressedExceptSpecials(InputController.ACTION_RIGHT);
        }
        
        if (InputController.useSor2Controlls)
        {
            this.attackHoldingCondittion = false;
            slamFrontToBack = controller.pressed(InputController.ACTION_ATTACK);
            if (state != 39){
                if (this.direction == 0){
                    slamFrontToBack &= controller.holded(InputController.ACTION_LEFT);
                }else {
                    slamFrontToBack &= controller.holded(InputController.ACTION_RIGHT);
                }
            }
        }
        
        if (this.ab) {
            if (this.slamFrontToBack) {
                this.comboState = 0;
                this.nextState = 0;
                this.comboResetTimer = 0;
            } else if (this.comboResetTimer > 0) {
                if (--this.comboResetTimer == 0) {
                    this.comboState = 0;
                } else {
                    switch (this.comboState) {
                        case 23:
                            if (controller.pressed( // 2138112
                                    (InputController.useSor2Controlls ? 0 : InputController.ACTION_UP)
                                    | (InputController.useSor2Controlls ? 0 : InputController.ACTION_DOWN)
                                    | InputController.ACTION_ATTACK
                                )
                                || (!InputController.useSor2Controlls && (controller.holded(
                                        InputController.ACTION_UP
                                        | InputController.ACTION_DOWN
                                ) || this.attackHoldingCondittion))) {
                                this.nextState = 24;
                            }
                            altComboPress = 0;
                            break;
                        case 24:
                            checkSor2AltCombo();
                            
                            if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                     && (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP) || altComboPress == 1)
                            ) {
                                this.nextState = 27;
                            } else  if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                    && (controller.holded(InputController.ACTION_DOWN) || controller.pressed(InputController.ACTION_DOWN) || altComboPress == 2)
                            ) {
                                this.nextState = 30;
                            } else if (controller.pressed(InputController.ACTION_ATTACK) || this.attackHoldingCondittion) {
                                this.nextState = 25;
                            }
                            break;
                        case 25:
                            checkSor2AltCombo();
                            
                            if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                    && (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP) || altComboPress == 1)
                            ) {
                                this.nextState = 27;
                            } else if (controller.pressed(InputController.ACTION_ATTACK) || this.attackHoldingCondittion) {
                                this.nextState = 26;
                            }
                            break;
                        case 27:
                            checkSor2AltCombo();
                            
                            if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                    && (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP) || altComboPress == 1)
                            ) {
                                this.nextState = 29;
                            } else if (controller.pressed(InputController.ACTION_ATTACK) || this.attackHoldingCondittion) {
                                this.nextState = 26;
                            }
                            break;
                    }
                }
            }
        }
        switch (this.state) {
            case 0:
                if ((this.stateFlags & INVINCIBILITY_FLAG) != 0) {
                    this.stateFlags &= ~INVINCIBILITY_FLAG;
                    this.setState(1);
                    break;
                }
                this.setState(3);
            /* fall through */
            case 3:
                this.A = 0;
                this.B = 0;
                if (this.q > 0) {
                    this.q--;
                    break;
                }
                if (main.GameManager.k > 0) {
                    break;
                }
                if (this.nextState != 0) {
                    this.setState(this.nextState);
                    break;
                }
                if (this.comboCounter != 0
                    && ((!InputController.useSor2Controlls && controller.e(InputController.ACTION_DOWN))
                        || (InputController.useSor2Controlls && controller.holded(InputController.ACTION_JUMP) && controller.holded(InputController.ACTION_ATTACK))
                       )
                ) {
                    this.dropWeapon(); // drop weapon
                    break;
                }
                if (controller.pressed(InputController.ACTION_ATTACK)) {
                    if (this.comboCounter == 0) {
                        this.setState(23);
                    } else if (this.comboCounter == 1) {
                        this.setState(34);
                    } else if (this.comboCounter == 2) {
                        this.setState(35);
                    } else {
                        this.setState(36);
                    }
                    break;
                }
                if (controller.pressed(InputController.ACTION_JUMP)) {
                    this.setState(28);
                    break;
                }
                if (controller.holded(
                        InputController.ACTION_UP
                        | InputController.ACTION_DOWN
                        | InputController.ACTION_LEFT
                        | InputController.ACTION_RIGHT
                    ) // 61440
                ){ // any walk direction
                    this.state = 4;
                    this.c(1);
                }
                if (this.state != 4) {
                    break;
                }
            /* fall through */
            case 4:
                if (main.GameManager.k > 0) {
                    this.setState(3);
                } else if (this.position.y == 0) {
                    if (this.nextState != 0) {
                        this.setState(this.nextState);
                    } else {
                        if (controller.holdedExceptSpecials(InputController.ACTION_RIGHT)) {
                            this.direction = 0;
                        } else if (controller.holdedExceptSpecials(InputController.ACTION_LEFT)) {
                            this.direction = 1;
                        }
                        if (controller.pressed(InputController.ACTION_ATTACK)) {
                            if (this.comboCounter == 0) {
                                this.setState(23);
                            } else if (this.comboCounter == 1) {
                                this.setState(34);
                            } else if (this.comboCounter == 2) {
                                this.setState(35);
                            } else {
                                this.setState(36);
                            }
                        } else if (controller.pressed(InputController.ACTION_JUMP) && !this.ab) {
                            this.setState(28);
                        } else if (!controller.holded(
                                InputController.ACTION_UP
                                | InputController.ACTION_DOWN
                                | InputController.ACTION_LEFT
                                | InputController.ACTION_RIGHT
                            ) // 61440
                        ) {
                            this.setState(3);
                        } else {
                            if (controller.holded(InputController.ACTION_RIGHT)) {
                                this.position.x += 24576;
                                this.direction = 0;
                            } else if (controller.holded(InputController.ACTION_LEFT)) {
                                this.position.x += -24576;
                                this.direction = 1;
                            }
                            if (controller.holded(InputController.ACTION_DOWN)) {
                                this.position.z += 14745;
                            } else if (controller.holded(InputController.ACTION_UP)) {
                                this.position.z += -14745;
                            }
                        }
                    }
                }
                break;
            case 1:
            case 2:
                controller.resetInput();
                if (this.checkAndUpdateIfReachedTargetPosition()) {
                    this.state = -1;
                    this.setState(3);
                }
                break;
            case 5:
                this.p = 10;
                if (this.loopMovement) {
                    this.canPerformSpecial = true;
                    this.n = 0;
                    this.setState(3);
                }
                break;
            case 6:
                if (this.currAnimFrame > 3) {
                    this.state = -1;
                    this.setState(3);
                }
                break;
            case 14:
                this.canPerformSpecial = false;
                this.L(this);
                break;
            case 12:
            case 13:
            case 17:
                this.L(this);
                break;
            case 15:
                if (this.y == 2 && this.position.y == 0) {
                    if (this.currAnimFrame > 16) {
                        this.g.x = 0;
                    }
                    if (this.currAnimFrame == 13) {
                        main.Blaze.k();
                        main.Blaze.playSound(5);
                        this.g(-16);
                    }
                } else if (this.y == 6) {
                    if ((this.currAnimFrame == 13 || this.currAnimFrame == 14)
                            && ((!InputController.useSor2Controlls && controller.pressedExceptSpecials(InputController.ACTION_UP))
                             || (InputController.useSor2Controlls && controller.holded(InputController.ACTION_JUMP) && controller.holded(InputController.ACTION_UP)))
                    ) {
                        this.position.x += this.I.x;
                        this.setState(33);
                        break;
                    }
                    if (this.u == 16) {
                        this.applyDamage(this.damage);
                        main.Blaze.k();
                        main.Blaze.playSound(5);
                        this.g(java.lang.Math.abs(this.I.x) >> 12);
                    }
                }
                if (this.loopMovement) {
                    if (this.y == 6) {
                        this.position.x += this.I.x;
                    }
                    if (this.energy <= 0) {
                        this.setState(14);
                    } else if (this.y != 1) {
                        this.setState(5);
                    } else {
                        this.setState(3);
                    }
                }
                break;
            case 18:
                this.canPerformSpecial = false;
                if ((this.currAnimFrame == 8 || this.currAnimFrame == 9)
                        && controller.pressedExceptSpecials(InputController.ACTION_UP)) {
                    this.setState(33);
                } else {
                    this.L(this);
                }
                break;
            case 33:
                if (this.loopMovement) {
                    this.setState(3);
                }
                break;
            case 19:
                this.canPerformSpecial = false;
                this.L(this);
                break;
            case 47:
                this.canPerformSpecial = false;
                if (main.GameManager.currentLevel == 6) {
                    this.H();
                }
                if (this.currAnimFrame == 6) {
                    main.GameManager.e();
                    main.Blaze.addPlayerScore(playerId, this.attackMoveScore);
                }
                if (this.grabbedObject != null && this.grabbedObject.energy > 0) {
                    this.grabbedObject.position.set(this.position);
                }
                if (this.loopMovement) {
                    this.setState(3);
                }
                break;
            case 31:
                this.canPerformSpecial = false;
                if (this.u == 2) {
                    main.Blaze.playSound(46);
                }
                this.x = 2;
                this.e(0);
                if (this.u > 4 && this.u < 12) {
                    this.g.x = this.direction == 0 ? -12288 : 12288;
                } else {
                    this.g.x = 0;
                }
                if (this.loopMovement) {
                    this.setState(3);
                    this.q = 4;
                }
                break;
            case 32:
                if (this.loopMovement) {
                    this.setState(3);
                    this.q = 10;
                }
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27: {
                int i = 0;
                if (this.state == 25 && this.u > 2) {
                    i = 1;
                } else if (this.state == 26 && this.u > 3) {
                    this.x = 2;
                    this.T = main.GameManager.currentDifficulty == 0 ? 1400 : 1000;
                    i = 1;
                } else if (this.state == 27 && this.u > 5) {
                    this.x = 2;
                    i = 1;
                }
                this.e(i);
                if (this.loopMovement) {
                    if (this.nextState != 0) {
                        this.setState(this.nextState);
                    } else {
                        if (this.state == 26) {
                            this.q = 4;
                        }
                        this.setState(3);
                    }
                }
                break;
            }
            case 28:
                if (this.w <= 0) {
                    this.e(0);
                    if (this.u == 6) {
                        main.Blaze.playSound(45);
                    }
                    if (this.currAnimFrame == 12) {
                        this.N = 8;
                        this.stateFlags &= ~0x10000;
                    }
                    if (this.currAnimFrame == 13) {
                        this.d(10, 0, 0);
                    }
                    this.g.x = this.g.x * 93 / 100;
                    if (this.u == 3) {
                        this.g.x = this.direction == 0 ? 45056 : -45056;
                    } else if (this.u > 12) {
                        this.g.x = 0;
                    }
                    if (this.loopMovement) {
                        this.setState(37);
                    }
                }
                break;
            case 29:
                if (this.w <= 0) {
                    this.e(0);
                    this.x = 1;
                    this.T = 500;
                    if (this.currAnimFrame == 12) {
                        this.N = 8;
                        this.stateFlags &= ~0x10000;
                    }
                    if (this.u > 7) {
                        this.d(24, 0, 0);
                    }
                    this.e(this.u);
                    if (this.u > 7) {
                        this.T = 1000;
                        this.x = 2;
                    } else if (this.u == 1) {
                        this.T = 1000;
                        this.x = 2;
                    }
                    this.g.x = this.g.x * 81 / 100;
                    if (this.u == 1) {
                        this.g.x = this.direction == 0 ? 110592 : -110592;
                    }
                    if (this.loopMovement) {
                        this.setState(3);
                        this.q = 6;
                        this.g.x = 0;
                    }
                }
                break;
            case 42:
            case 43:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.ab = true;
                    this.o = 2;
                    this.grabbedObject.p = 2;
                    if (this.currAnimFrame == 2) {
                        this.grabbedObject.p = 0;
                        this.grabbedObject.onAttackContact(this, this.A, 4, this.direction, this.T);
                        main.Blaze.addPlayerScore(playerId, this.attackMoveScore);
                        main.Blaze.playSound(57);
                        main.Blaze.k();
                        this.grabbedObject.c(0, 0, 48);
                    }
                    if (this.loopMovement) {
                        if (this.nextState != 0) {
                            this.setState(this.nextState);
                        } else {
                            this.setState(38);
                        }
                    }
                }
                break;
            case 44:
                if (this.currAnimFrame == 9 && this.grabbedObject != null) {
                    this.grabbedObject.onAttackContact(this, this.A, 2, this.direction, this.T);
                    main.Blaze.addPlayerScore(playerId, this.attackMoveScore);
                    this.grabbedObject.D = true;
                    main.Blaze.playSound(this.soundToPlayOnContact);
                    this.grabbedObject.c(0, 0, 50);
                    main.Blaze.l();
                }
                if (this.loopMovement) {
                    this.setState(3);
                    this.q = 8;
                }
                break;
            case 45:
                this.canPerformSpecial = false;
                if (main.GameManager.currentLevel == 6) {
                    this.H();
                }
                if (this.loopMovement) {
                    this.releaseGrabbedObj();
                    this.setState(3);
                }
                break;
            case 38:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.o = 2;
                    this.grabbedObject.p = 2;
                    if (this.grabbedObject.objectType == 3) {
                        if (controller.pressed(InputController.ACTION_LEFT)) {
                            this.direction = 0;
                        } else if (controller.pressed(InputController.ACTION_RIGHT)) {
                            this.direction = 1;
                        }
                    }
                    this.a(true);
                    if (this.grabbedObject.objectType == 3) {
                        if (this.currAnimFrame > 3 && controller.pressed(
                                InputController.ACTION_JUMP
                                | InputController.ACTION_LEFT
                                | InputController.ACTION_RIGHT
                                | InputController.ACTION_ATTACK
                            ) // 2117633
                        ) {
                            this.setState(46);
                        }
                    } else if ((controller.pressed(InputController.ACTION_ATTACK) && (!InputController.useSor2Controlls || !slamFrontToBack))
                            || (!InputController.useSor2Controlls && (this.grabAttack || this.currAnimFrame > 3 && this.attackHoldingCondittion))
                    ) { // press attack
                        if (this.grabComboCount == 0) {
                            this.setState(42); // knee 1
                        } else if (this.grabComboCount == 1) {
                            this.setState(43); // knee 2
                        } else {
                            this.setState(44); // grab combo end
                        }
                    } else if (controller.pressed(
                            (InputController.useSor2Controlls ? 0 : InputController.ACTION_UP)
                            | InputController.ACTION_JUMP // custom code
                        )
                    ) { // press up
                        this.setState(40); // Vault from front
                    } else if (this.slamFrontToBack) {
                        this.setState(45);
                    } else if (controller.e(InputController.ACTION_DOWN)) {
                        this.releaseGrabbedObj();
                        this.setState(3);
                        this.q = 9;
                    }
                }
                break;
            case 39:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.o = 2;
                    this.grabbedObject.p = 2;
                    this.a(false);
                    if (this.slamFrontToBack) {
                        this.setState(47);
                    } else if (controller.pressed(
                            (InputController.useSor2Controlls ? 0 : InputController.ACTION_UP)
                            | InputController.ACTION_JUMP // custom code
                        )
                    ){
                        this.setState(41); // vault from back
                    } else if (controller.e(InputController.ACTION_DOWN)) {
                        this.releaseGrabbedObj();
                        this.setState(3);
                        this.q = 6;
                    }
                }
                break;
            case 40:
                this.canPerformSpecial = false;
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.a(true);
                    if (this.loopMovement) {
                        this.direction ^= 0x1;
                        ++vaultCount;
                        this.setState(39);
                    }
                }
                break;
            case 41:
                this.canPerformSpecial = false;
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.a(false);
                    if (this.loopMovement) {
                        this.direction ^= 0x1;
                        main.Point var_q = this.position;
                        var_q.x = var_q.x + (this.direction == 0 ? -81920 : 81920);
                        this.position.z = this.grabbedObject.position.z;
                        ++vaultCount;
                        this.setState(38);
                    }
                }
                break;
            case 46:
                if (this.currAnimFrame > 5) {
                    this.setState(3);
                    this.q = 4;
                }
                break;
            case 34:
            case 35:
            case 36:
                this.e(0);
                if (this.loopMovement) {
                    this.setState(3);
                    this.q = 4;
                }
                break;
            case 37:
                this.canPerformSpecial = false;
                if (this.currAnimFrame > 3) {
                    this.setState(3);
                    this.q = 4;
                }
                break;
        }
        if ((this.stateFlags & 0x400000) != 0) {
            this.canPerformSpecial = false;
        }
        if (main.MainCanvas.mainState != 14 && main.MainCanvas.mainState != 5) {
            this.canPerformSpecial = false;
        }
        if (this.canPerformSpecial && this.q < 2 && this.energy > this.aj
                && controller.pressed(InputController.ACTION_DEF_SPECIAL)) {
            this.setState(31);
        }
        if (this.state == 4 || this.state == 3 || this.state == 23) {
            int i;
            if ((i = this.checkGrab(81920, 81920, 0)) == 1) { // Check grab, == 1 means grab from front, 2 means grab from back
                this.grabComboCount = 0;
                this.setState(38);
            } else if (i == 2) {
                this.grabComboCount = 0;
                this.setState(39);
            }
        }
        super.i();
        this.h();
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
        switch (this.t) {
            case 0:
            case 1:
            case 40:
                if (this.comboCounter != 0) {
                    this.r.a(2020793310, this.u, this.ag);
                    if (this.ah != null) {
                        if (this.comboCounter == 1) {
                            main.Blaze var_k_6_;
                            (var_k_6_ = this).ah.a(var_k_6_.ai[0]);
                            var_k_6_.ah.b = var_k_6_.direction == 0 ? 0 : 65536;
                            if (var_k_6_.t == 0) {
                                var_k_6_.ah.a(1);
                            } else {
                                var_k_6_.ah.a(2);
                            }
                        } else if (this.comboCounter == 2) {
                            main.Blaze var_k_7_;
                            (var_k_7_ = this).ah.a(var_k_7_.ai[0]);
                            var_k_7_.ah.a(3);
                            if (var_k_7_.t == 0) {
                                var_k_7_.ah.b = var_k_7_.direction == 0 ? 65536 : 0;
                            } else {
                                var_k_7_.ah.b = var_k_7_.direction == 0 ? 0 : 65536;
                            }
                        } else {
                            main.Blaze var_k_8_;
                            (var_k_8_ = this).ah.a(var_k_8_.ai[1]);
                            var_k_8_.ah.a(4);
                            var_k_8_.ah.b = var_k_8_.direction == 0 ? 65536 : 0;
                        }
                        this.ah.a(this.position.x + this.ag.x, this.position.z + this.ag.y,
                                this.position.y);
                        this.ah.c = this.r.c;
                        main.ar.addElementToVector1(this.ah);
                    }
                }
                break;
            case 10:
            case 12:
            case 26:
            case 27:
                this.r.a(2020793310, this.u, this.I);
                break;
        }
    }

    public final void checkHammerSmash() {
        int i = 81920;
        boolean bool = false;
        if (this.state == 31) {
            i = 196608;
        } else if (this.state == 29 || this.state == 27) {
            i = 98304;
        }
        if (this.o == 0) {
            this.h();
            for (int i_9_ = 0; i_9_ < main.GameManager.collidableObjects.size();
                    i_9_++) {
                main.AbstractObject var_af;
                if (((var_af = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_9_))).stateFlags
                        & 0xe00) != 0
                        && this.a(var_af, i)) {
                    main.Blaze.addPlayerScore(playerId, this.attackMoveScore);
                    if (this.state == 31) {
                        if (!this.ak) {
                            this.ak = true;
                            if (this.energy > this.aj) {
                                this.energy -= this.aj;
                            }
                        }
                        var_af.onAttackContact(this, this.A, this.x, this.getDirectionTowardObject(var_af), this.T);
                        var_af.c(0, 0, 48);
                        var_af.a(5, 5, 48, 1);
                        this.c(3, 3, 48);
                        this.a(32, 0, 48, 0);
                        main.GameManager.d();
                        this.ab = false;
                        this.w = 3;
                        break;
                    }
                    boolean bool_10_ = true;
                    if (!bool) {
                        main.Blaze.playSound(this.soundToPlayOnContact);
                        bool = true;
                    }
                    if (this.state == 27) {
                        if (this.currAnimFrame < 6) {
                            var_af.onAttackContact(this, this.A, this.x, this.direction, this.T);
                            this.c(40, 0, 16);
                        } else {
                            var_af.onAttackContact(this, this.A, this.x, this.direction == 0 ? 1 : 0,
                                    this.T);
                            this.c(-40, 0, 16);
                        }
                    } else {
                        var_af.onAttackContact(this, this.A, this.x, this.direction, this.T);
                        var_af.c(0, 0, 48);
                    }
                    this.ab = true;
                    main.Blaze.k();
                    if (this.state == 29 && this.currAnimFrame < 4) {
                        bool_10_ = false;
                    } else if (this.state == 34) {
                        bool_10_ = false;
                    }
                    if (bool_10_ && this.w == 0) {
                        this.w = 2;
                    }
                }
            }
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_11_,
            int i_12_, int i_13_) {
        if (i_13_ != 0) {
            this.dropWeapon();
        }
        if ((this.stateFlags & 0x10000) != 0 && this.currAnimFrame > 2 && this.currAnimFrame < 14) {
            i_11_ = 2;
        }
        int i_14_;
        if ((i_14_ = this.onBeingAttacked(var_af, i, i_11_, i_12_, i_13_)) > 0) {
            this.setState(i_14_);
        }
    }

    public final boolean d() {
        if (this.p > 0 || this.G) {
            return false;
        }
        switch (this.state) {
            case 3:
            case 4:
            case 23:
                return true;
            default:
                return false;
        }
    }

    public final void e() {
        if (this.N() && this.state != 15) {
            if (this.y == 6) {
                this.position.x += this.I.x;
            }
            this.setState(15);
        }
    }

    public final void clearData() {
        this.clearAbstractData();
        if (this.ah != null) {
            this.ah = null;
        }
        this.ag = null;
        this.ai = null;
        this.I = null;
    }
}
