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
import org.linphone.core.LinphoneFriend.SubscribePolicy;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.OnlineStatus;
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
/*  27:    */
/*  28:    */ 
/*  29:    */ public class TutorialBuddyStatus
/*  30:    */   implements LinphoneCoreListener
/*  31:    */ {
/*  32:    */   private boolean running;
/*  33:    */   private TutorialNotifier TutorialNotifier;
/*  34:    */   
/*  35:    */   public TutorialBuddyStatus(TutorialNotifier TutorialNotifier)
/*  36:    */   {
/*  37: 71 */     this.TutorialNotifier = TutorialNotifier;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public TutorialBuddyStatus()
/*  41:    */   {
/*  42: 75 */     this.TutorialNotifier = new TutorialNotifier();
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void newSubscriptionRequest(LinphoneCore lc, LinphoneFriend lf, String url)
/*  46:    */   {
/*  47: 81 */     write("[" + lf.getAddress().getUserName() + "] wants to see your status, accepting");
/*  48: 82 */     lf.edit();
/*  49: 83 */     lf.setIncSubscribePolicy(SubscribePolicy.SPAccept);
/*  50: 84 */     lf.done();
/*  51:    */     try
/*  52:    */     {
/*  53: 87 */       lc.addFriend(lf);
/*  54:    */     }
/*  55:    */     catch (LinphoneCoreException e)
/*  56:    */     {
/*  57: 89 */       write("Error while adding friend [" + lf.getAddress().getUserName() + "] to linphone in the callback");
/*  58:    */     }
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void notifyPresenceReceived(LinphoneCore lc, LinphoneFriend lf)
/*  62:    */   {
/*  63: 94 */     write("New state [" + lf.getStatus() + "] for user id [" + lf.getAddress().getUserName() + "]");
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void registrationState(LinphoneCore lc, LinphoneProxyConfig cfg, RegistrationState cstate, String smessage)
/*  67:    */   {
/*  68: 99 */     write(cfg.getIdentity() + " : " + smessage + "\n");
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void show(LinphoneCore lc) {}
/*  72:    */   
/*  73:    */   public void byeReceived(LinphoneCore lc, String from) {}
/*  74:    */   
/*  75:    */   public void displayStatus(LinphoneCore lc, String message) {}
/*  76:    */   
/*  77:    */   public void displayMessage(LinphoneCore lc, String message) {}
/*  78:    */   
/*  79:    */   public void displayWarning(LinphoneCore lc, String message) {}
/*  80:    */   
/*  81:    */   public void globalState(LinphoneCore lc, GlobalState state, String message) {}
/*  82:    */   
/*  83:    */   public void textReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneAddress from, String message) {}
/*  84:    */   
/*  85:    */   public void callState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State cstate, String msg) {}
/*  86:    */   
/*  87:    */   public void callStatsUpdated(LinphoneCore lc, LinphoneCall call, LinphoneCallStats stats) {}
/*  88:    */   
/*  89:    */   public void ecCalibrationStatus(LinphoneCore lc, EcCalibratorStatus status, int delay_ms, Object data) {}
/*  90:    */   
/*  91:    */   public void callEncryptionChanged(LinphoneCore lc, LinphoneCall call, boolean encrypted, String authenticationToken) {}
/*  92:    */   
/*  93:    */   public void notifyReceived(LinphoneCore lc, LinphoneCall call, LinphoneAddress from, byte[] event) {}
/*  94:    */   
/*  95:    */   public void dtmfReceived(LinphoneCore lc, LinphoneCall call, int dtmf) {}
/*  96:    */   
/*  97:    */   public static void main(String[] args)
/*  98:    */   {
/*  99:118 */     if ((args.length < 1) || (args.length > 3)) {
/* 100:119 */       throw new IllegalArgumentException("Bad number of arguments [" + args.length + "] should be 1, 2 or 3");
/* 101:    */     }
/* 102:123 */     TutorialBuddyStatus tutorial = new TutorialBuddyStatus();
/* 103:    */     try
/* 104:    */     {
/* 105:126 */       String userSipAddress = args[1];
/* 106:    */       
/* 107:    */ 
/* 108:129 */       String mySipAddress = args.length > 1 ? args[1] : null;
/* 109:    */       
/* 110:131 */       String mySipPassword = args.length > 2 ? args[2] : null;
/* 111:    */       
/* 112:133 */       tutorial.launchTutorial(userSipAddress, mySipAddress, mySipPassword);
/* 113:    */     }
/* 114:    */     catch (Exception e)
/* 115:    */     {
/* 116:135 */       e.printStackTrace();
/* 117:    */     }
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void launchTutorial(String sipAddress, String mySipAddress, String mySipPassword)
/* 121:    */     throws LinphoneCoreException
/* 122:    */   {
/* 123:142 */     LinphoneCoreFactory lcFactory = LinphoneCoreFactory.instance();
/* 124:    */     
/* 125:    */ 
/* 126:    */ 
/* 127:146 */     LinphoneCore lc = lcFactory.createLinphoneCore(this, null);
/* 128:    */     try
/* 129:    */     {
/* 130:152 */       LinphoneFriend lf = lcFactory.createLinphoneFriend(sipAddress);
/* 131:153 */       if (lf == null)
/* 132:    */       {
/* 133:154 */         write("Could not create friend; weird SIP address?");
/* 134:    */       }
/* 135:    */       else
/* 136:    */       {
/* 137:158 */         if (mySipAddress != null)
/* 138:    */         {
/* 139:160 */           LinphoneAddress address = lcFactory.createLinphoneAddress(mySipAddress);
/* 140:161 */           String username = address.getUserName();
/* 141:162 */           String domain = address.getDomain();
/* 142:165 */           if (mySipPassword != null) {
/* 143:167 */             lc.addAuthInfo(lcFactory.createAuthInfo(username, mySipPassword, null, domain));
/* 144:    */           }
/* 145:171 */           LinphoneProxyConfig proxyCfg = lc.createProxyConfig(mySipAddress, domain, null, true);
/* 146:172 */           proxyCfg.enablePublish(true);
/* 147:173 */           lc.addProxyConfig(proxyCfg);
/* 148:174 */           lc.setDefaultProxyConfig(proxyCfg);
/* 149:175 */           while (!proxyCfg.isRegistered())
/* 150:    */           {
/* 151:176 */             lc.iterate();
/* 152:    */             try
/* 153:    */             {
/* 154:178 */               Thread.sleep(1000L);
/* 155:    */             }
/* 156:    */             catch (InterruptedException ie)
/* 157:    */             {
/* 158:180 */               write("Interrupted!\nAborting"); return;
/* 159:    */             }
/* 160:    */           }
/* 161:    */         }
/* 162:187 */         lf.enableSubscribes(true);
/* 163:    */         
/* 164:    */ 
/* 165:190 */         lf.setIncSubscribePolicy(SubscribePolicy.SPAccept);
/* 166:    */         try
/* 167:    */         {
/* 168:193 */           lc.addFriend(lf);
/* 169:    */         }
/* 170:    */         catch (LinphoneCoreException e)
/* 171:    */         {
/* 172:195 */           write("Error while adding friend " + lf.getAddress().getUserName() + " to linphone"); return;
/* 173:    */         }
/* 174:200 */         lc.setPresenceInfo(0, null, OnlineStatus.Online);
/* 175:    */         
/* 176:    */ 
/* 177:    */ 
/* 178:204 */         this.running = true;
/* 179:205 */         while (this.running)
/* 180:    */         {
/* 181:206 */           lc.iterate();
/* 182:    */           try
/* 183:    */           {
/* 184:208 */             Thread.sleep(50L);
/* 185:    */           }
/* 186:    */           catch (InterruptedException ie)
/* 187:    */           {
/* 188:210 */             write("Interrupted!\nAborting"); return;
/* 189:    */           }
/* 190:    */         }
/* 191:217 */         lc.setPresenceInfo(0, null, OnlineStatus.Offline);
/* 192:    */         
/* 193:219 */         lc.iterate();
/* 194:    */         
/* 195:    */ 
/* 196:222 */         lf.edit();
/* 197:223 */         lf.enableSubscribes(false);
/* 198:224 */         lf.done();
/* 199:225 */         lc.iterate();
/* 200:    */       }
/* 201:    */     }
/* 202:    */     finally
/* 203:    */     {
/* 204:229 */       write("Shutting down...");
/* 205:    */       
/* 206:231 */       lc.destroy();
/* 207:232 */       write("Exited");
/* 208:    */     }
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void stopMainLoop()
/* 212:    */   {
/* 213:238 */     this.running = false;
/* 214:    */   }
/* 215:    */   
/* 216:    */   private void write(String s)
/* 217:    */   {
/* 218:243 */     this.TutorialNotifier.notify(s);
/* 219:    */   }
/* 220:    */   
/* 221:    */   public void messageReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneChatMessage message) {}
/* 222:    */   
/* 223:    */   public void transferState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State new_call_state) {}
/* 224:    */   
/* 225:    */   public void infoReceived(LinphoneCore lc, LinphoneCall call, LinphoneInfoMessage info) {}
/* 226:    */   
/* 227:    */   public void subscriptionStateChanged(LinphoneCore lc, LinphoneEvent ev, SubscriptionState state) {}
/* 228:    */   
/* 229:    */   public void notifyReceived(LinphoneCore lc, LinphoneEvent ev, String eventName, LinphoneContent content) {}
/* 230:    */   
/* 231:    */   public void publishStateChanged(LinphoneCore lc, LinphoneEvent ev, PublishState state) {}
/* 232:    */   
/* 233:    */   public void isComposingReceived(LinphoneCore lc, LinphoneChatRoom cr) {}
/* 234:    */   
/* 235:    */   public void configuringStatus(LinphoneCore lc, RemoteProvisioningState state, String message) {}
/* 236:    */   
/* 237:    */   public void authInfoRequested(LinphoneCore lc, String realm, String username, String Domain) {}
/* 238:    */   
/* 239:    */   public void fileTransferProgressIndication(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, int progress) {}
/* 240:    */   
/* 241:    */   public void fileTransferRecv(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, byte[] buffer, int size) {}
/* 242:    */   
/* 243:    */   public int fileTransferSend(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, ByteBuffer buffer, int size)
/* 244:    */   {
/* 245:324 */     return 0;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void uploadProgressIndication(LinphoneCore lc, int offset, int total) {}
/* 249:    */   
/* 250:    */   public void uploadStateChanged(LinphoneCore lc, LogCollectionUploadState state, String info) {}
/* 251:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.tutorials.TutorialBuddyStatus

 * JD-Core Version:    0.7.0.1

 */