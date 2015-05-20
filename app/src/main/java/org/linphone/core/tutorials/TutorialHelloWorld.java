/*   1:    */ package org.linphone.core.tutorials;
/*   2:    */ 
/*   3:    */ import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCallStats;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneContent;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.LogCollectionUploadState;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.core.LinphoneCore.RemoteProvisioningState;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;

import java.nio.ByteBuffer;

/*   4:    */
/*   5:    */
/*   6:    */
/*   7:    */
/*   8:    */
/*   9:    */
/*  10:    */
/*  11:    */
/*  12:    */
/*  13:    */
/*  14:    */
/*  15:    */
/*  16:    */
/*  17:    */
/*  18:    */
/*  19:    */
/*  20:    */
/*  21:    */
/*  22:    */
/*  23:    */
/*  24:    */
/*  25:    */
/*  26:    */ 
/*  27:    */ public class TutorialHelloWorld
/*  28:    */   implements LinphoneCoreListener
/*  29:    */ {
/*  30:    */   private boolean running;
/*  31:    */   private TutorialNotifier TutorialNotifier;
/*  32:    */   
/*  33:    */   public TutorialHelloWorld(TutorialNotifier TutorialNotifier)
/*  34:    */   {
/*  35: 62 */     this.TutorialNotifier = TutorialNotifier;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public TutorialHelloWorld()
/*  39:    */   {
/*  40: 66 */     this.TutorialNotifier = new TutorialNotifier();
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void show(LinphoneCore lc) {}
/*  44:    */   
/*  45:    */   public void byeReceived(LinphoneCore lc, String from) {}
/*  46:    */   
/*  47:    */   public void authInfoRequested(LinphoneCore lc, String realm, String username, String domain) {}
/*  48:    */   
/*  49:    */   public void displayStatus(LinphoneCore lc, String message) {}
/*  50:    */   
/*  51:    */   public void displayMessage(LinphoneCore lc, String message) {}
/*  52:    */   
/*  53:    */   public void displayWarning(LinphoneCore lc, String message) {}
/*  54:    */   
/*  55:    */   public void globalState(LinphoneCore lc, GlobalState state, String message) {}
/*  56:    */   
/*  57:    */   public void registrationState(LinphoneCore lc, LinphoneProxyConfig cfg, RegistrationState cstate, String smessage) {}
/*  58:    */   
/*  59:    */   public void newSubscriptionRequest(LinphoneCore lc, LinphoneFriend lf, String url) {}
/*  60:    */   
/*  61:    */   public void notifyPresenceReceived(LinphoneCore lc, LinphoneFriend lf) {}
/*  62:    */   
/*  63:    */   public void textReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneAddress from, String message) {}
/*  64:    */   
/*  65:    */   public void callStatsUpdated(LinphoneCore lc, LinphoneCall call, LinphoneCallStats stats) {}
/*  66:    */   
/*  67:    */   public void ecCalibrationStatus(LinphoneCore lc, EcCalibratorStatus status, int delay_ms, Object data) {}
/*  68:    */   
/*  69:    */   public void callEncryptionChanged(LinphoneCore lc, LinphoneCall call, boolean encrypted, String authenticationToken) {}
/*  70:    */   
/*  71:    */   public void notifyReceived(LinphoneCore lc, LinphoneCall call, LinphoneAddress from, byte[] event) {}
/*  72:    */   
/*  73:    */   public void dtmfReceived(LinphoneCore lc, LinphoneCall call, int dtmf) {}
/*  74:    */   
/*  75:    */   public void callState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State cstate, String msg)
/*  76:    */   {
/*  77: 91 */     write("State: " + msg);
/*  78: 93 */     if (LinphoneCall.State.CallEnd.equals(cstate)) {
/*  79: 94 */       this.running = false;
/*  80:    */     }
/*  81:    */   }
/*  82:    */   
/*  83:    */   public static void main(String[] args)
/*  84:    */   {
/*  85:100 */     if (args.length != 1) {
/*  86:101 */       throw new IllegalArgumentException("Bad number of arguments");
/*  87:    */     }
/*  88:105 */     TutorialHelloWorld helloWorld = new TutorialHelloWorld();
/*  89:    */     try
/*  90:    */     {
/*  91:107 */       String destinationSipAddress = args[1];
/*  92:108 */       helloWorld.launchTutorial(destinationSipAddress);
/*  93:    */     }
/*  94:    */     catch (Exception e)
/*  95:    */     {
/*  96:110 */       e.printStackTrace();
/*  97:    */     }
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void launchTutorial(String destinationSipAddress)
/* 101:    */     throws LinphoneCoreException
/* 102:    */   {
/* 103:120 */     LinphoneCore lc = LinphoneCoreFactory.instance().createLinphoneCore(this, null);
/* 104:    */     try
/* 105:    */     {
/* 106:126 */       LinphoneCall call = lc.invite(destinationSipAddress);
/* 107:127 */       if (call == null)
/* 108:    */       {
/* 109:128 */         write("Could not place call to " + destinationSipAddress);
/* 110:129 */         write("Aborting");
/* 111:    */       }
/* 112:    */       else
/* 113:    */       {
/* 114:132 */         write("Call to " + destinationSipAddress + " is in progress...");
/* 115:    */         
/* 116:    */ 
/* 117:    */ 
/* 118:    */ 
/* 119:137 */         this.running = true;
/* 120:138 */         while (this.running)
/* 121:    */         {
/* 122:139 */           lc.iterate();
/* 123:    */           try
/* 124:    */           {
/* 125:141 */             Thread.sleep(50L);
/* 126:    */           }
/* 127:    */           catch (InterruptedException ie)
/* 128:    */           {
/* 129:143 */             write("Interrupted!\nAborting"); return;
/* 130:    */           }
/* 131:    */         }
/* 132:150 */         if (!LinphoneCall.State.CallEnd.equals(call.getState()))
/* 133:    */         {
/* 134:151 */           write("Terminating the call");
/* 135:152 */           lc.terminateCall(call);
/* 136:    */         }
/* 137:    */       }
/* 138:    */     }
/* 139:    */     finally
/* 140:    */     {
/* 141:155 */       write("Shutting down...");
/* 142:    */       
/* 143:157 */       lc.destroy();
/* 144:158 */       write("Exited");
/* 145:    */     }
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void stopMainLoop()
/* 149:    */   {
/* 150:164 */     this.running = false;
/* 151:    */   }
/* 152:    */   
/* 153:    */   private void write(String s)
/* 154:    */   {
/* 155:169 */     this.TutorialNotifier.notify(s);
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void messageReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneChatMessage message) {}
/* 159:    */   
/* 160:    */   public void transferState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State new_call_state) {}
/* 161:    */   
/* 162:    */   public void infoReceived(LinphoneCore lc, LinphoneCall call, LinphoneInfoMessage info) {}
/* 163:    */   
/* 164:    */   public void subscriptionStateChanged(LinphoneCore lc, LinphoneEvent ev, SubscriptionState state) {}
/* 165:    */   
/* 166:    */   public void notifyReceived(LinphoneCore lc, LinphoneEvent ev, String eventName, LinphoneContent content) {}
/* 167:    */   
/* 168:    */   public void publishStateChanged(LinphoneCore lc, LinphoneEvent ev, PublishState state) {}
/* 169:    */   
/* 170:    */   public void isComposingReceived(LinphoneCore lc, LinphoneChatRoom cr) {}
/* 171:    */   
/* 172:    */   public void configuringStatus(LinphoneCore lc, RemoteProvisioningState state, String message) {}
/* 173:    */   
/* 174:    */   public void fileTransferProgressIndication(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, int progress) {}
/* 175:    */   
/* 176:    */   public void fileTransferRecv(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, byte[] buffer, int size) {}
/* 177:    */   
/* 178:    */   public int fileTransferSend(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, ByteBuffer buffer, int size)
/* 179:    */   {
/* 180:244 */     return 0;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void uploadProgressIndication(LinphoneCore lc, int offset, int total) {}
/* 184:    */   
/* 185:    */   public void uploadStateChanged(LinphoneCore lc, LogCollectionUploadState state, String info) {}
/* 186:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.tutorials.TutorialHelloWorld

 * JD-Core Version:    0.7.0.1

 */