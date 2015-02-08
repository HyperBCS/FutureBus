package com.hyperbcs.brandon.futurebus;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

class AsyncTaskRunner extends AsyncTask<String, String, String[]> {
    @Override
    protected String[] doInBackground(String... params) {
        String r = params[0];
        String s = params[1];
        String rs = "wknd1";
        String ss = "hillw";
        System.out.println(rs+ss);
        String minutes = null;
        String[] minuteArray1;
        minuteArray1 = new String[3];
        try {
            //URL url = new URL("http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
            //URL url = new URL("http://webservices.nextbus.com/service/publicXMLFeed?a=rutgers&command=predictions&r=" + r + "&s=" + s);
            URL url = new URL("http://webservices.nextbus.com/service/publicXMLFeed?a=rutgers&command=predictions&r="+r+"&s="+s);
            System.out.println("URL: "+url);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("prediction");



            int minute;
            minuteArray1 = new String[nodeList.getLength()];
            for (int i = 0; i < nodeList.getLength(); i++) {

                StringWriter sw = new StringWriter();
                Transformer serializer = TransformerFactory.newInstance().newTransformer();
                serializer.transform(new DOMSource(nodeList.item(i)), new StreamResult(sw));
                String result = sw.toString();
                minutes = result.replaceAll("<.*minutes=\"", "").replaceAll("\" is.*", "");
                minute = Integer.parseInt(minutes);
                minuteArray1[i] = minutes;


                //return minuteArray;
            }
        } catch (Exception e) {
            //System.out.println("XML Pasing Excpetion = " + e);
        }
        return minuteArray1;
    }

    protected void onPostExecute(String[] minute) {
        //int[] minutes = minute.clone();
        //BuschFragment listD = new BuschFragment();
        //System.out.println("THISIS MINUTE"+minute[0]);
        System.out.print("MINUTE 0"+minute[0]);
        returnString(minute);
    }

    public String[] returnString(String[] minute){
        return minute;

    }
}
/** Set the layout view to display */
