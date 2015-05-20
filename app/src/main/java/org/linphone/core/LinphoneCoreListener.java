package org.linphone.core;

import java.nio.ByteBuffer;

public abstract interface LinphoneCoreListener
{
  public abstract void authInfoRequested(LinphoneCore paramLinphoneCore, String paramString1, String paramString2, String paramString3);
  
  public abstract void callStatsUpdated(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, LinphoneCallStats paramLinphoneCallStats);
  
  public abstract void newSubscriptionRequest(LinphoneCore paramLinphoneCore, LinphoneFriend paramLinphoneFriend, String paramString);
  
  public abstract void notifyPresenceReceived(LinphoneCore paramLinphoneCore, LinphoneFriend paramLinphoneFriend);
  
  public abstract void textReceived(LinphoneCore paramLinphoneCore, LinphoneChatRoom paramLinphoneChatRoom, LinphoneAddress paramLinphoneAddress, String paramString);
  
  public abstract void dtmfReceived(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, int paramInt);
  
  public abstract void notifyReceived(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, LinphoneAddress paramLinphoneAddress, byte[] paramArrayOfByte);
  
  public abstract void transferState(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, LinphoneCall.State paramState);
  
  public abstract void infoReceived(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, LinphoneInfoMessage paramLinphoneInfoMessage);
  
  public abstract void subscriptionStateChanged(LinphoneCore paramLinphoneCore, LinphoneEvent paramLinphoneEvent, SubscriptionState paramSubscriptionState);
  
  public abstract void publishStateChanged(LinphoneCore paramLinphoneCore, LinphoneEvent paramLinphoneEvent, PublishState paramPublishState);
  
  public abstract void show(LinphoneCore paramLinphoneCore);
  
  public abstract void displayStatus(LinphoneCore paramLinphoneCore, String paramString);
  
  public abstract void displayMessage(LinphoneCore paramLinphoneCore, String paramString);
  
  public abstract void displayWarning(LinphoneCore paramLinphoneCore, String paramString);
  
  public abstract void fileTransferProgressIndication(LinphoneCore paramLinphoneCore, LinphoneChatMessage paramLinphoneChatMessage, LinphoneContent paramLinphoneContent, int paramInt);
  
  public abstract void fileTransferRecv(LinphoneCore paramLinphoneCore, LinphoneChatMessage paramLinphoneChatMessage, LinphoneContent paramLinphoneContent, byte[] paramArrayOfByte, int paramInt);
  
  public abstract int fileTransferSend(LinphoneCore paramLinphoneCore, LinphoneChatMessage paramLinphoneChatMessage, LinphoneContent paramLinphoneContent, ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void globalState(LinphoneCore paramLinphoneCore, LinphoneCore.GlobalState paramGlobalState, String paramString);
  
  public abstract void registrationState(LinphoneCore paramLinphoneCore, LinphoneProxyConfig paramLinphoneProxyConfig, LinphoneCore.RegistrationState paramRegistrationState, String paramString);
  
  public abstract void configuringStatus(LinphoneCore paramLinphoneCore, LinphoneCore.RemoteProvisioningState paramRemoteProvisioningState, String paramString);
  
  public abstract void messageReceived(LinphoneCore paramLinphoneCore, LinphoneChatRoom paramLinphoneChatRoom, LinphoneChatMessage paramLinphoneChatMessage);
  
  public abstract void callState(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, LinphoneCall.State paramState, String paramString);
  
  public abstract void callEncryptionChanged(LinphoneCore paramLinphoneCore, LinphoneCall paramLinphoneCall, boolean paramBoolean, String paramString);
  
  public abstract void notifyReceived(LinphoneCore paramLinphoneCore, LinphoneEvent paramLinphoneEvent, String paramString, LinphoneContent paramLinphoneContent);
  
  public abstract void isComposingReceived(LinphoneCore paramLinphoneCore, LinphoneChatRoom paramLinphoneChatRoom);
  
  public abstract void ecCalibrationStatus(LinphoneCore paramLinphoneCore, LinphoneCore.EcCalibratorStatus paramEcCalibratorStatus, int paramInt, Object paramObject);
  
  public abstract void uploadProgressIndication(LinphoneCore paramLinphoneCore, int paramInt1, int paramInt2);
  
  public abstract void uploadStateChanged(LinphoneCore paramLinphoneCore, LinphoneCore.LogCollectionUploadState paramLogCollectionUploadState, String paramString);
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCoreListener
 * JD-Core Version:    0.7.0.1
 */