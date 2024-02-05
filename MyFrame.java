import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
    JLayeredPane mixMap;
    //Tạo các object để sử dụng các panel ,button,... trong class khác
    Intro intro=new Intro();
    Trailer trailer=new Trailer();
    FirstMap firstMap=new FirstMap();
    SecondMap secondMap=new SecondMap();
    ThirdMap thirdMap=new ThirdMap();


    MyFrame(){
        //setup trộn giữa các trang
        mixMap=new JLayeredPane();
        mixMap.setBounds(0, 0, 615, 615);
        mixMap.add(thirdMap.thirdMapPanel);
        mixMap.add(secondMap.secondMapPanel);
        mixMap.add(firstMap.firstMapPanel);
        mixMap.add(trailer.trailerPanel);
        mixMap.add(intro.introPanel);
        
        
        
        // setup Jframe
        ImageIcon logo=new ImageIcon("./picture/logo.jpg");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615,615);
        this.setTitle("Journey to Adulthood");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(mixMap);
        this.setVisible(true);
    }



    
    // Code sự kiện nhấn nút
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
