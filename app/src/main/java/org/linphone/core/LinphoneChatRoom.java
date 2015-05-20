package org.linphone.core;

public abstract interface LinphoneChatRoom
{
  public abstract LinphoneAddress getPeerAddress();
  
  public abstract void sendMessage(String paramString);
  
  @Deprecated
  public abstract void sendMessage(LinphoneChatMessage paramLinphoneChatMessage, LinphoneChatMessage.StateListener paramStateListener);
  
  public abstract LinphoneChatMessage createLinphoneChatMessage(String paramString);
  
  public abstract LinphoneChatMessage[] getHistory();
  
  public abstract LinphoneChatMessage[] getHistory(int paramInt);
  
  public abstract LinphoneChatMessage[] getHistoryRange(int paramInt1, int paramInt2);
  
  public abstract void destroy();
  
  public abstract int getUnreadMessagesCount();
  
  public abstract int getHistorySize();
  
  public abstract void deleteHistory();
  
  public abstract void compose();
  
  public abstract boolean isRemoteComposing();
  
  public abstract void markAsRead();
  
  public abstract void deleteMessage(LinphoneChatMessage paramLinphoneChatMessage);
  
  public abstract void updateUrl(LinphoneChatMessage paramLinphoneChatMessage);
  
  public abstract LinphoneChatMessage createLinphoneChatMessage(String paramString1, String paramString2, LinphoneChatMessage.State paramState, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract LinphoneCore getCore();
  
  public abstract LinphoneChatMessage createFileTransferMessage(LinphoneContent paramLinphoneContent);
  
  public abstract void sendChatMessage(LinphoneChatMessage paramLinphoneChatMessage);
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneChatRoom
 * JD-Core Version:    0.7.0.1
 */