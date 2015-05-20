package org.linphone.core;

public abstract interface PayloadType
{
  public abstract String getMime();
  
  public abstract int getRate();
  
  public abstract void setRecvFmtp(String paramString);
  
  public abstract String getRecvFmtp();
  
  public abstract void setSendFmtp(String paramString);
  
  public abstract String getSendFmtp();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PayloadType
 * JD-Core Version:    0.7.0.1
 */