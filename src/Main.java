import Entities.GUI.StartPage;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /************** Pledge of Honor ******************************************
         I hereby certify that I have completed this programming project on my own
         without any help from anyone else. The effort in the project thus belongs
         completely to me. I did not search for a solution, or I did not consult any
         program written by others or did not copy any program from other sources. I
         read and followed the guidelines provided in the project description.
         READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
         SIGNATURE: <Kerem Burak Yılmaz, 83349>
         *************************************************************************/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new StartPage();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}