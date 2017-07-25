/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;


/**
 * @author paddingdun
 *
 * 2015年12月10日
 */
public class HttpHelper {
	
	
	/**
	 * 请求超时;用于判读是否启动了服务;
	 */
	final static int MAX_CONNECTING_REQUEST_TIMEOUT = 5 * 1000;
	
	/**
	 * 暂时不知道,是不是服务器繁忙时,来不及响应请求处理;
	 */
	final static int MAX_CONNECT_TIMEOUT = 5 * 1000;
	
	/**
	 * 和远端最长时间连接;
	 */
	final static int MAX_SOCKET_TIMEOUT = 30 * 60 * 1000;
	
	final static int MAX_CONNECT_POOL_SIZE = 1;
	final static int MAX_ROUTE_COUNT = 30;
	
	/**
	 * 请求对象;
	 */
	private HttpRequestBase		request;
	/**
	 * 请求实体;post,put;
	 */
	private EntityBuilder		entityBuilder;
	/**
	 * 请求实体;get,delete;
	 */
	private URIBuilder			uriBuilder;
	/**
	 * httpclient builder;
	 */
	private HttpClientBuilder	clientBuilder;
	/**
	 * httpclient;
	 */
	private CloseableHttpClient	httpClient;
	/**
	 * cookie; 
	 */
	private CookieStore			cookieStore;
	/**
	 * 请求相关配置;
	 */
	private Builder				requestConfig;
	/**
	 * 请求类型;
	 * 1:post;
	 * 2:get;
	 * 3:put;
	 * 4:delete;
	 */
	private int					type;
	
	
	private int					socketTimeout = MAX_SOCKET_TIMEOUT;
	private int					connectTimeout = MAX_CONNECT_TIMEOUT;
	private int					connectionRequestTimeout = MAX_CONNECTING_REQUEST_TIMEOUT;
	
	private int 				connectPoolSize = MAX_CONNECT_POOL_SIZE;
	private int					maxRouteCount = MAX_ROUTE_COUNT;
	
	private HttpHelper(HttpRequestBase request){
		this.request = request;
        
        this.clientBuilder = HttpClients.custom();
        this.requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT);
        this.cookieStore = new BasicCookieStore();
        
