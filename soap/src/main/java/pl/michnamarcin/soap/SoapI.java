package pl.michnamarcin.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SoapI
{
    @WebMethod
    long push(String data);

    @WebMethod
    boolean check(int id);
}
