/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ import java.nio.ByteBuffer;
/*   4:    */ 
/*   5:    */ public class LinphoneCoreListenerBase
/*   6:    */   implements LinphoneCoreListener
/*   7:    */ {
/*   8:    */   public void authInfoRequested(LinphoneCore lc, String realm, String username, String Domain) {}
/*   9:    */   
/*  10:    */   public void callStatsUpdated(LinphoneCore lc, LinphoneCall call, LinphoneCallStats stats) {}
/*  11:    */   
/*  12:    */   public void newSubscriptionRequest(LinphoneCore lc, LinphoneFriend lf, String url) {}
/*  13:    */   
/*  14:    */   public void notifyPresenceReceived(LinphoneCore lc, LinphoneFriend lf) {}
/*  15:    */   
/*  16:    */   public void textReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneAddress from, String message) {}
/*  17:    */   
/*  18:    */   public void dtmfReceived(LinphoneCore lc, LinphoneCall call, int dtmf) {}
/*  19:    */   
/*  20:    */   public void notifyReceived(LinphoneCore lc, LinphoneCall call, LinphoneAddress from, byte[] event) {}
/*  21:    */   
/*  22:    */   public void transferState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State new_call_state) {}
/*  23:    */   
/*  24:    */   public void infoReceived(LinphoneCore lc, LinphoneCall call, LinphoneInfoMessage info) {}
/*  25:    */   
/*  26:    */   public void subscriptionStateChanged(LinphoneCore lc, LinphoneEvent ev, SubscriptionState state) {}
/*  27:    */   
/*  28:    */   public void publishStateChanged(LinphoneCore lc, LinphoneEvent ev, PublishState state) {}
/*  29:    */   
/*  30:    */   public void show(LinphoneCore lc) {}
/*  31:    */   
/*  32:    */   public void displayStatus(LinphoneCore lc, String message) {}
/*  33:    */   
/*  34:    */   public void displayMessage(LinphoneCore lc, String message) {}
/*  35:    */   
/*  36:    */   public void displayWarning(LinphoneCore lc, String message) {}
/*  37:    */   
/*  38:    */   public void fileTransferProgressIndication(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, int progress) {}
/*  39:    */   
/*  40:    */   public void fileTransferRecv(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, byte[] buffer, int size) {}
/*  41:    */   
/*  42:    */   public int fileTransferSend(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, ByteBuffer buffer, int size)
/*  43:    */   {
/*  44:131 */     return 0;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void globalState(LinphoneCore lc, LinphoneCore.GlobalState state, String message) {}
/*  48:    */   
/*  49:    */   public void registrationState(LinphoneCore lc, LinphoneProxyConfig cfg, LinphoneCore.RegistrationState state, String smessage) {}
/*  50:    */   
/*  51:    */   public void configuringStatus(LinphoneCore lc, LinphoneCore.RemoteProvisioningState state, String message) {}
/*  52:    */   
/*  53:    */   public void messageReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneChatMessage message) {}
/*  54:    */   
/*  55:    */   public void callState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State state, String message) {}
/*  56:    */   
/*  57:    */   public void callEncryptionChanged(LinphoneCore lc, LinphoneCall call, boolean encrypted, String authenticationToken) {}
/*  58:    */   
/*  59:    */   public void notifyReceived(LinphoneCore lc, LinphoneEvent ev, String eventName, LinphoneContent content) {}
/*  60:    */   
/*  61:    */   public void isComposingReceived(LinphoneCore lc, LinphoneChatRoom cr) {}
/*  62:    */   
/*  63:    */   public void ecCalibrationStatus(LinphoneCore lc, LinphoneCore.EcCalibratorStatus status, int delay_ms, Object data) {}
/*  64:    */   
/*  65:    */   public void uploadProgressIndication(LinphoneCore lc, int offset, int total) {}
/*  66:    */   
/*  67:    */   public void uploadStateChanged(LinphoneCore lc, LinphoneCore.LogCollectionUploadState state, String info) {}
/*  68:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCoreListenerBase
 * JD-Core Version:    0.7.0.1
 */