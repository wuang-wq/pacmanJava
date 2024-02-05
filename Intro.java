import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;


public class Intro extends JFrame{
    JPanel introPanel;
    JButton Start;
    JButton Exit;
    Intro(){
        //set up panel
        this.setLayout(new BorderLayout());
        introPanel = new JPanel();
        introPanel.setSize(615, 615);
        // introPanel.setOpaque(true);
        introPanel.setLayout(new GridLayout(2, 1));
        //Code phần giao diện
        this.init();
    }

    public void init() {
        // Set font (Có thể set nhiều font với kích thước khác nhau, chỉ cần đặt khác tên đi là được)
        Font font = new Font("Arial", Font.BOLD, 32);


        // Set các thành phần cơ bản cho ứng dụng
        this.setSize(615, 615);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Tạo ra một nút Start và đặt nội dung cho nó là Start
        Start = new JButton("Start");
        Start.setFont(font);

        // Thêm các thành phần vào giao diện chính
        introPanel.add(Start);

        
        // Add thành phần introPanel vào giao diện chính của intro
        this.add(introPanel, BorderLayout.CENTER);

    }
}
