package org.linphone.core;

public abstract interface LinphoneInfoMessage
{
  public abstract void setContent(LinphoneContent paramLinphoneContent);
  
  public abstract LinphoneContent getContent();
  
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract String getHeader(String paramString);
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneInfoMessage
 * JD-Core Version:    0.7.0.1
 */