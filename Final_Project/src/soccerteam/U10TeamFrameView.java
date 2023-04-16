package soccerteam;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class U10TeamFrameView extends JFrame implements U10TeamView {

    JPanel overviewPanel;
    JLabel teamSizeTitle;
    JLabel displayTeamSize;
    JLabel teamStatusTitle;
    JLabel displayTeamStatus;
    JLabel lineupStatusTitle;
    JLabel displayLineupStatus;


    public U10TeamFrameView(String appName) {
        super(appName);

        this.setSize(new Dimension(600, 400));
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());

        // Setting Fonts for different parts of UI.
        Font panelTitleFont = new Font("Arial", Font.BOLD, 20);
        Font contentTitleFont = new Font("Arial", Font.BOLD, 14);

        // Setting GridBagConstraints.
        GridBagConstraints gridControl = new GridBagConstraints();
        gridControl.anchor = GridBagConstraints.FIRST_LINE_START;

        // Set Section Boarder Style
        LineBorder sectionBoarder = new LineBorder(Color.gray, 1, true);

        // Set up Overview Section.
        GridLayout overviewLayout = new GridLayout(3, 2);
        overviewLayout.setHgap(10);

        this.overviewPanel = new JPanel(overviewLayout);
        TitledBorder overViewBoarder = new TitledBorder(sectionBoarder, "Overview");
        overViewBoarder.setTitleFont(panelTitleFont);
        this.overviewPanel.setBorder(overViewBoarder);

        this.teamSizeTitle = new JLabel(" Team Size: ");
        this.teamSizeTitle.setFont(contentTitleFont);
        this.displayTeamSize = new JLabel("0/20");
        this.overviewPanel.add(this.teamSizeTitle);
        this.overviewPanel.add(this.displayTeamSize);

        this.teamStatusTitle = new JLabel(" Team Status: ");
        this.teamStatusTitle.setFont(contentTitleFont);
        this.displayTeamStatus = new JLabel("Not Established");
        this.overviewPanel.add(this.teamStatusTitle);
        this.overviewPanel.add(this.displayTeamStatus);

        this.lineupStatusTitle = new JLabel(" Starting Lineup Status: ");
        this.lineupStatusTitle.setFont(contentTitleFont);
        this.displayLineupStatus = new JLabel("Not Formed");
        this.overviewPanel.add(this.lineupStatusTitle);
        this.overviewPanel.add(this.displayLineupStatus);

        this.add(this.overviewPanel, gridControl);

        // Set up Starting Lineup Section

        // Set Team Members Section

        // Set New Player Section

        // Set Team Management Section

        this.pack();
        this.setVisible(true);


    }

    @Override
    public void addFeatures(U10TeamFeatures features) {

    }

    @Override
    public void displayTeamSize(int teamSize) {

    }

    @Override
    public void displayTeamStatus(String creationStatus) {

    }

    @Override
    public void displayStartingLineupStatus(String startingLineupStatus) {

    }

    @Override
    public void clearNewPlayerInput() {

    }

    @Override
    public void clearRemovePlayerInput() {

    }

    @Override
    public void displayStartingLineupList(String startingLineupList) {

    }

    @Override
    public void displayTeamList(String teamList) {

    }
}
