/*
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.DatabaseOperation;

import java.util.List;

public class testFunction {
    public static void main(String[] args) {
        StopMapper stopMapper = DatabaseOperation.session.getMapper(StopMapper.class);
        List<Stop> stops = stopMapper.SelectStopBySimilarName("市民");
        stops.stream().map(Stop::getName).forEach(System.out::println);
    }
}
*/

import SmartBusSystem.service.function.UserSearchStop;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class StopQueryExample extends JFrame {
    private JDialog StopQueryDialog;
    private JLabel StopName;
    private JTextField StopNameInput;
    private JScrollPane StopListPane;
    private JList<String> StopNameList;
    private JButton SearchStop;
    private DefaultListModel<String> stopQueryListModel;

    public StopQueryExample() {
        initComponents();
        initStopQueryDialog();
    }

    private void initComponents() {
        StopQueryDialog = new JDialog(this, "\u7ad9\u70b9\u67e5\u8be2", true);
        StopName = new JLabel("\u7ad9\u70b9\u540d\u79f0:");
        StopNameInput = new JTextField();
        StopListPane = new JScrollPane();
        StopNameList = new JList<>();
        SearchStop = new JButton("\u641c\u7d22");

        //======== StopQueryDialog ========
        {
            StopQueryDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            StopQueryDialog.setAlwaysOnTop(true);
            var StopQueryDialogContentPane = StopQueryDialog.getContentPane();
            StopQueryDialogContentPane.setLayout(null);

            //---- StopName ----
            StopName.setFont(StopName.getFont().deriveFont(StopName.getFont().getStyle() | Font.BOLD, StopName.getFont().getSize() + 5f));
            StopQueryDialogContentPane.add(StopName);
            StopName.setBounds(new Rectangle(new Point(40, 30), StopName.getPreferredSize()));

            //---- StopNameInput ----
            StopNameInput.setBackground(Color.white);
            StopQueryDialogContentPane.add(StopNameInput);
            StopNameInput.setBounds(130, 35, 135, StopNameInput.getPreferredSize().height);

            //======== StopListPane ========
            {
                StopNameList.setVisibleRowCount(5);
                StopListPane.setViewportView(StopNameList);
            }
            StopQueryDialogContentPane.add(StopListPane);
            StopListPane.setBounds(130, 65, 135, 80);

            //---- SearchStop ----
            SearchStop.setFont(SearchStop.getFont().deriveFont(SearchStop.getFont().getStyle() | Font.BOLD, SearchStop.getFont().getSize() + 1f));
            SearchStop.setFocusPainted(false);
            StopQueryDialogContentPane.add(SearchStop);
            SearchStop.setBounds(new Rectangle(new Point(120, 165), SearchStop.getPreferredSize()));

            StopQueryDialogContentPane.setPreferredSize(new Dimension(330, 240));
            StopQueryDialog.setSize(330, 240);
            StopQueryDialog.setLocationRelativeTo(StopQueryDialog.getOwner());
        }
    }

    private void updateStopQueryList() {
        String text = StopNameInput.getText();

        if (text == null || text.isEmpty()) {
            stopQueryListModel.clear();
            return;
        }

        // 模拟搜索结果，替换为实际的搜索方法
        List<String> stopQueryResults = UserSearchStop.listStop2listStopName(UserSearchStop.searchBySimilarName(text));

        stopQueryListModel.clear();

        for (String stopQueryResult : stopQueryResults) {
            stopQueryListModel.addElement(stopQueryResult);
        }
    }

    private void selectStopQueryList() {
        String selectStopName = StopNameList.getSelectedValue();
        if (selectStopName != null) {
            StopNameInput.setText(selectStopName);
            stopQueryListModel.clear();
        }
    }

    private void initStopQueryDialog() {
        stopQueryListModel = new DefaultListModel<>();
        StopNameList.setModel(stopQueryListModel);

        StopNameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStopQueryList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStopQueryList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStopQueryList();
            }
        });

        StopNameList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selectStopQueryList();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StopQueryExample example = new StopQueryExample();
            example.StopQueryDialog.setVisible(true);
        });
    }
}
