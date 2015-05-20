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
/*  27:    */ public class TutorialRegistration
/*  28:    */   implements LinphoneCoreListener
/*  29:    */ {
/*  30:    */   private boolean running;
/*  31:    */   private TutorialNotifier TutorialNotifier;
/*  32:    */   
/*  33:    */   public TutorialRegistration(TutorialNotifier TutorialNotifier)
/*  34:    */   {
/*  35: 67 */     this.TutorialNotifier = TutorialNotifier;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public TutorialRegistration()
/*  39:    */   {
/*  40: 71 */     this.TutorialNotifier = new TutorialNotifier();
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void registrationState(LinphoneCore lc, LinphoneProxyConfig cfg, RegistrationState cstate, String smessage)
/*  44:    */   {
/*  45: 79 */     write(cfg.getIdentity() + " : " + smessage);
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void show(LinphoneCore lc) {}
/*  49:    */   
/*  50:    */   public void byeReceived(LinphoneCore lc, String from) {}
/*  51:    */   
/*  52:    */   public void authInfoRequested(LinphoneCore lc, String realm, String username, String domain) {}
/*  53:    */   
/*  54:    */   public void displayStatus(LinphoneCore lc, String message) {}
/*  55:    */   
/*  56:    */   public void displayMessage(LinphoneCore lc, String message) {}
/*  57:    */   
/*  58:    */   public void displayWarning(LinphoneCore lc, String message) {}
/*  59:    */   
/*  60:    */   public void globalState(LinphoneCore lc, GlobalState state, String message) {}
/*  61:    */   
/*  62:    */   public void newSubscriptionRequest(LinphoneCore lc, LinphoneFriend lf, String url) {}
/*  63:    */   
/*  64:    */   public void notifyPresenceReceived(LinphoneCore lc, LinphoneFriend lf) {}
/*  65:    */   
/*  66:    */   public void textReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneAddress from, String message) {}
/*  67:    */   
/*  68:    */   public void callState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State cstate, String msg) {}
/*  69:    */   
/*  70:    */   public void callStatsUpdated(LinphoneCore lc, LinphoneCall call, LinphoneCallStats stats) {}
/*  71:    */   
/*  72:    */   public void ecCalibrationStatus(LinphoneCore lc, EcCalibratorStatus status, int delay_ms, Object data) {}
/*  73:    */   
/*  74:    */   public void callEncryptionChanged(LinphoneCore lc, LinphoneCall call, boolean encrypted, String authenticationToken) {}
/*  75:    */   
/*  76:    */   public void notifyReceived(LinphoneCore lc, LinphoneCall call, LinphoneAddress from, byte[] event) {}
/*  77:    */   
/*  78:    */   public void dtmfReceived(LinphoneCore lc, LinphoneCall call, int dtmf) {}
/*  79:    */   
/*  80:    */   public static void main(String[] args)
/*  81:    */   {
/*  82:101 */     if (args.length != 2) {
/*  83:102 */       throw new IllegalArgumentException("Bad number of arguments");
/*  84:    */     }
/*  85:106 */     TutorialRegistration tutorial = new TutorialRegistration();
/*  86:    */     try
/*  87:    */     {
/*  88:109 */       String userSipAddress = args[1];
/*  89:    */       
/*  90:111 */       String userSipPassword = args[2];
/*  91:112 */       tutorial.launchTutorial(userSipAddress, userSipPassword);
/*  92:    */     }
/*  93:    */     catch (Exception e)
/*  94:    */     {
/*  95:114 */       e.printStackTrace();
/*  96:    */     }
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void launchTutorial(String sipAddress, String password)
/* 100:    */     throws LinphoneCoreException
/* 101:    */   {
/* 102:121 */     LinphoneCoreFactory lcFactory = LinphoneCoreFactory.instance();
/* 103:    */     
/* 104:    */ 
/* 105:    */ 
/* 106:125 */     LinphoneCore lc = lcFactory.createLinphoneCore(this, null);
/* 107:    */     try
/* 108:    */     {
/* 109:131 */       LinphoneAddress address = lcFactory.createLinphoneAddress(sipAddress);
/* 110:132 */       String username = address.getUserName();
/* 111:133 */       String domain = address.getDomain();
/* 112:136 */       if (password != null) {
/* 113:138 */         lc.addAuthInfo(lcFactory.createAuthInfo(username, password, null, domain));
/* 114:    */       }
/* 115:142 */       LinphoneProxyConfig proxyCfg = lc.createProxyConfig(sipAddress, domain, null, true);
/* 116:143 */       proxyCfg.setExpires(2000);
/* 117:144 */       lc.addProxyConfig(proxyCfg);
/* 118:145 */       lc.setDefaultProxyConfig(proxyCfg);
/* 119:    */       
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:150 */       this.running = true;
/* 124:151 */       while (this.running)
/* 125:    */       {
/* 126:152 */         lc.iterate();
/* 127:153 */         sleep(50);
/* 128:    */       }
/* 129:158 */       lc.getDefaultProxyConfig().edit();
/* 130:159 */       lc.getDefaultProxyConfig().enableRegister(false);
/* 131:160 */       lc.getDefaultProxyConfig().done();
/* 132:161 */       while (lc.getDefaultProxyConfig().getState() != RegistrationState.RegistrationCleared)
/* 133:    */       {
/* 134:162 */         lc.iterate();
/* 135:163 */         sleep(50);
/* 136:    */       }
/* 137:167 */       lc.getDefaultProxyConfig().edit();
/* 138:168 */       lc.getDefaultProxyConfig().enableRegister(true);
/* 139:169 */       lc.getDefaultProxyConfig().done();
/* 140:172 */       while ((lc.getDefaultProxyConfig().getState() != RegistrationState.RegistrationOk) && (lc.getDefaultProxyConfig().getState() != RegistrationState.RegistrationFailed))
/* 141:    */       {
/* 142:173 */         lc.iterate();
/* 143:174 */         sleep(50);
/* 144:    */       }
/* 145:    */     }
/* 146:    */     finally
/* 147:    */     {
/* 148:179 */       write("Shutting down linphone...");
/* 149:    */       
/* 150:181 */       lc.destroy();
/* 151:    */     }
/* 152:    */   }
/* 153:    */   
/* 154:    */   private void sleep(int ms)
/* 155:    */   {
/* 156:    */     try
/* 157:    */     {
/* 158:187 */       Thread.sleep(ms);
/* 159:    */     }
/* 160:    */     catch (InterruptedException ie)
/* 161:    */     {
/* 162:189 */       write("Interrupted!\nAborting");
/* 163:190 */       return;
/* 164:    */     }
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void stopMainLoop()
/* 168:    */   {
/* 169:195 */     this.running = false;
/* 170:    */   }
/* 171:    */   
/* 172:    */   private void write(String s)
/* 173:    */   {
/* 174:200 */     this.TutorialNotifier.notify(s);
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void messageReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneChatMessage message) {}
/* 178:    */   
/* 179:    */   public void transferState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State new_call_state) {}
/* 180:    */   
/* 181:    */   public void infoReceived(LinphoneCore lc, LinphoneCall call, LinphoneInfoMessage info) {}
/* 182:    */   
/* 183:    */   public void subscriptionStateChanged(LinphoneCore lc, LinphoneEvent ev, SubscriptionState state) {}
/* 184:    */   
/* 185:    */   public void notifyReceived(LinphoneCore lc, LinphoneEvent ev, String eventName, LinphoneContent content) {}
/* 186:    */   
/* 187:    */   public void publishStateChanged(LinphoneCore lc, LinphoneEvent ev, PublishState state) {}
/* 188:    */   
/* 189:    */   public void isComposingReceived(LinphoneCore lc, LinphoneChatRoom cr) {}
/* 190:    */   
/* 191:    */   public void configuringStatus(LinphoneCore lc, RemoteProvisioningState state, String message) {}
/* 192:    */   
/* 193:    */   public void fileTransferProgressIndication(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, int progress) {}
/* 194:    */   
/* 195:    */   public void fileTransferRecv(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, byte[] buffer, int size) {}
/* 196:    */   
/* 197:    */   public int fileTransferSend(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, ByteBuffer buffer, int size)
/* 198:    */   {
/* 199:275 */     return 0;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void uploadProgressIndication(LinphoneCore lc, int offset, int total) {}
/* 203:    */   
/* 204:    */   public void uploadStateChanged(LinphoneCore lc, LogCollectionUploadState state, String info) {}
/* 205:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.tutorials.TutorialRegistration

 * JD-Core Version:    0.7.0.1

 */