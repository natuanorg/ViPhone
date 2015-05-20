package org.linphone.core;

public abstract interface LinphoneContent
{
  public abstract String getType();
  
  public abstract String getSubtype();
  
  public abstract String getEncoding();
  
  public abstract String getDataAsString();
  
  public abstract byte[] getData();
  
  public abstract int getExpectedSize();
  
  public abstract void setExpectedSize(int paramInt);
  
  public abstract int getRealSize();
  
  public abstract void setType(String paramString);
  
  public abstract void setSubtype(String paramString);
  
  public abstract void setEncoding(String paramString);
  
  public abstract void setStringData(String paramString);
  
  public abstract void setData(byte[] paramArrayOfByte);
  
  public abstract void setName(String paramString);
  
  public abstract String getName();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneContent
 * JD-Core Version:    0.7.0.1
 */