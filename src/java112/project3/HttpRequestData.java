package java112.project3;


import java.util.Locale;


/**
 * The HttpRequestData class is a JavaBean for the project 3 web application.
 *
 *
 *
 * @author Andrew Diebold
 */
public class HttpRequestData {

    private String remoteComputer;
    private String remoteComputerAddress;
    private String httpMethod;
    private String requestUri;
    private StringBuffer requestUrl;
    private String protocalRequest;
    private String serverName;
    private int serverPortNumber;
    private Locale currentServerLocale;
    private String query;
    private String queryParameter;
    private String userAgent;


    /**
     * Empty constructor for HttpRequestData
     */
    public HttpRequestData() {

    }

    /**
     * Returns the value of remoteComputer
     * @return remoteComputer
     */
    public String getRemoteComputer() {
        return remoteComputer;
    }

    /**
     * Setter for remoteComputer value
     * @param remoteComputer
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }

    /**
     * Returns the value of remoteComputerAddress
     * @return remoteComputerAddress
     */
    public String getRemoteComputerAddress() {
        return remoteComputerAddress;
    }

    /**
     * Setter for remoteComputerAddress
     * @param remoteComputerAddress
     */
    public void setRemoteComputerAddress(String remoteComputerAddress) {
        this.remoteComputerAddress = remoteComputerAddress;
    }

    /**
     * Returns the value of httpMethod
     * @return httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * Setter for httpMethod
     * @param httpMethod
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * Returns the value of requestUri
     * @return requestUri
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * Setter for requestUri
     * @param requestUri
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * Returns the value of requestUrl
     * @return requestUrl
     */
    public StringBuffer getRequestUrl() {
        return requestUrl;
    }

    /**
     * Setter for requestUrl
     * @param requestUrl
     */
    public void setRequestUrl(StringBuffer requestUrl) {
        this.requestUrl = requestUrl;
    }

    /**
     * Returns the value of protocalRequest
     * @return protocalRequest
     */
    public String getProtocalRequest() {
        return protocalRequest;
    }

    /**
     * Setter for protocalRequest
     * @param protocalRequest
     */
    public void setProtocalRequest(String protocalRequest) {
        this.protocalRequest = protocalRequest;
    }

    /**
     * Returns the value of serverName
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * Setter for serverName
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * Returns the value of serverPortNumber
     * @return serverPortNumber
     */
    public int getServerPortNumber() {
        return serverPortNumber;
    }

    /**
     * Setter for serverPortNumber
     * @param serverPortNumber
     */
    public void setServerPortNumber(int serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }

    /**
     * Returns the value of currentServerLocale
     * @return currentServerLocale
     */
    public Locale getCurrentServerLocale() {
        return currentServerLocale;
    }

    /**
     * Setter for currentServerLocale
     * @param currentServerLocale
     */
    public void setCurrentServerLocale(Locale currentServerLocale) {
        this.currentServerLocale = currentServerLocale;
    }

    /**
     * Returns the value of query
     * @return query
     */
    public String getQuery() {
        return query;
    }

    /**
     * Setter for query
     * @param query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * Returns the value of queryParameter
     * @return queryParameter
     */
    public String getQueryParameter() {
        return queryParameter;
    }

    /**
     * Setter for queryParameter
     * @param queryParameter
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    /**
     * Returns the value of userAgent
     * @return userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Setter for userAgent
     * @param userAgent
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
