/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import connection.ExcuteSQLStatement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.data.category.DefaultCategoryDataset;

public class QuanlyThongKe extends JPanel {
    private DropShadowPane pane_shadow;

    private static final int CHART_WIDTH = 800;
    private static final int CHART_HEIGHT = 570;
    private JComboBox<String> chonChuKy_jComboBox;
    private JComboBox<String> chonThoiGianTheoNam_jComboBox;
    private JComboBox<String> chonThoiGianTheoThang_jComboBox;
    private ButtonGradient xemThongKe_jButton;
    private ChartPanel chartPanel;
    private XYDataset dataset;
    private JFreeChart chart;
    private boolean isNam = true;
    
    private Connection connection;

    public QuanlyThongKe(Connection connection) {
        this.connection = connection;
        initUI();
    }

    private void initUI() {
        setOpaque(true);
        setBackground(new Color(230, 235, 240));
        setPreferredSize(new Dimension(800, 600)); 
        
        pane_shadow = new DropShadowPane(4, 0, 0, 0, Color.white, 50);
        pane_shadow.setPreferredSize(new Dimension(770, 550)); 

        JPanel pane_main = new JPanel();
        pane_main.setLayout(new BorderLayout());
        
        //tao panel o tren
        JPanel controlPanel = new JPanel();
//        controlPanel.setBackground(Color.white);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.setBorder(new EmptyBorder(5, 0, 0, 0));
        pane_main.add(controlPanel, BorderLayout.NORTH);

        //them combobox chon chu ky
        chonChuKy_jComboBox = new JComboBox<>();
        chonChuKy_jComboBox.setPreferredSize(new Dimension(150, 30));
        String[] chonChuKyThongKe = {"Theo năm", "Theo tháng"};
        for (String i : chonChuKyThongKe) {
            chonChuKy_jComboBox.addItem(i);
        }
        chonChuKy_jComboBox.addItemListener((ItemEvent e) -> {
            if (chonChuKy_jComboBox.getSelectedItem().equals("Theo tháng")) {
                chonThoiGianTheoThang_jComboBox.setEnabled(true);
            } else {
                chonThoiGianTheoThang_jComboBox.setEnabled(false);
            }
        });

        controlPanel.add(chonChuKy_jComboBox);

        //them 2 combox chon thoi gian
        //1. combobox theo nam
        chonThoiGianTheoNam_jComboBox = new JComboBox<>();
        chonThoiGianTheoNam_jComboBox.setPreferredSize(new Dimension(100, 30));

        String getAllNamInPhieuNhap = "SELECT DISTINCT EXTRACT(YEAR FROM NGAYNHAP) AS NAM FROM PHIEUNHAP ORDER BY NAM ASC";
        ResultSet allNamInPhieuNhapResultSet = ExcuteSQLStatement.ExcuteSQLQuery(getAllNamInPhieuNhap, connection);
        try {
            while (allNamInPhieuNhapResultSet.next()) {
                chonThoiGianTheoNam_jComboBox.addItem(allNamInPhieuNhapResultSet.getString("NAM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        chonThoiGianTheoNam_jComboBox.setSelectedIndex(1);
        //combobox theo thang
        chonThoiGianTheoThang_jComboBox = new JComboBox<>();
        chonThoiGianTheoThang_jComboBox.setPreferredSize(new Dimension(100, 30));
        chonThoiGianTheoThang_jComboBox.setEnabled(false);
        String getAllThangInPhieuNhap = "SELECT DISTINCT EXTRACT(MONTH FROM NGAYNHAP) AS THANG FROM PHIEUNHAP WHERE EXTRACT(YEAR FROM NGAYNHAP) = " + chonThoiGianTheoNam_jComboBox.getSelectedItem() + " ORDER BY THANG ASC";
        ResultSet allThangInPhieuNhapResultSet = ExcuteSQLStatement.ExcuteSQLQuery(getAllThangInPhieuNhap, connection);
        try {
            while (allThangInPhieuNhapResultSet.next()) {
                chonThoiGianTheoThang_jComboBox.addItem(allThangInPhieuNhapResultSet.getString("THANG"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        controlPanel.add(chonThoiGianTheoNam_jComboBox);
        controlPanel.add(chonThoiGianTheoThang_jComboBox);

        //Phan nay tao chart
        int nam = Integer.parseInt((String) chonThoiGianTheoNam_jComboBox.getSelectedItem());
        dataset = createDataset(nam);
        chart = createChart(dataset,isNam);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        pane_main.add(chartPanel, BorderLayout.CENTER);

        //them button xem thong ke
        xemThongKe_jButton = new ButtonGradient();
        xemThongKe_jButton.setPreferredSize(new Dimension(150, 30));
        xemThongKe_jButton.setText("XEM THỐNG KÊ");
        xemThongKe_jButton.setFont(
                new Font("SansSerif", 1, 12));
        controlPanel.add(xemThongKe_jButton);
        xemThongKe_jButton.addActionListener(
                (e) -> {
                    XYDataset datasetMoi = null;
                    if (chonChuKy_jComboBox.getSelectedItem().equals("Theo năm")) {
                        int namMoi = Integer.parseInt((String) chonThoiGianTheoNam_jComboBox.getSelectedItem());// năm mới
                        datasetMoi = createDataset(namMoi);
                    } else {

                    }
                    // Cập nhật biểu đồ với tập dữ liệu mới
                    XYPlot plot = chart.getXYPlot();
                    plot.setDataset(datasetMoi);
                }
        );
        
        pane_shadow.add(pane_main);
        add(pane_shadow);
    }

    private int getCostByMonth(int month, int year) {
        int cost = 0;
        String getCostStatetment = "select SL, DONGIA from PHIEUNHAP where EXTRACT(MONTH FROM NGAYNHAP) = " + month + " AND EXTRACT(YEAR FROM NGAYNHAP) = " + year;
        ResultSet costResultSet = ExcuteSQLStatement.ExcuteSQLQuery(getCostStatetment, connection);
        try {
            while (costResultSet.next()) {
                cost = cost + costResultSet.getInt("SL") + costResultSet.getInt("DONGIA");

            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThongKe.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }

    private int getCostByDay(int day, int month, int year) {
        int cost = 0;
        String getCostStatetment = "select SL, DONGIA from PHIEUNHAP where EXTRACT (DAY FROM NGAYNHAP) = " + day + "AND EXTRACT(MONTH FROM NGAYNHAP) = " + month + " AND EXTRACT(YEAR FROM NGAYNHAP) = " + year;
        ResultSet costResultSet = ExcuteSQLStatement.ExcuteSQLQuery(getCostStatetment, connection);
        try {
            while (costResultSet.next()) {
                cost = cost + costResultSet.getInt("SL") + costResultSet.getInt("DONGIA");

            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThongKe.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }

    private int getIncomeByMonth(int month, int year) {
        int income = 0;
        String getIncomeStatement = "select TRIGIA from HOADON where EXTRACT(MONTH FROM NGHD) = " + month + " AND EXTRACT(YEAR FROM NGHD) = " + year;
        ResultSet costResultSet = ExcuteSQLStatement.ExcuteSQLQuery(getIncomeStatement, connection);
        try {
            while (costResultSet.next()) {
                income = income + costResultSet.getInt("TRIGIA");

            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThongKe.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return income;
    }

    private int getInComeByDay(int day, int month, int year) {
        int income = 0;
        String getIncomeStatement = "select TRIGIA from HOADON where EXTRACT(DAY FROM NGHD) = " + day + " AND EXTRACT(MONTH FROM NGHD) = " + month + " AND EXTRACT(YEAR FROM NGHD) = " + year;
        ResultSet costResultSet = ExcuteSQLStatement.ExcuteSQLQuery(getIncomeStatement, connection);
        try {
            while (costResultSet.next()) {
                income = income + costResultSet.getInt("TRIGIA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanlyThongKe.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return income;
    }

    private XYDataset createDataset(int nam) {

        var inComeSeries = new XYSeries("Doanh thu");
        var costSeries = new XYSeries("Chi phi");
        var profitSeries = new XYSeries("Loi nhuan");
        double income;
        double cost;

        for (int i = 0; i < 13; i++) {
            income = getIncomeByMonth(i, nam);
            cost = getCostByMonth(i, nam);
            inComeSeries.add(i, income);
            costSeries.add(i, cost);
            profitSeries.add(i, income - cost);
        }

        var initDataset = new XYSeriesCollection();
        initDataset.addSeries(inComeSeries);
        initDataset.addSeries(costSeries);
        initDataset.addSeries(profitSeries);

        return initDataset;
    }

    private XYDataset createDataset(int nam, int thang) {
        var inComeSeries = new XYSeries("Doanh thu");
        var costSeries = new XYSeries("Chi phi");
        var profitSeries = new XYSeries("Loi nhuan");
        double income;
        double cost;

        for (int i = 0; i < 13; i++) {
            income = getIncomeByMonth(i, nam);
            cost = getCostByMonth(i, nam);
            inComeSeries.add(i, income);
            costSeries.add(i, cost);
            profitSeries.add(i, income - cost);
        }

        var initDataset = new XYSeriesCollection();
        initDataset.addSeries(inComeSeries);
        initDataset.addSeries(costSeries);
        initDataset.addSeries(profitSeries);

        return initDataset;
    }

    private JFreeChart createChart(XYDataset dataset, boolean checkChuKy) {

        JFreeChart initChart = ChartFactory.createXYLineChart(
                "Thông kê doanh thu năm ... ",
                "Tháng",
                "Doanh thu",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = initChart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(2, Color.GREEN); //set color for line 2
        for (int i = 0; i < 3; i++) {
            renderer.setSeriesStroke(i, new BasicStroke(1.1f)); //set do day cho line 2
        }
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.GRAY);
//        plot.setDomainCrosshairVisible(true);
//        plot.setRangeCrosshairVisible(true); // set y = 0 khác màu
        //này là trục Ox
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        if (checkChuKy) {
            domain.setRange(1.00, 12.00);
            domain.setTickUnit(new NumberTickUnit(1));
        } else {
            domain.setRange(1,12);
        }
        domain.setVerticalTickLabels(true);
        /*này là trục Oy nhưng mà để nó auto tốt hơn nên ko cần
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0.0, 1.0);
        range.setTickUnit(new NumberTickUnit(0.1));
         */

        initChart.getLegend().setFrame(BlockBorder.NONE);

        initChart.setTitle(new TextTitle("Thống kê doanh thu",
                new Font("SansSerif", java.awt.Font.BOLD, 18) //Serif, Segoe
        )
        );

        return initChart;
    }
}
