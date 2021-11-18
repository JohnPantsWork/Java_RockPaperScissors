package s16_j;

import javax.swing.*;
import java.awt.event.*;

class CLoginF extends JFrame {
    private JFrame frame;

    private JLabel lblPlayer, lblComputer, lblWin, lblLose, lblDraw;
    private JTextField txtResult;
    private JButton btnRock, btnScissors, btnPaper, btnRST;

    private int Draw, Win, Lose;

    private ImageIcon player_icon, computer_icon;
    private ImageIcon icon_rock = new ImageIcon("src\\s16_j\\images\\CStone.gif");
    private ImageIcon icon_paper = new ImageIcon("src\\s16_j\\images\\CPaper.gif");
    private ImageIcon icon_scissors = new ImageIcon("src\\s16_j\\images\\CScissor.gif");

    CLoginF() {

        frame = new JFrame("猜拳遊戲");
        frame.setLayout(null);
        frame.setBounds(100, 100, 300, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblPlayer = new JLabel("按下按鈕猜拳...", player_icon, SwingConstants.CENTER);
        lblPlayer.setBounds(10, 10, 100, 60);
        frame.add(lblPlayer);

        lblComputer = new JLabel("開戰吧人類！", computer_icon, SwingConstants.CENTER);
        lblComputer.setBounds(150, 10, 100, 60);
        frame.add(lblComputer);

        lblWin = new JLabel("玩家贏次數：0");
        lblWin.setBounds(150, 70, 100, 20);
        frame.add(lblWin);

        lblLose = new JLabel("電腦贏次數：0");
        lblLose.setBounds(150, 105, 100, 20);
        frame.add(lblLose);

        lblDraw = new JLabel("平手次數：0");
        lblDraw.setBounds(150, 140, 100, 20);
        frame.add(lblDraw);

        txtResult = new JTextField("五場比賽中...");
        txtResult.setBounds(150, 175, 100, 20);
        txtResult.setEditable(false);
        frame.add(txtResult);

        btnScissors = new JButton("剪刀");
        btnScissors.setBounds(10, 70, 120, 30);
        btnScissors.addActionListener(Listenerbtn);
        frame.add(btnScissors);

        btnRock = new JButton("石頭");
        btnRock.setBounds(10, 105, 120, 30);
        btnRock.addActionListener(Listenerbtn);
        frame.add(btnRock);

        btnPaper = new JButton("布");
        btnPaper.setBounds(10, 140, 120, 30);
        btnPaper.addActionListener(Listenerbtn);
        frame.add(btnPaper);

        btnRST = new JButton("重新開始");
        btnRST.setBounds(10, 175, 120, 30);
        btnRST.addActionListener(Listenerbtn);
        frame.add(btnRST);

        frame.repaint();
    }

    private ActionListener Listenerbtn = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String computerAnswer = computerRandom();

            if (e.getSource() == btnScissors) {
                lblPlayer.setIcon(icon_scissors);
                lblPlayer.setText("剪刀");

                if (computerAnswer.equals("scissors")) {
                    lblDraw.setText("平手次數：" + (++Draw));
                } else if (computerAnswer.equals("rock")) {
                    lblLose.setText("電腦贏次數：" + (++Lose));
                } else {
                    lblWin.setText("玩家贏次數：" + (++Win));
                }
                checkResult();
            } else if (e.getSource() == btnRock) {
                lblPlayer.setIcon(icon_rock);
                lblPlayer.setText("石頭");

                if (computerAnswer.equals("rock")) {
                    lblDraw.setText("平手次數：" + (++Draw));
                } else if (computerAnswer.equals("paper")) {
                    lblLose.setText("電腦贏次數：" + (++Lose));
                } else {
                    lblWin.setText("玩家贏次數：" + (++Win));
                }
                checkResult();
            } else if (e.getSource() == btnPaper) {
                lblPlayer.setIcon(icon_paper);
                lblPlayer.setText("布");

                if (computerAnswer.equals("paper")) {
                    lblDraw.setText("平手次數：" + (++Draw));
                } else if (computerAnswer.equals("scissors")) {
                    lblLose.setText("電腦贏次數：" + (++Lose));
                } else {
                    lblWin.setText("玩家贏次數：" + (++Win));
                }
                checkResult();
            } else if (e.getSource() == btnRST) {
                gameReset();
            }
        }
    };

    private void gameReset() {
        txtResult.setText("五場比賽中...");
        lblPlayer.setIcon(null);
        lblPlayer.setText("按下按鈕猜拳...");
        lblComputer.setIcon(null);
        lblComputer.setText("人類再一場！");
        Win = 0;
        Lose = 0;
        Draw = 0;
        lblWin.setText("玩家贏次數：" + Win);
        lblLose.setText("電腦贏次數：" + Lose);
        lblDraw.setText("平手次數：" + Draw);
    }

    private String computerRandom() {
        double i = Math.ceil(Math.random() * 3);
        int j = (int) i;

        if (j == 1) {
            lblComputer.setIcon(icon_rock);
            lblComputer.setText("石頭");
            return "rock";
        } else if (j == 2) {
            lblComputer.setIcon(icon_paper);
            lblComputer.setText("布");
            return "paper";
        } else {
            lblComputer.setIcon(icon_scissors);
            lblComputer.setText("剪刀");
            return "scissors";
        }
    }

    private void checkResult() {
        if (Win + Lose + Draw == 5) {
            if (Win > Lose) {
                txtResult.setText("玩家贏了！");
            } else if (Win < Lose) {
                txtResult.setText("電腦贏了！");
            } else {
                txtResult.setText("平手！");
            }
        }
    }
}

public class s16_j {
    public static void main(String[] args) {
        new CLoginF();
    }
}