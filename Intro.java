import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;


public class Intro{
    JPanel introPanel;
    JButton Start;
    JButton Exit;
    Intro(){
        //set up panel
        introPanel = new JPanel(null);
        introPanel.setSize(615, 615);
        introPanel.setOpaque(true);
        //Code phần giao diện
        this.init();
    }

    public void init() {
        // Set font (Có thể set nhiều font với kích thước khác nhau, chỉ cần đặt khác tên đi là được)
        Font font = new Font("Arial", Font.BOLD, 16);


        // Set các thành phần cơ bản cho ứng dụng
        introPanel.setVisible(true);

        // Tạo ra một nút Start và đặt nội dung cho nó là Start
        Start = new JButton("Start");
        Start.setFont(font);
        Start.setBounds(50, 300, 100, 50);

        // Làm cho nút trở nên trong suốt
        // Start.setOpaque(false);
        // Start.setContentAreaFilled(false);
        // Start.setBorderPainted(false);

        // Thêm các thành phần vào giao diện chính
        introPanel.add(Start);

    }
}
