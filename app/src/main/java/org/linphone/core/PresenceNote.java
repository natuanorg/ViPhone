package org.linphone.core;

public abstract interface PresenceNote
{
  public abstract String getContent();
  
  public abstract int setContent(String paramString);
  
  public abstract String getLang();
  
  public abstract int setLang(String paramString);
  
  public abstract long getNativePtr();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceNote
 * JD-Core Version:    0.7.0.1
 */