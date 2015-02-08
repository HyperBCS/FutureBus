package com.hyperbcs.brandon.futurebus;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Brandon on 2/7/15.
 */
public class GetRoutes extends ActionBarActivity {
    public void returnRoutes(String r, String s) {
        /** Create a new layout to display the view */


        /** Create a new textview array to display the results */
        /*AsyncTaskRunners runner = new AsyncTaskRunners();
        runner.execute();*/


        class AsyncTaskRunners extends AsyncTask<String, String, String> {
            @Override
            protected String doInBackground(String... params) {
                TextView name[];
                TextView website[];                TextView category[];

                String times = null;

                try {

                    //URL url = new URL("http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
                    URL url = new URL("http://webservices.nextbus.com/service/publicXMLFeed?a=rutgers&command=predictions&r=wknd1&s=hillw");
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(new InputSource(url.openStream()));
                    doc.getDocumentElement().normalize();

                    NodeList nodeList = doc.getElementsByTagName("item");
                    //System.out.println(nodeList.getLength());
                    /** Assign textview array lenght by arraylist size */
                    name = new TextView[nodeList.getLength()];
                    website = new TextView[nodeList.getLength()];
                    category = new TextView[nodeList.getLength()];

                    for (int i = 0; i < nodeList.getLength(); i++) {

                        Node node = nodeList.item(i);


                        Element fstElmnt = (Element) node;
                        NodeList nameList = fstElmnt.getElementsByTagName("name");
                        Element nameElement = (Element) nameList.item(0);
                        nameList = nameElement.getChildNodes();
                        name[i].setText("Name = " + ((Node) nameList.item(0)).getNodeValue());

                        NodeList websiteList = fstElmnt.getElementsByTagName("website");
                        Element websiteElement = (Element) websiteList.item(0);
                        websiteList = websiteElement.getChildNodes();
                        website[i].setText("Website = " + ((Node) websiteList.item(0)).getNodeValue());

                        category[i].setText("Website Category = " + websiteElement.getAttribute("category"));

                    }
                } catch (Exception e) {
                    System.out.println("XML Pasing Excpetion = " + e);
                }
                return times;
            }
        }
        /** Set the layout view to display */
    }
}