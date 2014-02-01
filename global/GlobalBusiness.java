package com.techm.business.global;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.techm.pmttracker.dao.DBUtil;

public class GlobalBusiness {
	DBUtil DBCon = DBUtil.getInstance();
	
	public String pmtAutoComplete (String inputText) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		con = DBCon.getConnection();
		
		String pmtID = null;
		String pmtName = null;
		String returnText = null;
		Boolean idFlag = false;
		Boolean nameFlag = false;
		
		String resXML = "";
		try {
			
			
	inputText = inputText.trim();
	System.out.println("-------------------------" + inputText.toLowerCase());
	System.out.println("--------------------------" + inputText.toUpperCase());
	
	pstmt1 = con.prepareStatement("select pmt_id, pmt_name from pmt where pmt_id like ?");
	pstmt1.setString(1, inputText+"%");	
	
	rs1 = pstmt1.executeQuery();
	
	while (rs1.next()) {
		idFlag = true;
		pmtID = rs1.getString(1);
		pmtName = rs1.getString(2);
		if (returnText != null)
		returnText = returnText + pmtID + " | " + pmtName +  "\n";
		else
			returnText = pmtID +  " | " + pmtName + "\n";
	}
	
	if (!idFlag) {
		
		pstmt2 = con.prepareStatement("select pmt_id, pmt_name from pmt where pmt_name like ? or pmt_name like ?");
	
		pstmt2.setString(1, "%"+inputText.toLowerCase()+"%");
		pstmt2.setString(2, "%"+inputText.toUpperCase()+"%");
		
		rs2 = pstmt2.executeQuery();
		
		while (rs2.next()) {
			nameFlag = true;
			pmtID = rs2.getString(1);
			pmtName = rs2.getString(2);
			if (returnText != null)
			returnText = returnText + pmtID + " | " + pmtName +  "\n";
			else
				returnText = pmtID +  " | " + pmtName + "\n";
		}
		
		
	}
	
	if (idFlag)
		resXML = toDocument(rs1);
	else if (nameFlag)
		resXML = toDocument(rs2);

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					DBCon.releaseConnection(con);
			} catch (Exception e) {
			}
		}
		
		
		
		
		return resXML;
		
	}
	
	
	public String toDocument(ResultSet rs) throws ParserConfigurationException,
	SQLException, TransformerException {
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.newDocument();
Element results = doc.createElement("ResultSet");
doc.appendChild(results);

Boolean hasData = false;
String resXML;

ResultSetMetaData rsmd = rs.getMetaData();
int colCount = rsmd.getColumnCount();

while (rs.next()) {
	hasData = true;
	Element row = doc.createElement("Result");
	results.appendChild(row);
	for (int i = 1; i <= colCount; i++) {
		String columnName = rsmd.getColumnName(i);
		Object value = rs.getObject(i);
		
		Element node = doc.createElement(columnName);
		if (value == null)
			value = "";
	
		node.appendChild(doc.createTextNode(value.toString()));
		row.appendChild(node);
	}
}

if (hasData == true) {
	DOMSource domSource = new DOMSource(doc);
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer();
	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
			"yes");
	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
	StringWriter sw = new StringWriter();
	StreamResult sr = new StreamResult(sw);
	transformer.transform(domSource, sr);
	resXML = sw.toString();
	System.out.println(sw.toString());
} else
	resXML = "-3";
return resXML;

}
}
