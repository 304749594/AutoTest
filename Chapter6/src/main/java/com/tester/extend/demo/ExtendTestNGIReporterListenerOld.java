package com.tester.extend.demo;

import com.aventstack.extentreports.ExtentReports;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class ExtendTestNGIReporterListenerOld implements IReporter {
    //生成的路径以及文件名
    private static final String OUTPUT_FOLDER = "test-output/";
    private static final String FILE_NAME="index.html";

    private ExtentReports extend;

    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

    }
}