package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest
  extends JsonRequest<JSONObject>
{
  public JsonObjectRequest(int paramInt, String paramString, JSONObject paramJSONObject, Response.Listener<JSONObject> paramListener, Response.ErrorListener paramErrorListener) {}
  
  public JsonObjectRequest(String paramString, JSONObject paramJSONObject, Response.Listener<JSONObject> paramListener, Response.ErrorListener paramErrorListener) {}
  
  public Response<JSONObject> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      Response localResponse = Response.success(new JSONObject(new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return localResponse;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return Response.error(new ParseError(localUnsupportedEncodingException));
    }
    catch (JSONException localJSONException)
    {
      return Response.error(new ParseError(localJSONException));
    }
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.JsonObjectRequest
 * JD-Core Version:    0.7.0.1
 */