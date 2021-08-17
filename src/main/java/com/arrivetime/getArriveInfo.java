package com.arrivetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;




public class getArriveInfo {

	/* 인증에 필요한 서비스키 */
	String servicekey;
	/* 정류장 고유번호 */
	String stid;
	/* 버스아이디 번혼 */
	String busid;
	/* 정류장의 순번 */
	String ord;
	
	public getArriveInfo() {

		}
	
	public void getSingleInfo() {
		stid = "107000113"; //하나읜행 장위동지점.					
		BufferedReader br= null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;	
		//서비스에 필요한 정보
		
		servicekey 	= "pSOAK8471LEISSDhzMmpDUreAN6WDvZyeTcedPRCk6rSrWN0lTo6MGAmz8ZHMwVsbaaLtNXR2j15PiolFtoTDQ%3D%3D";
		stid 		= "107000113";
		busid 		= "100100026";
		ord			= "9";
		
		try {
			//OpenApi 호출
			String urlstr = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRoute"
					+ "?serviceKey=" 	+ servicekey
					+ "&stId=" 			+ stid
					+ "&busRouteId="	+ busid
					+ "&ord="			+ ord;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			
			//응답 읽기
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			String result = "";
			String line;
			while((line = br.readLine()) != null) {
				result = result + line.trim(); //result = URL로 XML을 읽은 값.				
			}
			
			
			//xml파싱
			InputSource is = new InputSource(new StringReader(result));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//msgBody/itemList");
			
			NodeList nodeList = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
			for(int i = 0; i < nodeList.getLength();i++) {
				NodeList child = nodeList.item(i).getChildNodes();
				for(int j= 0; j< child.getLength(); j++) {
					Node node = child.item(j);
					
					 System.out.println("현재 노드 이름 : " + node.getNodeName());
	                    System.out.println("현재 노드 값 : " + node.getTextContent());
	                    System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
	                    System.out.println("현재 노드의 다음 노드 : " + node.getNextSibling());
	                    System.out.println("");

	
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String getServicekey() {
		return servicekey;
	}

	public void setServicekey(String servicekey) {
		this.servicekey = servicekey;
	}

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getOrd() {
		return ord;
	}

	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	
	

}
	


