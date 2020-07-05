package pl.michnamarcin.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("http://localhost:8080/soap_war/Soap?wsdl");
        QName qName = new QName("http://soap.michnamarcin.pl/", "SoapService");
        Service service = Service.create(url, qName);
        SoapI soap = service.getPort(SoapI.class);
        System.out.println(soap.push("Marek"));
        System.out.println(soap.check(13));
    }
}
