# Eason's CS5004 Final Project
Yuchen Pan (Eason)
Spring 2023, CS5004

## About
This is a U10 soccer team dashboard.
(This program may require system access for getting local date and time.)

## List of Features
- Check team size (max 20)
- Check team establishment status (establised / not established)
- Check starting lineup status (formed / not formed)
- Check starting lineup list (Position, Name, Number), sorted by Position (goalie, defender, midfielder, forward)
- Check all team members, sorted by Last name in alphabetical order
- Add new player
- Remove a player by their jersey number
- Create team (can only create once)
- Form starting lineup (can form multiple times)
- Exit the app

## How to Run
Simply navigate to ./res in terminal, then use code "java -jar ./Final_Project.jar" to run the program.

## How to Use the Program
After the program started, you can add players to the team, after you have at least 10 players added, you can create a soccer team, which enables you to form a starting lineup. 
After that, you can continuely adding new players or removing players, and form starting lineup.
Hit Exit button to close the program.

## Design/Model Changes
The return type of getTeam and getStartingLineup methods in the Model has been change from String to String[][], due to the use of JTable in the view to display team member and starting lineup lists. As JTable only accept Object[][] as data.

## Assumptions
- Assuming middle names are not requied
- Assuming users can read English
- Assuming player names are not too long to be displayed
- Assuming users' monitors have at least 830 x 550 resolution
- Assuming Arial font is installed on users' computers
- Assuming users can read font size 14 and above
- Assuming users can identify colour of Black, Blue, grey, and Red.

## Limitations
- This program does not recognize and tell whether there are special simbols, numbers or spaces in the player names input
- This program has only one set logic for selecting starting lineup, and currently not customizable via GUI.
- This program is not mobile-friendly

## Citations
- Unknown Author, Class Timer, Oracle, https://docs.oracle.com/javase/7/docs/api/java/util/Timer.html (Accessed April 19, 2023)
- Unknown Author, How to Print Table in Java Using Formatter?, Java T Point, https://www.javatpoint.com/how-to-print-table-in-java-using-formatter (Accessed March 28, 2023)
- Amir Boroumand, Sort a List of Objects by Field in Java, Hire Amir, https://hireamir.com/blog/sort-list-of-objects-by-field-java, (Accessed March 27, 2023)
- Jon Skeet, How to convert enum value to int?, Stack Overflow, https://stackoverflow.com/questions/8157755/how-to-convert-enum-value-to-int, (Accessed March 27, 2023)
- Unknown Author, Creating Sliders Using JSlider Class, Zentut, https://www.zentut.com/java-swing/jslider/, (Accessed April 3, 2023)
- Unknown Author, How to Use Panels, Oracle, https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html, (Accessed April 3, 2023)
- M. Hamdi, Populating Swing JComboBox from Enum, Stack Overflow, https://stackoverflow.com/questions/1459069/populating-swing-jcombobox-from-enum, (Accessed April 3, 2023)
- Unknown Author, Class Thread, Oracle, https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#setDaemon(boolean), (Accessed April 19, 2023)
- Unknown Author, How to Use GridBagLayout, Oracle, https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html, (Accessed April 8, 2023)
- Unknown Author, How to Use GridLayout, Oracle, https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html, (Accessed April 8, 2023)
- Unknown Author, How to Use Tables, Oracle, https://docs.oracle.com/javase/tutorial/uiswing/components/table.html, (Accessed April 16, 2023)
- 843805, JPanel border with rounded corners, Oracle Forums, https://forums.oracle.com/ords/apexds/post/jpanel-border-with-rounded-corners-0946, (Accessed April 16, 2023)
- Unknown Author, Create a LineBorder with rounded corners in Java, Java2s, http://www.java2s.com/Tutorials/Java/Swing/Border/Create_a_LineBorder_with_rounded_corners_in_Java.htm, (Accessed April 16, 2023)
- Suleiman Ibrahim, Working with Gridbag Layout in Java, Section, https://www.section.io/engineering-education/working-with-gridbag-layout-in-java/, (Accessed April 8, 2023)

