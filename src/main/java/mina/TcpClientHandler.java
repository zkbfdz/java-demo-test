package mina;

import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kai.zhu on 2018/3/28/028.
 */
public class TcpClientHandler extends IoHandlerAdapter{

    private final String values;

    public TcpClientHandler(String values) {
        this.values = values;
    }

    @Override
    public void sessionOpened(IoSession session) {
        session.write(values);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse1 = simpleDateFormat.parse("0000-00-00 00:00:00");
        Date parse2 = simpleDateFormat.parse("0000-00-00 00:00:00");
        System.out.println(parse1.getTime() > parse2.getTime());
        System.out.println(StringUtils.isNumeric("1.2"));
    }
}
