package Controller;
import java.net.URL;
import javax.sound.sampled.*;
public class Sound {
Clip clip;
float pVol;
float cVol;
FloatControl fc;
boolean mute=false;
public void setFile(URL url) {
	try {
		AudioInputStream sound = AudioSystem.getAudioInputStream(url);
		clip = AudioSystem.getClip();
		clip.open(sound);
		fc=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void play(URL url) {

	clip.start();
}
public void stop (URL url) {
	clip.stop();
	fc.setValue(3.0f);
}
}
