package org.linphone.core;

public abstract interface LinphoneCallParams
{
  public abstract void setVideoEnabled(boolean paramBoolean);
  
  public abstract boolean getVideoEnabled();
  
  public abstract void setAudioBandwidth(int paramInt);
  
  public abstract LinphoneCore.MediaEncryption getMediaEncryption();
  
  public abstract void setMediaEnctyption(LinphoneCore.MediaEncryption paramMediaEncryption);
  
  public abstract PayloadType getUsedAudioCodec();
  
  public abstract PayloadType getUsedVideoCodec();
  
  public abstract void enableLowBandwidth(boolean paramBoolean);
  
  public abstract boolean isLowBandwidthEnabled();
  
  public abstract void setRecordFile(String paramString);
  
  public abstract void addCustomHeader(String paramString1, String paramString2);
  
  public abstract String getCustomHeader(String paramString);
  
  public abstract void setPrivacy(int paramInt);
  
  public abstract int getPrivacy();
  
  public abstract void setSessionName(String paramString);
  
  public abstract String getSessionName();
  
  public abstract VideoSize getSentVideoSize();
  
  public abstract VideoSize getReceivedVideoSize();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCallParams
 * JD-Core Version:    0.7.0.1
 */