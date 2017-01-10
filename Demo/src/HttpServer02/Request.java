package HttpServer02;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * Created by Faron on 2017/1/8.
 */
public class Request {
    private String method;
    private String url;
    public static final String CRLF = "\r\n";
    private Map<String, List<String>> csMap;
    private BufferedReader br;
    public String RequestContent;
    private InputStream is;

    public Request() {
        method = "";
        url = "";
        csMap = new HashMap<String, List<String>>();
    }

    public Request(InputStream is) throws IOException {
        this();
        this.is = is;
        byte[] data = new byte[20480];
        int len = is.read(data);
        RequestContent = new String(data, 0, len);
        ParseRequestContent();
    }

    public Request(Socket socket) throws IOException {
        this();
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        RequestContent = br.readLine();
        ParseRequestContent();
    }

    public void ParseRequestContent() {
        if (null == RequestContent || RequestContent.equals("")) {
            return;
        }
        System.out.println(RequestContent);
        // GET /index.html?uname=fengliwen&pwd=123 HTTP/1.1
        String paramString = "";
        String firstline = RequestContent.substring(0, RequestContent.indexOf(CRLF)).trim();
        int idx = RequestContent.indexOf("/");
        this.method = firstline.substring(0, idx).trim();
        String urlStr = firstline.substring(idx, firstline.indexOf("HTTP/")).trim();
        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            //post中 请求参数在最后一个回车符号之后
            paramString = RequestContent.substring(RequestContent.lastIndexOf(CRLF)).trim();
        } else {
            if (urlStr.contains("?")) {
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramString = urlArray[1];//接受请求参数
            } else {
                this.url = urlStr;
            }
        }

        if (paramString.equals("")) {
            return;
        }
        //将请求封装到Map中
        parseParams(paramString);

    }

    private void parseParams(String paramString) {
        //分割，将字符串转换成数组
        StringTokenizer tokenizer = new StringTokenizer(paramString, "&");
        while (tokenizer.hasMoreTokens()) {
            String keyValue = tokenizer.nextToken();
            String[] keyValues = keyValue.split("=");
            if (keyValues.length == 1) {
                keyValues = Arrays.copyOf(keyValues, 2);//为什么要复制呢？是因为KeyValues是切割后的数组
                keyValues[1] = null;
            }
            //获取key
            String key = keyValues[0];
            //获取value
            String value = null == keyValues[1] ? null : decode(keyValues[1].trim(), "UTF-8");   //存入的时候进行解码
            //转换成Map存储 分拣
            if (!csMap.containsKey(key)) {
                csMap.put(key, new ArrayList<String>());
            }
            List<String> values = csMap.get(key);  //将key对应的List交给values
            values.add(value);

        }

    }

    //提供一个方法访问csmap中的值
    //根据页面中的name访问这些值
    public String[] getParameterValues(String name) {
        //创建一个List来存放获取的key对应的值
        List<String> valueList = new ArrayList<String>();
        if ((valueList = csMap.get(name)) == null) {
            return null;
        } else {
            return valueList.toArray(new String[0]); //很多底层都返回数组  这里的new String[0] 只是 一个类型标示，用来告诉toArray方法具体转化成什么类型
        }
    }

    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        if (null == values) {
            return null;
        } else {
            return values[0];
        }

    }

    public String decode(String value, String charset) {
        try {
            return java.net.URLDecoder.decode(value, charset);
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

//    public static void main(String[] args){
//        String str = "uname=fengliwen&pwd=123&fav=f1&fav=f2&fav=f3";
//        new Request().parseParams(str);
//
//    }


}
