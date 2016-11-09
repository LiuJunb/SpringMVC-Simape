package com.xmg.touna.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/**
 * 
 *==========================================================
 *
 * 版权：
 *
 * 作者：liujun  1552752505@qq.com
 *
 * 版本：1.0
 *
 * 创建日期： 2016年3月11日  上午10:18:33
 *
 * 描述：使用方法
 * 
 * get使用方法
  
  			String getSynString = OkHttpClientManager.getSynString("http://localhost:8080/szb2-backend/city/getAll/?ds=SZB2_Head");
			LogHelper.info("getSynString==="+getSynString);
   post使用方法		
			List<Param> params=new ArrayList<OkHttpClientManager.Param>();
			Param param1=new Param();
			param1.setKey("jsonString");
			param1.setValue(json);
			Param param2=new Param();
			param2.setKey("ds");
			param2.setValue("SZB2");
			params.add(param1);
			params.add(param2);
			
			String postSynString = OkHttpClientManager.postSynString("http://localhost:8080/szb2-backend/dropDownBox/getPurchaseIds",params);
			LogHelper.info("postSynString==="+postSynString);
 *
 * 全局接口公共部分：
 *
 * 修订历史：
 *
 *==========================================================
 *
 */
public class OkHttpClientManager {

	private OkHttpClient mOkHttpClient;
	private static OkHttpClientManager mInstance;
	
	private OkHttpClientManager()
    {
        mOkHttpClient = new OkHttpClient();
        
    }
	
	 public static OkHttpClientManager getInstance()
	    {
	        if (mInstance == null)
	        {
	            synchronized (OkHttpClientManager.class)
	            {
	                if (mInstance == null)
	                {
	                    mInstance = new OkHttpClientManager();
	                }
	            }
	        }
	        return mInstance;
	   }
	    //===========================对外公布的方法===================================
	 
	 	/**
	 	 * 同步get请求
	 	 * @param url 请求的路径
	 	 * @return 返回值是字符窜
	 	 * @throws IOException
	 	 */
	    public static String getSynString(String url) throws IOException
	    {
	        return getInstance()._getSynString(url);
	    }
	    
	    /**
	     * 异步的get请求
	     * @param url
	     */
	    public static void getAsyn(String url)
	    {
	    	getInstance()._getAsyn(url,new ResultCallback() {
				
				@Override
				public void onResponse(Call arg0, Response arg1) throws IOException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onFailure(Call arg0, IOException arg1) {
					// TODO Auto-generated method stub
					
				}
			});
	    }
	    
	    /**
	     * 异步的get请求,带回调
	     * @param url
	     * @param resultCallback
	     */
	    public static void getAsyn(String url,ResultCallback resultCallback)
	    {
	    	getInstance()._getAsyn(url,resultCallback);
	    }

	    
	    /**
	     * 同步post请求
	     * @param url 请求的路径
	     * @param params 
	     * @return 返回值是字符窜
	     * @throws IOException
	     */
	    public static String postSynString(String url, List<Param> params) throws IOException
	    {
	        return getInstance()._postSynString(url, params);
	    }
	    
	    /**
	     * 异步的post请求
	     * @param url
	     * @param params
	     */
	    public static void postAsyn(String url,List<Param> params)
	    {
	        getInstance()._postAsyn(url, params,new ResultCallback() {
				
				@Override
				public void onResponse(Call arg0, Response arg1) throws IOException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onFailure(Call arg0, IOException arg1) {
					// TODO Auto-generated method stub
					
				}
			});
	    }
	    /**
	     * 异步的post请求,带回调
	     * @param url
	     * @param params
	     * @param resultCallback
	     */
	    public static void postAsyn(String url,List<Param> params,ResultCallback resultCallback)
	    {
	    	getInstance()._postAsyn(url, params,resultCallback);
	    }
	    
	    //===========================不对外公布的方法===================================
	    

		/**
	     * 同步的Get请求
	     *
	     * @param url
	     * @return 字符串
	     */
	    private String _getSynString(String url) throws IOException
	    {
	        Response execute = _getSyn(url);
	        return execute.body().string();
	    }
	 	/**
	     * 同步的Get请求
	     *
	     * @param url
	     * @return Response
	     */
	    private Response _getSyn(String url) throws IOException
	    {
	        final Request request = new Request.Builder()
	                .url(url)
	                .build();
	        Call call = mOkHttpClient.newCall(request);
	        Response execute = call.execute();
	        return execute;
	    }
	    
	    /**
	     * 异步的get请求
	     *
	     * @param url
	     * @param resultCallback 
	     * @param callback
	     * @param params
	     */
	    private void _getAsyn(String url, ResultCallback resultCallback)
	    {
	    	 final Request request = new Request.Builder()
             .url(url)
             .build();
			mOkHttpClient.newCall(request).enqueue(resultCallback);
	    }
	    
	    
	    

	    /**
	     * 同步的Post请求
	     *
	     * @param url
	     * @param params post的参数
	     * @return 字符串
	     */
	    private String _postSynString(String url, List<Param> params) throws IOException
	    {
	        Response response = _post(url, params);
	        return response.body().string();
	    }
	    
	    /**
	     * 同步的Post请求
	     *
	     * @param url
	     * @param params post的参数
	     * @return
	     */
	    private Response _post(String url,List<Param> params) throws IOException
	    {
	        Request request = buildPostRequest(url, params);
	        Response response = mOkHttpClient.newCall(request).execute();
	        return response;
	    }
	    
	    /**
	     * 异步的post请求
	     *
	     * @param url
	     * @param callback
	     * @param params
	     * @param resultCallback 
	     */
	    private void _postAsyn(String url, List<Param> params, ResultCallback resultCallback)
	    {
	        Request request = buildPostRequest(url, params);
			mOkHttpClient.newCall(request).enqueue(resultCallback);
	    }
	    
	    

	    private Request buildPostRequest(String url, List<Param> params)
	    {
			if (params == null)
	            params = new ArrayList<OkHttpClientManager.Param>();
			
			FormBody.Builder builder = new FormBody.Builder();
	        for (Param param : params)
	        {
	        	System.out.println(param.key+"="+param.value);
	            builder.add(param.key, param.value);
	        }
	        RequestBody requestBody = builder.build();
	        return new Request.Builder()
	                .url(url)
	                .post(requestBody)
	                .build();
	    }
	    
	    /**
	     * 自定义的一个参数
	     */
	    public static class Param
	    {
	    	 String key;
		     String value;
		     
	        public Param()
	        {
	        }

	        public Param(String key, String value)
	        {
	            this.key = key;
	            this.value = value;
	        }

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}
	        

	      
	    }

}
