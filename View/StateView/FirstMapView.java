package View.StateView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import Model.GameModel.GameModel;
import Model.StateModel.FirstMapModel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirstMapView {
    GameModel Mf;
    FirstMapModel firstMapModel;
    View.TileView.TileManager tileManager;
    // TilePanel tilePanel;

    JLayeredPane layeredPane;
    public FirstMapView(GameModel Mf, FirstMapModel firstMapModel) {
        this.Mf = Mf;
        this.firstMapModel = firstMapModel;

        tileManager = new View.TileView.TileManager(Mf);
        View.TileView.TilePanel tilePanel = new View.TileView.TilePanel(Mf, tileManager);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());


        // set up panel
        firstMapModel.getFirstMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        firstMapModel.getFirstMapPanel().setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());
        firstMapModel.getFirstMapPanel().setLayout(null);

        // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel();
        background.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeight());
        // Thêm JLabel vào content pane với BorderLayout
       // firstMapModel.getFirstMapPanel().add(background);

        // Tạo một JPanel để chứa các thành phần khác
        firstMapModel.getChildFirstMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        firstMapModel.getChildFirstMapPanel().setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        firstMapModel.getChildFirstMapPanel().setOpaque(false);

        // Set size cho các obj
        for (int i = 0; i < firstMapModel.getN(); i++) {
            this.firstMapModel.getObj()[i] = new JLabel();
            this.firstMapModel.getObj()[i].setSize(15, 15);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);

        // Set hình nền cho trái tim, set up trái tim
        this.firstMapModel.getHeart().setSize(20, 20);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon newImageIconHeart = new ImageIcon(newImageHeart);
        this.firstMapModel.getHeart().setIcon(newImageIconHeart);

        for (int i = 0; i < firstMapModel.getN(); i++) {
            this.firstMapModel.getObj()[i].setIcon(newImageIcon);
        }

        // Đặt vị trí của các obj trên background
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap1.txt")));
            int i = 0; // Sử dụng biến i để xác định vị trí của mỗi JLabel trong mảng obj[]
            while (sc.hasNextInt()) {
                int p = sc.nextInt();
                int q = sc.nextInt();

                if (i < firstMapModel.getN()) { // Đảm bảo rằng i không vượt quá số lượng JLabel trong mảng obj[]
                    firstMapModel.getX()[i] = p;
                    firstMapModel.getY()[i] = q;
                    i++; // Tăng biến i lên để đến JLabel tiếp theo trong mảng obj[]
                }
            }
            sc.close(); // Đóng luồng sau khi sử dụng xong.
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // In ra lỗi nếu tệp tin không được tìm thấy
        }
// add obj vào map
        for (int i = 0; i < firstMapModel.getN(); i++) {
            firstMapModel.getObj()[i].setLocation(firstMapModel.getX()[i], firstMapModel.getY()[i]); // Thiết lập vị trí
                                                                                                     // của JLabel thứ i
            firstMapModel.getChildFirstMapPanel().add(firstMapModel.getObj()[i]); // Thêm JLabel vào childFirstMapPanel
            firstMapModel.setAddObj(true, i);
        }

        // Thêm trái tim vào map
        this.firstMapModel.getHeart().setLocation(firstMapModel.getHeartXLocation(), firstMapModel.getHeartYLocation());
        firstMapModel.getChildFirstMapPanel().add(firstMapModel.getHeart());
        firstMapModel.setAddHeart(true);
        tilePanel.add(firstMapModel.getChildFirstMapPanel());

        // *****************************************************/
        firstMapModel.getMapLabel().setFont(new Font("Arial", Font.BOLD, 45));
        firstMapModel.getMapLabel().setForeground(Color.BLACK);
        firstMapModel.getMapLabel()
                .setPreferredSize(new Dimension(firstMapModel.getMapLabel().getPreferredSize().width + 20,
                        firstMapModel.getMapLabel().getPreferredSize().height));
        int labelX = (Mf.getJframeWidth() - firstMapModel.getMapLabel().getPreferredSize().width) / 2;
        int labelY = (Mf.getJframeHeight() - firstMapModel.getMapLabel().getPreferredSize().height) / 2;
        firstMapModel.getMapLabel().setBounds(labelX, labelY, firstMapModel.getMapLabel().getPreferredSize().width,
                firstMapModel.getMapLabel().getPreferredSize().height);
        firstMapModel.getChildFirstMapPanel().add(firstMapModel.getMapLabel());
        
        firstMapModel.getChildFirstMapPanel().setOpaque(false);
        tilePanel.setBounds(0,0,615,615);
        // tilePanel.setVisible(true);
        // tilePanel.setOpaque(true);

        
        layeredPane.add(firstMapModel.getChildFirstMapPanel());
        layeredPane.add(tilePanel);
        
        firstMapModel.getFirstMapPanel().add(layeredPane);
        // Thêm lắng nghe sự kiện MouseListener vào JLabel background
        tilePanel.addMouseListener(new MyMouseListener());
    }
     // Lớp lắng nghe sự kiện MouseListener
     class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Lấy tọa độ x và y của sự kiện click chuột
            int x = e.getX();
            int y = e.getY();
            // In tọa độ x và y ra màn hình
            System.out.println("X: " + x + ", Y: " + y);
        }

        // Các phương thức khác của MouseListener không được sử dụng trong trường hợp này
        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
