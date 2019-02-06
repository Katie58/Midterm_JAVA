package midterm;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MusicClass {
	
	public static void playCorrectSound() {
		try {
	
		    File file = new File("soundFolder/happykids.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info; 
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format); 
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    System.out.println("Something went wrong");
		    e.printStackTrace();
		}
	}
	
	public static void playWinSound() {
		try {
	
		    File file = new File("soundFolder/Home_Run.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info; 
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format); 
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    System.out.println("Something went wrong");
		    e.printStackTrace();
		}
	}
	
	public static void playWrongSound() {
		try {
	
		    File file = new File("soundFolder/groans.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info; 
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format); 
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    System.out.println("Something went wrong");
		    e.printStackTrace();
		}
	}
	
	public static void playLoseSound() {
		try {
	
		    File file = new File("soundFolder/boooo.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info; 
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format); 
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    System.out.println("Something went wrong");
		    e.printStackTrace();
		}
	}
}
