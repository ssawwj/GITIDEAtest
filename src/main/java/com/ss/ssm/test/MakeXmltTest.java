package com.ss.ssm.test;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
	@author ss
	@date 2019年5月29日 下午3:27:39
**/
public class MakeXmltTest {

	 public static void main(String[] args) {
	        FileWriter out = null;
	        try {
	            out = new FileWriter( "src/main/resources/Xml/foo.xml" );  //写入文件
	            createDocument().write( out );
	            
	            OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
	            format.setEncoding("UTF-8");
	            XMLWriter writer = new XMLWriter( System.out, format );
	            writer.write( createDocument() );
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            if (out!=null) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    
	    public static Document createDocument() {
	        Document document = DocumentHelper.createDocument();

	        Element root = document.addElement( "result" );
	        root.addElement("code").addText("1");
	        Element data = root.addElement("data");

	        Element person1 = data.addElement( "person" );
	        person1.addElement( "name" ).setText("张三");
	        person1.addElement( "id" ).setText("1");
	        person1.addElement( "url" ).setText("http://192.168.191.1:9999/TestWeb/c7fe21616d2a5e2bd1e84bd453a5b30f.jpg");
	        Element courses1 =person1.addElement( "courses" );
	        Element course1 = courses1.addElement( "course" );
	        course1.addElement( "courseName" ).setText("语文");
	        course1.addElement( "courseMarks" ).setText("90");
	        course1.addElement( "courseId" ).setText("1");
	        Element course2 = courses1.addElement( "course" );
	        course2.addElement( "courseName" ).setText("数学");
	        course2.addElement( "courseMarks" ).setText("80");
	        course2.addElement( "courseId" ).setText("2");
	        Element course3 = courses1.addElement( "course" );
	        course3.addElement( "courseName" ).setText("英语");
	        course3.addElement( "courseMarks" ).setText("70");
	        course3.addElement( "courseId" ).setText("3");

	        Element person2 = data.addElement( "person" )
	        .addAttribute( "name", "李四" )
	        .addAttribute( "id", "2" )
	        .addAttribute("url", "http://192.168.191.1:9999/TestWeb/4052858c526002a712ef574ccae1948f.jpg");
	        person2.addElement( "course" )
	        .addAttribute( "courseName", "语文" )
	        .addAttribute( "courseMarks", "91" )
	        .addAttribute( "courseId", "1" );
	        person2.addElement( "course" )
	        .addAttribute( "courseName", "数学" )
	        .addAttribute( "courseMarks", "82" )
	        .addAttribute( "courseId", "1" );
	        person2.addElement( "course" )
	        .addAttribute( "courseName", "英语" )
	        .addAttribute( "courseMarks", "73" )
	        .addAttribute( "courseId", "1" );

	        return document;
	    }


}
