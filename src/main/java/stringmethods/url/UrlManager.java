package stringmethods.url;

public class UrlManager {
    private String protocol;
    private Integer port;
    private String host;
    private String path = "";
    private String query;

    public UrlManager(String url) {
        protocol = url.substring(0,url.indexOf("://"));
        int pleng = protocol.length();
        host = url.substring(url.charAt(pleng)+3,url.indexOf("/",pleng+3));
        if(host.contains(":")){
            host = host.split(":")[0];
            port = Integer.parseInt(host.split(":")[1]);
        }
        if (url.contains("\\?")){
            path = url.substring(pleng+3+host.length()+port.toString().length(), url.indexOf("\\?"));
            query = url.substring(url.indexOf("\\?"));
        } else {
            path = url.substring(pleng+3+host.length()+port.toString().length()+1);
        }
    }

    public String getProtokoll() {
        return protocol;
    }
    public Integer getPort() {
        return port;
    }
    public String getHost() {
        return host;
    }
    public String getPath() {
        return path;
    }
    public String getQuery() {
        return query;
    }
}
