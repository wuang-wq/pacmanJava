package State;

import javax.swing.*;
import main.MyFrame;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class ScoreBoard {
    private JTextArea fieldText;
    private JButton Back;
    private JLayeredPane scoreBoard;
    JTable table;
    String[] col;
    String[] textShow = {
        "Nguyen Van Hoan",
        "Pham Hoang Viet",
        "Ngo Van Quang",
        "Dang Quoc Nam",
        "Nguyen Phuong Nam"
    };
    MyFrame Mf;

    public ScoreBoard(MyFrame Mf){
        this.Mf = Mf;
        scoreBoard = new JLayeredPane();

        //set font
        fieldText = new JTextArea();
        Font font = new Font("Arial", Font.BOLD, 13);
        fieldText.setFont(font);
        fieldText.setForeground(Color.BLACK);

        //set vị trí
        fieldText.setBounds(105, 180, 300, 265);
        fieldText.setOpaque(false);
        fieldText.setEnabled(false);

        //set background
        ImageIcon image = new ImageIcon("./picture/Background_ScoreBoard.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());


        // tự động xuống dòng
        fieldText.setLineWrap(true);
        fieldText.setWrapStyleWord(true);   
        
        //khởi tạo nút
        Back = new JButton("Back");

        //set size
        Back.setBounds(Mf.getJframeWidth()-107, Mf.getJframeHeight()-597, 130, 50);
        Back.setForeground(Color.BLACK);
        Back.setOpaque(false);
        Back.setContentAreaFilled(false);
        Back.setBorderPainted(false);
        Back.setFocusable(false);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        Back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Back.setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Back.setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });

        scoreBoard.add(Back);
        scoreBoard.add(fieldText, JLayeredPane.DEFAULT_LAYER);

        scoreBoard.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
        
       }

       

       public JButton getBack(){
        return Back;
       }
       public JLayeredPane getscoreBoard() {
        return scoreBoard;
    }
}


// tên lớp, thành phần dũ liệu, khai báo