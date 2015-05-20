package org.linphone.core;

public abstract interface LpConfig
{
  public abstract void setInt(String paramString1, String paramString2, int paramInt);
  
  public abstract void setFloat(String paramString1, String paramString2, float paramFloat);
  
  public abstract void setBool(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void setString(String paramString1, String paramString2, String paramString3);
  
  public abstract void setIntRange(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract int getInt(String paramString1, String paramString2, int paramInt);
  
  public abstract float getFloat(String paramString1, String paramString2, float paramFloat);
  
  public abstract boolean getBool(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract String getString(String paramString1, String paramString2, String paramString3);
  
  public abstract int[] getIntRange(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void sync();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LpConfig
 * JD-Core Version:    0.7.0.1
 */