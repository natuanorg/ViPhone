package org.linphone.core;

public abstract interface LinphoneLogHandler
{
  public static final int Fatal = 16;
  public static final int Error = 8;
  public static final int Warn = 4;
  public static final int Info = 2;
  public static final int Debug = 1;
  
  public abstract void log(String paramString1, int paramInt, String paramString2, String paramString3, Throwable paramThrowable);
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneLogHandler
 * JD-Core Version:    0.7.0.1
 */