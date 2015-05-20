package org.linphone.core;

public abstract interface LinphoneBuffer
{
  public abstract byte[] getContent();
  
  public abstract void setContent(byte[] paramArrayOfByte);
  
  public abstract int getSize();
  
  public abstract void setSize(int paramInt);
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneBuffer
 * JD-Core Version:    0.7.0.1
 */