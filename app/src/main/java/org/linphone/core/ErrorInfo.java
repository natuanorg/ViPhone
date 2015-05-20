package org.linphone.core;

public abstract interface ErrorInfo
{
  public abstract Reason getReason();
  
  public abstract int getProtocolCode();
  
  public abstract String getPhrase();
  
  public abstract String getDetails();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.ErrorInfo
 * JD-Core Version:    0.7.0.1
 */