        //post;
        if (request instanceof HttpPost) {
            this.type = 1;
            this.entityBuilder = EntityBuilder.create().setParameters(new ArrayList<NameValuePair>());
        //put;   
        } else if(request instanceof HttpPut) {
            this.type = 3;
            this.entityBuilder = EntityBuilder.create().setParameters(new ArrayList<NameValuePair>());
        //get;   
        } else if(request instanceof HttpGet) {
            this.type = 2;
            this.uriBuilder = new URIBuilder();
        //delete;
        } else if(request instanceof HttpDelete) {
            this.type = 4;
            this.uriBuilder = new URIBuilder();
        }
	}
	
	/**
	 * @param request
	 * @return
	 */
	private static HttpHelper create(HttpRequestBase request) {
        return new HttpHelper(request);
    }
	
	/**
	 * post;
	 * @param url
	 * @return
	 */
    public static HttpHelper post(String url) {
        return create(new HttpPost(url));
    }
    
    /**
     * put
     * @param url
     * @return
     */
    public static HttpHelper put(String url) {
        return create(new HttpPut(url));
    }
    
    /**
     * get;
     * @param url
     * @return
     */
    public static HttpHelper get(String url) {
        return create(new HttpGet(url));
    }
    
    /**
     * delete;
     * @param url
     * @return
     */
    public static HttpHelper delete(String url) {
        return create(new HttpDelete(url));
    }
    
    /**
     * 添加请求参数;
     * @param name
     * @param value
     * @return
     */
    public HttpHelper addParameter(final String name, final String value) {
    	//post, put;
        if (entityBuilder != null) {
        	entityBuilder.getParameters().add(new BasicNameValuePair(name, value));
        //get,delete;
        } else {
            uriBuilder.addParameter(name, value);
        }
        return this;
    }
    
    /**
     * 替换原有的参数;
     * @param params
     * @return
     */
    public HttpHelper setParameter(List<NameValuePair> parameters) {
    	//post, put;
        if (entityBuilder != null) {
        	entityBuilder.setParameters(parameters);
        //get,delete;
        } else {
            uriBuilder.setParameters(parameters);
        }
        return this;
    }
    
    /**
     * 替换原有的参数;
     * @param params
     * @return
     */
    public HttpHelper setParameter(NameValuePair ...parameters) {
    	//post, put;
        if (entityBuilder != null) {
        	entityBuilder.setParameters(parameters);
        //get,delete;
        } else {
            uriBuilder.setParameters(parameters);
        }
        return this;
    }
    
    /**
     * 设置json请求参数;
     * @param object
     * @return
     */
    public HttpHelper setParameterJson(String str) {
    	//post, put;
        if (entityBuilder != null) {
        	entityBuilder.setBinary(str.getBytes(Consts.UTF_8));
        } 
        return this;
    }
    
    /**
     * 添加header;
     * @param name
     * @param value
     * @return
     */
    public HttpHelper addHeader(String name, String value) {
        request.addHeader(name, value);
        return this;
    }
    
    /**
     * 覆盖之前添加的所有header;
     * @param headers
     * @return
     */
    public HttpHelper setHeaders(Map<String, String> headers) {
        Header [] headerArray = new Header[headers.size()];
        int i = 0;
        for (Entry<String, String> header : headers.entrySet()) {
            headerArray[i++] = new BasicHeader(header.getKey(), header.getValue());
        }
        
        request.setHeaders(headerArray);
        return this;
    }
    
    /**
     * 删除指定的header;
     * @param name
     * @param value
     * @return
     */
    public HttpHelper removeHeader(String name, String value) {
        request.removeHeader(new BasicHeader(name, value));
        return this;
    }
    
    /**
     * 设置内容编码;
     * @param encoding
     * @return
     */
    public HttpHelper setContentEncoding(final String encoding) {
        if(entityBuilder != null) 
        	entityBuilder.setContentEncoding(encoding);
        return this;
    }
    
    /**
     * 设置Content-Type;
     * @param contentType
     * @return
     */
    public HttpHelper setContentType(ContentType contentType) {
        if(entityBuilder != null) 
        	entityBuilder.setContentType(contentType);
        return this;
    }
    
    /**
     * 
     * @param mimeType
     * @param charset
     * @return
     */
    public HttpHelper setContentType(final String mimeType, final Charset charset) {
        if(entityBuilder != null) 
        	entityBuilder.setContentType(ContentType.create(mimeType, charset));
        return this;
    }
    
    /**
     * 和远端最长时间连接;
     * 单位:毫秒;
     * @param socketTimeout
     * @return
     */
    public HttpHelper setSocketTimeout(int socketTimeout){
    	this.socketTimeout = socketTimeout;
        return this;
    }
    
    /**
     * 暂时不知道,是不是服务器繁忙时,来不及响应请求处理;
     * 单位:毫秒;
     * @param connectTimeout
     * @return
     */
    public HttpHelper setConnectTimeout(int connectTimeout) {
    	this.connectTimeout = connectTimeout;
        return this;
    }
    
    /**
     * 请求超时;用于判读是否启动了服务;
     * 单位:毫秒;
     * @param connectionRequestTimeout
     * @return
     */
    public HttpHelper setConnectionRequestTimeout(int connectionRequestTimeout) {
    	this.connectionRequestTimeout = connectionRequestTimeout;
        return this;
    }
    
    public HttpHelper setConnectPoolSize(int connectPoolSize) {
		this.connectPoolSize = connectPoolSize;
		return this;
	}

	public HttpHelper setMaxRouteCount(int maxRouteCount) {
		this.maxRouteCount = maxRouteCount;
		return this;
	}
	
//	/**
//	 * 设置双向认证的JKS;
//	 * @param jksFilePath
//	 * @param password
//	 * @return
//	 */
//    public HttpHelper setJKS(String jksFilePath, String password) {
//        return setJKS(new File(jksFilePath), password);
//    }
//    
//    /**
//     * 设置双向认证的JKS
//     * @param jksFile
//     * @param password
//     * @return
//     */
//    public HttpHelper setJKS(File jksFile, String password) {
//        try{
//        	InputStream instream = new FileInputStream(jksFile);
//            return setJKS(instream, password);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    
//    /**
//     * 设置双向认证的JKS, 不会关闭InputStream;
//     * @param instream
//     * @param password
//     * @return
//     */
//    public HttpHelper setJKS(InputStream instream, String password) {
//        try {
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(instream, password.toCharArray());
//            return setJKS(keyStore);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    
//    /**
//     * 设置双向认证的JKS;
//     * @param keyStore
//     * @return
//     */
//    public HttpHelper setJKS(KeyStore keyStore) {
//        try {
//        	SSLContext.getInstance("TLS");
//            SSLContexts.custom().useProtocol("");
////            socketFactory = new SSLConnectionSocketFactory(sslContext);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage(), e);
//        }
//        
//        return this;
//    }

	/**
     * 设置请求相关参数;
     */
    private void configRequest() {
        URI uri = null;
        //get和delete时,重新设定请求uri;
        if(uriBuilder != null 
        		&& uriBuilder.getQueryParams().size() != 0) {
            try {
                uri = uriBuilder.setPath(request.getURI().toString()).build();
            } catch (URISyntaxException e) {
            	e.printStackTrace();
            	throw new RuntimeException(e);
            }
        }
        
        HttpEntity httpEntity = null;
        
        switch (type) {
        //post;
        case 1:
            httpEntity = entityBuilder.build();
            if(httpEntity.getContentLength() > 0) ((HttpPost)request).setEntity(httpEntity);
            break;
        //get;    
        case 2:
            HttpGet get = ((HttpGet)request);
            if (uri != null)  get.setURI(uri);
            break;
        //put;
        case 3:
            httpEntity = entityBuilder.build();
            if(httpEntity.getContentLength() > 0) ((HttpPut)request).setEntity(httpEntity);
            break;
        //delete;    
        case 4:
            HttpDelete delete = ((HttpDelete)request);
            if (uri != null) delete.setURI(uri);
            
            break;
        }
        
        clientBuilder.setDefaultCookieStore(cookieStore);
        
        this.requestConfig
		//暂时不知道,是不是服务器繁忙时,来不及响应请求处理;
		.setConnectTimeout(connectTimeout)
		//请求超时;用于判读是否启动了服务;
		.setConnectionRequestTimeout(connectionRequestTimeout)
		//和远端最长时间连接;
		.setSocketTimeout(socketTimeout);
        
        request.setConfig(requestConfig.build());
    }
    
    /**
     * 条用返回;
     * @param responseHandler
     * @return
     */
    public <T> T execute(final ResponseHandler<? extends T> responseHandler) {
    	//组装request和entity;
    	configRequest();

    	if(httpClient == null) 
    		httpClient =  createHttpClient();
    	try {
    		return httpClient.execute(request, responseHandler);
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}
    }
    
    
