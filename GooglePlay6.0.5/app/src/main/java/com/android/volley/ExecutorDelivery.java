package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class ExecutorDelivery
  implements ResponseDelivery
{
  private final Executor mResponsePoster;
  
  public ExecutorDelivery(final Handler paramHandler)
  {
    this.mResponsePoster = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public final void postError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramRequest.addMarker("post-error");
    Response localResponse = Response.error(paramVolleyError);
    this.mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, localResponse, null));
  }
  
  public final void postResponse(Request<?> paramRequest, Response<?> paramResponse)
  {
    postResponse(paramRequest, paramResponse, null);
  }
  
  public final void postResponse(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable)
  {
    paramRequest.mResponseDelivered = true;
    paramRequest.addMarker("post-response");
    this.mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramResponse, paramRunnable));
  }
  
  private final class ResponseDeliveryRunnable
    implements Runnable
  {
    private final Request mRequest;
    private final Response mResponse;
    private final Runnable mRunnable;
    
    public ResponseDeliveryRunnable(Request paramRequest, Response paramResponse, Runnable paramRunnable)
    {
      this.mRequest = paramRequest;
      this.mResponse = paramResponse;
      this.mRunnable = paramRunnable;
    }
    
    public final void run()
    {
      if (this.mRequest.isCanceled()) {
        this.mRequest.finish("canceled-at-delivery");
      }
      label97:
      label107:
      for (;;)
      {
        return;
        if (this.mResponse.isSuccess())
        {
          this.mRequest.deliverResponse(this.mResponse.result);
          if (!this.mResponse.intermediate) {
            break label97;
          }
          this.mRequest.addMarker("intermediate-response");
        }
        for (;;)
        {
          if (this.mRunnable == null) {
            break label107;
          }
          this.mRunnable.run();
          return;
          this.mRequest.deliverError(this.mResponse.error);
          break;
          this.mRequest.finish("done");
        }
      }
    }
  }
}


/* Location:           F:\apktool\apktool\Google_Play_Store6.0.5\classes-dex2jar.jar
 * Qualified Name:     com.android.volley.ExecutorDelivery
 * JD-Core Version:    0.7.0.1
 */