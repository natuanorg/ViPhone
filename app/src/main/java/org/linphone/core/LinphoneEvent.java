package org.linphone.core;

public abstract interface LinphoneEvent
{
  public abstract String getEventName();
  
  public abstract SubscriptionDir getSubscriptionDir();
  
  public abstract SubscriptionState getSubscriptionState();
  
  public abstract void acceptSubscription();
  
  public abstract void denySubscription(Reason paramReason);
  
  public abstract void notify(LinphoneContent paramLinphoneContent);
  
  public abstract void updateSubscribe(LinphoneContent paramLinphoneContent);
  
  public abstract void updatePublish(LinphoneContent paramLinphoneContent);
  
  public abstract void terminate();
  
  public abstract Reason getReason();
  
  public abstract ErrorInfo getErrorInfo();
  
  public abstract void setUserContext(Object paramObject);
  
  public abstract Object getUserContext();
  
  public abstract void addCustomHeader(String paramString1, String paramString2);
  
  public abstract String getCustomHeader(String paramString);
  
  public abstract void sendSubscribe(LinphoneContent paramLinphoneContent);
  
  public abstract void sendPublish(LinphoneContent paramLinphoneContent);
  
  public abstract LinphoneCore getCore();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneEvent
 * JD-Core Version:    0.7.0.1
 */