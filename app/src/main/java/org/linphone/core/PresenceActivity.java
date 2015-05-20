package org.linphone.core;

public abstract interface PresenceActivity
{
  public abstract String toString();
  
  public abstract PresenceActivityType getType();
  
  public abstract int setType(PresenceActivityType paramPresenceActivityType);
  
  public abstract String getDescription();
  
  public abstract int setDescription(String paramString);
  
  public abstract long getNativePtr();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceActivity
 * JD-Core Version:    0.7.0.1
 */