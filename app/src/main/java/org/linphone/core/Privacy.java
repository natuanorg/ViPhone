package org.linphone.core;

public abstract interface Privacy
{
  public static final int NONE = 0;
  public static final int USER = 1;
  public static final int HEADER = 2;
  public static final int SESSION = 4;
  public static final int ID = 8;
  public static final int CRITICAL = 16;
  public static final int DEFAULT = 32768;
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.Privacy
 * JD-Core Version:    0.7.0.1
 */