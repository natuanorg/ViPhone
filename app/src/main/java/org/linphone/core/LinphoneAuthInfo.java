package org.linphone.core;

public abstract interface LinphoneAuthInfo
{
  public abstract String getUsername();
  
  public abstract void setUsername(String paramString);
  
  public abstract String getPassword();
  
  public abstract void setPassword(String paramString);
  
  public abstract String getRealm();
  
  public abstract void setRealm(String paramString);
  
  public abstract String getUserId();
  
  public abstract void setUserId(String paramString);
  
  public abstract String getHa1();
  
  public abstract void setHa1(String paramString);
  
  public abstract void setDomain(String paramString);
  
  public abstract String getDomain();
  
  public abstract LinphoneAuthInfo clone();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneAuthInfo
 * JD-Core Version:    0.7.0.1
 */