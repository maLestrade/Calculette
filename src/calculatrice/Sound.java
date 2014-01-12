package calculatrice;

import java.io.*;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;


/**
 * 
 * @author mama
 */
public class Sound {

    public Sound(String path) throws Exception {
        InputStream in = getClass().getResourceAsStream(path);
        player = new AdvancedPlayer(in);
    }

    public Sound(String path, PlaybackListener listener) throws Exception {
        InputStream in = (InputStream) new BufferedInputStream(
                new FileInputStream(
                        new File(path)));
        player = new AdvancedPlayer(in);
        player.setPlayBackListener(listener);
        
        //le karaté c'est cool!!
    }

    public void play() throws Exception {
        if (player != null) {
            isPlaying = true;
            player.play();
        }
    }

    public void play(int begin, int end) throws Exception {
        if (player != null) {
            isPlaying = true;
            player.play(begin, end);
        }
    }

    public void stop() throws Exception {
        if (player != null) {
            isPlaying = false;
            player.stop();
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    private boolean isPlaying = false;
    private AdvancedPlayer player = null;
}
