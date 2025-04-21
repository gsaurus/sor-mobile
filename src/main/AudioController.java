/* f - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public final class AudioController {

    private static int mainVolume;
    private static javax.microedition.media.Player midiPlayer = null;
    private static java.util.Hashtable soundsTable;
    private static int currentLevelMusicPlaying = -1;
    private static int midiLoopTimes;
    private static int soundLoopCount;
    public static java.lang.String[] midiFileNames
            = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13"};
    public static java.lang.String[] soundFileNames
            = {"00", null, null, "00", "57", "05", null, null, null, "29", null,
                null, "00", "60", null, null, null, null, null, "60", null, null,
                null, null, null, "25", null, null, null, "29", "29", "29", "29",
                null, "29", "29", null, null, null, null, null, "41", null, "43",
                null, null, "46", "47", "48", "49", null, "51", null, null, null,
                null, null, "57", null, "57", "60"
            };
    
    // No idea what this class object is for...
    private static java.lang.Class someClassKind;

    public static void loadSounds(java.lang.String[] soundNames) {
        if (soundsTable == null) {
            soundsTable = new java.util.Hashtable(10);
            for (int i = 0; i < soundNames.length; i++) {
                if (soundNames[i] != null && !soundsTable.containsKey(soundNames[i])) {
                    main.MainCanvas.displayLoadingScreen();
                    try {
                        java.lang.Class var_class = main.AudioController.someClassKind;
                        if (var_class == null) {
                            java.lang.Class var_class_0_;
                            try {
                                var_class_0_ = java.lang.Class.forName("java.lang.Object");
                            } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                                java.lang.NoClassDefFoundError noclassdeffounderror = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                                throw noclassdeffounderror;
                            }
                            var_class = main.AudioController.someClassKind = var_class_0_;
                        }
                        javax.microedition.media.Player player;
                        (player = (javax.microedition.media.Manager.createPlayer(
                                var_class.getResourceAsStream("/se" + soundNames[i] + ".wav"), "audio/x-wav")
                                )
                        ).realize();
                        player.prefetch();
                        soundsTable.put(soundNames[i], player);
                    } catch (java.lang.Exception exception) {
                        java.lang.Exception exception_1_;
                        (exception_1_ = exception).printStackTrace();
                    }
                }
            }
        }
    }

    public static void loadLevelMidi(int level, boolean repeatForever) {
        if ((currentLevelMusicPlaying == level) && (midiPlayer != null)) {
            midiLoopTimes = repeatForever ? -1 : 1;
            return;
        }
        closeMidiPlayer();
        try {
            midiLoopTimes = repeatForever ? -1 : 1;
            currentLevelMusicPlaying = level;
            if (mainVolume == 0) {
                return;
            }
            Class tmp55_52 = someClassKind;
            if (tmp55_52 == null) {
                try {
                    main.AudioController.someClassKind = Class.forName("java.lang.Object");
                } catch (ClassNotFoundException localClassNotFoundException) {
                    throw localClassNotFoundException;
                }
            }
            midiPlayer = Manager.createPlayer(tmp55_52.getResourceAsStream("/bgm" + midiFileNames[level] + ".mid"), "audio/midi");
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public static void playSound(int soundNum, int unusedParameter) {
        if ((mainVolume == 0) || (soundFileNames[soundNum] == null)) {
            return;
        }
        try {
            Player player = (Player) soundsTable.get(soundFileNames[soundNum]);
            if (player.getState() == 400) {
                return;
            }
            VolumeControl ctrl = (VolumeControl) player.getControl("VolumeControl");
            soundLoopCount = 1;
            player.setLoopCount(soundLoopCount);
            player.start();
            ctrl.setLevel(mainVolume);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public static void closeMidiPlayer() {
        if (midiPlayer != null) {
            midiPlayer.close();
            midiPlayer = null;
            currentLevelMusicPlaying = -1;
        }
    }

    private static void stopAllSounds() {
        if (soundsTable != null) {
            java.util.Enumeration sounds = soundsTable.elements();
            while (sounds.hasMoreElements()) {
                javax.microedition.media.Player soundPlayer = ((javax.microedition.media.Player) sounds.nextElement());
                try {
                    if (soundPlayer != null && soundPlayer.getState() != 0) {
                        soundPlayer.stop();
                    }
                } catch (java.lang.Exception exception) {
                    /* empty */
                }
            }
        }
    }

    public static void stopAllAudio() {
        main.AudioController.closeMidiPlayer();
        main.AudioController.stopAllSounds();
    }

    public static void stopAllAudioWithoutResetingCurrentLevelMusic() {
        if (midiPlayer != null) {
            midiPlayer.close();
            midiPlayer = null;
        }
        main.AudioController.stopAllSounds();
    }

    public static void reloadLevelMusicIfNotPlaying() {
        if (currentLevelMusicPlaying >= 0) {
            main.AudioController.loadLevelMidi(currentLevelMusicPlaying, midiLoopTimes < 0);
        }
    }

    public static void updateMidiState() {
        if (mainVolume != 0) {
            do {
                if (midiPlayer != null) {
                    try {
                        switch (midiPlayer.getState()) {
                            case 100:
                                midiPlayer.realize();
                                break;
                            case 200:
                                midiPlayer.prefetch();
                                break;
                            case 300:
                                if (midiLoopTimes == 0) {
                                    main.AudioController.closeMidiPlayer();
                                } else {
                                    midiPlayer.setLoopCount(midiLoopTimes < 0 ? -1 : 1);
                                    javax.microedition.media.control.VolumeControl volumecontrol
                                            = ((javax.microedition.media.control.VolumeControl) (java.lang.Object) midiPlayer.getControl("VolumeControl"));
                                    midiPlayer.start();
                                    volumecontrol.setLevel(mainVolume);
                                    midiLoopTimes--;
                                    java.lang.Thread.sleep(50L);
                                    break;
                                }
                                break;
                        }
                    } catch (java.lang.Exception exception) {
                        java.lang.Exception exception_10_;
                        (exception_10_ = exception).printStackTrace();
                        break;
                    }
                    break;
                }
            } while (false);
        }
    }

    public static void setVolume(int newVolume) {
        if (mainVolume != newVolume) {
            mainVolume = newVolume;
            if (mainVolume == 0) {
                main.AudioController.closeMidiPlayer();
                main.AudioController.stopAllSounds();
            } else if (midiPlayer != null && midiPlayer.getState() == 400) {
                // Set midi volume here. Sounds volume is set whenever they're triggered
                javax.microedition.media.control.VolumeControl volumecontrol;
                volumecontrol = ((javax.microedition.media.control.VolumeControl) (java.lang.Object) midiPlayer.getControl("VolumeControl"));
                volumecontrol.setLevel(mainVolume);
            }
        }
    }
}
