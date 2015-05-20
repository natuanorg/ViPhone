package org.linphone.core;

public abstract interface LinphoneProxyConfig
{
  public abstract LinphoneProxyConfig edit();
  
  public abstract void done();
  
  public abstract void setIdentity(String paramString)
    throws LinphoneCoreException;
  
  public abstract String getIdentity();
  
  public abstract void setProxy(String paramString)
    throws LinphoneCoreException;
  
  public abstract String getProxy();
  
  public abstract LinphoneProxyConfig enableRegister(boolean paramBoolean);
  
  public abstract boolean registerEnabled();
  
  public abstract String normalizePhoneNumber(String paramString);
  
  public abstract void setDialPrefix(String paramString);
  
  public abstract String getDialPrefix();
  
  public abstract void setDialEscapePlus(boolean paramBoolean);
  
  public abstract boolean getDialEscapePlus();
  
  public abstract String getDomain();
  
  public abstract boolean isRegistered();
  
  public abstract void setRoute(String paramString)
    throws LinphoneCoreException;
  
  public abstract String getRoute();
  
  public abstract void enablePublish(boolean paramBoolean);
  
  public abstract boolean publishEnabled();
  
  public abstract LinphoneCore.RegistrationState getState();
  
  public abstract void setExpires(int paramInt);
  
  public abstract int getExpires();
  
  public abstract void setPrivacy(int paramInt);
  
  public abstract int getPrivacy();
  
  public abstract void enableAvpf(boolean paramBoolean);
  
  public abstract boolean avpfEnabled();
  
  public abstract void setAvpfRRInterval(int paramInt);
  
  public abstract int getAvpfRRInterval();
  
  public abstract void enableQualityReporting(boolean paramBoolean);
  
  public abstract boolean qualityReportingEnabled();
  
  public abstract void setQualityReportingInterval(int paramInt);
  
  public abstract int getQualityReportingInterval();
  
  public abstract void setQualityReportingCollector(String paramString);
  
  public abstract String getQualityReportingCollector();
  
  public abstract void setRealm(String paramString);
  
  public abstract String getRealm();
  
  public abstract void setContactParameters(String paramString);
  
  public abstract String getContactParameters();
  
  public abstract void setContactUriParameters(String paramString);
  
  public abstract String getContactUriParameters();
  
  public abstract int lookupCCCFromIso(String paramString);
  
  public abstract int lookupCCCFromE164(String paramString);
  
  public abstract Reason getError();
  
  public abstract ErrorInfo getErrorInfo();
  
  public abstract void setPublishExpires(int paramInt);
  
  public abstract int getPublishExpires();
  
  public abstract void setUserData(Object paramObject);
  
  public abstract boolean isPhoneNumber(String paramString);
  
  public abstract Object getUserData();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneProxyConfig
 * JD-Core Version:    0.7.0.1
 */