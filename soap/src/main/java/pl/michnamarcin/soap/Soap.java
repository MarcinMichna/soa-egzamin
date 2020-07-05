package pl.michnamarcin.soap;

import pl.michnamarcin.core.Action;

import javax.jws.WebService;

@WebService(endpointInterface = "pl.michnamarcin.soap.SoapI")
public class Soap implements SoapI
{
    @Override
    public long push(String data)
    {
        Action.action(13);
        return 13;
    }

    @Override
    public boolean check(int id)
    {
        return false;
    }
}
