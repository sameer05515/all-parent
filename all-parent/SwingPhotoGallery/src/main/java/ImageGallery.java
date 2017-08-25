import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageGallery extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	File f=new File("F:/PREM-BACKUP/Vadhu-Agman/");
	
	
	
    private ImageIcon myImage1 = new ImageIcon ("F:/PREM-BACKUP/Vadhu-Agman/DSC_0031.JPG");
    private ImageIcon myImage2 = new ImageIcon ("F:/PREM-BACKUP/Vadhu-Agman/DSC_0032.JPG");
    private ImageIcon myImage3 = new ImageIcon ("F:/PREM-BACKUP/Vadhu-Agman/DSC_0033.JPG");
    private ImageIcon myImage4 = new ImageIcon ("F:/PREM-BACKUP/Vadhu-Agman/DSC_0034.JPG");
    JPanel ImageGallery = new JPanel();
    private ImageIcon[] myImages = new ImageIcon[4];
    private int curImageIndex=0;

    public ImageGallery ()
        {   
            ImageGallery.add(new JLabel (myImage1));
            myImages[0]=myImage1;
            myImages[1]=myImage2;
            myImages[2]=myImage3;
            myImages[3]=myImage4;

            add(ImageGallery, BorderLayout.NORTH);

            JButton PREVIOUS = new JButton ("Previous");
            JButton PLAY = new JButton ("Play");
            JButton STOP = new JButton ("Stop");
            JButton NEXT = new JButton ("Next");

            JPanel Menu = new JPanel();
            Menu.setLayout(new GridLayout(1,4));
            Menu.add(PREVIOUS);
            Menu.add(PLAY);
            Menu.add(STOP);
            Menu.add(NEXT);

            add(Menu, BorderLayout.SOUTH);

            //register listener
            PreviousButtonListener PreviousButton = new PreviousButtonListener ();
            PlayButtonListener PlayButton = new PlayButtonListener ();
            StopButtonListener StopButton = new StopButtonListener ();
            NextButtonListener NextButton = new NextButtonListener ();

            //add listeners to corresponding componenets 
            PREVIOUS.addActionListener(PreviousButton);
            PLAY.addActionListener(PlayButton);
            STOP.addActionListener(StopButton);
            NEXT.addActionListener(NextButton);

        }

    public static void main (String [] args)
        {
            ImageGallery frame = new ImageGallery();

            frame.setSize(490,430);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
        }



    class PreviousButtonListener implements ActionListener 
    {

        @SuppressWarnings("serial")
		public void actionPerformed(ActionEvent e)
            {
                if(curImageIndex>0 && curImageIndex <= 3)
                    {   ImageGallery.remove(0);
                        curImageIndex=curImageIndex-1;
                        final ImageIcon TheImage= myImages[curImageIndex];
//                        final Image
                        ImageGallery.add(new JLabel (TheImage){
                        	 @Override
                        	    public void paintComponent (Graphics g) {
                        	        super.paintComponent (g);
                        	        g.drawImage (TheImage.getImage(), 0, 0, getWidth (), getHeight (), null);
                        	    }
                        });
                        ImageGallery.validate();
                        ImageGallery.repaint(); 
                    }
                else 
                    {   
                        ImageGallery.remove(0);
                        ImageGallery.add(new JLabel (myImage1));
                        curImageIndex=0;
                        ImageGallery.validate();
                        ImageGallery.repaint();
                    }
            }
    }

    class PlayButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
            {
                        // *need help here*//

            }
    }

    class StopButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
            {
                        // *need help here*//
            }
    }

    class NextButtonListener implements ActionListener 
    {


        public void actionPerformed(ActionEvent e)
        {

            if(curImageIndex>=0 && curImageIndex < 3)
                {   ImageGallery.remove(0);
                    curImageIndex = curImageIndex + 1;
                    ImageIcon TheImage= myImages[curImageIndex];
                    ImageGallery.add(new JLabel (TheImage));
                    ImageGallery.validate();
                    ImageGallery.repaint(); 
                }
            else 
                {   
                    ImageGallery.remove(0);
                    ImageGallery.add(new JLabel (myImage4));
                    curImageIndex=3;
                    ImageGallery.validate();
                    ImageGallery.repaint();
                }

        }
    }
}