//    public ResponseWrapper execute(){
//    	if(httpClient == null) {
//            httpClient = clientBuilder.build();
//        }
//        
//        try {
//            HttpClientContext context = HttpClientContext.create();
//            CloseableHttpResponse response = httpClient.execute(request, context);
//            return new ResponseWrapper(response, request, context);
//        } catch (IOException e) {
//        	e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
	
	
	
	/**
	 * 创建httpClient;
	 * @return
	 */
	private CloseableHttpClient createHttpClient(){

		// Use custom message parser / writer to customize the way HTTP
		// messages are parsed from and written out to the data stream.
		HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory();
		HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

		// Use a custom connection factory to customize the process of
		// initialization of outgoing HTTP connections. Beside standard connection
		// configuration parameters HTTP connection factory can define message
		// parser / writer routines to be employed by individual connections.
		HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
				requestWriterFactory, responseParserFactory);

		/**
		 * SSL context for secure connections can be created either based on
		 * system or application specific properties.
		 */
		//单向认证;
		SSLContext sslcontext = SSLContexts.createSystemDefault();
		SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslcontext);

		/**
		 *  Create a registry of custom connection socket factories for supported
		 *  protocol schemes.
		 */
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", sslFactory)
				.build();

		/**
		 *  Use custom DNS resolver to override the system DNS resolution.
		 */
		DnsResolver dnsResolver = new SystemDefaultDnsResolver();


		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry, connFactory, dnsResolver);

		// Configure total max or per route limits for persistent connections
		// that can be kept in the pool or leased by the connection manager.
		connManager.setMaxTotal(connectPoolSize);
		connManager.setDefaultMaxPerRoute(maxRouteCount);
		
		CloseableHttpClient httpclient = clientBuilder
				.setConnectionManager(connManager)
				.build();
		return httpclient;
	}
	
	/**
	 * 关闭httpclient;
	 */
	public void close(){
		if (httpClient != null){
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		HttpHelper helper = null;
		CloseableHttpClient httpClient = null;
		try{
//			httpClient = HttpClients.createDefault();
//			HttpPost post = new HttpPost("http://localhost:8080/web/api/login");
//			get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.99 Safari/537.36");
			helper = HttpHelper.post("http://localhost:8080/web/api/login");
//			helper.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.99 Safari/537.36");
//			post.addHeader("Content-Type", "application/json;charset=utf-8");
//			JSONObject jo = new JSONObject();
//			jo.put("username", "测试一下");
//			jo.put("passwd", "test1234");
//			StringEntity e1 = new StringEntity(jo.toString(), Charset.forName("utf-8"));
////			post.setHeader("Content-Type", "application/json;charset=utf-8");
////			post.setEntity(e1);
//			
//			helper.setContentType(ContentType.APPLICATION_JSON);
//			helper.setParameterJson(jo.toString());
			
//			try {
//				HttpEntity entity = entityBuilder().setBinary(jo.toString().getBytes("utf-8")).build();
//				helper.setEntity(entity);
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			CountDownLatch count = new CountDownLatch(3);
//			for (int i = 0; i < 3; i++) {
//				new GetThread(count, httpClient, post, i).start();
//			}
//			try {
//				count.await();
//			} catch (InterruptedException e) {
//			}
			
			helper.execute(new ResponseHandler<Integer>(){
					public Integer handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
						int status = response.getStatusLine().getStatusCode();
						if(status >= 200 && status < 300){}
						HttpEntity entity = response.getEntity();
						if(entity != null){
							System.out.println(EntityUtils.toString(entity, "utf-8"));
						}
						return null;
					}
					
				});
		}finally{
			helper.close();
//			try {
//				httpClient.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
}
