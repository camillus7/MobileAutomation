package commonUtil;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.testng.Assert;
import org.testng.Reporter;

public class SOAPClient {
	
	/**
     * SOAP Client 
     */
    public void sendSOAPCloseRequest(String incidentNumber) throws Throwable {
        try {
        	Reporter.log("Sending SOAP Close Request for Incident : " + incidentNumber, true);

        	// Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Set Auth for empId
            String auth = "CarrierOnline";
            
            // Get test env from the URL and create OSB Remedy Url
            String env = "";
            String propertiesUrl = PropertiesUtil.getValue(PropertiesUtil.URL_PROPERTY);
            if (propertiesUrl.contains("@")) {
    			String[] part1 = propertiesUrl.split("@");
      			String[] envPart1 = part1[1].split(".windstream");
      			String[] envPart2 = envPart1[0].split("wol");
      			env = envPart2[0] + envPart2[1];
    		} 
            // Get env when URL has no login information
            else {
            	String[] part1 = propertiesUrl.split("//");
            	String[] part2 = part1[1].split(".");
            	env = part2[0];
            }
           	System.out.println("Environment = " + env);

           	// Get the Remedy URL from config.properties, append env and service
            String host = "http://osb-test2.windstream.com/client/PaetecOnline";
            String service = "WIN_ET_TicketUpdateProxy";
            String url = host + "/" + env + "/" + service;
            System.out.println("Remedy URL : = " + url);
         	
            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPCloseRequest(incidentNumber, auth), url);

            // Process the SOAP Response
            String response = printSOAPResponse(soapResponse);
            
            soapConnection.close();
             
            if ( response.contains("faultstring"))
            {
            	String split1[] = response.split("<faultstring>");
            	String split2[] = split1[1].split("</faultstring>");
            	String errorMessage = split2[0];
            	Reporter.log("Remedy Response = " + errorMessage, true);
            	Assert.fail();
            }

       } catch (Exception e) {
            Reporter.log("Error occurred in sendSOAPCloseRequest " + e.getMessage(), true);
            throw e;
        }
    }

    private static SOAPMessage createSOAPCloseRequest(String INC, String auth) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:WIN_ET_Ticket_Update_20170301";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Header
        SOAPHeader soapHeader = envelope.getHeader();
        /*
         * Use this authentication builder with Remedy business end point
         */
       /* SOAPElement soapHeaderElem = soapHeader.addChildElement("AuthenticationInfo", "urn");
        SOAPElement soapHeaderElem1 = soapHeaderElem.addChildElement("userName", "urn");
        soapHeaderElem1.addTextNode("CarrierOnline");
        SOAPElement soapHeaderElem2 = soapHeaderElem.addChildElement("password", "urn");
        soapHeaderElem2.addTextNode("CarrierOnline");*/
        
        /*
         * Use this header attribute with OSB url for Carrier tickets
         */
       soapHeader.addAttribute(new QName("remedy_auth_user"), auth);
       
       
       /*
        * Use this header attribute with OSB url for Win tickets
      soapHeader.addAttribute(new QName("remedy_auth_user"), "WinOnline");*/
        
        // Get date & time
        Date currentDate = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
        String time = new SimpleDateFormat("HH:mm:ss").format(currentDate);
        
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Close", "urn");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Incident_Number", "urn");
        soapBodyElem1.addTextNode(INC);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("EmployeeID", "urn");
        soapBodyElem2.addTextNode(auth);
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Closure_Tier_1", "urn");
        soapBodyElem3.addTextNode("Customer");
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Closure_Tier_2", "urn");
        soapBodyElem4.addTextNode("Customer");
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("Closure_Tier_3", "urn");
        soapBodyElem5.addTextNode("Customer Assist");
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("Closing_Code", "urn");
        soapBodyElem6.addTextNode("Ticket Made in Error");
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("Trouble_Clear_Date", "urn");
        soapBodyElem7.addTextNode(date);
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("Trouble_Clear_Time", "urn");
        soapBodyElem8.addTextNode(time);
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("Clearing_remarks", "urn");
        soapBodyElem9.addTextNode("Closing");
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("ETA_Service_Info", "urn");
        soapBodyElem10.addTextNode("INS");
        SOAPElement soapBodyElem11 = soapBodyElem.addChildElement("Action", "urn");
        soapBodyElem11.addTextNode("UPDATE CLOSE");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "CloseTicket");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static String printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
        System.out.println();
        
        // Capture the string value
        StringWriter stringResult = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(sourceContent, new StreamResult(stringResult));
        return stringResult.toString();
    }

}